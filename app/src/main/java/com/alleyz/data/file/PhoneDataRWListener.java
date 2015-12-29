package com.alleyz.data.file;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alleyz.layout.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Mr on 2015/12/24.
 */
public class PhoneDataRWListener implements View.OnClickListener {
    private Context context;
    private String fileName;
    private TextView tv=null;
    private EditText et=null;
    public PhoneDataRWListener(Context context,String fileName,TextView tv) {
        this.context = context;
        this.fileName=fileName;
        this.tv=tv;
    }

    public PhoneDataRWListener(Context context, String fileName,EditText et) {
        this.context = context;
        this.fileName = fileName;
        this.et=et;
    }

    @Override
    public void onClick(View v) {
        if(tv!=null)
            tv.setText("");
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        FileInputStream fis=null;
        BufferedReader br=null;
        try {
            switch (v.getId()) {
                case R.id.btnFileWrite:
                    fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
                    osw=new OutputStreamWriter(fos,"utf-8");
                    osw.write(et.getText().toString());
                    osw.flush();
                    fos.flush();
                    Toast.makeText(context,"写入完成",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnFileReadM:
                    fis = context.openFileInput(fileName);
                    br=new BufferedReader(new InputStreamReader(fis,"utf-8"));
                    String line;
                    StringBuffer sb=new StringBuffer();
                    while((line=br.readLine())!=null){
                        sb.append(line).append("\n");
                    }
                    tv.setText(sb.toString());
                    Toast.makeText(context,"读取完成",Toast.LENGTH_SHORT).show();
                    break;
            }
        }catch (Exception e){
            Log.e("","",e);
        }finally {
            try {
                if (osw != null) osw.close();
                if(fos!=null) fos.close();
                if(br!=null) br.close();
                if(fis!=null) fis.close();
            }catch (Exception e){

            }
        }
    }
}
