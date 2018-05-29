package com.wuwo.fangdaidemo.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wuwo.fangdaidemo.R;
import com.wuwo.fangdaidemo.adapter.NewsAdapter;
import com.wuwo.fangdaidemo.entity.NewsBeanLast;
import com.wuwo.fangdaidemo.ui.WebViewActivity;
import com.wuwo.fangdaidemo.utils.StaticClass;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 项目名：FangDaiDemo
 * 包名：com.wuwo.fangdaidemo.fragment
 * 文件名：MainFragment
 * 创建者：SGY
 * Created by 2018/5/20 18:50
 * 描述：TODO
 */

public class NewsFragment extends Fragment implements PullLoadMoreRecyclerView.PullLoadMoreListener {

    private PullLoadMoreRecyclerView recyclerView;
    private RecyclerView mRecyclerView;
    private int mCount;
    private NewsAdapter adapter;
    private List<NewsBeanLast.ResultBean.ListBean> mList = new ArrayList<>();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView(view);
    }

    private void findView(View view) {
        recyclerView = view.findViewById(R.id.ry_news);
        mRecyclerView = recyclerView.getRecyclerView();
        //代码设置scrollbar无效？未解决！
        mRecyclerView.setVerticalScrollBarEnabled(true);
        //显示下拉刷新
        recyclerView.setRefreshing(true);
        //设置上拉刷新文字
        recyclerView.setFooterViewText("loading");
        recyclerView.setLinearLayout();
        recyclerView.setOnPullLoadMoreListener(this);
        //设置分隔线
        DividerItemDecoration divider = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.dividerline));
        recyclerView.addItemDecoration(divider);
        getData(8);
    }

    private void getData(int mCount) {
        //解析接口
        String url = "http://v.juhe.cn/weixin/query?key=" + StaticClass.NEWS_KEY + "&ps="+mCount;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            Handler mainHandler = new Handler();

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String json = response.body().string();
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        gsonFromJson(json);
                    }
                });
            }
        });
    }

//    private List<NewsBeanLast.ResultBean.ListBean> getmList(){
//
//    }
    private void gsonFromJson(String t) {
        //Gson解析
        Gson gson = new Gson();
        NewsBeanLast newsBeans = gson.fromJson(t, NewsBeanLast.class);
        mList = newsBeans.getResult().getList();//TODO
        //获取adapter
        adapter = new NewsAdapter(getActivity(), mList);//TODO
        //设置点击事件
        adapter.setOnItemClickListener(new NewsAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("title", mList.get(position).getTitle());
                intent.putExtra("url", mList.get(position).getUrl());
                startActivity(intent);
                mList.get(position).getUrl();//TODO
            }

            @Override
            public void onLongClick(int position) {
                Toast.makeText(getActivity(), "longclick", Toast.LENGTH_SHORT).show();
            }
        });
        //给recyclerView设置adapter
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        adapter.addAllData(mList);
        recyclerView.setPullLoadMoreCompleted();
    }

    @Override
    public void onLoadMore() {
        adapter.addAllData(mList);

        recyclerView.setPullLoadMoreCompleted();
    }
}
