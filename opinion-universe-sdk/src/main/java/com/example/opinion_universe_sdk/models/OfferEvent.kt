package com.example.opinion_universe_sdk.models

import com.google.gson.annotations.SerializedName

data class OfferEvent(
    @SerializedName("event_id")
    val eventId: String? = null,

    @SerializedName("event_name")
    val eventName: String? = null,

    // In your JSON, these are strings inside quotes like "0.210"
    @SerializedName("event_payout")
    val eventPayout: String? = null,

    @SerializedName("event_amount")
    val eventAmount: String? = null
)