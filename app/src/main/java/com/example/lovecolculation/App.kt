package com.example.lovecolculation

import android.app.Application
import androidx.room.Room
import com.example.lovecolculation.localdb.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "love_file").build()
    }
}

