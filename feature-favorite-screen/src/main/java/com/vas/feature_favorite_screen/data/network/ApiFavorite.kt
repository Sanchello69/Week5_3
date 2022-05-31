package com.vas.feature_favorite_screen.data.network

import android.util.Log
import com.vas.core.utils.Constants
import com.vas.feature_favorite_screen.data.model.FavoriteCatModelApi
import io.ktor.client.*
import io.ktor.client.request.*

class ApiFavorite (private val httpClient: HttpClient) {

    suspend fun getFavoriteResult(): List<FavoriteCatModelApi> {
        try {
            val response: List<FavoriteCatModelApi> = httpClient.get(Constants.BASE_URL + Constants.FAVORITE_URL){
                url {
                    parameters.append("limit", "10")
                }
                header("x-api-key", Constants.API_KEY)
            }

            return response
        } catch (e: Exception){
            Log.d("error_get_main", "${e.message}")
            return emptyList()
        }
    }
}