package com.scwj.syc.kotlinmvpdemo.di.module

import android.app.Activity
import com.scwj.syc.kotlinmvpdemo.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by sunYuChen on 2018-07-16
 */
@Module
class ActivityModule(val activity:Activity) {

    @Provides
    @ActivityScope
    fun provideActivity():Activity=activity
}