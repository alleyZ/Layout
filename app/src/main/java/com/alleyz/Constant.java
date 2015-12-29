package com.alleyz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alleyz.data.contentprovider.MyProviderActivity;
import com.alleyz.data.file.FileOptActivity;
import com.alleyz.data.share.MineSharePreferenceActivity;
import com.alleyz.data.share.ShareDataActivity;
import com.alleyz.data.sqlite.SQLiteActivity;
import com.alleyz.data.xml.SimpleXmlActivity;
import com.alleyz.layout.LinearLayout.LinearActivity;
import com.alleyz.layout.R;
import com.alleyz.layout.customWidgets.CustomWidgetActivity;
import com.alleyz.layout.fragment.TryFragActivity;
import com.alleyz.net.asyncTask.AsyncTaskActivity;
import com.alleyz.net.asynchttp.AsyncHttpActivity;
import com.alleyz.net.volley.VolleyActivity;
import com.alleyz.ui.RecyclerView.RecycleActivity;
import com.alleyz.ui.RecyclerView.Recyler2Activity;
import com.alleyz.ui.animation.AniLinearActivity;
import com.alleyz.ui.animation.CustomAnimationActivity;
import com.alleyz.ui.animation.ManyAnimationActivity;
import com.alleyz.ui.menu.ContextMenuActivity;
import com.alleyz.ui.menu.MenuOptionActivity;
import com.alleyz.ui.menu.SubMenuActivity;
import com.alleyz.ui.slidingMenu.SlidingMenuActivity;
import com.alleyz.ui.viewpager.ViewPagerActivity;
import com.alleyz.ui.widgets.WidgetsActivity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Mr on 2015/12/23.
 */
public class Constant {

    private static Map<Integer,Class> btnOpenActivity=new HashMap<>();

    public static void addBtnOpenActivity(int btnId,Class clazz){
        btnOpenActivity.put(btnId,clazz);
    }

    public static void  bindButtonsClickEvent(final AppCompatActivity activity){
        Iterator<Integer> btns=btnOpenActivity.keySet().iterator();
        while(btns.hasNext()){
            int btnId=btns.next();
            final Class viewClass=btnOpenActivity.get(btnId);
            activity.findViewById(btnId).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("M_C",((Button)v).getText().toString()+" clicked!");
                    activity.startActivity(new Intent(activity.getBaseContext(),viewClass));
                }
            });
        }
    }

    public static void init(final AppCompatActivity activity){
        addBtnOpenActivity(R.id.btnLinearActivity, LinearActivity.class);
//        addBtnOpenActivity(R.id.btnRelativeActivity,RecycleActivity.class);
//        addBtnOpenActivity(R.id.btnFrameActivity,RecycleActivity.class);
        addBtnOpenActivity(R.id.btnRecycler, RecycleActivity.class);
        addBtnOpenActivity(R.id.btnRecylerAdapter, Recyler2Activity.class);
        addBtnOpenActivity(R.id.btnBaseWidgets, WidgetsActivity.class);
        addBtnOpenActivity(R.id.btnSlidingMenu, SlidingMenuActivity.class);
        addBtnOpenActivity(R.id.btnCustomWidgets, CustomWidgetActivity.class);
        addBtnOpenActivity(R.id.btnFrag, TryFragActivity.class);
        addBtnOpenActivity(R.id.btnAniActivity, AniLinearActivity.class);
        addBtnOpenActivity(R.id.btnOptionMenu, MenuOptionActivity.class);
        addBtnOpenActivity(R.id.btnSubMenuActivity, SubMenuActivity.class);
        addBtnOpenActivity(R.id.btnContextMenuActivity, ContextMenuActivity.class);
        addBtnOpenActivity(R.id.btnManyAniActivity, ManyAnimationActivity.class);
        addBtnOpenActivity(R.id.btnCustomAniActivity, CustomAnimationActivity.class);
        addBtnOpenActivity(R.id.btnViewPagerActivity, ViewPagerActivity.class);
        addBtnOpenActivity(R.id.btnMainFileActivity, FileOptActivity.class);
        addBtnOpenActivity(R.id.btnShareDataActivity, ShareDataActivity.class);
        addBtnOpenActivity(R.id.btnMineShareActivity, MineSharePreferenceActivity.class);
        addBtnOpenActivity(R.id.btnSQLiteActivity, SQLiteActivity.class);
        addBtnOpenActivity(R.id.btnProviderActivity, MyProviderActivity.class);
        addBtnOpenActivity(R.id.btnSimpleXmlActivity, SimpleXmlActivity.class);
        addBtnOpenActivity(R.id.btnAsyncTaskActivity,AsyncTaskActivity.class);
        addBtnOpenActivity(R.id.btnVolleyActivity,VolleyActivity.class);
        addBtnOpenActivity(R.id.btnAsyncHttpActivity,AsyncHttpActivity.class);
        bindButtonsClickEvent(activity);
    }
    public static final String FILE_INFO="_info";
    public static final String FILE_PHONE_INFO="_phone_info";
    public static final String FILE_STORAGE_INFO="phoneinfo.txt";
}
