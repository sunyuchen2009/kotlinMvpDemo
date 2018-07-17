package com.scwj.syc.kotlinmvpdemo.ui.main.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.scwj.syc.kotlinmvpdemo.R
import com.scwj.syc.kotlinmvpdemo.base.BaseActivity
import com.scwj.syc.kotlinmvpdemo.di.component.ActivityComponent
import com.scwj.syc.kotlinmvpdemo.ui.main.contract.MainContract
import com.scwj.syc.kotlinmvpdemo.ui.main.presenter.MainPresenter

class MainActivity : BaseActivity<MainPresenter>(),MainContract.Veiw {


    override fun getLayout(): Int =R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initInject() {
        activityComponent.inject(this)
    }

    override fun initPresenter() {
        mPresenter.attachView(this)
    }

    override fun showMsg(msg: String) {
        Toast.makeText(this,"Great",Toast.LENGTH_SHORT).show()
    }

}
