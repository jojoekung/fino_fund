package com.example.finofund.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.finofund.R
import com.example.finofund.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mainViewModel = MainViewModel()

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {

        mainViewModel.isLoading.observe(this, Observer {
            binding.loadingLayout.visibility = if (it) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })
    }
}