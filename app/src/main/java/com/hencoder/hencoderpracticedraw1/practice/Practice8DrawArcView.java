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

public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        float x = (getWidth() - getHeight() / 2) / 2;
        float y = getHeight() / 4;
        RectF oval = new RectF( x, y,
                getWidth() - x, getHeight() - y);
        canvas.drawOval(oval,paint);
        paint.setColor(Color.RED);
        canvas.drawArc(oval,-90,90,true,paint);
    }
}
