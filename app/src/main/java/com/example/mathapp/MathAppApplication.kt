package com.example.mathapp

import android.app.Application
import com.example.mathapp.util.SettingsManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MathAppApplication : Application() {
    companion object {
        lateinit var instance: MathAppApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        SettingsManager.initialize(applicationContext)
        instance = this
    }

}