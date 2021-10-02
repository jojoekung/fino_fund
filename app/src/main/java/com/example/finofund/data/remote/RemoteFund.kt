package com.example.finofund.data.remote

import com.example.finofund.data.ApiService
import com.example.finofund.data.Fund
import com.example.finofund.data.FundRankResponse
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class RemoteFund {

    private val okHttpClient = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(ApiService::class.java)

    fun getFund(onSuccess: (List<Fund>) -> Unit, onFail: () -> Unit) {

        retrofit.getAllFund()
            .enqueue(object : Callback<FundRankResponse> {
                override fun onResponse(
                    call: Call<FundRankResponse>,
                    response: Response<FundRankResponse>
                ) {
                    if (response.code() == 200) {
                        val data = response.body()?.data
                        data?.let {
                            onSuccess.invoke(data)
                        } ?: run {
                            onFail.invoke()
                        }
                    } else {
                        onFail.invoke()
                    }
                }

                override fun onFailure(call: Call<FundRankResponse>, t: Throwable) {
                    onFail.invoke()
                }
            })
    }

    companion object {

        const val BASE_URL = "https://storage.googleapis.com/finno-ex-re-v2-static-staging/"
    }
}