package com.alleyz.ui.slidingMenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alleyz.layout.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by Mr on 2015/12/22.
 */
public class SlidingMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidingmeun);
        SlidingMenu sm=new SlidingMenu(this);
        sm.setMode(SlidingMenu.LEFT);
        sm.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        sm.setFadeEnabled(true);
        sm.setFadeDegree(0.1f);
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        sm.setMenu(R.layout.sliding_menu);
        sm.setBehindOffsetRes(R.dimen.sliding_menu_offset);
//        sm.setShadowWidth(50);
    }
}
