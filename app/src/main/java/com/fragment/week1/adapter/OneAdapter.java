package com.fragment.week1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fragment.week1.bean.NewsBean;
import com.fragment.week1.R;

import java.util.List;

/**
 * Created by r on 2017/6/10.
 */

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.MyViewHolder> implements View.OnClickListener {

    private Context context;
    private List<NewsBean> mDatas;
    private LayoutInflater inflater;

    public OneAdapter(Context context, List<NewsBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        inflater=LayoutInflater. from(context);
    }



    //创建新View，被LayoutManager所调用
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.one_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        view.setOnClickListener(this);

        return holder;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv1.setText(mDatas.get(position).getTv1());
        holder.tv2.setText(mDatas.get(position).getTv2());
        holder.image.setImageResource(mDatas.get(position).getPic());

        holder.itemView.setTag(position);

    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onClick(View v) {

        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }


    //自定义的ViewHolder，持有每个Item的的所有界面元素
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv1,tv2;
        private final ImageView image;

        public MyViewHolder(View view) {
            super(view);
            tv1 = (TextView) view.findViewById(R.id.tv1);
            tv2 = (TextView) view.findViewById(R.id.tv2);
            image = (ImageView) view.findViewById(R.id.image);
        }
    }
    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }


    private OnItemClickListener mOnItemClickListener = null;


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
