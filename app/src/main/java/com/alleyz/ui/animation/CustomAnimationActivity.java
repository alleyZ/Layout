package com.alleyz.ui.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import com.alleyz.layout.R;

/**
 * Created by Mr on 2015/12/24.
 */
public class CustomAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani_custom);
        findViewById(R.id.btnAniCustom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation ani = new CustomAnimation();
                ani.setDuration(1000);
                v.startAnimation(ani);
            }
        });

        findViewById(R.id.btnAniCustomLR).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation ani =new Animation(){
                    @Override
                    protected void applyTransformation(float interpolatedTime, Transformation t) {
                        super.applyTransformation(interpolatedTime, t);
                        t.getMatrix().setTranslate((float) Math.sin(interpolatedTime*30)*50,0);
                    }
                };
                ani.setDuration(500);
                v.startAnimation(ani);
            }
        });
    }
}
