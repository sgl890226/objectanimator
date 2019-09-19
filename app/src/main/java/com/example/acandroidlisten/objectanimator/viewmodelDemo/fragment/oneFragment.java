package com.example.acandroidlisten.objectanimator.viewmodelDemo.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acandroidlisten.objectanimator.R;
import com.example.acandroidlisten.objectanimator.viewmodelDemo.MainView2Model;
import com.example.acandroidlisten.objectanimator.viewmodelDemo.MainViewModel;

import java.util.ArrayList;
import java.util.Random;

public class oneFragment extends Fragment {
    private View view;
    MainView2Model mainView2Model;
    private TextView oneTv;
    private TextView oneTv1;
    private Button oneBt;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one, container, false);
        oneTv = view.findViewById(R.id.oneTv);
        oneTv1 = view.findViewById(R.id.oneTv1);
        oneBt = view.findViewById(R.id.oneBt);

        mainView2Model = ViewModelProviders.of(this.getActivity()).get(MainView2Model.class);
        mainView2Model.itemALive.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String string) {
               // oneTv.setText(string);
            }
        });

        oneBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainView2Model.changeItem();
               // Toast.makeText(oneFragment.this.getActivity(),"ssss",Toast.LENGTH_SHORT).show();
            }
        });

        mainView2Model.itemListLive.observe(this, new Observer<SparseArray<String>>() {
            @Override
            public void onChanged(@Nullable SparseArray<String> stringSparseArray) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0;i<stringSparseArray.size();i++){
                    sb.append(stringSparseArray.get(i)+";");
                }
                oneTv1.setText(sb.toString());
            }
        });
        return view;
    }
}
