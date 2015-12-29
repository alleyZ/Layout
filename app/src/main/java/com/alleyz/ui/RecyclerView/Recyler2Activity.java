package com.alleyz.ui.RecyclerView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * Created by Mr on 2015/12/22.
 */
public class Recyler2Activity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("R2","oncreate is running ");
        rv=new RecyclerView(this);
        setContentView(rv);//绑定布局
        //设置布局样式
//        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setLayoutManager(new GridLayoutManager(this,3,LinearLayoutManager.HORIZONTAL,false));
        //设置布局适配器
        rv.setAdapter(new MetaAdapter());
    }
}
