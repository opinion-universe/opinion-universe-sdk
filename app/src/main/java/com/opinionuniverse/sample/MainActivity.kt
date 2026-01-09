package com.opinionuniverse.sample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.opinionuniverse.sdk.OpinionUniverse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext // Added this import

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Calling the function so it actually runs when the app starts
        loadSdkData()
    }

    private fun loadSdkData() {
        // 1. Initialize with placeholders for the client
        // Provide these to your client separately
        val publisherId = "YOUR_PUBLISHER_ID"
        val appId = "YOUR_APP_ID"
        OpinionUniverse.init(publisherId, appId)

        val userKey = "USER_DYNAMIC_KEY"

        lifecycleScope.launch(Dispatchers.IO) {
            try {
                // --- 1. Fetch Apps/Offers ---
                val apps = OpinionUniverse.getOffers(key = userKey)

                withContext(Dispatchers.Main) {
                    // This is where the client would update a RecyclerView or UI
                    Log.d("OpinionUniverse", "✅ Apps Loaded: ${apps.size}")
                }

                // --- 2. Fetch Surveys ---
                val surveys = OpinionUniverse.getSurveys(key = userKey)

                withContext(Dispatchers.Main) {
                    Log.d("OpinionUniverse", "✅ Surveys Loaded: ${surveys.size}")
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.e("OpinionUniverse", "❌ Error loading data: ${e.message}")
                }
            }
        }
    }
}