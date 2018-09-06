package com.picpic.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SectionStatePagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mFragmentList=new ArrayList<>();
    private final HashMap<Fragment,Integer> mFragments=new HashMap<>();
    private final HashMap<String,Integer> mFragmentsNumber=new HashMap<>();
    private final HashMap<Integer,String> mFragmentsName=new HashMap<>();

    public SectionStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragments(Fragment fragment,String fragName){
        mFragmentList.add(fragment);
        mFragments.put(fragment,mFragmentList.size()-1);
        mFragmentsName.put(mFragmentList.size()-1,fragName);
        mFragmentsNumber.put(fragName,mFragmentList.size()-1);
    }

    public Integer getFragmentNumber(String fragName){
        if (mFragmentsNumber.containsKey(fragName)){
            return mFragmentsNumber.get(fragName);

        }else {
            return  null;
        }
    }

    public Integer getFragmentNumber(Fragment fragment){
        if (mFragmentsNumber.containsKey(fragment)){
            return mFragmentsNumber.get(fragment);

        }else {
            return  null;
        }
    }


    public String getFragmentNumber(Integer fragmentNum){
        if (mFragmentsName.containsKey(fragmentNum)){
            return mFragmentsName.get(fragmentNum);

        }else {
            return  null;
        }
    }
}
