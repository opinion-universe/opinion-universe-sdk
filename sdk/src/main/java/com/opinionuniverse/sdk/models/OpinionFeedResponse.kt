package com.opinionuniverse.sdk.models

import com.google.gson.annotations.SerializedName

// 1. Root uses a Generic Type 'T'
data class OpinionFeedResponse<T>(
    @SerializedName("message") val message: String? = null,
    @SerializedName("code") val code: Int? = null,
    @SerializedName("data") val data: DataContainer<T>? = null
)

// 2. Data Container passes 'T' down
data class DataContainer<T>(
    @SerializedName("response") val response: ResponseContainer<T>? = null
)

// 3. Response Container holds the specific list
data class ResponseContainer<T>(
    @SerializedName("currency_name") val currencyName: String? = null,
    @SerializedName("offers") val offers: List<T>? = null
)