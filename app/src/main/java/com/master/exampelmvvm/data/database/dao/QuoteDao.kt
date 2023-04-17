package com.master.exampelmvvm.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.master.exampelmvvm.data.database.entities.QuoteEntities


@Dao
interface QuoteDao {

    @Query("SELECT * FROM quote_table ORDER BY author DESC")
    suspend fun getAllQuotes(): List<QuoteEntities>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertALL(quotes: List<QuoteEntities>)

    @Query("DELETE FROM quote_table")
    suspend fun deleteAllquotes()

}


