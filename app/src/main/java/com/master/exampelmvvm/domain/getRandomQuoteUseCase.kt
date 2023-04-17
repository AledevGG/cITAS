package com.master.exampelmvvm.domain

import com.master.exampelmvvm.data.QuoteRepository
import com.master.exampelmvvm.data.model.QuoteModel
import com.master.exampelmvvm.domain.model.Quote
import javax.inject.Inject

class getRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

  suspend operator fun invoke(): Quote?{
        val quotes = repository.getAllQuoteFromDataBase()
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}