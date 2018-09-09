package com.picpic.Home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.picpic.BaseActivity;
import com.picpic.R;
import com.picpic.Utils.SectionPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {



    @BindView(R.id.container) ViewPager mViewPager;
    private Context context= HomeActivity.this;


    @Override
    public int setContentView() {
        return R.layout.activity_home;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpViewPager(mViewPager);

    }



    private void setUpViewPager(ViewPager viewPager){//, ArrayList<SubcatItem> subItems){

        SectionPagerAdapter viewPagerAdapter=new SectionPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new CameraFragment());
        viewPagerAdapter.addFragment(new HomeFragment());
        viewPagerAdapter.addFragment(new MessageFragment());

        viewPager.setAdapter(viewPagerAdapter);

        viewPager.setCurrentItem(1,true);


//        TabLayout tabLayout=findViewById(R.id.tabs_home);
//        tabLayout.setupWithViewPager(viewPager);
//
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
//        tabLayout.getTabAt(1).setIcon(R.drawable.ic_logo);
//        tabLayout.getTabAt(2).setIcon(R.drawable.ic_direct);

    }



}
