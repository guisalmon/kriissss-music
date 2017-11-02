package org.robnetwork.kriissssmusic.viewmodel;

import android.databinding.Observable;
import android.databinding.ObservableField;
import android.util.Log;

import com.bumptech.glide.Glide;

import org.robnetwork.kriissssmusic.activity.MainActivity;
import org.robnetwork.kriissssmusic.broadcastreceiver.WifiChangedReceiver;
import org.robnetwork.kriissssmusic.helper.ConnectionHelper;
import org.robnetwork.kriissssmusic.helper.NetworkHelper;
import org.robnetwork.kriissssmusic.helper.NotificationHelper;

import cz.kinst.jakub.viewmodelbinding.ViewModel;

public class MainActivityVM extends ViewModel {
    private static final String TAG = MainActivityVM.class.getSimpleName();

    public ObservableField<Boolean> isAtHome = new ObservableField<>(false);

    @Override
    public void onViewModelCreated() {
        super.onViewModelCreated();
        NetworkHelper.start(getContext());

        isAtHome.set(ConnectionHelper.isConnectedToHomeWifi(getContext()));

        WifiChangedReceiver.isAtHome.addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                isAtHome.set(WifiChangedReceiver.isAtHome.get());
            }
        });

        if (isAtHome.get()) {
            NotificationHelper.createNotification(getContext());
        }
    }

    @Override
    public void onViewAttached(boolean firstAttachment) {
        super.onViewAttached(firstAttachment);
        if (getActivity() != null
                && getActivity() instanceof MainActivity
                && ((MainActivity) getActivity()).getBinding() != null) {
            Glide.with(getContext())
                    .load("file:///android_asset/flutter.gif")
                    .into(((MainActivity) getActivity()).getBinding().flutterView);
        }
    }

    @Override
    public void onViewDetached(boolean finalDetachment) {
        super.onViewDetached(finalDetachment);
        if (finalDetachment) {
            NetworkHelper.stop();
        }
    }

    public void onClickBox() {
        Log.d(TAG, "Box ! ");
        NetworkHelper.setSoundSource(NetworkHelper.ID_BOX);
    }

    public void onClickTv() {
        Log.d(TAG, "Tv ! ");
        NetworkHelper.setSoundSource(NetworkHelper.ID_TV);
    }

    public void onClickCyke() {
        Log.d(TAG, "Cyke ! ");
        NetworkHelper.setSoundSource(NetworkHelper.ID_CYKE);
    }

    public void onClickRoom() {
        Log.d(TAG, "Room ! ");
        NetworkHelper.setSoundSource(NetworkHelper.ID_ROOM);
    }

    public void onClickKriss() {
        Log.d(TAG, "Kriissss ! ");
        NetworkHelper.setSoundSource(NetworkHelper.ID_KRISS);
    }
}
