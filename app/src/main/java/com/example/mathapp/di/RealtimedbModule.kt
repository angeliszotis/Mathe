package com.example.mathapp.di

import android.content.Context
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TakeRealTimeData {


    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): FirebaseDatabase {
        return   Firebase.database("https://mathapp-373cc-default-rtdb.europe-west1.firebasedatabase.app/")

    }

}