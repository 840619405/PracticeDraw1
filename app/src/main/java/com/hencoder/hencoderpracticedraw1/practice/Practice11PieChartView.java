package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Practice11PieChartView extends View {
    private int mRoundDiameter;
    private List<Integer> mDatas;
    private int mDataSum;

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mDatas = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            mDatas.add(random.nextInt(10) + 5);
        }
        mDataSum = getDataSum();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        if (getWidth() > getHeight()) {
            mRoundDiameter = getHeight() - 100;
        } else {
            mRoundDiameter = getWidth() - 100;
        }
        int ovalLeft = getCenteredLeftPadding();
        int ovalTop = getCenteredTopPadding();
        int ovalRight = getCenteredLeftPadding() + mRoundDiameter;
        int ovalBottom = getCenteredTopPadding() + mRoundDiameter;
        RectF oval = new RectF(ovalLeft, ovalTop, ovalRight, ovalBottom);
        //canvas.drawOval(oval, paint);
        float angle = 0;
        float angleInterval = (float) 20 / (float) mDatas.size();
        for (int i = 0; i < mDatas.size(); i++) {
            int randomColor = getRandomColor();
            paint.setColor(randomColor);
            Integer data = mDatas.get(i);
            float sweepAngle = ((float) data / (float) mDataSum) * 360;
            canvas.drawArc(oval, angle+(angleInterval/2), sweepAngle-(angleInterval/2), true, paint);
            angle += sweepAngle;
        }
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
    }


    /**
     * 居中的左边距
     *
     * @return
     */
    private int getCenteredLeftPadding() {
        return (getWidth() - mRoundDiameter) / 2;
    }

    /**
     * 居中的上边距
     *
     * @return
     */
    private int getCenteredTopPadding() {
        return (getHeight() - mRoundDiameter) / 2;
    }

    /**
     * 获取数据中的最大值
     *
     * @return
     */
    private int getDataSum() {
        int sum = 0;
        for (int i = 0; i < mDatas.size(); i++) {
            Integer data = mDatas.get(i);
            sum += data;
        }
        return sum;
    }

    public int getRandomColor() {
        Random random = new Random();
        int r = 0;
        int g = 0;
        int b = 0;
        for (int i = 0; i < 2; i++) {
            //       result=result*10+random.nextInt(10);
            int temp = random.nextInt(16);
            r = r * 16 + temp;
            temp = random.nextInt(16);
            g = g * 16 + temp;
            temp = random.nextInt(16);
            b = b * 16 + temp;
        }
        return Color.rgb(r, g, b);
    }
}
