package com.vas.feature_main_screen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vas.feature_main_screen.domain.useCase.GetMainUseCase
import com.vas.feature_main_screen.domain.useCase.PostLikeUseCase

class MainViewModelFactory(val getMainUseCase: GetMainUseCase,
                           val postLikeUseCase: PostLikeUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                getMainUseCase = getMainUseCase,
                postLikeUseCase = postLikeUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}