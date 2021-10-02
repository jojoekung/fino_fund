package com.example.finofund.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finofund.R
import com.example.finofund.databinding.ActivityMainBinding
import com.example.finofund.utils.goneView
import com.example.finofund.utils.visibleView

class MainActivity : AppCompatActivity() {

    private val mainViewModel = MainViewModel()
    private val fundAdapter = FundAdapter()

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

        mainViewModel.fund.observe(this, Observer {
            if (it.isNullOrEmpty()) {
                fundAdapter.clearData()
                binding.tvNoData.visibleView()
            } else {
                fundAdapter.addFund(it)
                binding.tvNoData.goneView()
            }
        })

        binding.rcFundList.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL, false
        )
        binding.rcFundList.adapter = fundAdapter
    }
}