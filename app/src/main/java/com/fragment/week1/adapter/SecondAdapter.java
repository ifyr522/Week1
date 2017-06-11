package com.fragment.week1.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fragment.week1.R;
import com.fragment.week1.bean.SecondBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by r on 2017/6/10.
 */

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.MasonryView>  {

    ArrayList<SecondBean> list;

    private List<Integer> mHeights;


    public SecondAdapter(ArrayList<SecondBean> list) {
        this.list = list;
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_item, parent, false);
        return new MasonryView(view);
    }

    @Override
    public void onBindViewHolder(MasonryView holder, int position) {

        holder.imageView.setImageResource(list.get(position).getImg());
        holder.textView.setText(list.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MasonryView extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public MasonryView(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.masonry_item_img);
            textView = (TextView) itemView.findViewById(R.id.masonry_item_title);
        }
    }

}
