package com.scwj.syc.kotlinmvpdemo.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;

/**
 * Created by sunYuChen on 2018-08-08
 */
public class WaveView extends View {
    private int mWaveLength;
    private int mScreenWidth;
    private int mScreenHeight;
    private int mCenterY;
    private  int mWaveCount;
    private int offset;

    private Path mPath;
    private Paint mPaint;

    private ValueAnimator mValueAnimatior;

    public WaveView(Context context) {
        super(context);
    }

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(8);
        mPaint.setColor(Color.LTGRAY);
        mWaveLength = 800;

        addAnim();//添加属性动画
    }

    public WaveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // 需要计算出屏幕能容纳多少个波形
        mPath = new Path();
        mScreenHeight = h;
        mScreenWidth = w;
        mCenterY = h / 2;
        mWaveCount = (int) Math.round(mScreenWidth / mWaveLength + 1.5); // 计算波形的个数
        Log.e("波浪个数",String.valueOf(mWaveCount));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPath.reset();

        mPath.moveTo(-mWaveLength,mCenterY);
        for (int i = 0; i < mWaveCount; i++) {
            mPath.quadTo(-mWaveLength * 3 / 4 + i * mWaveLength + offset,mCenterY + 60,-mWaveLength / 2 + i * mWaveLength + offset,mCenterY);
            mPath.quadTo(-mWaveLength / 4 + i * mWaveLength + offset,mCenterY - 60,i * mWaveLength + offset,mCenterY);
        }

        mPath.lineTo(mScreenWidth,mScreenHeight);
        mPath.lineTo(0,mScreenHeight);
        mPath.close();
        canvas.drawPath(mPath,mPaint);



    }

    //添加属性动画
    private void addAnim(){
        mValueAnimatior = ValueAnimator.ofInt(0, mWaveLength);
        mValueAnimatior.setDuration(1000);
        mValueAnimatior.setInterpolator(new LinearInterpolator());
        mValueAnimatior.setRepeatCount(ValueAnimator.INFINITE);
        mValueAnimatior.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                offset = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        mValueAnimatior.start();

    }


}
