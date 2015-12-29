package com.alleyz.ui.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.SubMenu;

import com.alleyz.layout.R;

/**
 * Created by Mr on 2015/12/23.
 */
public class SubMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sub);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        SubMenu sm1=menu.addSubMenu(Menu.NONE, Menu.FIRST, 1, "菜单1");
        SubMenu sm2=menu.addSubMenu(Menu.NONE, Menu.FIRST + 1, 2, "菜单2");

        sm1.add(Menu.NONE,Menu.FIRST+100,1,"子菜单11");
        sm1.add(Menu.NONE,Menu.FIRST+101,2,"子菜单12");

        sm2.add(Menu.NONE,Menu.FIRST+201,1,"子菜单21");
        sm2.add(Menu.NONE,Menu.FIRST+201,2,"子菜单22");
        return true;
    }
}
