package com.alleyz.ui.animation;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Toast;

/**
 * Created by Mr on 2015/12/24.
 */
public class CustomAnimation extends Animation {


    public CustomAnimation() {
    }

    public CustomAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     *
     * @param interpolatedTime 补间时间
     * @param t
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        System.out.println(interpolatedTime+"");
        t.setAlpha(interpolatedTime);
        t.getMatrix().setTranslate(200*interpolatedTime,200*interpolatedTime);
        super.applyTransformation(interpolatedTime, t);
//        Log.i("",interpolatedTime+"");
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        System.out.println("width:"+width);
        System.out.println("height:"+height);
        System.out.println("parentWidth:"+parentWidth);
        System.out.println("parentHeight:"+parentHeight);
        super.initialize(width, height, parentWidth, parentHeight);
    }
}
