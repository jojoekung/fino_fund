package com.example.finofund.domain

import com.example.finofund.data.Fund
import com.example.finofund.data.remote.RemoteFund

class FundUseCase {

    private val remoteFund = RemoteFund()

    fun getAllFund(onSuccess: (List<Fund>) -> Unit, onFail: () -> Unit) {

        remoteFund.getFund(onSuccess = {
            onSuccess.invoke(it)
        }, onFail = {
            onFail.invoke()
        })
    }
}