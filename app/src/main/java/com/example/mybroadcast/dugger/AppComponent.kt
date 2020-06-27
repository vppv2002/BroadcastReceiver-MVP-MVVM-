package com.example.mybroadcast.dugger

import android.content.Context
import com.example.mybroadcast.ui.MainActivity
import com.example.mybroadcast.MyReceiver
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        BaseModule::class,
    ArsenalModule::class
    ]
)

interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun getContext(): Context
    fun inject(myReceiver: MyReceiver)

}



