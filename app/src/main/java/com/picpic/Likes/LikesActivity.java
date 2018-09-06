package com.picpic.Likes;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.picpic.Profile.ProfileActivity;
import com.picpic.R;
import com.picpic.Utils.BottomNavigationViewHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LikesActivity extends AppCompatActivity {

    @BindView(R.id.bottomNavViewBar) BottomNavigationView mBottomNavigationView;
    private Context mContext=LikesActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likes);
        ButterKnife.bind(this);



        /*
         * setup BottomNavigationView
         * */
        setupBottomNavigation(mBottomNavigationView);




    }

    private void setupBottomNavigation(BottomNavigationView mBottomNavigationView) {

        BottomNavigationViewHelper.enableNavigation(mContext,mBottomNavigationView);

        Menu menu=mBottomNavigationView.getMenu();
        MenuItem menuItem=menu.getItem(3);
        menuItem.setChecked(true);
    }
}
