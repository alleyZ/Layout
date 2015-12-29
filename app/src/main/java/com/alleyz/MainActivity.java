package com.alleyz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.alleyz.data.file.FileOptActivity;
import com.alleyz.data.share.MineSharePreferenceActivity;
import com.alleyz.data.share.ShareDataActivity;
import com.alleyz.data.sqlite.SQLiteActivity;
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
import com.alleyz.ui.viewpager.ViewPagerActivity;
import com.alleyz.ui.widgets.WidgetsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定打开Activity事件
//        Constant.bindButtonsClickEvent(this);
        Constant.init(this);
    }
    final int Menu_Id2=2;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,Menu_Id2,2,"表格布局");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case Menu_Id2:
                startActivity(new Intent(MainActivity.this,MainGridActivity.class));
                break;
        }
        return true;
    }

}
