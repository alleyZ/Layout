package com.alleyz.ui.animation;

import android.animation.LayoutTransition;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

import com.alleyz.layout.R;

/**
 * Created by Mr on 2015/12/23.
 */
public class AniLinearActivity  extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout rootView;

    void getRootView(){
        rootView= (LinearLayout)((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani_linear);
        getRootView();
        Animation ani=new ScaleAnimation(0,1,0,1);
        ani.setDuration(1000);
        LayoutAnimationController lac=new LayoutAnimationController(ani,0.6f);
        rootView.setLayoutAnimation(lac);
        LayoutTransition lt=new LayoutTransition();
        lt.setDuration(700);
        rootView.setLayoutTransition(lt);
        findViewById(R.id.btnAni1).setOnClickListener(this);
        findViewById(R.id.btnAni2).setOnClickListener(this);
        findViewById(R.id.btnAni3).setOnClickListener(this);
        findViewById(R.id.btnAni4).setOnClickListener(this);
        findViewById(R.id.btnAni5).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        rootView.removeView(v);
    }
}
