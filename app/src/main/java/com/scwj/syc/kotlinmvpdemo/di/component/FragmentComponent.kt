package com.scwj.syc.kotlinmvpdemo.di.component

import android.app.Activity
import com.scwj.syc.kotlinmvpdemo.di.module.FragmentModule
import com.scwj.syc.kotlinmvpdemo.di.scope.FragmentScope
import com.scwj.syc.kotlinmvpdemo.ui.main.fragment.HomeFragment
import com.scwj.syc.kotlinmvpdemo.ui.main.fragment.LifeFragment
import com.scwj.syc.kotlinmvpdemo.ui.main.fragment.MineFragment
import dagger.Component

/**
 * Created by sunYuChen on 2018-07-23
 */
@Component(modules = arrayOf(FragmentModule::class))
@FragmentScope
interface FragmentComponent {

    fun inject(homeFragment:HomeFragment)

    fun inject(lifeFragment: LifeFragment)

    fun inject(mineFragment: MineFragment)
}