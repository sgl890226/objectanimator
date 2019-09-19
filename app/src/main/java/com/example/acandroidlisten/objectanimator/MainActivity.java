package com.example.acandroidlisten.objectanimator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;

import com.example.acandroidlisten.objectanimator.MyProgressBar.MainProActivity;
import com.example.acandroidlisten.objectanimator.animator.MainAnimatorActivity;
import com.example.acandroidlisten.objectanimator.viewmodelDemo.Main1Activity;
import com.example.acandroidlisten.objectanimator.viewmodelDemo.Main2Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                intent = new Intent(this, MainAnimatorActivity.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                intent = new Intent(this, Main1Activity.class);
                startActivity(intent);
                break;
            case R.id.btn3:
                intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.btn4:
                intent = new Intent(this, MainProActivity.class);
                startActivity(intent);
                break;
        }
    }


}
