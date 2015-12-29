package com.alleyz.layout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alleyz.layout.R;

/**
 * Created by Mr on 2015/12/23.
 */
public class TryFragment extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout root=(LinearLayout)inflater.inflate(R.layout.fragment_tryfrag, container, false);
        root.findViewById(R.id.btnTryFrag1).setOnClickListener(this);

        Animation ani=new ScaleAnimation(0,1,0,1);
        ani.setDuration(3000);
        LayoutAnimationController lac=new LayoutAnimationController(ani,0.6f);
        root.setLayoutAnimation(lac);
        return root;
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btnTryFrag1:
                Toast.makeText(getActivity(),v.toString()+" is click!",Toast.LENGTH_SHORT).show();
//                break;
//        }
    }
}
