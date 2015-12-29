package com.alleyz.ui.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.alleyz.layout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr on 2015/12/24.
 */
public class ViewPagerActivity extends AppCompatActivity{
    private ViewPager vp;
    private List<View> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        vp=(ViewPager)findViewById(R.id.vp1);
        views=new ArrayList<>();
        LayoutInflater li=LayoutInflater.from(this);
        for(int i=0;i<4;i++){
            View rootView=li.inflate(R.layout.vp1,null);
            TextView tv=(TextView)rootView.findViewById(R.id.tvVp1);
            tv.setText("ViewPager_" + (i + 1));
//            tv.setGravity(View.TEXT_ALIGNMENT_CENTER);
            views.add(rootView);
        }
        vp.setAdapter(new ViewPagerAdapter(views,this));
    }

    public static class ViewPagerAdapter extends PagerAdapter{
        private List<View> views;
        private Context context;

        public ViewPagerAdapter(List<View> views, Context context) {
            this.views = views;
            this.context = context;
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView(views.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
//            return super.instantiateItem(container, position);
            container.addView(views.get(position));
            return views.get(position);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }
    }
}
