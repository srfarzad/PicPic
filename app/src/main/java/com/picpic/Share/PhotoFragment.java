package com.picpic.Share;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.picpic.BaseFragment;
import com.picpic.R;

public class PhotoFragment extends BaseFragment {


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_photo;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
