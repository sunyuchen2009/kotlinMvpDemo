package com.scwj.syc.kotlinmvpdemo.ui.login.activity

import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.scwj.syc.kotlinmvpdemo.R
import com.scwj.syc.kotlinmvpdemo.base.BaseActivity
import com.scwj.syc.kotlinmvpdemo.ui.login.contract.LoginContract
import com.scwj.syc.kotlinmvpdemo.ui.login.presenter.LoginPresenter
import com.scwj.syc.kotlinmvpdemo.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by sunYuChen on 2018-07-13
 */
class LoginActivity:BaseActivity<LoginPresenter>(),LoginContract.View{

    override fun getLayout(): Int =R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showMsg("testSuccess")
        Glide.with(this)
                .load("https://www.easyicon.net/api/resizeApi.php?id=1082114&size=128")
                .into(iv_hello)
    }

    override fun showMsg(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        tv_hello.setText(msg)
    }


    override fun initInject() =activityComponent.inject(this)

    override fun initPresenter() =mPresenter.attachView(this)
}