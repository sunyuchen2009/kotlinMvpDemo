package com.scwj.syc.kotlinmvpdemo.ui.main.fragment

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import com.bumptech.glide.Glide
import com.scwj.syc.kotlinmvpdemo.R
import com.scwj.syc.kotlinmvpdemo.base.BaseActivity
import com.scwj.syc.kotlinmvpdemo.base.BaseFragment
import com.scwj.syc.kotlinmvpdemo.di.component.FragmentComponent
import com.scwj.syc.kotlinmvpdemo.ui.main.contract.MineContract
import com.scwj.syc.kotlinmvpdemo.ui.main.presenter.MinePresenter
import kotlinx.android.synthetic.main.fragment_life.*
import kotlinx.android.synthetic.main.fragment_mine.*

/**
 * Created by sunYuChen on 2018-07-25
 */
class MineFragment:BaseFragment<MinePresenter>(),MineContract.View {
    override fun initInject() {
        fragmentComponent.inject(this)
    }

    override fun initPresenter() {
        mPresenter.attachView(this)
    }

    override fun getLayout(): Int = R.layout.fragment_mine

    override fun showMsg(msg: String) {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Glide.with(this)
//                .load("https://www.easyicon.net/api/resizeApi.php?id=1082114&size=128")
//                .into(mine_iv_gif)
    }

    //为circleView设置添加平移动画
    private fun startTranslateAnim() {
        /**
         *  fromXDelta:视图在水平方向x 移动的起始值
         *  toXDelta:  视图在水平方向x 移动的结束值
         *  fromYDelta:视图在竖直方向y 移动的起始值
         *  toYDelta:  视图在竖直方向y 移动的结束值
         */
        var translateAnimatin: Animation = TranslateAnimation(0f,500f,0f,500f)

        translateAnimatin.duration=3000 //设置动画持续时间

        life_circle.startAnimation(translateAnimatin)
    }

    companion object {

        val TAG=MineFragment::class.java.simpleName

        fun newInstance():MineFragment{
            val args= Bundle()
            val fragment=MineFragment()
            fragment.arguments=args
            return fragment
        }
    }

}