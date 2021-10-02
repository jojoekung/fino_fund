package com.example.finofund.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finofund.data.Fund
import com.example.finofund.domain.FundUseCase

class MainViewModel : ViewModel() {

    private val fundUseCase = FundUseCase()

    private val _fund = MutableLiveData<List<Fund>>()
    val fund: LiveData<List<Fund>>
        get() = _fund

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        showLoading()
        getFund()
    }

    fun getFund() {

        fundUseCase.getAllFund({
            hideLoading()
            _fund.postValue(it)
        }, {
            hideLoading()
        })
    }

    fun hideLoading() {
        _isLoading.postValue(false)
    }

    fun showLoading() {
        _isLoading.postValue(true)
    }
}