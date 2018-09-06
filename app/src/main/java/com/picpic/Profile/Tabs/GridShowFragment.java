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

import com.picpic.Utils.CustomGridAdapter;
import com.picpic.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridShowFragment extends Fragment {
    private static final int NUM_GRID_COLUMN=3;
    private GridView grid;



    int[] imageId={
            R.drawable.squareflower, R.drawable.squareflower,
            R.drawable.squareflower, R.drawable.squareflower
    };


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_grid_imageview,container,false);

        ButterKnife.bind(this,view);



         grid = view.findViewById(R.id.gridview);
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

        return view;
    }
}
