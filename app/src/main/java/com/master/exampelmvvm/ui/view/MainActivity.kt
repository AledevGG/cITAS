package com.master.exampelmvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.master.exampelmvvm.databinding.ActivityMainBinding

import com.master.exampelmvvm.ui.viewModel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val quoteViewModel: QuoteViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        quoteViewModel.onCreate()



        quoteViewModel.quoteModel.observe(this,  Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })

        quoteViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }
    }
}