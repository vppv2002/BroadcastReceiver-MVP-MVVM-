package com.example.mybroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.mybroadcast.arsenal.NotificationArsenal
import com.example.mybroadcast.arsenal.getNotification
import javax.inject.Inject

class MyReceiver : BroadcastReceiver() {


    @Inject
    lateinit var notoficationArsenal: NotificationArsenal

    override fun onReceive(context: Context, intent: Intent) {
        (context.applicationContext as App)
            .appComponent.inject(this)



        Toast.makeText(context,"Hello Receiver",Toast.LENGTH_SHORT).show()
//        getNotification(context).showNotification()
        notoficationArsenal.showNotification()
    }
}
