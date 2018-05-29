package com.wuwo.fangdaidemo;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.wuwo.fangdaidemo.fragment.MainFragment;
import com.wuwo.fangdaidemo.fragment.NewsFragment;
import com.wuwo.fangdaidemo.fragment.UserFragment;
import com.wuwo.fangdaidemo.view.MyTitleBarLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout id_main_tablayout;
    private ViewPager id_main_viewpager;
    private List<String> mBottomTittle;
    private List<Fragment> mFragment;
    private MyTitleBarLayout id_titlebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    //初始化View
    private void initView() {
        id_titlebar  = findViewById(R.id.id_titlebar);
        id_main_tablayout = findViewById(R.id.id_main_tablayout);
        id_main_viewpager = findViewById(R.id.id_main_viewpager);

        //预加载
        id_main_viewpager.setOffscreenPageLimit(mFragment.size());

        //设置适配器
        id_main_viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //选中的Item
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return mFragment.get(position);
            }
            //返回item的个数
            @Override
            public int getCount() {
                return mFragment.size();
            }
            //设置标题

            @Override
            public CharSequence getPageTitle(int position) {
                return mBottomTittle.get(position);
            }
        });

        //绑定
        id_main_tablayout.setupWithViewPager(id_main_viewpager);

    }

    //初始化数据
    private void initData() {
        mBottomTittle = new ArrayList<>();
        mBottomTittle.add(getString(R.string.main_name));
        mBottomTittle.add(getString(R.string.news_name));
        mBottomTittle.add(getString(R.string.user_name));

        mFragment = new ArrayList<>();
        mFragment.add(new MainFragment());
        mFragment.add(new NewsFragment());
        mFragment.add(new UserFragment());
    }
}
