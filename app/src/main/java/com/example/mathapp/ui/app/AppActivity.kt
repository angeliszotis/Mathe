package com.example.mathapp.ui.app

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.mathapp.R
import com.example.mathapp.ui.receiver.NetworkReceiver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private var broadcastReceiver = NetworkReceiver()

    override fun onStart() {
        super.onStart()
        registerReceiver(broadcastReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }
}
