package com.example.mathapp.di

import android.content.Context
import com.example.mathapp.data.room.dao.UserRoomDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.random.Random

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideQueryProductsByName() = Firebase.firestore
        .collection("unit1").whereEqualTo("id", Random.nextInt(1,20).toString())


}

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

