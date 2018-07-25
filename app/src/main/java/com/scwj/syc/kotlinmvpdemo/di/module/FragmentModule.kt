package com.scwj.syc.kotlinmvpdemo.di.module

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.scwj.syc.kotlinmvpdemo.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * Created by sunYuChen on 2018-07-23
 */
@Module
class FragmentModule(val fragment: Fragment){

    @Provides
    @FragmentScope
    fun provideActivity(): FragmentActivity? = fragment.activity
}