package com.picpic.Search;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.picpic.Likes.LikesActivity;
import com.picpic.R;
import com.picpic.Utils.BottomNavigationViewHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.bottomNavViewBar)
    BottomNavigationView mBottomNavigationView;

    private Context mContext=SearchActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        setupBottomNavigation(mBottomNavigationView);

    }

    /*
     * setup BottomNavigationView & items Click
     * */
    private void setupBottomNavigation(BottomNavigationView mBottomNavigationView) {
        BottomNavigationViewHelper.enableNavigation(mContext,mBottomNavigationView);
        Menu menu=mBottomNavigationView.getMenu();
        MenuItem menuItem=menu.getItem(1);
        menuItem.setChecked(true);
    }


}
