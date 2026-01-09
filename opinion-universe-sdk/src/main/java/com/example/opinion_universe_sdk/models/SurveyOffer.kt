package com.example.opinion_universe_sdk.models

import com.google.gson.annotations.SerializedName

data class SurveyOffer(
    @SerializedName("offer_id") val offerId: String? = null,
    @SerializedName("offer_name") val name: String? = null,
    @SerializedName("payout") val payout: Double? = null,
    @SerializedName("amount") val amount: Double? = null,
    @SerializedName("image_url") val imageUrl: String? = null,
    @SerializedName("offer_url_easy") val link: String? = null,
    @SerializedName("offer_type") val offerType: String? = null,
    @SerializedName("countries") val countries: String? = null,

    // Specific to Surveys
    @SerializedName("loi") val loi: Double? = null,
    @SerializedName("ir") val ir: Double? = null
)