package com.wuwo.fangdaidemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.wuwo.fangdaidemo.MainActivity;
import com.wuwo.fangdaidemo.R;
import com.wuwo.fangdaidemo.utils.ShareUtils;
import com.wuwo.fangdaidemo.utils.StaticClass;

/**
 * 项目名：FangDaiDemo
 * 包名：com.wuwo.fangdaidemo.ui
 * 文件名：SplashActivity
 * 创建者：SGY
 * Created by 2018/5/20 21:03
 * 描述：TODO
 */

public class SplashActivity extends AppCompatActivity {

    private ImageView iv_splash;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case StaticClass.HANDLER_SPLASH:

                    if (isFirst()){
                        startActivity(new Intent(SplashActivity.this,GuideActivity.class));
                    }else {
                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    }
                    finish();
                    break;
            }
        }
    };
    //判断是否第一次运行
    private boolean isFirst() {
        boolean isFirst = ShareUtils.getBoolean(this, StaticClass.SHARE_IS_FIRST, true);
        if (isFirst){
            ShareUtils.putBoolean(this, StaticClass.SHARE_IS_FIRST,false);
            return true;
        }else {
            return false;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
    }

    private void initView() {
        handler.sendEmptyMessageDelayed(StaticClass.HANDLER_SPLASH,500);
        iv_splash = findViewById(R.id.iv_splash);
    }

    //禁止返回键
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
