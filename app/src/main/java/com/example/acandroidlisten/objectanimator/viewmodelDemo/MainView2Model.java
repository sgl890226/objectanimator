package com.example.acandroidlisten.objectanimator.viewmodelDemo;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.CountDownTimer;
import android.util.SparseArray;

import java.util.Random;

public class MainView2Model extends ViewModel {
    private int itemA,itemB = 0;
    public MutableLiveData<String> itemALive = new MutableLiveData();
    public MutableLiveData<SparseArray<String>> itemListLive= new MutableLiveData();
    public void changeItem(){
        itemALive.postValue("刷新数据");
        SparseArray<String> list = new SparseArray<>();
        for (int i = 0 ;i < 10; i++ ){
            list.put(i,new Random().nextInt(100)+"");
        }
        itemListLive.postValue(list);
    }

}
