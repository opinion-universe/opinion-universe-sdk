package com.opinionuniverse.sdk

import android.util.Log
import com.opinionuniverse.sdk.models.AppOffer
import com.opinionuniverse.sdk.models.SurveyOffer
import com.opinionuniverse.sdk.network.RetrofitClient

object OpinionUniverse {

    private const val TAG = "OpinionUniverseSDK"

    // Internal storage for configuration
    private var pubId: String? = null
    private var appId: String? = null
    private var isInitialized = false

    /**
     * Step 1: Initialize the SDK with your static IDs.
     * Call this once (e.g., in Application class or MainActivity onCreate).
     */
    fun init(pubId: String, appId: String) {
        this.pubId = pubId
        this.appId = appId
        this.isInitialized = true
        Log.d(TAG, "SDK Initialized with PubID: $pubId, AppID: $appId")
    }

    /**
     * Fetch Apps/Games.
     * Requires 'key' to be passed dynamically.
     */
    suspend fun getOffers(key: String): List<AppOffer> {
        if (!isInitialized) {
            Log.e(TAG, "❌ SDK not initialized! Call OpinionUniverse.init() first.")
            return emptyList()
        }

        return try {
            val response = RetrofitClient.instance.getOffers(
                pubId = pubId!!,
                appId = appId!!,
                key = key
            )

            if (response.isSuccessful && response.body() != null) {
                response.body()!!.data?.response?.offers ?: emptyList()
            } else {
                Log.e(TAG, "getOffers failed: ${response.code()}")
                emptyList()
            }
        } catch (e: Exception) {
            Log.e(TAG, "getOffers exception", e)
            emptyList()
        }
    }

    /**
     * Fetch Surveys.
     * Requires 'key' to be passed dynamically.
     */
    suspend fun getSurveys(key: String): List<SurveyOffer> {
        if (!isInitialized) {
            Log.e(TAG, "❌ SDK not initialized! Call OpinionUniverse.init() first.")
            return emptyList()
        }

        return try {
            val response = RetrofitClient.instance.getSurveys(
                pubId = pubId!!,
                appId = appId!!,
                key = key
            )

            if (response.isSuccessful && response.body() != null) {
                response.body()!!.data?.response?.offers ?: emptyList()
            } else {
                Log.e(TAG, "getSurveys failed: ${response.code()}")
                emptyList()
            }
        } catch (e: Exception) {
            Log.e(TAG, "getSurveys exception", e)
            emptyList()
        }
    }
}