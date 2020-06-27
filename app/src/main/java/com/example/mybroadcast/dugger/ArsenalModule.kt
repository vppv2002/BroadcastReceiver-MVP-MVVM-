package com.example.mybroadcast.dugger

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.mybroadcast.arsenal.NotificationArsenal
import com.example.mybroadcast.arsenal.NotificationArsenalOreo
import com.example.mybroadcast.arsenal.NotificationArsenalPreOreo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ArsenalModule {

    @RequiresApi(Build.VERSION_CODES.O)
    @Singleton
    @Provides
    fun provideNotificationArsenal(context: Context): NotificationArsenal {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationArsenalOreo(context)
        } else {
            NotificationArsenalPreOreo(context)
        }
    }

}
