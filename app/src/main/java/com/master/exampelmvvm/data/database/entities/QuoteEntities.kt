package com.master.exampelmvvm.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.master.exampelmvvm.domain.model.Quote

@Entity(tableName = "quote_table")
data class QuoteEntities(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int = 0,
    @ColumnInfo("quote") val quote: String,
    @ColumnInfo("author") val author: String

)

fun Quote.toDataBase() = QuoteEntities(quote = quote, author = author)