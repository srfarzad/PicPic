package com.picpic.Share;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.picpic.BaseActivity;
import com.picpic.R;
import com.picpic.Utils.SectionPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShareActivity extends BaseActivity {

    @BindView(R.id.container) ViewPager mViewPager;
    @BindView(R.id.tabsBottom) TabLayout tabLayout;

    @Override
    public int setContentView() {
        return R.layout.activity_share;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupViewPager();
    }


    private void setupViewPager(){
        SectionPagerAdapter adapter=new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new GallaryFragment());
        adapter.addFragment(new PhotoFragment());

        mViewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setText(getString(R.string.GALLARY));
        tabLayout.getTabAt(1).setText(getString(R.string.PHOTO));


    }

}
