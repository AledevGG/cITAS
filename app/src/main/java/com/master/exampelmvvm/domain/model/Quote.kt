package com.master.exampelmvvm.domain.model

import com.master.exampelmvvm.data.database.entities.QuoteEntities
import com.master.exampelmvvm.data.model.QuoteModel

data class Quote(val quote: String, val author: String)


fun QuoteModel.ToDomain() = Quote(quote, author)
fun QuoteEntities.ToDomain() = Quote(quote, author)
