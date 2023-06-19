package com.example.mathapp.ui.receiver

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class NetworkReceiver : BroadcastReceiver() {

    @SuppressLint("ServiceCast")
    override fun onReceive(context: Context?, intent: Intent?) {
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnected == true

        // Broadcast the network connectivity status using LocalBroadcastManager
        val statusIntent = Intent(ACTION_NETWORK_CONNECTIVITY)
        statusIntent.putExtra(EXTRA_NETWORK_CONNECTIVITY, isConnected)
        LocalBroadcastManager.getInstance(context).sendBroadcast(statusIntent)
    }

    companion object {
        const val ACTION_NETWORK_CONNECTIVITY = "com.example.mathapp.NETWORK_CONNECTIVITY"
        const val EXTRA_NETWORK_CONNECTIVITY = "networkConnectivity"
    }
}