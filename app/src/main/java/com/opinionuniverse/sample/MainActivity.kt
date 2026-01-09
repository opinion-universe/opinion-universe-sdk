package com.opinionuniverse.opinionuniversesdk

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.opinionuniverse.sdk.OpinionUniverse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Initialize the SDK (Do this once, e.g., when app starts)
        val myPubId = "16"
        val myAppId = "ID_241d2f6907795bff19dc741ac40fabff"
        OpinionUniverse.init(myPubId, myAppId)

        // 2. The dynamic Key (could come from your backend or config)
        val myUserKey = "61ed8cf1d77421a82cff3a2f24b9afdfca4ffde1f530cd8b"

        lifecycleScope.launch(Dispatchers.IO) {

            // --- Fetch Apps ---
            Log.d("SDK_APP", "--- Fetching Apps ---")
            val apps = OpinionUniverse.getOffers(key = myUserKey)
            Log.d("SDK_APP", "✅ Apps Loaded: ${apps.size}")
            apps.take(3).forEach {
                Log.d("SDK_APP", "   📱 ${it}")
            }

            // --- Fetch Surveys ---
            Log.d("SDK_APP", "--- Fetching Surveys ---")
            val surveys = OpinionUniverse.getSurveys(key = myUserKey)
            Log.d("SDK_APP", "✅ Surveys Loaded: ${surveys.size}")
            surveys.take(3).forEach {
                Log.d("SDK_APP", "   📝 ${it}")
            }
        }
    }
}