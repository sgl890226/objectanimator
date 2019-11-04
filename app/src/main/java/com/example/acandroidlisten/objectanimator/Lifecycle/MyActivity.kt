package com.example.acandroidlisten.objectanimator.Lifecycle

import android.arch.lifecycle.LifecycleOwner
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.acandroidlisten.objectanimator.R
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleRegistry
import kotlinx.android.synthetic.main.activity_my.*

class MyActivity : AppCompatActivity() {

    private var mLifecycleRegistry: LifecycleRegistry? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
        val myLifeCycle = MyObserver()
//      26 之前的可以使用这种方式
//        mLifecycleRegistry = LifecycleRegistry(this)
//        mLifecycleRegistry!!.markState(Lifecycle.State.CREATED)
//        mLifecycleRegistry!!.addObserver(myLifeCycle)
//       myLifeCycle.disconnectListener()
       this.getLifecycle().addObserver(myLifeCycle)
        mybtn1.setOnClickListener {
            finish()
        }

    }
}