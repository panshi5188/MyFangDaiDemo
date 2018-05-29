package com.wuwo.fangdaidemo.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wuwo.fangdaidemo.R;

/**
 * 项目名：FangDaiDemo
 * 包名：com.wuwo.fangdaidemo.view
 * 文件名：MyTitleBar
 * 创建者：SGY
 * Created by 2018/5/21 10:48
 * 描述：TODO
 */

public class MyTitleBarLayout extends RelativeLayout {

    private Button iv_back;
    private TextView tv_title;


    public MyTitleBarLayout(Context context) {
        this(context,null);
    }

    public MyTitleBarLayout(final Context context, AttributeSet attrs) {
        this(context, attrs,0);

    }

    public MyTitleBarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.mytitlebar,this,true);

        iv_back = findViewById(R.id.iv_back);
        tv_title = findViewById(R.id.tv_title);

        iv_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }

    public void setTitleText(String text){
        tv_title.setText(text);
    }
}
