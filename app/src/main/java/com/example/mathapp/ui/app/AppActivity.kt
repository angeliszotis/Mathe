package com.example.mathapp.ui.app

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.mathapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
