package com.scwj.syc.kotlinmvpdemo.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.scwj.syc.kotlinmvpdemo.R;
import skin.support.widget.SkinCompatSupportable;

/**
 * Created by sunYuChen on 2018-07-31
 * 自定义实心圆view，具体实现过程在onDraw()方法中
 */
public class CircleView extends View implements SkinCompatSupportable{

    //设置画笔变量
    private Paint mPaint;

    private int mColor;

    //自定义view有4个构造函数
    //如果这个view是在java中new的，则用第一个构造方法
    public CircleView(Context context) {
        super(context);
        init();  //初始化画笔操作
    }

    //如果这个view在xml中声明，则调用第二个构造方法
    //自定义属性是从attrs参数中传入的
    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,0);

        //加载自定义属性集合
        TypedArray a=context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        //解析集合中的circle_color属性
        //将解析的属性传入画笔颜色变量中（本周是定义画笔颜色）
        //第二个参数是默认颜色，即没有指定circle_color是显示的颜色
        mColor=a.getColor(R.styleable.CircleView_circle_color,Color.RED);

        //解析后释放资源
        a.recycle();
        init();
    }

    //不会自动调用
    //一般在第二个构造函数中主动使用（如view有style属性时）
    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    //API21 之后才使用
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }

    //画笔初始化
    private void init(){
        //实例化
        mPaint=new Paint();
        //设置画笔颜色
        mPaint.setColor(mColor);
        //设置画笔宽度
        mPaint.setStrokeWidth(5f);
        //设置画笔模式为填充
        mPaint.setStyle(Paint.Style.FILL);
    }

    //在这个方法中进行绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int paddingTop=getPaddingTop();
        int paddingBottom=getPaddingBottom();
        int paddingLeft=getPaddingLeft();
        int paddingRight=getPaddingRight();

        //这里的width和height只是获取从xml中传入的值，可以根据这两个值去约束绘制的图形的大小
        //考虑padding的情况
        int width=getWidth()-paddingLeft-paddingRight;
        int height=getHeight()-paddingTop-paddingBottom;
        int r=Math.min(width,height)/2;

        canvas.drawCircle(width/2+paddingLeft,height/2+paddingTop,r,mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //获取宽度的测量模式以及大小
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);

        //获取长度的测量模式以及大小
        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);

        //设置默认宽、高，需要根据需求灵活设置
        int mWidth=400;
        int mHeight=400;

        //当布局参数都设置为WRAP、其中一个设置为WRAP时，设置默认值
        if (getLayoutParams().width== ViewGroup.LayoutParams.WRAP_CONTENT
                && getLayoutParams().height==ViewGroup.LayoutParams.WRAP_CONTENT){
            setMeasuredDimension(mWidth,mHeight);
        } else if (getLayoutParams().width==ViewGroup.LayoutParams.WRAP_CONTENT){
            setMeasuredDimension(mWidth,heightSize);
        } else if (getLayoutParams().height==ViewGroup.LayoutParams.WRAP_CONTENT){
            setMeasuredDimension(widthSize,mHeight);
        }
    }

    @Override
    public void applySkin() {

    }
}
