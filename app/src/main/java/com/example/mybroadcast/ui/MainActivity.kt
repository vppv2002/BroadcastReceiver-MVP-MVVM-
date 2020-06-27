package com.example.mybroadcast.ui

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.mybroadcast.App
import com.example.mybroadcast.MyReceiver
import com.example.mybroadcast.R
import com.example.mybroadcast.arsenal.NotificationArsenal
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainView {
    val myR = MyReceiver()


    @Inject
    lateinit var context: Context

    @Inject
    lateinit var notificationArsenal: NotificationArsenal

    @Inject
    lateinit var presenter:MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).appComponent.inject(this)
        val d = (application as App).appComponent.getContext()

//        presenter.showNotification1()



        notificationArsenal.showNotification()
        btn_hello.setOnClickListener { sendMessage(it) }

    }


    override fun onStart() {
        super.onStart()
        presenter.view=this
    }

    override fun onStop() {
        super.onStop()
        presenter.view=null
    }


    override fun updateText(text:String) {
txt_text.text=text
    }

    fun sendMessage(view: View) {
        val i = Intent()
        i.action = "com.example.mybroadcast.INTENT"
        val localBroadcastManager = LocalBroadcastManager.getInstance(this)
        localBroadcastManager.sendBroadcast(i)
    }

    override fun onPause() {
        super.onPause()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myR)
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter("com.example.mybroadcast.INTENT")
        LocalBroadcastManager.getInstance(this).registerReceiver(myR, filter)
    }

}