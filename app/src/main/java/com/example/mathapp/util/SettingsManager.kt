package com.example.mathapp.util

import android.content.Context
import android.content.SharedPreferences

object SettingsManager {
    private const val PREFS_NAME = "MyAppPrefs"
    private const val PREF_MUSIC_ENABLED = "MusicEnabled"

    private lateinit var sharedPreferences: SharedPreferences

    fun initialize(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun isMusicEnabled(): Boolean {
        return sharedPreferences.getBoolean(PREF_MUSIC_ENABLED, true)
    }

    fun setMusicEnabled(enabled: Boolean) {
        sharedPreferences.edit().putBoolean(PREF_MUSIC_ENABLED, enabled).apply()
    }
}