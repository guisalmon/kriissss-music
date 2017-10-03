package org.robnetwork.kriissssmusic.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.robnetwork.kriissssmusic.R;
import org.robnetwork.kriissssmusic.databinding.ActivityMainBinding;
import org.robnetwork.kriissssmusic.viewmodel.MainActivityVM;

import cz.kinst.jakub.viewmodelbinding.ViewModelActivity;

public class MainActivity extends ViewModelActivity<ActivityMainBinding, MainActivityVM> {
    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setupViewModel(R.layout.activity_main, MainActivityVM.class);
        super.onCreate(savedInstanceState);
    }

}
