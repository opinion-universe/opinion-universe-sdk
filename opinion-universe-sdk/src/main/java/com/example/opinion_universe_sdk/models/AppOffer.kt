package com.example.opinion_universe_sdk.models

import com.google.gson.annotations.SerializedName

data class AppOffer(
    @SerializedName("offer_id") val offerId: String? = null,
    @SerializedName("offer_name") val name: String? = null,
    @SerializedName("offer_desc") val description: String? = null,
    @SerializedName("call_to_action") val callToAction: String? = null,
    @SerializedName("payout") val payout: Double? = null,
    @SerializedName("amount") val amount: Double? = null,
    @SerializedName("image_url") val imageUrl: String? = null,
    @SerializedName("offer_url_easy") val link: String? = null,
    @SerializedName("offer_type") val offerType: String? = null,
    @SerializedName("countries") val countries: String? = null,
    @SerializedName("devices") val devices: String? = null,
    @SerializedName("preview_url") val previewUrl: String? = null,
    @SerializedName("events") val events: List<OfferEvent>? = null
)