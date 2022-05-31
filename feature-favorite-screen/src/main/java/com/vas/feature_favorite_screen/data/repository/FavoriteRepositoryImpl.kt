package com.vas.feature_favorite_screen.data.repository

import com.vas.feature_favorite_screen.data.network.ApiFavorite
import com.vas.feature_favorite_screen.domain.model.FavoriteCatModel
import com.vas.feature_favorite_screen.domain.repository.FavoriteRepository

class FavoriteRepositoryImpl(private val api: ApiFavorite): FavoriteRepository {

    override suspend fun getFavoriteResult() : List<FavoriteCatModel> {
        return api.getFavoriteResult().map {
            FavoriteCatModel(it.imageId)
        }
    }
}