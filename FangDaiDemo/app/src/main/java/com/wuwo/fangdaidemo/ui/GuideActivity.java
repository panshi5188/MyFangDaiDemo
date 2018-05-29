package com.wuwo.fangdaidemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.wuwo.fangdaidemo.MainActivity;
import com.wuwo.fangdaidemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名：FangDaiDemo
 * 包名：com.wuwo.fangdaidemo.ui
 * 文件名：GuideActivity
 * 创建者：SGY
 * Created by 2018/5/20 22:55
 * 描述：引导页
 */

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    //容器
    private List<View> mList = new ArrayList<>();
    private View view1,view2,view3;
    //小圆点
    private ImageView point1,point2,point3;
    private Button btn_start;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initView();
    }

    //初始化View
    private void initView() {



        point1 = findViewById(R.id.point1);
        point2 = findViewById(R.id.point2);
        point3 = findViewById(R.id.point3);
        //设置默认图片
        setPointImg(true,false,false);

        mViewPager = findViewById(R.id.mViewPager);
        view1 = View.inflate(this,R.layout.pager_item_one,null);
        view2 = View.inflate(this,R.layout.pager_item_two,null);
        view3 = View.inflate(this,R.layout.pager_item_three,null);
        mList.add(view1);
        mList.add(view2);
        mList.add(view3);
        btn_start = view3.findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);

        //设置适配器
        mViewPager.setAdapter(new GuideAdapter());
        //监听ViewPager的滑动
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        setPointImg(true,false,false);
                        break;
                    case 1:
                        setPointImg(false,true,false);
                        break;
                    case 2:
                        setPointImg(false,false,true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }
    }

    private class GuideAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view ==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager)container).addView(mList.get(position));
            return mList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager)container).removeView(mList.get(position));
//            super.destroyItem(container, position, object);
        }
    }

    private void setPointImg(boolean isCheck1,boolean isCheck2,boolean isCheck3){
        if (isCheck1){
            point1.setImageResource(R.drawable.point_on);
        }else {
            point1.setImageResource(R.drawable.point_off);
        }
        if (isCheck2){
            point2.setImageResource(R.drawable.point_on);
        }else {
            point2.setImageResource(R.drawable.point_off);
        }
        if (isCheck3){
            point3.setImageResource(R.drawable.point_on);
        }else {
            point3.setImageResource(R.drawable.point_off);
        }
    }
}
