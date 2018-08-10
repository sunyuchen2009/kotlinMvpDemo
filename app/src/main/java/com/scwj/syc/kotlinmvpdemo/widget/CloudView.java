package com.scwj.syc.kotlinmvpdemo.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;

import com.scwj.syc.kotlinmvpdemo.R;

/**
 * Created by sunYuChen on 2018-08-08
 */
public class CloudView extends View {

    private int mWidth;
    private int mHeight;
    private int mLeft;

    private Paint mPaint;

    public CloudView(Context context) {
        super(context);
        init();
    }

    public CloudView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }


    public CloudView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(8);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(60);
        mPaint.setPathEffect(new CornerPathEffect(4));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mWidth=getWidth();
        mHeight=getHeight();
        float mScaleW = mWidth/120;
        float mScaleH = mHeight/60;

        Path path = new Path();
        path.moveTo(5.82f * mScaleW, 51.78f * mScaleH);
        path.quadTo(24 * mScaleW, 28 * mScaleH, 51.2f * mScaleW, 34.4f * mScaleH);
        path.cubicTo(51f * mScaleW, 14 * mScaleH, 113 * mScaleW, -3 * mScaleH, mWidth, 51.78f * mScaleH);
        path.lineTo(5.82f * mScaleW, 51.78f * mScaleH);
        canvas.drawPath(path, mPaint);

    }

    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
        mLeft=r;
        Log.e("top",String.valueOf(t));
    }

}
