package com.wuwo.fangdaidemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.wuwo.fangdaidemo.R;
import com.wuwo.fangdaidemo.ui.ShowResultActivity;

/**
 * 项目名：FangDaiDemo
 * 包名：com.wuwo.fangdaidemo.fragment
 * 文件名：itemOneFragment
 * 创建者：SGY
 * Created by 2018/5/29 16:01
 * 描述：TODO
 */

public class itemOneFragment extends Fragment implements View.OnClickListener {

    private EditText id_amount;
    private EditText id_year;
    private EditText id_rate;
    private RadioGroup id_radiogroup;
    private Button id_calculate;
    private boolean isBenxi;
    private String amount, year, rate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_one, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        id_amount = view.findViewById(R.id.id_amount);
        id_year = view.findViewById(R.id.id_year);
        id_rate = view.findViewById(R.id.id_rate);
        id_radiogroup = view.findViewById(R.id.id_radiogroup);
        id_calculate = view.findViewById(R.id.id_calculate);
        id_calculate.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_calculate:
                getEditContent();
                showCalculate();
                break;
        }

    }
    //获取输入框内容
    public void getEditContent() {
        amount = id_amount.getText().toString().trim();
        year = id_year.getText().toString().trim();
        rate = id_rate.getText().toString().trim();
        id_radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.id_first_radioButton) {
                    isBenxi = true;
                } else if (checkedId == R.id.id_second_radioButton) {
                    isBenxi = false;
                }
            }
        });
    }
    //计算
    private void showCalculate() {
        if (!TextUtils.isEmpty(amount) && !TextUtils.isEmpty(amount) && !TextUtils.isEmpty(amount)) {
            showResult();
        } else if (TextUtils.isEmpty(amount)) {
            Toast.makeText(getActivity(), "请输入贷款金额", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(year)) {
            Toast.makeText(getActivity(), "请输入贷款年限", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(rate)) {
            Toast.makeText(getActivity(), "请输入贷款利率", Toast.LENGTH_SHORT).show();
        }
    }

    //展示结果
    private void showResult() {
        //将输入框数据传给下一页并跳转
        Intent intent = new Intent(getActivity(), ShowResultActivity.class);
        intent.putExtra("edit_amount",amount);
        intent.putExtra("edit_year",year);
        intent.putExtra("edit_rate",rate);
        intent.putExtra("isBenxi",isBenxi);
        startActivity(intent);
        //展示结果,另一页获取后计算展示
    }
}
