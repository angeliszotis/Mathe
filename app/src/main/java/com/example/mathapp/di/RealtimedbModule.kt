package com.example.mathapp.di

import android.content.Context
import com.example.mathapp.domain.Quiz.QuizRepositoryImpl
import com.example.mathapp.domain.QuizRepository
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCarsRepository(database: FirebaseDatabase): QuizRepository =
        QuizRepositoryImpl(database)

    @Provides
    @Singleton
    fun provideRealtimeDatabase(): FirebaseDatabase =
        Firebase.database("https://mathapp-373cc-default-rtdb.europe-west1.firebasedatabase.app/")

}