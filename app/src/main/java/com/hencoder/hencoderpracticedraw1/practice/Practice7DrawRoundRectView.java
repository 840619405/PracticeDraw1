package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class Practice7DrawRoundRectView extends View {

    public Practice7DrawRoundRectView(Context context) {
        super(context);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        int width=200;
        int height=120;
        int left=(getWidth()/2)-(width/2);
        int top=(getHeight()/2)-(height/2);
        int right=(getWidth()/2)+(width/2);
        int bottom=(getHeight()/2)+(height/2);
        canvas.drawRoundRect(left,top,right,bottom,10,10,paint);
//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
    }
}
