package com.picpic.Profile.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.picpic.R;
import com.picpic.Utils.PostAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListShowFragment extends Fragment {

    @BindView(R.id.recycler_plist) RecyclerView mRecyclerView;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_listshow,container,false);
        ButterKnife.bind(this,view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
        PostAdapter adapter=new PostAdapter();
        mRecyclerView.setAdapter(adapter);

        return view;
    }
}
