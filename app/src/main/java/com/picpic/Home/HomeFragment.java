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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.picpic.BaseFragment;
import com.picpic.Utils.BottomNavigationViewHelper;
import com.picpic.Utils.PostAdapter;
import com.picpic.R;
import com.picpic.models.IMessageListener;
import com.picpic.models.Posts;
import com.picpic.webservice.WebserviceCaller;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("ValidFragment")
public class HomeFragment extends BaseFragment {

    @BindView(R.id.bottomNavViewBar)
    BottomNavigationView mBottomNavigationView;

    @BindView(R.id.recycler_homeF)
    RecyclerView mRecyclerView;

    @BindView(R.id.home_toolbar)
    Toolbar mToolbar;

    WebserviceCaller webserviceCaller;


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_home;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        AppCompatActivity activity =(AppCompatActivity)getActivity();
        activity.setSupportActionBar(mToolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_camera);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);

        setHasOptionsMenu(true);

        setupBottomNavigation(mBottomNavigationView);
        webserviceCaller = new WebserviceCaller();


        getAllPosts();

    }


    public void getAllPosts(){

        webserviceCaller.getAllPosts(new IMessageListener() {
            @Override
            public void onResponse(List posts) {
                Log.e("","");
                setupRecyclerView(mRecyclerView,posts);
            }

            @Override
            public void onResponse(Object posts) {

            }

            @Override
            public void onError(String error) {
                Log.e("","");
            }
        });

    }


    private void setupRecyclerView(RecyclerView mRecyclerView, List<Posts> posts) {

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setNestedScrollingEnabled(false);

        //PostAdapter adapter=new PostAdapter(getActivity(),posts);
        //mRecyclerView.setAdapter(adapter);

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
