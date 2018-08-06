package com.scwj.syc.kotlinmvpdemo.ui.main.fragment

import android.os.Bundle
import android.view.View
import android.view.animation.*
import com.bumptech.glide.Glide
import com.scwj.syc.kotlinmvpdemo.R
import com.scwj.syc.kotlinmvpdemo.base.BaseFragment
import com.scwj.syc.kotlinmvpdemo.ui.main.contract.LifeContract
import com.scwj.syc.kotlinmvpdemo.ui.main.presenter.LifePresenter
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_life.*
import javax.inject.Inject

/**
 * Created by sunYuChen on 2018-07-24
 */
class LifeFragment @Inject
constructor():BaseFragment<LifePresenter>(),LifeContract.View{
    override fun initPresenter() {
        mPresenter.attachView(this)
    }

    override fun initInject() {
        fragmentComponent.inject(this)
    }

    override fun getLayout(): Int =R.layout.fragment_life

    override fun showMsg(msg: String) {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        startTranslateAnim()
//        startScaleAnim()
//        startRotateAnim()
//        startAlphaAnim()
        startCombineAnim()
    }

    //为circleView设置添加平移动画
    private fun startTranslateAnim() {
        /**
         *  fromXDelta:视图在水平方向x 移动的起始值
         *  toXDelta:  视图在水平方向x 移动的结束值
         *  fromYDelta:视图在竖直方向y 移动的起始值
         *  toYDelta:  视图在竖直方向y 移动的结束值
         */
        var translateAnimatin:Animation= TranslateAnimation(0f,500f,0f,500f)

        translateAnimatin.duration=3000 //设置动画持续时间

        life_circle.startAnimation(translateAnimatin)
    }

    //为circleView添加缩放动画
    private fun startScaleAnim(){
        /**
         *  fromX：      动画在水平方向X的起始缩放倍数
         *  toX：        动画在水平方向X的结束缩放倍数
         *  fromY：      动画在竖直方向Y的起始缩放倍数
         *  toY：        动画在竖直方向Y的结束缩放倍数
         *  pivotXType： 缩放轴点的x坐标的模式
         *  pivotXValue：缩放轴点x坐标的相对值
         *  pivotYType： 缩放轴点y坐标的模式
         *  pivotYValue：缩放轴点y坐标的相对值
         *
         *  pivotXType = Animation.ABSOLUTE：          缩放轴点的x坐标 = View左上角原点(在x方向) + pivotXValue
         *  pivotXType = Animation.RELATIVE_TO_SELF：  缩放轴点的x坐标 = View左上角原点(在x方向) + 自身宽度 * pivotXValue
         *  pivotXType = Animation.RELATIVE_TO_PARENT：缩放轴点的x坐标 = View左上角原点(在x方向) + 父控件宽度 * pivotXValue
         */
        var scaleAnimation:Animation= ScaleAnimation(0f,2f,0f,2f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
        scaleAnimation.duration=3000
        life_circle.startAnimation(scaleAnimation)
    }

    //为circleView添加旋转动画
    private fun startRotateAnim(){
        /**
         *  fromDegrees: 动画开始时，视图的旋转角度（正数为顺时针，负数为逆时针）
         *  toDegrees:   动画结束时，视图的旋转角度（正数为顺时针，负数为逆时针）
         *  pivotXType： 缩放轴点的x坐标的模式
         *  pivotXValue：缩放轴点x坐标的相对值
         *  pivotYType： 缩放轴点y坐标的模式
         *  pivotYValue：缩放轴点y坐标的相对值
         *
         *  pivotXType = Animation.ABSOLUTE：          旋转轴点的x坐标 = View左上角原点(在x方向) + pivotXValue
         *  pivotXType = Animation.RELATIVE_TO_SELF：  旋转轴点的x坐标 = View左上角原点(在x方向) + 自身宽度 * pivotXValue
         *  pivotXType = Animation.RELATIVE_TO_PARENT：旋转轴点的x坐标 = View左上角原点(在x方向) + 父控件宽度 * pivotXValue
         */
        var rotateAnimation:Animation=RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
        rotateAnimation.duration=3000
        life_circle.startAnimation(rotateAnimation)
    }

    //为circleView设置透明度动画
    private fun startAlphaAnim(){
        /**
         *  fromAlpha:动画开始时视图的透明度（取值范围-1~1）
         *  toAlpha:  动画结束时的透明度（取值范围-1~1）
         */
        var alphaAnimation:Animation = AlphaAnimation(1f,0f)
        alphaAnimation.duration=3000
        life_circle.startAnimation(alphaAnimation)
    }

    //为circleView设置组合动画
    private fun startCombineAnim(){
        /**
         *  shareInterpolator:
         *      Pass true if all of the animations in this set should use the interpolator associated with this AnimationSet.
         *      Pass false if each animation should use its own interpolator.
         */
        var setAnimation:AnimationSet = AnimationSet(true)

        var overshootInterpolator:OvershootInterpolator=OvershootInterpolator()
        setAnimation.interpolator=overshootInterpolator


        //子动画1:旋转
        var rotate:Animation=RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
        rotate.duration=1000

        //自动画2：平移
        var translate:Animation=TranslateAnimation(TranslateAnimation.RELATIVE_TO_PARENT,-0.5f,
                                                    TranslateAnimation.RELATIVE_TO_PARENT,0.5f,
                                                    TranslateAnimation.RELATIVE_TO_SELF,0f,
                                                    TranslateAnimation.RELATIVE_TO_SELF,0f)
        translate.duration=8000

        //子动画3：透明度
        var alpha:Animation=AlphaAnimation(1f,0f)
        alpha.duration=3000
        alpha.startOffset=7000

        //子动画4：缩放
        var scale:Animation=ScaleAnimation(1f,0.5f,1f,0.5f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
        scale.duration=1000
        scale.startOffset=4000

        //将4个子动画添加到组合动画里
        setAnimation.addAnimation(rotate)
        setAnimation.addAnimation(alpha)
        setAnimation.addAnimation(translate)
        setAnimation.addAnimation(scale)

        life_circle.startAnimation(setAnimation)

    }


    companion object {

        val TAG=LifeFragment::class.java.simpleName

        fun newInstance():LifeFragment{
            val args= Bundle()
            val fragment=LifeFragment()
            fragment.arguments=args
            return fragment
        }
    }
}