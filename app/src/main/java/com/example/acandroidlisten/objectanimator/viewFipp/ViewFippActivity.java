package com.example.acandroidlisten.objectanimator.viewFipp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.acandroidlisten.objectanimator.R;
import com.example.acandroidlisten.objectanimator.viewmodelDemo.MainViewModel;

public class ViewFippActivity extends AppCompatActivity  {
    ViewFlipper viewFlipper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfipp);
        initView();
    }
    private void initView() {
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        for(int i=0;i<3;i++){
            View view = getLayoutInflater().inflate(R.layout.item_viewfipp,null);
            viewFlipper.addView(view);
        }
        viewFlipper.setFlipInterval(1000);
        viewFlipper.startFlipping();

    }
}
