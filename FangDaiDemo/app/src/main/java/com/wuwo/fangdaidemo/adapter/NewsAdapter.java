package com.wuwo.fangdaidemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.wuwo.fangdaidemo.R;
import com.wuwo.fangdaidemo.entity.NewsBeanLast;
import com.wuwo.fangdaidemo.utils.PicassoUtils;
import com.wuwo.fangdaidemo.utils.TimeUtils;

import java.util.List;

/**
 * 项目名：FangDaiDemo
 * 包名：com.wuwo.fangdaidemo.adapter
 * 文件名：NewsAdapter
 * 创建者：SGY
 * Created by 2018/5/21 17:59
 * 描述：TODO
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<NewsBeanLast.ResultBean.ListBean> mList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private WindowManager wm;
    private int width,height;
    private OnItemClickListener mOnItemClickListener;

    public NewsAdapter(Context context, List<NewsBeanLast.ResultBean.ListBean> mList) {
        this.mList = mList;
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
    }
    //添加全部数据
    public void addAllData(List<NewsBeanLast.ResultBean.ListBean> mList){
        this.mList.addAll(mList);
        notifyDataSetChanged();
    }
    //删除全部数据
    public void clearData(){
        this.mList.clear();
    }
    //自定义点击监听接口
    public interface OnItemClickListener{
        void onClick( int position);
        void onLongClick( int position);
    }
    //提供设置点击监听方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this. mOnItemClickListener=onItemClickListener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.news_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        NewsBeanLast.ResultBean.ListBean listBean = mList.get(position);
        holder.title.setText(listBean.getTitle());
        holder.source.setText(listBean.getSource());
        holder.newsDate.setText(TimeUtils.getNowTime());
        //加载图片
        if (!(listBean.getFirstImg()).isEmpty()) {
            PicassoUtils.loadImageViewSize(mContext,listBean.getFirstImg(), 440 ,260,holder.firstImg);
        }
        //回调点击事件
        if (mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onLongClick(position);
                    return true;
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView firstImg;
        TextView title;
        TextView source;
        TextView newsDate;

        public ViewHolder(View itemView) {
            super(itemView);
            firstImg = itemView.findViewById(R.id.newsPhoto);
            title = itemView.findViewById(R.id.newsContent);
            source = itemView.findViewById(R.id.newsSource);
            newsDate = itemView.findViewById(R.id.newsDate);

        }
    }
}
