package com.picpic.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.picpic.BaseActivity;
import com.picpic.Profile.Menu.EditProfileFragment;
import com.picpic.Profile.Menu.SignOutFragment;
import com.picpic.R;
import com.picpic.Utils.BottomNavigationViewHelper;
import com.picpic.Utils.SectionStatePagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;

public class AccountSettingsActivity extends BaseActivity {

    private SectionStatePagerAdapter adapter;
    private Context mContext=AccountSettingsActivity.this;

    @BindView(R.id.bottomNavViewBar)
    BottomNavigationView mBottomNavigationView;

    @BindView(R.id.container)
    ViewPager mViewPager;

    @BindView(R.id.relLayout1)
    RelativeLayout mRelativeLayout;

    @Override
    public int setContentView() {
        return R.layout.activity_accountsetting;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        /*
        * recive fargment number from profileActivity to show editProfile
        * */
        try {
            Bundle bundle=getIntent().getExtras();
            int fragNum=bundle.getInt("fragNum");

                setupFragments();
            setViewPager(fragNum);


        }catch (Exception e){
            e.printStackTrace();
        }


        setupListMenu();

        setupFragments();

        setupBottomNavigation(mBottomNavigationView);
    }




    private void setupFragments(){
        adapter=new SectionStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragments(new EditProfileFragment(),getString(R.string.Edit_Profile));
        adapter.addFragments(new SignOutFragment(),getString(R.string.Sign_Out));

    }

    private void setViewPager(int fragNum){
        mRelativeLayout.setVisibility(View.GONE);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(fragNum);

    }
    private void setupListMenu(){

        ListView listView=findViewById(R.id.listview_accountSetting);
        ArrayList<String> options=new ArrayList<>();
        options.add(getString(R.string.Edit_Profile));
        options.add(getString(R.string.Sign_Out));

        ArrayAdapter adapter=new ArrayAdapter(AccountSettingsActivity.this,android.R.layout.simple_list_item_1,options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                setViewPager(i);
            }
        });
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

}
