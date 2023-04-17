package com.master.exampelmvvm.domain

import com.master.exampelmvvm.data.QuoteRepository
import com.master.exampelmvvm.data.database.entities.toDataBase
import com.master.exampelmvvm.data.model.QuoteModel
import com.master.exampelmvvm.domain.model.Quote
import javax.inject.Inject

class getQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {


    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuoteFromApi()

      return  if (quotes.isNotEmpty()) {
          repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDataBase() })
          quotes
        } else {

            repository.getAllQuoteFromDataBase()
        }

    }

}

