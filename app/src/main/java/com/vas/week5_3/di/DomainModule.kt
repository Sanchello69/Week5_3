package com.vas.week5_3.di

import com.vas.feature_main_screen.domain.repository.MainRepository
import com.vas.feature_main_screen.domain.useCase.GetMainUseCase
import com.vas.feature_main_screen.domain.useCase.PostLikeUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetMainUseCase(mainRepository: MainRepository): GetMainUseCase{
        return GetMainUseCase(mainRepository = mainRepository)
    }

    @Provides
    fun providePostLikeUseCase(mainRepository: MainRepository): PostLikeUseCase {
        return PostLikeUseCase(mainRepository = mainRepository)
    }

}