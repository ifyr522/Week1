package com.fragment.week1.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fragment.week1.R;
import com.fragment.week1.SpacesItemDecoration;
import com.fragment.week1.adapter.SecondAdapter;
import com.fragment.week1.bean.SecondBean;

import java.util.ArrayList;

/**
 * Created by r on 2017/6/10.
 */

public class SecondFragment extends Fragment {

    ArrayList<SecondBean> list = new ArrayList<>();
    private RecyclerView recyclerView;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.onefragment, container, false);


        initView(view);


        return view;
    }

    private void initData() {
        int[] pic = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.ih,R.drawable.o,R.drawable.p,R.drawable.t,R.drawable.tg};
        for (int x = 0; x < 10; x++) {
            SecondBean bean = new SecondBean(pic[x], "标题" + x);
            list.add(bean);
        }


    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        //设置layoutManager
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        initData();

        SecondAdapter adapter = new SecondAdapter(list);
        recyclerView.setAdapter(adapter);

        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        recyclerView.addItemDecoration(decoration);

        adapter.notifyDataSetChanged();
    }

}
