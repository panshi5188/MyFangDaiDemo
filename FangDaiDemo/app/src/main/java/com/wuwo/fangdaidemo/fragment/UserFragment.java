package com.wuwo.fangdaidemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wuwo.fangdaidemo.R;

/**
 * 项目名：FangDaiDemo
 * 包名：com.wuwo.fangdaidemo.fragment
 * 文件名：MainFragment
 * 创建者：SGY
 * Created by 2018/5/20 18:50
 * 描述：TODO
 */

public class UserFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user,null);
        return view;
    }
}
