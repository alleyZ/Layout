package com.alleyz.data.share;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alleyz.layout.R;

/**
 * Created by Mr on 2015/12/24.
 */
public class ShareDataActivity extends AppCompatActivity  implements View.OnClickListener{
    public static String KEY="MY_IS_KEY";

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_share_data);

        sp=getPreferences(MODE_PRIVATE);

        et = (EditText) findViewById(R.id.etShare);

        findViewById(R.id.btnShareAdd).setOnClickListener(this);
        findViewById(R.id.btnShareDel).setOnClickListener(this);
        findViewById(R.id.btnShareRead).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnShareAdd:
                editor=sp.edit();
                editor.putString(KEY,et.getText().toString());
                editor.commit();
                Toast.makeText(this,"已存储",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnShareRead:
                String val=sp.getString(KEY,"无数据");
                Toast.makeText(this,"读取到数据为："+val,Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnShareDel:
                editor.putString(KEY,null);
                editor.commit();
                Toast.makeText(this,"已删除",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
