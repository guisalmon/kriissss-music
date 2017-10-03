package org.robnetwork.kriissssmusic.viewmodel;

import android.util.Log;

import org.robnetwork.kriissssmusic.helper.NetworkHelper;

import cz.kinst.jakub.viewmodelbinding.ViewModel;

public class MainActivityVM extends ViewModel {
    private static final String TAG = MainActivityVM.class.getSimpleName();

    @Override
    public void onViewModelCreated() {
        super.onViewModelCreated();
        NetworkHelper.start(getContext());

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
