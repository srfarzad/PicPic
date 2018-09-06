package com.picpic.Home;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.picpic.Utils.BottomNavigationViewHelper;
import com.picpic.Utils.PostAdapter;
import com.picpic.R;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment {

    @BindView(R.id.bottomNavViewBar)
    BottomNavigationView mBottomNavigationView;

    @BindView(R.id.recycler_homeF)
    RecyclerView mRecyclerView;

    @BindView(R.id.home_toolbar)
    Toolbar mToolbar;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        ButterKnife.bind(this,view);

        /*
        * setup RecyclerView
        * */
        setupRecyclerView(mRecyclerView);


        /*
        * setup Toolbar
        * */

        AppCompatActivity activity =(AppCompatActivity)getActivity();
        activity.setSupportActionBar(mToolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_camera);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);

        setHasOptionsMenu(true);



        /*
         * setup BottomNavigationView
         * */
        setupBottomNavigation(mBottomNavigationView);



        return view;
    }

    private void setupRecyclerView(RecyclerView mRecyclerView) {

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setNestedScrollingEnabled(false);

        PostAdapter adapter=new PostAdapter();
        mRecyclerView.setAdapter(adapter);

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.direct_menuicon,menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);

    }

    private void setupBottomNavigation(BottomNavigationView mBottomNavigationView) {

        BottomNavigationViewHelper.enableNavigation(getActivity(), mBottomNavigationView);
        Menu menu= mBottomNavigationView.getMenu();
        MenuItem menuItem=menu.getItem(0);
        menuItem.setChecked(true);

    }

}
