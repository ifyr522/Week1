package com.fragment.week1.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fragment.week1.Main2Activity;
import com.fragment.week1.R;
import com.fragment.week1.adapter.OneAdapter;
import com.fragment.week1.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by r on 2017/6/10.
 */

public class OneFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<NewsBean> mDatas = new ArrayList<>();
    private OneAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private int[] arr = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.ih,R.drawable.o,R.drawable.p,R.drawable.t,R.drawable.tg};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(),R.layout.onefragment,null);


        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        getData();

        adapter = new OneAdapter(getActivity(),mDatas);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OneAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), Main2Activity.class);
                intent.putExtra("title",mDatas.get(position).getTv1());
                intent.putExtra("pic",mDatas.get(position).getPic());
                intent.putExtra("content",mDatas.get(position).getTv2());
                startActivity(intent);
            }
        });
        return view;
    }

    private void getData() {

        for (int i = 0; i < 10; i++) {
            NewsBean bean = new NewsBean();
            bean.setTv1("新闻标题"+i);
            bean.setTv2("内容"+i);
            bean.setPic(arr[i]);
            mDatas.add(bean);
        }
    }


}
