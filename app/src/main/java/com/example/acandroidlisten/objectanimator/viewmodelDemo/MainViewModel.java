package com.example.acandroidlisten.objectanimator.viewmodelDemo;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.CountDownTimer;

public class MainViewModel extends ViewModel {
    private int itemA,itemB = 0;
    public MutableLiveData<Integer> itemALive = new MutableLiveData();


    public int getItemB() {
        return itemB;
    }

    public int getItemA() {
        return itemA;
    }



    public void changeItem(){
        //模拟一下耗时操作,网络请求等 ..
        new CountDownTimer(5000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                
                itemA += 1;
                itemALive.setValue(itemA);
            }

            @Override
            public void onFinish() {
                //getCurrentItemA();
            }
        }.start();
    }

}
