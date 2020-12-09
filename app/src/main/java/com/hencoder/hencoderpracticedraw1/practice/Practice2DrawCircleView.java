package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {
    private Paint mPint=new Paint();
    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPint.setColor(Color.BLACK);
//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        //实心圆
        canvas.drawCircle(200,100,50,mPint);
        mPint.setStyle(Paint.Style.STROKE);
        //空心圆
        canvas.drawCircle(400,100,50,mPint);
        mPint.setStyle(Paint.Style.FILL_AND_STROKE);
        //蓝色实心圆
        mPint.setColor(Color.BLUE);
        canvas.drawCircle(200,250,50,mPint);
        //线宽20的空心圆
        mPint.setStyle(Paint.Style.STROKE);
        mPint.setStrokeWidth(20);
        canvas.drawCircle(400,250,50,mPint);
    }
}
