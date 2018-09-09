package com.picpic.Profile.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.picpic.BaseFragment;
import com.picpic.R;
import com.picpic.Utils.PostAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListShowFragment extends BaseFragment {

    @BindView(R.id.recycler_plist) RecyclerView mRecyclerView;


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_listshow;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
        // PostAdapter adapter=new PostAdapter();
        // mRecyclerView.setAdapter(adapter);
    }



}
