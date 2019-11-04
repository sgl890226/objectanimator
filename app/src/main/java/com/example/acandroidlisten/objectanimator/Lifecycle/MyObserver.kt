package com.example.acandroidlisten.objectanimator.Lifecycle

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log

class MyObserver : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun connectListener() {
       // ...
        Log.i("sss","Event.ON_RESUME")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun disconnectListener() {
     //   ...
        Log.i("sss","Event.ON_PAUSE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun createListener() {
        //   ...
        Log.i("sss","Event.ON_CREATE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroyListener() {
        //   ...
        Log.i("sss","Event.ON_DESTROY")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun anyListener() {
        //   ...
        Log.i("sss","Event.ON_ANY")
    }


}

//myLifecycleOwner.getLifecycle().addObserver(MyObserver())