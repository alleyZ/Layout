package com.alleyz.layout.customWidgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Mr on 2015/12/23.
 */
public class MyCircle extends View {
    public MyCircle(Context context) {
        super(context);
        setProperties();
    }

    public MyCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
        setProperties();
    }

    public MyCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setProperties();
    }

    public MyCircle(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setProperties();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
//        canvas.drawCircle(4, 4, 2, paint);
//        canvas.drawRect(0,0,100,100,paint);
        canvas.save();
//        if(cx<(1440-10-100))
//            cx+=10;
//        else
//            cx-=10;
        if(!left)
            cx+=10;
        else
            cx-=10;
        if((cx+100)==1440)
            left=true;
        else if((cx-100)==0){
            left=false;
        }
        if(cx%100==0)
            idx++;
        paint.setColor(colors[idx]);
        if((idx+1)==colors.length)
            idx=0;
        canvas.drawCircle(cx, 200, 100, paint);
        canvas.rotate(10);
        canvas.restore();
        Log.i("Circle", "this is Circle");
        invalidate();
    }
    private int idx=2;
    private int[] colors=new int[]{
            0xFF000000,0xFF444444,0xFF888888,0xFFCCCCCC,0xFFFFFFFF,0xFFFF0000,0xFF00FF00,0xFF0000FF,0xFFFFFF00,0xFF00FFFF,0xFFFF00FF
    };
    private float cx=100;
    private boolean left=false;
    private Paint paint;

    private void setProperties(){
        paint=new Paint();
//        paint.setColor(Color.GRAY);
    }
}
