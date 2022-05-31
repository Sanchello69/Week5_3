package com.vas.feature_favorite_screen.domain.repository

import com.vas.feature_favorite_screen.domain.model.FavoriteCatModel

interface FavoriteRepository {
    suspend fun getFavoriteResult() : List<FavoriteCatModel>
}