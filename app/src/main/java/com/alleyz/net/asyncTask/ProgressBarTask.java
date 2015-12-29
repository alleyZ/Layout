package com.alleyz.net.asyncTask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Mr on 2015/12/28.
 */
public class ProgressBarTask extends AsyncTask<Integer,Integer,Boolean> {

//    APP ID:  20151228000008346
//    网站或应用名称:  alleyz
//    密钥:  O0JhJVSIeVGkRqiSBw6A
//    创建时间:  2015-12-28 11:26:06

    private TextView tv;
    private ProgressBar pb;

    public ProgressBarTask(TextView tv, ProgressBar pb) {
        super();
        this.tv = tv;
        this.pb = pb;
    }

    @Override
    protected Boolean doInBackground(Integer... params) {
        Log.i("doInBackground", "it`s running ");
        for(int i=params[0];i<=10;i++){
            try{
                if(isCancelled())break;
                Thread.sleep(1000);
                Log.i("task", "it`s running " + i);
                publishProgress(10 * i);//改变UI
            }catch (Exception e){}
        }
        return true;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tv.setText("开始执行异步任务");
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        String str=tv.getText().toString();
        tv.setText("执行结束[" + str + "]，结果："+aBoolean);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.i("pro","param "+values[0]);
        tv.setText(values[0]+"%");
        pb.setProgress(values[0]);
    }

    @Override
    protected void onCancelled(Boolean aBoolean) {
        super.onCancelled(aBoolean);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        tv.setText("执行结束[" + tv.getText().toString() + "]");
    }
}
