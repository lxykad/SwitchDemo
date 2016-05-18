package com.lxy.switchDemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by liuxinyu on 2016/5/16.
 */
public class MySwitch extends View {

    private Paint mPaint;
    private int mMaxValue;
    private int mLeftValue;
    private Bitmap mBackgroundBitmap;
    private Bitmap mFrontBitmap;

    private boolean mIsOpen;


    public MySwitch(Context context) {
        super(context);
        initView();
    }

    public MySwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public MySwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public void initView() {
        mPaint = new Paint();
        mBackgroundBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.switch_background);
        mFrontBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.swtch_front);

        mMaxValue = mBackgroundBitmap.getWidth() - mFrontBitmap.getWidth();
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mIsOpen) {
                    mLeftValue = mMaxValue;
                    mIsOpen = true;
                } else {
                    mLeftValue = 0;
                    mIsOpen = false;
                }

                invalidate();
            }
        });

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(mBackgroundBitmap.getWidth(), mBackgroundBitmap.getHeight());


    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBackgroundBitmap, 0, 0, mPaint);
        canvas.drawBitmap(mFrontBitmap, mLeftValue, 0, mPaint);
    }
}
