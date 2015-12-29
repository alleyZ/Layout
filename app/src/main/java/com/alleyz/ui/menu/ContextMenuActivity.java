package com.alleyz.ui.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.alleyz.layout.R;

/**
 * Created by Mr on 2015/12/23.
 */
public class ContextMenuActivity extends AppCompatActivity{
    private View tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_context);
        tv=findViewById(R.id.tvContextActivity);
        registerForContextMenu(tv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        Log.i("","上下文菜单");
        for(int i=0;i<6;i++){
            menu.add(Menu.NONE, i+1, i, "上下文菜单"+i);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this,"you selected :"+item.getTitle(),Toast.LENGTH_LONG).show();
        return true;
    }
}
