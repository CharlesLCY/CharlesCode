package com.example.myapplication

import android.app.Application
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.tencent.mmkv.MMKV

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ARouter.init(this)

        val rootDir = MMKV.initialize(this)
        Log.d("mmkv", rootDir)
    }
}