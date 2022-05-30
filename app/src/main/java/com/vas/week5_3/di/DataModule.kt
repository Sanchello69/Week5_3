package com.vas.week5_3.di

import com.vas.feature_main_screen.data.network.Api
import com.vas.feature_main_screen.data.network.KtorClient
import com.vas.feature_main_screen.data.repository.MainRepositoryImpl
import com.vas.feature_main_screen.domain.repository.MainRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideApiHelper(): Api {
        return Api(KtorClient.httpClient)
    }

    @Provides
    fun provideMainRepository(api: Api): MainRepository{
        return MainRepositoryImpl(api = api)
    }

}