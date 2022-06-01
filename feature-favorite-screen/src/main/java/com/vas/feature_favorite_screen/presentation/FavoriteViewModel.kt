package com.vas.feature_favorite_screen.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vas.core.utils.Resource
import com.vas.feature_favorite_screen.domain.model.FavoriteCatModel
import com.vas.feature_favorite_screen.domain.useCase.GetFavoriteUseCase
import kotlinx.coroutines.*

class FavoriteViewModel(private val getFavoriteUseCase: GetFavoriteUseCase): ViewModel() {

    fun getFavorite() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = getFavoriteUseCase.execute()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}