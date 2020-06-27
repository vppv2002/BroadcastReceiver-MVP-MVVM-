package com.example.mybroadcast.ui

import android.os.Handler
import com.example.mybroadcast.arsenal.NotificationArsenal
import javax.inject.Inject
import java.util.logging.Handler as Handler1

class MainPresenter @Inject constructor() {

    @Inject
    lateinit var notificationArsenal: NotificationArsenal


    var view: MainView? =null


    init {
        Handler().postDelayed({
            view?.updateText("after 4 sec")
        },4000)
    }


    fun showNotification1(){
        notificationArsenal.showNotification()
    }
}