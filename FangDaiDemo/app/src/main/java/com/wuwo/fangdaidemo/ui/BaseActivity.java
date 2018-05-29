package com.wuwo.fangdaidemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.wuwo.fangdaidemo.R;

/**
 * 项目名：FangDaiDemo
 * 包名：com.wuwo.fangdaidemo.ui
 * 文件名：BaseActivity
 * 创建者：SGY
 * Created by 2018/5/20 19:12
 * 描述：TODO
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //显示返回键
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //菜单栏操作

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
