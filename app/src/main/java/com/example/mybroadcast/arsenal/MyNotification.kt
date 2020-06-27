package com.example.mybroadcast.arsenal

import android.content.Context
import android.os.Build

fun getNotification(context: Context)=
    if(Build.VERSION.SDK_INT<Build.VERSION_CODES.O){
       NotificationArsenalPreOreo(context)
    }
    else{
        NotificationArsenalOreo(context)
    }
