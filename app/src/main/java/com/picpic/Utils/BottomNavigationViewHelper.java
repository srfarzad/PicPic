package com.picpic.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.picpic.Home.HomeActivity;
import com.picpic.Likes.LikesActivity;
import com.picpic.Profile.ProfileActivity;
import com.picpic.R;
import com.picpic.Search.SearchActivity;
import com.picpic.Share.ShareActivity;

public class BottomNavigationViewHelper {

public static void enableNavigation(final Context context,BottomNavigationView view){
    view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.bootomBarItem_home:
                    context.startActivity(new Intent(context, HomeActivity.class)); //index=0
                    break;
                case R.id.bootomBarItem_search:
                    context.startActivity(new Intent(context, SearchActivity.class)); //index=1
                    break;
                case R.id.bootomBarItem_share:
                    context.startActivity(new Intent(context, ShareActivity.class)); //index=2
                    break;
                case R.id.bootomBarItem_like:
                    context.startActivity(new Intent(context, LikesActivity.class)); //index=3
                    break;
                case R.id.bootomBarItem_profile:
                    context.startActivity(new Intent(context, ProfileActivity.class)); //index=4
                    break;
            }
            return false;
        }
    });
}
}
