package com.vas.week5_3.app

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.vas.feature_main_screen.di.MainDepsStore
import com.vas.week5_3.di.AppComponent
import com.vas.week5_3.di.DaggerAppComponent

class App : Application(){

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this)

        appComponent = DaggerAppComponent.create()

        MainDepsStore.deps = appComponent
        //DetailsDepsStore.deps = appComponent
    }
}