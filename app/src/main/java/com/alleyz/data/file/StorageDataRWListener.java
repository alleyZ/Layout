package com.alleyz.data.file;

import android.content.Context;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alleyz.layout.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Mr on 2015/12/24.
 */
public class StorageDataRWListener implements View.OnClickListener{

    private TextView tv;
    private EditText et;
    private Context context;
    private String name;

    public StorageDataRWListener(Context context , TextView tv, String name) {
        this.tv = tv;
        this.context = context;
        this.name = name;
    }

    public StorageDataRWListener( Context context, EditText et, String name) {
        this.et = et;
        this.context = context;
        this.name = name;
    }

    @Override
    public void onClick(View v) {
        OutputStreamWriter osw=null;
        BufferedReader br=null;
        int i=ActivityCompat.checkSelfPermission(context,"android.permission.MOUNT_UNMOUNT_FILESYSTEMS");
        int j=ActivityCompat.checkSelfPermission(context,"android.permission.WRITE_EXTERNAL_STORAGE");
        int k=ActivityCompat.checkSelfPermission(context,"android.permission.READ_EXTERNAL_STORAGE");
        Log.i("","MOUNT_UNMOUNT_FILESYSTEMS:"+i);
        Log.i("","WRITE_EXTERNAL_STORAGE:"+j);
        Log.i("","READ_EXTERNAL_STORAGE:"+k);
        try{
            File storageFile=Environment.getExternalStorageDirectory();
            if(!storageFile.exists()){
                Toast.makeText(context,"未插入SD卡!",Toast.LENGTH_SHORT).show();
                return;
            }
            File file=new File(storageFile,name);

            Log.i("", storageFile.length()+"字节");
            Log.i("",storageFile+" "+name);
            Log.i("",file.getPath());
            switch (v.getId()){
                case R.id.btnFileWStorage:
                    if(!file.exists())
                        file.createNewFile();
                    osw=new OutputStreamWriter(new FileOutputStream(file),"utf-8");
                    osw.write(et.toString());
                    osw.flush();
                    Toast.makeText(context,name+"写入成功!",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnFileRStorage:
                    if(!file.exists()){
                        Toast.makeText(context,name+"文件不存在!",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    String line;
                    StringBuffer sb=new StringBuffer();
                    while((line=br.readLine())!=null){
                        sb.append(line).append("\n");
                    }
                    tv.setText(sb.toString());
                    break;
            }
        }catch (Exception e){
            Log.e("111","111",e);
        }finally {
            try {
                if (osw != null) osw.close();
                if (br != null) br.close();
            }catch (Exception e){}
        }
    }
}
