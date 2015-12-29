package com.alleyz.data.file;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alleyz.Constant;
import com.alleyz.layout.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Mr on 2015/12/24.
 */
public class FileOptActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvReadAssets;
    private EditText etInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_opt);

        tvReadAssets = (TextView) findViewById(R.id.tvFileReadAssets);
        etInput = (EditText)findViewById(R.id.etFileOpt);

        findViewById(R.id.btnFileReadRaw).setOnClickListener(this);
        findViewById(R.id.btnFileReadAssets).setOnClickListener(this);
//        String writeStr=etInput.getText().toString();
        findViewById(R.id.btnFileWrite).setOnClickListener(new PhoneDataRWListener(this,Constant.FILE_PHONE_INFO,etInput));
        findViewById(R.id.btnFileReadM).setOnClickListener(new PhoneDataRWListener(this,Constant.FILE_PHONE_INFO,tvReadAssets));

        findViewById(R.id.btnFileWStorage).setOnClickListener(new StorageDataRWListener(this,etInput,Constant.FILE_STORAGE_INFO));
        findViewById(R.id.btnFileRStorage).setOnClickListener(new StorageDataRWListener(this,tvReadAssets,Constant.FILE_STORAGE_INFO));
    }

    @Override
    public void onClick(View v) {
        tvReadAssets.setText("");
        InputStream is=null;
        BufferedReader br=null;
        try {
            switch (v.getId()) {
                case R.id.btnFileReadAssets:
                    is=getResources().getAssets().open(Constant.FILE_INFO);
                    break;
                case R.id.btnFileReadRaw:
                    is=getResources().openRawResource(R.raw._rawinfo);
                    break;
            }

            br=new BufferedReader(new InputStreamReader(is,"utf-8"));

            String line;
            StringBuffer sb=new StringBuffer();
            while((line=br.readLine())!=null){
                sb.append(line).append("\n");
            }

            tvReadAssets.setText(sb.toString());
        }catch (Exception e){
            Log.e("read","",e);
        }finally {
            try{
                is.close();
                br.close();
            }catch (Exception e){

            }
        }
    }
}
