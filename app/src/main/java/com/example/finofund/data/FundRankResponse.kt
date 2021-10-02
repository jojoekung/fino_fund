package com.example.finofund.data

import com.google.gson.annotations.SerializedName

data class FundRankResponse(

    @SerializedName("data")
    val data: List<Fund>? = null,

    @SerializedName("error")
    val error: String? = null,

    @SerializedName("status")
    val status: Boolean? = null
)

data class Fund(

    @SerializedName("mstar_id")
    val mStarId: String? = null,

    @SerializedName("nav")
    val nav: Double? = null,

    @SerializedName("thailand_fund_code")
    val thailandFundCode: String? = null,

    @SerializedName("nav_return")
    val navReturn: Double? = null,

    @SerializedName("nav_date")
    val navDate: String? = null,

    @SerializedName("avg_return")
    val avgReturn: Double? = null
)
