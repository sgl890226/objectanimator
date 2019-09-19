package com.example.acandroidlisten.objectanimator.viewmodelDemo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.acandroidlisten.objectanimator.R;
import com.example.acandroidlisten.objectanimator.viewmodelDemo.MainViewModel;

public class Main1Activity extends AppCompatActivity  {
    MainViewModel mainViewModel;
    TextView tvA,tvB;
    Button btA,btB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        tvA = (TextView) findViewById(R.id.tvA);
        tvB =  (TextView) findViewById(R.id.tvB);
        tvA.setText(mainViewModel.getItemA()+"");
        tvB.setText(mainViewModel.getItemB()+"");
        mainViewModel.itemALive.observe(this,new Observer<Integer>(){

            @Override
            public void onChanged(@Nullable Integer integer) {
                tvA.setText(integer+"");
            }
        });
        btA = findViewById(R.id.btnA);
        btB = findViewById(R.id.btnB);
        btA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewModel.changeItem();
            }
        });
        btB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvB.setText(3+"");
            }
        });
    }

}
