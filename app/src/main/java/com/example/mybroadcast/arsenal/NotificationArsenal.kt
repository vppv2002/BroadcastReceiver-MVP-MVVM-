package com.example.mybroadcast.arsenal

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import com.example.mybroadcast.ui.MainActivity
import com.example.mybroadcast.R

abstract class NotificationArsenal(context: Context):ContextWrapper(context) {
    val notifyId=101

    val nm=context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun prepare(builder : Notification.Builder) {

        val notificationIntent = Intent(this, MainActivity::class.java)
        val contentIntent: PendingIntent = PendingIntent.getActivity(
            this,
            1000, notificationIntent,
            PendingIntent.FLAG_CANCEL_CURRENT
        )

        builder.apply {
            setContentIntent(contentIntent)
            setContentTitle("Text")
            setContentText("Tetx")
            setSmallIcon(R.mipmap.ic_launcher)
        }
        nm.notify(notifyId,builder.build())
    }

    abstract fun showNotification()

}