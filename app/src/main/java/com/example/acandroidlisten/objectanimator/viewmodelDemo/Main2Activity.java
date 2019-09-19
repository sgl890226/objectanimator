package com.example.acandroidlisten.objectanimator.viewmodelDemo;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.acandroidlisten.objectanimator.R;
import com.example.acandroidlisten.objectanimator.viewmodelDemo.fragment.ThreeFragment;
import com.example.acandroidlisten.objectanimator.viewmodelDemo.fragment.TwoFragment;
import com.example.acandroidlisten.objectanimator.viewmodelDemo.fragment.oneFragment;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    MainView2Model mainViewModel;
    FrameLayout flContent;
    BottomNavigationBar bottomNavigationBar;
    private ArrayList<Fragment> fragments = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        flContent = findViewById(R.id.flContent);
        bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);
        mainViewModel = ViewModelProviders.of(this).get(MainView2Model.class);
//        mainViewModel.itemALive.observe(this,new Observer<Integer>(){
//
//            @Override
//            public void onChanged(@Nullable Integer integer) {
//               // tvA.setText(integer+"");
//            }
//        });
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED)
                .setInActiveColor(R.color.color_ff333333)
                .setActiveColor(R.color.colorPrimary)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.icon_practice, "首页"))
                .addItem(new BottomNavigationItem(R.mipmap.icon_course, "啦啦").setActiveColorResource(R.color.color_ffd7b176))
                .addItem(new BottomNavigationItem(R.mipmap.icon_my, "我的")).setFirstSelectedPosition(0).initialise();
        fragments = new ArrayList<>();
        fragments.add(new oneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        Fragment bookFragment = fragments.get(0);
        transaction.replace(R.id.flContent, bookFragment);
        transaction.commit();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    ft.replace(R.id.flContent, fragment);
                } else {
                    ft.add(R.id.flContent, fragment);
                }
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                ft.remove(fragment);
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }
}
