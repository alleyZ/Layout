package com.alleyz.net.asyncTask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alleyz.layout.R;

/**
 * Created by Mr on 2015/12/28.
 */
public class AsyncTaskActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv;
    private AsyncTask<Integer,Integer,Boolean> task;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_task_async);

        tv=(TextView)findViewById(R.id.tvAsyncTask);

        pb = (ProgressBar)findViewById(R.id.pbAsyncTask);

        findViewById(R.id.btnAsyncActivity).setOnClickListener(this);;

        findViewById(R.id.btnCancleAsyncActivity).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAsyncActivity:
                task=new ProgressBarTask(tv,pb);
                task.execute(0);
                break;
            case R.id.btnCancleAsyncActivity:
                task.cancel(true);
                break;
        }
    }
}
