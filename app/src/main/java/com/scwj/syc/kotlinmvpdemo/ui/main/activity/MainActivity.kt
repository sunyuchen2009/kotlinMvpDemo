package com.scwj.syc.kotlinmvpdemo.ui.main.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.scwj.syc.kotlinmvpdemo.R
import com.scwj.syc.kotlinmvpdemo.base.BaseActivity
import com.scwj.syc.kotlinmvpdemo.ui.main.contract.MainContract
import com.scwj.syc.kotlinmvpdemo.ui.main.fragment.HomeFragment
import com.scwj.syc.kotlinmvpdemo.ui.main.fragment.LifeFragment
import com.scwj.syc.kotlinmvpdemo.ui.main.fragment.MineFragment
import com.scwj.syc.kotlinmvpdemo.ui.main.presenter.MainPresenter
import com.scwj.syc.kotlinmvpdemo.widget.bottombar.BottomBar
import com.scwj.syc.kotlinmvpdemo.widget.bottombar.BottomBarTab
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_life.*
import kotlinx.android.synthetic.main.fragment_mine.*

class MainActivity : BaseActivity<MainPresenter>(),MainContract.Veiw {

    private val mFragments = arrayOfNulls<Fragment?>(3)

    override fun getLayout(): Int =R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFragments[0]=HomeFragment.newInstance()
        mFragments[1]=LifeFragment.newInstance()
        mFragments[2]=MineFragment.newInstance()

        //添加首页fragment
        addFragment(HomeFragment.newInstance(),R.id.main_fl_container)

        bottom_bar.addItem(BottomBarTab(this, R.mipmap.ic_launcher, R.mipmap.ic_launcher, getString(R.string.main_home)))
                .addItem(BottomBarTab(this, R.mipmap.ic_launcher, R.mipmap.ic_launcher, getString(R.string.main_home)))
                .addItem(BottomBarTab(this, R.mipmap.ic_launcher, R.mipmap.ic_launcher, getString(R.string.main_home)))

        bottom_bar.setOnTabSelectedListener(object : BottomBar.OnTabSelectedListener{

            override fun onTabSelected(position: Int, prePosition: Int) {
                replaceFragment(mFragments[position],R.id.main_fl_container)
                Log.e("TAG:","点击的是"+position.toString())
            }
            override fun onTabUnselected(position: Int) {
            }
            override fun onTabReselected(position: Int) {
            }
        })

//        addGifPic()
    }

    fun addGifPic(){
        Glide.with(this)
                .load("https://gss0.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/060828381f30e924d12005cd4a086e061c95f742.gif")
                .centerCrop()
                .into(life_iv_gif)

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
