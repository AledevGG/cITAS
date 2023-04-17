package com.master.exampelmvvm.data

import com.master.exampelmvvm.data.database.dao.QuoteDao
import com.master.exampelmvvm.data.database.entities.QuoteEntities
import com.master.exampelmvvm.data.network.QuoteService
import com.master.exampelmvvm.domain.model.Quote
import com.master.exampelmvvm.domain.model.ToDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService, private val quoteDao: QuoteDao  ) {


    suspend fun getAllQuoteFromApi():List<Quote>{
        val response = api.getQuotes()
        return response.map {it.ToDomain()  }
    }

    suspend fun getAllQuoteFromDataBase(): List<Quote> {

        val response: List<QuoteEntities> = quoteDao.getAllQuotes()
      return response.map { it.ToDomain()  }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntities>) {
        quoteDao.insertALL(quotes)
    }

    suspend fun clearQuotes() {

        quoteDao.deleteAllquotes()
    }
}