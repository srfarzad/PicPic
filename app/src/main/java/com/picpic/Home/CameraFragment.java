package com.picpic.Home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.picpic.BaseFragment;
import com.picpic.R;


public class CameraFragment extends BaseFragment {



    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_camera;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
