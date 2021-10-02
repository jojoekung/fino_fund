package com.example.finofund.data

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("recruitment-test/fund-ranking-1Y.json")
    fun getAllFund():Call<FundRankResponse>

}