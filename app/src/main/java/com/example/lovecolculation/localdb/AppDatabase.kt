package com.example.lovecolculation.localdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecolculation.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
 abstract class AppDatabase : RoomDatabase() {

    abstract fun getDao(): LoveDao

}