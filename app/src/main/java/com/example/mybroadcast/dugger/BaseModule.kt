package com.example.mybroadcast.dugger

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BaseModule(private val context: Context) {


    @Singleton
    @Provides
    fun provideAppContext() = context

}