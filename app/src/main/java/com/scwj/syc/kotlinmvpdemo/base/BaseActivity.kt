package com.scwj.syc.kotlinmvpdemo.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
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

    //FragmentManager的扩展函数
    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        beginTransaction().func().commit()
    }

    //添加fragment方法
    fun FragmentActivity.addFragment(fragment: Fragment?, frameId: Int){
        supportFragmentManager.inTransaction { add(frameId, fragment!!) }
    }

    //替换fragment方法
    fun FragmentActivity.replaceFragment(fragment: Fragment?, frameId: Int){
        supportFragmentManager.inTransaction { replace(frameId,fragment!!) }
    }

    //在子类中重写这个方法以注入Activity中的对象
    abstract fun initInject()

    //在子类中重写这个方法将通过attachView()方法连接presenter与veiw
    abstract fun initPresenter()

    protected abstract fun getLayout():Int
}