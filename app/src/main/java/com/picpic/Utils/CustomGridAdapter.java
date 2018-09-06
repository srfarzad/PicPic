package com.picpic.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.picpic.R;
import com.picpic.Utils.SqaureImageView;

public class CustomGridAdapter extends BaseAdapter {

    private Context mContext;
    private final int[] Imageid;

    public CustomGridAdapter(Context mContext, int[] imageid) {
        this.mContext = mContext;
        Imageid = imageid;
    }

    @Override
    public int getCount() {
        return Imageid.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        View grid;
        LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView==null){
            grid=new View(mContext);
            grid=inflater.inflate(R.layout.layout_grid_single_imageview,null);

            SqaureImageView imageView=grid.findViewById(R.id.gridImageView);

            imageView.setImageResource(Imageid[i]);

        }else {
            grid=(View) convertView;
        }
        return grid;
    }

}
