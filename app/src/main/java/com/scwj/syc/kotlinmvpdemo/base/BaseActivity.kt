package com.scwj.syc.kotlinmvpdemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.scwj.syc.kotlinmvpdemo.di.component.ActivityComponent
import com.scwj.syc.kotlinmvpdemo.di.component.DaggerActivityComponent
import com.scwj.syc.kotlinmvpdemo.di.module.ActivityModule
import javax.inject.Inject


/**
 * Created by sunYuChen on 2018-07-16
 */
abstract class BaseActivity<T:BasePresenter<*>>:AppCompatActivity(),BaseView {
    @Inject
    lateinit var mPresenter: T

    protected val activityComponent:ActivityComponent
        get() = DaggerActivityComponent.builder()
            .activityModule(activityModule)
            .build()

    protected val activityModule:ActivityModule
        get() = ActivityModule(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initInject()
        initPresenter()
    }

    abstract fun initInject()

    abstract fun initPresenter()

    protected abstract fun getLayout():Int
}