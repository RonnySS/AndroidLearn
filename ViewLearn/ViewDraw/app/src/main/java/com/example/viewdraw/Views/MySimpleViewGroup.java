package com.example.viewdraw.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class MySimpleViewGroup extends ViewGroup {
    private String TAG = this.getClass().getSimpleName();


    public MySimpleViewGroup(Context context) {
        super(context);
        Log.d(TAG, "MySimpleViewGroup: init1");
    }




    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs)
    {
        return new MarginLayoutParams(getContext(), attrs);
    }

    public MySimpleViewGroup(Context context, AttributeSet attrs) {

        super(context, attrs);
        Log.d(TAG, "MySimpleViewGroup: init2");
    }

    public MySimpleViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d(TAG, "MySimpleViewGroup: init3");
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d("TAG", "看看ViewGroup的到底是由父还是子决定的onMeasure: "+MeasureSpec.getSize(widthMeasureSpec));
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        // 计算出所有的childView的宽和高
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
        Log.d("TAG", "看看ViewGroup的到底是由父还是子决定的onMeasure: "+MeasureSpec.getSize(widthMeasureSpec));

    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        for (int i=0; i<getChildCount(); i++) {
            View child = getChildAt(i);

            // 取出当前子View宽 / 高
            int width = child.getMeasuredWidth();
            int height = child.getMeasuredHeight();

            // 2. 计算当前子View的四个位置值
            // 2.1 位置的计算逻辑
            int mLeft = (r - width) / 2;
            int mTop = (b - height) / 2;
            int mRight =  mLeft + width;
            int mBottom = mTop + height;

            // 3. 根据上述4个位置的计算值，设置子View的4个顶点
            // 即确定了子View在父容器的位置
            child.layout(mLeft, mTop, mRight,mBottom);
        }







    }

}
