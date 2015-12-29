package com.alleyz.ui.widgets;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.alleyz.layout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr on 2015/12/22.
 */
public class WidgetsActivity extends AppCompatActivity implements View.OnClickListener,CompoundButton.OnCheckedChangeListener{
    private Spinner spinner;
    private Button btnDatePicker,btnTimePicker;
    private String[] dataSource=getDataSource();
    private TextView tvResult;
    private String[] getDataSource(){
        int c=10;
        String[] datas=new String[c];
        for(int i=0;i<c;i++){
            datas[i]="select"+i;
        }
        return datas;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        //下拉框
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataSource));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("select", "user select is :" + dataSource[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i("select", "nothing nothing ");
            }
        });
        //日期选择器
        btnDatePicker=(Button) findViewById(R.id.btnDatePicker);
        btnDatePicker.setOnClickListener(this);
        btnTimePicker = (Button) findViewById(R.id.btnTimePicker);
        btnTimePicker.setOnClickListener(this);

        ((RadioGroup)findViewById(R.id.rgQues)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String h=((RadioButton)findViewById(checkedId)).getText().toString();
                Log.i("",checkedId+" "+h);
                Toast.makeText(WidgetsActivity.this,"所选答案为："+h,Toast.LENGTH_SHORT).show();
            }
        });

        //复选框
        ((CheckBox)findViewById(R.id.cb1)).setOnCheckedChangeListener(this);
        ((CheckBox)findViewById(R.id.cb2)).setOnCheckedChangeListener(this);
        ((CheckBox)findViewById(R.id.cb3)).setOnCheckedChangeListener(this);
        ((CheckBox)findViewById(R.id.cb4)).setOnCheckedChangeListener(this);

        tvResult=(TextView)findViewById(R.id.tvResult);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDatePicker:
                new DatePickerDialog(WidgetsActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Log.i("date", year + "-" + monthOfYear + "-" + dayOfMonth);
                        btnDatePicker.setText(String.format("%d-%d-%d", year, monthOfYear + 1, dayOfMonth));
                    }
                }, 2015, 11, 22).show();;
                break;
            case R.id.btnTimePicker:
                new TimePickerDialog(WidgetsActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.i("timer",hourOfDay+":"+minute);
                        btnTimePicker.setText(String.format("%d:%d",hourOfDay,minute));
                    }
                },0,0,true).show();
                break;
        }
    }
    private List<String> cbResult=new ArrayList<>();
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String r=buttonView.getText().toString();
        if(isChecked) {
            cbResult.add(r);
        }else{
            if(cbResult.contains(r))
                cbResult.remove(r);
        }
        String text="";
        for(String a :cbResult){
            text+=a+"、";
        }
        tvResult.setText("我他妈喜欢："+text);
    }
}
