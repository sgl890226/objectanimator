package com.example.acandroidlisten.objectanimator.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.example.acandroidlisten.objectanimator.R;

public class MainAnimatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ani);
        Button tvButton = findViewById(R.id.tvButton);
        Button tvButton1 = findViewById(R.id.tvButton1);
        final View ivMain = findViewById(R.id.ivMain);
        final ImageView ivCurriculum = findViewById(R.id.ivCurriculum);
        final ObjectAnimator objectAnimator = ObjectAnimator.ofInt(tvButton, "textColor", 0xffffffff, 0xffff0000);
        objectAnimator.setDuration(3000);
        objectAnimator.setRepeatCount(Animation.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        final ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(ivMain,"rotationY",0,360);
        objectAnimator2.setDuration(3000);



        tvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startObjectAnimator(ivMain);
            }
        });
        tvButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startObjectAnimator1(ivCurriculum);
              //  showAnimation(ivCurriculum);
            }
        });
    }
    /**
     * 设置动画 - 铃铛左右摆动
     */
    private void showAnimation(View view) {
        // 获取自定义动画实例
        CustomRotateAnim rotateAnim = CustomRotateAnim.getCustomRotateAnim();
        // 一次动画执行1秒
        rotateAnim.setDuration(500);
        // 设置为循环播放
        rotateAnim.setRepeatCount(2);
        // 设置为匀速
        rotateAnim.setInterpolator(new LinearInterpolator());
        // 开始播放动画
        view.startAnimation(rotateAnim);
    }

    /**
     * 开启动画
     */
    private void startObjectAnimator1(View view){
        try {
            view.setVisibility(View.VISIBLE);
            ObjectAnimator  objectAnimator2 = ObjectAnimator.ofFloat(view, "translationY", -115.0f,115f,0f);
//            ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(view, "scaleY", 0.5f, 1.0f);
            objectAnimator2.setInterpolator(new OvershootInterpolator());
            objectAnimator2.setDuration(200);
            objectAnimator2.start();
//            objectAnimator2.setRepeatCount(2);
//            AnimatorSet animatorSet = new AnimatorSet();
//            animatorSet.playTogether( objectAnimator1,objectAnimator2,objectAnimator3,objectAnimator4);
//            animatorSet.setDuration(800);
//            animatorSet.setInterpolator(new BounceInterpolator());
//            animatorSet.start();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    /**
     * 开启动画
     */
    private void startObjectAnimator(View view){
        try {
            view.setVisibility(View.VISIBLE);
            ObjectAnimator  objectAnimator0 = ObjectAnimator.ofFloat(view, "scaleX", 0.5f, 1.0f);
            ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(view, "scaleY", 0.5f, 1.0f);
            ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(view, "translationX",0f,-5.0f,5f);
            objectAnimator2.setInterpolator(new OvershootInterpolator());
            objectAnimator2.setDuration(50);
            objectAnimator2.setRepeatCount(2);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimator0, objectAnimator1,objectAnimator2);
            animatorSet.setDuration(800);
            animatorSet.setInterpolator(new BounceInterpolator());
            //animatorSet.setInterpolator(new SpringInterpolator(0.3f));
            animatorSet.start();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
