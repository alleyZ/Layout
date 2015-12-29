package com.alleyz.data.contentprovider;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alleyz.layout.R;

/**
 * Created by Mr on 2015/12/25.
 */
public class MyProviderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);

        findViewById(R.id.btnProvider).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<5;i++){
                    ContentValues cvs=new ContentValues();
                    cvs.put("name","i="+i);
                    getContentResolver().insert(MyProvider.URI, cvs);
                }

            }
        });
    }
}
