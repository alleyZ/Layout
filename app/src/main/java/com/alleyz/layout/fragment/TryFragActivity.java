package com.alleyz.layout.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alleyz.layout.R;

/**
 * Created by Mr on 2015/12/23.
 */
public class TryFragActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tryfrag);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .addToBackStack("")
                    .add(R.id.lyTryFrag, new TryFragment()).commit();
        }
    }
}
