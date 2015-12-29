package com.alleyz.ui.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.alleyz.layout.R;

/**
 * Created by Mr on 2015/12/23.
 */
public class MenuOptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_option);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        for(int i=0;i<18;i++){
            menu.add(Menu.NONE,Menu.FIRST+i,i,"选项菜单"+i);
        }
        return true;
    }
}
