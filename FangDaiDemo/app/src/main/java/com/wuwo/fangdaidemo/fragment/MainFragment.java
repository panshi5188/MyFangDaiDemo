package com.wuwo.fangdaidemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wuwo.fangdaidemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名：FangDaiDemo
 * 包名：com.wuwo.fangdaidemo.fragment
 * 文件名：MainFragment
 * 创建者：SGY
 * Created by 2018/5/20 18:50
 * 描述：TODO
 */

public class MainFragment extends Fragment {

    private TabLayout id_first_tablayout;
    private ViewPager id_first_viewpager;
    private List<String> mTopTittle;
    private List<Fragment> mFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,null);
        initData();
        initView(view);
        return view;
    }
    private void initData() {
        mTopTittle = new ArrayList<>();
        mTopTittle.add("商业贷款");
        mTopTittle.add("公积金");
        mTopTittle.add("组合贷款");

        mFragment = new ArrayList<>();
        mFragment.add(new itemOneFragment());
        mFragment.add(new itemTwoFragment());
        mFragment.add(new itemThreeFragment());

    }

    private void initView(View view) {
        id_first_tablayout = view.findViewById(R.id.id_first_tablayout);
        id_first_viewpager = view.findViewById(R.id.id_first_viewpager);
        id_first_viewpager.setOffscreenPageLimit(mFragment.size());
        id_first_viewpager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTopTittle.get(position);
            }
        });
            id_first_tablayout.setupWithViewPager(id_first_viewpager);
    }
}
