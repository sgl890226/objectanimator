package com.example.acandroidlisten.objectanimator.viewmodelDemo.fragment;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acandroidlisten.objectanimator.R;
import com.example.acandroidlisten.objectanimator.viewmodelDemo.MainView2Model;

import java.util.List;

public class TwoFragment extends Fragment {
    private View view;
    private MainView2Model mainView2Model;
    TextView twoTv;
    RecyclerView twoRecyclerView;
    MyRecyclerViewAdapter myRecyclerViewAdapter = null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_two, container, false);
        mainView2Model = ViewModelProviders.of(this.getActivity()).get(MainView2Model.class);
        twoTv = view.findViewById(R.id.twoTv);
        twoRecyclerView = view.findViewById(R.id.twoRecyclerView);
        twoRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        myRecyclerViewAdapter =  new MyRecyclerViewAdapter(twoRecyclerView,mainView2Model.itemListLive.getValue());
        twoRecyclerView.setAdapter(myRecyclerViewAdapter);

        mainView2Model.itemALive.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String string) {
                twoTv.setText(string);
            }
        });
        mainView2Model.itemListLive.observe(this, new Observer<SparseArray<String>>() {
            @Override
            public void onChanged(@Nullable SparseArray<String> stringSparseArray) {
                myRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
        return view;
    }

    class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.RecyclerHolder> {
        private Context mContext;
        private SparseArray<String> dataList = new SparseArray<>();

        public MyRecyclerViewAdapter(RecyclerView recyclerView,SparseArray<String> dataList) {
            this.mContext = recyclerView.getContext();
            this.dataList = dataList;
        }

        public void setData(SparseArray<String> dataList) {
            if (null != dataList) {
                this.dataList = dataList;
                notifyDataSetChanged();
            }
        }

        @Override
        public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_fragment_two, parent, false);
            return new RecyclerHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerHolder holder, int position) {
            holder.textView.setText(dataList.get(position));
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        class RecyclerHolder extends RecyclerView.ViewHolder {
            TextView textView;

            private RecyclerHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.text_adapter1);
            }
        }
    }
}
