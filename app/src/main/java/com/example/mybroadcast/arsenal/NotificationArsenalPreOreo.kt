package com.example.mybroadcast.arsenal

import android.app.Notification
import android.content.Context

class NotificationArsenalPreOreo(context: Context):NotificationArsenal(context) {


    override fun showNotification() {
        @Suppress("DEPRECATION")
val builder = Notification.Builder(this)
        prepare(builder)

    }




}