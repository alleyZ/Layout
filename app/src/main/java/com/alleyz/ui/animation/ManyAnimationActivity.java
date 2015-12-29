package com.alleyz.ui.animation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import com.alleyz.layout.R;

/**
 * Created by Mr on 2015/12/23.
 */
public class ManyAnimationActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani_many);
        findViewById(R.id.btnAlpCode).setOnClickListener(this);
        findViewById(R.id.btnAlpXml).setOnClickListener(this);

        findViewById(R.id.btnRotateCode).setOnClickListener(this);
        findViewById(R.id.btnRotateXml).setOnClickListener(this);

        findViewById(R.id.btnTranslateCode).setOnClickListener(this);
        findViewById(R.id.btnTranslateXml).setOnClickListener(this);

        findViewById(R.id.btnScaleCode).setOnClickListener(this);
        findViewById(R.id.btnScaleXml).setOnClickListener(this);

        findViewById(R.id.btnAniMixCode).setOnClickListener(this);
        findViewById(R.id.btnAniMixXml).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Animation ani = null;
        switch (v.getId()){
            case R.id.btnAlpCode:
                ani=new AlphaAnimation(0,1);
                ani.setDuration(1000);
                ani.setBackgroundColor(Color.GREEN);
                break;
            case R.id.btnAlpXml:
                ani= AnimationUtils.loadAnimation(getBaseContext(),R.anim.ani_alp_btn);
                break;
            case R.id.btnRotateCode:
//                ani=new RotateAnimation(0,360,200,200);
                ani=new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                ani.setDuration(1000);
                ani.setFillAfter(true);
                break;
            case R.id.btnRotateXml:
                ani=AnimationUtils.loadAnimation(getBaseContext(),R.anim.ani_rotate_btn);
                break;
            case R.id.btnTranslateCode:
                ani=new TranslateAnimation(0,10,0,10);
                ani.setDuration(100);
                break;
            case R.id.btnTranslateXml:
                ani=AnimationUtils.loadAnimation(getBaseContext(),R.anim.ani_tra_btn);
                break;
            case R.id.btnScaleCode:
                ani=new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                ani.setDuration(1000);
                break;
            case R.id.btnScaleXml:
                ani=AnimationUtils.loadAnimation(getBaseContext(),R.anim.ani_scale_btn);
                break;
            case R.id.btnAniMixCode:
                AnimationSet as=new AnimationSet(true);
                as.setDuration(1000);

                AlphaAnimation alpha=new AlphaAnimation(0,1);
                alpha.setDuration(1000);

                TranslateAnimation ta=new TranslateAnimation(50,0,150,0);
                ta.setDuration(1000);

                as.addAnimation(alpha);
                as.addAnimation(ta);

                ani=as;
                break;

            case R.id.btnAniMixXml:
                ani=AnimationUtils.loadAnimation(getBaseContext(),R.anim.ani_mix);
                break;
        }
        if(ani!=null) {
            ani.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    Toast.makeText(ManyAnimationActivity.this,"onAnimationStart",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    Toast.makeText(ManyAnimationActivity.this,"onAnimationEnd",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    Toast.makeText(ManyAnimationActivity.this,"onAnimationRepeat",Toast.LENGTH_SHORT).show();
                }
            });
            v.startAnimation(ani);
        }
    }
}
