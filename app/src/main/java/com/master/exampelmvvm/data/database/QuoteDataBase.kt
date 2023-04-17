package com.master.exampelmvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.master.exampelmvvm.data.database.dao.QuoteDao
import com.master.exampelmvvm.data.database.entities.QuoteEntities

@Database(entities = [QuoteEntities::class], version = 1)
abstract class QuoteDataBase: RoomDatabase() {

    abstract fun getQuoteDao(): QuoteDao

}