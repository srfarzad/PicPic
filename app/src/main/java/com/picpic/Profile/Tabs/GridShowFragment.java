package com.picpic.Profile.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.picpic.BaseFragment;
import com.picpic.Utils.CustomGridAdapter;
import com.picpic.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class GridShowFragment extends BaseFragment {

    private static final int NUM_GRID_COLUMN=3;


    @BindView(R.id.gridview)
    GridView grid;

    int[] imageId={
            R.drawable.squareflower, R.drawable.squareflower,
            R.drawable.squareflower, R.drawable.squareflower
    };


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_grid_imageview;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CustomGridAdapter adapter=new CustomGridAdapter(getActivity().getBaseContext(),imageId);
        grid.setAdapter(adapter);
        int gridWidth=getResources().getDisplayMetrics().widthPixels;
        int imageWidth=gridWidth/NUM_GRID_COLUMN;
        grid.setColumnWidth(imageWidth);
//        grid.setNestedScrollingEnabled(false);


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity().getApplicationContext(),"click "+i,Toast.LENGTH_LONG).show();
            }
        });


    }




}
