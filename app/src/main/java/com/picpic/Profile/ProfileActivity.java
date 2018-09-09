package com.picpic.Profile;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jackandphantom.circularimageview.CircleImage;
import com.picpic.BaseActivity;
import com.picpic.Profile.Tabs.FourFragment;
import com.picpic.Profile.Tabs.GridShowFragment;
import com.picpic.Profile.Tabs.ThreeFragment;
import com.picpic.Profile.Tabs.ListShowFragment;
import com.picpic.R;
import com.picpic.Utils.BottomNavigationViewHelper;
import com.picpic.Utils.CustomViewPager;
import com.picpic.Utils.SectionPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends BaseActivity {
    @BindView(R.id.sliding_tabs_profile)
    TabLayout mTabLayout;

    @BindView(R.id.viewPager_profile)
    CustomViewPager mViewPager;

    @BindView(R.id.bottomNavViewBar)
    BottomNavigationView mBottomNavigationView;

    @BindView(R.id.profile_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.ic_profile_menu)
    AppCompatImageView menu;

    @BindView(R.id.profile_image)
    CircleImage circleImage;

    @BindView(R.id.textEditProfile)
    AppCompatTextView editProfile;

    private Context mContext=ProfileActivity.this;

    @Override
    public int setContentView() {
        return R.layout.activity_profile;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(mToolbar);


//        menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(mContext,AccountSettingsActivity.class));
//            }
//        });

//        editProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//              Bundle bundle=new Bundle();
//              bundle.putInt("fragNum",0);
//              Intent intent=new Intent(mContext,AccountSettingsActivity.class);
//              intent.putExtras(bundle);
//              startActivity(intent);
//            }
//        });

        circleImage.setImageResource(R.drawable.profile);



        mViewPager.setPagingEnabled(false);
        setUpViewPager(mViewPager);


        setUpTabs(mTabLayout);


        setupBottomNavigation(mBottomNavigationView);

    }

    @OnClick(R.id.ic_profile_menu)
    public void menuClick(){
        startActivity(new Intent(mContext,AccountSettingsActivity.class));

    }

    @OnClick(R.id.textEditProfile)
    public void editProfile(){
        Bundle bundle=new Bundle();
        bundle.putInt("fragNum",0);
        Intent intent=new Intent(mContext,AccountSettingsActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }



    /*
     * setup Tablayout and tab colors
     * */
    private void setUpTabs(final TabLayout mTabLayout) {

        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.ic_grid));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.ic_view));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.ic_tags));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.ic_bookmark_tab));


        mTabLayout.getTabAt(0).getIcon().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
        mTabLayout.getTabAt(1).getIcon().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
        mTabLayout.getTabAt(2).getIcon().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
        mTabLayout.getTabAt(3).getIcon().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);



        mTabLayout.setOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(mViewPager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        tab.getIcon().setColorFilter(Color.BLUE,PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
                        mTabLayout.getTabAt(0).getIcon().clearColorFilter();
                        tab.getIcon().clearColorFilter();
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                }
        );
    }



    /*
     * setup BottomNavigationView & items Click
     * */
    private void setupBottomNavigation(BottomNavigationView mBottomNavigationView) {
        BottomNavigationViewHelper.enableNavigation(mContext,mBottomNavigationView);
        Menu menu=mBottomNavigationView.getMenu();
        MenuItem menuItem=menu.getItem(4);
        menuItem.setChecked(true);
    }


    private void setUpViewPager(ViewPager mViewPager) {

        SectionPagerAdapter adapter=new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new GridShowFragment());
        adapter.addFragment(new ListShowFragment());
        adapter.addFragment(new ThreeFragment());
        adapter.addFragment(new FourFragment());
        mViewPager.setAdapter(adapter);

    }

}
