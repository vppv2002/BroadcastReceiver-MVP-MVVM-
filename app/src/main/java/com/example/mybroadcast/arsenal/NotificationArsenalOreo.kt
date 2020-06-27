package com.example.mybroadcast.arsenal

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
const val CHANNEL_ID="channelId"

@RequiresApi(Build.VERSION_CODES.O)
class NotificationArsenalOreo(context: Context):NotificationArsenal(context) {

    init {
        val channel = NotificationChannel(CHANNEL_ID, "My channel", NotificationManager.IMPORTANCE_HIGH)
       nm.createNotificationChannel(channel)
    }


    override fun showNotification() {
        val builder = Notification.Builder(this)
        prepare(builder)

    }

}