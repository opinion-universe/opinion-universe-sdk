package com.example.opinion_universe_sdk.network

import com.example.opinion_universe_sdk.models.AppOffer
import com.example.opinion_universe_sdk.models.OpinionFeedResponse
import com.example.opinion_universe_sdk.models.SurveyOffer
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpinionApiService {

    // No default values here anymore. Everything comes from the caller.
    @GET("publisher/offersFeed")
    suspend fun getOffers(
        @Query("pubid") pubId: String,
        @Query("app_id") appId: String,
        @Query("key") key: String,
        @Query("platform") platform: String = "All", // You can keep generic defaults like "All" if you want
        @Query("country") country: String = "All"
    ): Response<OpinionFeedResponse<AppOffer>>

    @GET("publisher/offersFeed")
    suspend fun getSurveys(
        @Query("pubid") pubId: String,
        @Query("app_id") appId: String,
        @Query("key") key: String,
        @Query("type") type: String = "live_surveys", // This is fixed for this method
        @Query("platform") platform: String = "All",
        @Query("country") country: String = "All"
    ): Response<OpinionFeedResponse<SurveyOffer>>
}