package com.alleyz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.alleyz.layout.LinearLayout.LinearActivity;
import com.alleyz.layout.R;
import com.alleyz.ui.RecyclerView.RecycleActivity;
import com.alleyz.ui.RecyclerView.Recyler2Activity;
import com.alleyz.ui.animation.AniLinearActivity;
import com.alleyz.ui.animation.CustomAnimationActivity;
import com.alleyz.ui.animation.ManyAnimationActivity;
import com.alleyz.layout.customWidgets.CustomWidgetActivity;
import com.alleyz.layout.fragment.TryFragActivity;
import com.alleyz.ui.menu.ContextMenuActivity;
import com.alleyz.ui.menu.MenuOptionActivity;
import com.alleyz.ui.menu.SubMenuActivity;
import com.alleyz.ui.slidingMenu.SlidingMenuActivity;
import com.alleyz.ui.widgets.WidgetsActivity;

/**
 * Created by Mr on 2015/12/23.
 */
public class MainGridActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grid);
        //绑定打开Activity事件
        Constant.addBtnOpenActivity(R.id.btnLinearActivity,LinearActivity.class);
//        Constant.addBtnOpenActivity(R.id.btnRelativeActivity,RecycleActivity.class);
//        Constant.addBtnOpenActivity(R.id.btnFrameActivity,RecycleActivity.class);
        Constant.addBtnOpenActivity(R.id.btnRecycler,RecycleActivity.class);
        Constant.addBtnOpenActivity(R.id.btnRecylerAdapter,Recyler2Activity.class);
        Constant.addBtnOpenActivity(R.id.btnBaseWidgets,WidgetsActivity.class);
        Constant.addBtnOpenActivity(R.id.btnSlidingMenu,SlidingMenuActivity.class);
        Constant.addBtnOpenActivity(R.id.btnCustomWidgets,CustomWidgetActivity.class);
        Constant.addBtnOpenActivity(R.id.btnFrag,TryFragActivity.class);
        Constant.addBtnOpenActivity(R.id.btnAniActivity,AniLinearActivity.class);
        Constant.addBtnOpenActivity(R.id.btnOptionMenu,MenuOptionActivity.class);
        Constant.addBtnOpenActivity(R.id.btnSubMenuActivity,SubMenuActivity.class);
        Constant.addBtnOpenActivity(R.id.btnContextMenuActivity,ContextMenuActivity.class);
        Constant.addBtnOpenActivity(R.id.btnManyAniActivity,ManyAnimationActivity.class);
        Constant.addBtnOpenActivity(R.id.btnCustomAniActivity, CustomAnimationActivity.class);

        Constant.bindButtonsClickEvent(this);
    }
    final int Menu_Id1=1;
    final int Menu_Id2=2;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE,Menu_Id1,1,"线性布局");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case Menu_Id1:
                startActivity(new Intent(MainGridActivity.this,MainActivity.class));
                break;
        }
        return true;
    }
}
