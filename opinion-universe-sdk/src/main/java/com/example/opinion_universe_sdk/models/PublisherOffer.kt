package com.example.opinion_universe_sdk.models

import com.google.gson.annotations.SerializedName

data class PublisherOffer(
    @SerializedName("offer_id")
    val offer_id: String? = null,

    @SerializedName("offer_name")
    val name: String? = null,

    @SerializedName("offer_desc")
    val description: String? = null,

    @SerializedName("call_to_action")
    val callToAction: String? = null,

    @SerializedName("payout")
    val payout: Double? = null,

    @SerializedName("amount")
    val amount: Double? = null,

    @SerializedName("image_url")
    val image_url: String? = null,

    @SerializedName("offer_url_easy")
    val link: String? = null,

    @SerializedName("offer_type")
    val offerType: String? = null,

    @SerializedName("countries")
    val countries: String? = null,

    @SerializedName("devices")
    val devices: String? = null,

    @SerializedName("preview_url")
    val previewUrl: String? = null,

    @SerializedName("events")
    val events: List<OfferEvent>? = null,

    // 🔴 CHANGED FROM Int? TO Double?
    @SerializedName("loi")
    val loi: Double? = null,

    // 🔴 CHANGED FROM Int? TO Double? (Just to be safe)
    @SerializedName("ir")
    val ir: Double? = null
)