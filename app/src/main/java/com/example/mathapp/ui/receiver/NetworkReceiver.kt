package com.example.mathapp.ui.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast

class NetworkReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnected == true

        Toast.makeText(
            context,
            if (isConnected) "Έχεις Ιντερνετ" else "Δεν Υπαρχει συνδεση στο Διαδικτιο",
            Toast.LENGTH_SHORT
        ).show()
    }
}