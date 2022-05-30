package com.vas.week5_3.di

import com.vas.feature_main_screen.domain.useCase.GetMainUseCase
import com.vas.feature_main_screen.domain.useCase.PostLikeUseCase
import com.vas.feature_main_screen.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideMainViewModelFactory(getMainUseCase: GetMainUseCase,
                                    postLikeUseCase: PostLikeUseCase): MainViewModelFactory {
        return MainViewModelFactory(getMainUseCase = getMainUseCase, postLikeUseCase = postLikeUseCase)
    }

}