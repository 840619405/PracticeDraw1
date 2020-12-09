package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 相对view居中直方图
 */
public class Practice10HistogramView extends View {
    private int mLineWidth;
    private int mLineHeight;
    private String mTitle = "直方图";
    private List<Integer> mDatas;
    private int mDataMax;
    private int mRectWidth;

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mDatas = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            mDatas.add(random.nextInt(10) + 5);
        }
        mDataMax = getDataMax();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        mLineWidth = getWidth() - 300;
        mLineHeight = getHeight() - 200;
        //居中绘制竖线、横线
        int lineVerticalStartX = getCenteredLeftPadding();
        int lineVerticalStartY = getCenteredTopPadding();
        int lineHorizontalStartX = getCenteredLeftPadding();
        int lineHorizontalStartY = getCenteredTopPadding() + mLineHeight;
        canvas.drawLine(lineHorizontalStartX, lineHorizontalStartY, mLineWidth + getCenteredLeftPadding(), lineHorizontalStartY, paint);
        canvas.drawLine(lineVerticalStartX, lineVerticalStartY, lineVerticalStartX, mLineHeight + getCenteredTopPadding(), paint);
        //绘制横线下方的文字
        paint.setTextSize(20);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float titleWidth = paint.measureText(mTitle);
        float titleX = (mLineWidth - titleWidth) / 2 + getCenteredLeftPadding();
        float titleY = getCenteredTopPadding() + mLineHeight + (fontMetrics.bottom - fontMetrics.top) + 20;
        canvas.drawText(mTitle, titleX, titleY, paint);
        //绘制矩形
        float dataWidth = mLineWidth / (mDatas.size());
        paint.setTextSize(12);
        fontMetrics = paint.getFontMetrics();
        for (int i = 0; i < mDatas.size(); i++) {
            paint.setColor(Color.GREEN);
            Integer data = mDatas.get(i);
            float dataHeight = (((float) data / (float) mDataMax)) * (mLineHeight - 20);
            float dataLeft = getCenteredLeftPadding() + (dataWidth * i) + 10;
            float dataTop = getHeight() - getCenteredTopPadding() - dataHeight;
            float dataRight = dataLeft + dataWidth - 10;
            float dataBottom = lineHorizontalStartY;
            canvas.drawRect(dataLeft, dataTop, dataRight, dataBottom - 1, paint);
            float dataTextWidth = paint.measureText("" + i);
            float dataTextStartX = dataLeft + ((dataWidth - dataTextWidth) / 2);
            float dataTextStartY = dataBottom + (fontMetrics.bottom - fontMetrics.top);
            paint.setColor(Color.WHITE);
            canvas.drawText("" + i, dataTextStartX, dataTextStartY, paint);
        }
    }

    /**
     * 居中的左边距
     *
     * @return
     */
    private int getCenteredLeftPadding() {
        return (getWidth() - mLineWidth) / 2;
    }

    /**
     * 居中的上边距
     *
     * @return
     */
    private int getCenteredTopPadding() {
        return (getHeight() - mLineHeight) / 2;
    }

    /**
     * 获取数据中的最大值
     *
     * @return
     */
    private int getDataMax() {
        int result = 0;
        for (int i = 0; i < mDatas.size(); i++) {
            Integer data = mDatas.get(i);
            if (data > result) {
                result = data;
            }
        }
        return result;
    }
}
