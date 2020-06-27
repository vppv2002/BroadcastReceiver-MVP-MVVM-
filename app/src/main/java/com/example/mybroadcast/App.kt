package com.example.mybroadcast

import android.app.Application
import com.example.mybroadcast.dugger.AppComponent
import com.example.mybroadcast.dugger.ArsenalModule
import com.example.mybroadcast.dugger.BaseModule
import com.example.mybroadcast.dugger.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .baseModule(BaseModule(this))
            .arsenalModule(ArsenalModule())
            .build()
    }

}
