package com.scwj.syc.kotlinmvpdemo.di.component

import android.app.Activity
import com.scwj.syc.kotlinmvpdemo.di.module.ActivityModule
import com.scwj.syc.kotlinmvpdemo.di.scope.ActivityScope
import com.scwj.syc.kotlinmvpdemo.ui.login.activity.LoginActivity
import com.scwj.syc.kotlinmvpdemo.ui.main.activity.MainActivity
import dagger.Component

/**
 * Created by sunYuChen on 2018-07-13
 */
@Component(modules = arrayOf(ActivityModule::class))
@ActivityScope
interface ActivityComponent {

    fun getActivity(): Activity

    fun inject(loginActivity:LoginActivity)

    fun inject(mainActivity:MainActivity)
}