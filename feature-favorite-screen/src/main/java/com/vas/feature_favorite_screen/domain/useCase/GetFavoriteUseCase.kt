package com.vas.feature_favorite_screen.domain.useCase

import com.vas.feature_favorite_screen.domain.model.FavoriteCatModel
import com.vas.feature_favorite_screen.domain.repository.FavoriteRepository

class GetFavoriteUseCase(private val favoriteRepository: FavoriteRepository) {

    suspend fun execute(): List<FavoriteCatModel> {
        return favoriteRepository.getFavoriteResult()
    }
}