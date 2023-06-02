package com.example.mathapp.di

import android.content.Context
import com.example.mathapp.data.room.dao.UserRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDb {
    @Singleton
    @Provides
    fun provideRoomDatabase(
        @ApplicationContext context: Context
    ): UserRoomDatabase {
        return UserRoomDatabase.getDatabase(context)
    }
}

