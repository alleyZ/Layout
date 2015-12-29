package com.alleyz.data.sqlite;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.alleyz.layout.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mr on 2015/12/25.
 */
public class SQLiteActivity extends ListActivity implements View.OnClickListener{
    DaoHelper helper=null;
    SimpleAdapter adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        helper= new DaoHelper(this,"mines.db",null,1);
//        lv = (ListView)findViewById(R.id.lvSqlite);

        findViewById(R.id.btnSqlite).setOnClickListener(this);
        findViewById(R.id.btnSqliteRead).setOnClickListener(this);
        findViewById(R.id.btnSqlRList).setOnClickListener(this);
        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent,final View view,final int position, long id) {
                new AlertDialog.Builder(SQLiteActivity.this)
                        .setTitle("删除")
                        .setMessage("确定要删除吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                TextView tv = (TextView) view.findViewById(R.id.tvSqlTestId);
                                String idStr = tv.getText().toString();
                                SQLiteDatabase dbWrite = helper.getWritableDatabase();
                                int i = dbWrite.delete("tbl_test", "id=?", new String[]{idStr});
                                Toast.makeText(SQLiteActivity.this, "已删除" + i, Toast.LENGTH_SHORT).show();
                                refreshData();
                            }
                        }).show();
                return true;
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSqlite:
                SQLiteDatabase db=helper.getWritableDatabase();
                ContentValues cvs=new ContentValues();
                cvs.put("name","zhangsan");
                cvs.put("sex", "男");
                Long l=db.insert("tbl_test",null,cvs);
                Toast.makeText(this,"插入数据:"+l,Toast.LENGTH_SHORT).show();
                db.close();
                refreshData();
                break;
            case R.id.btnSqliteRead:
                SQLiteDatabase rdb=helper.getReadableDatabase();
                Cursor sor=rdb.query("tbl_test", new String[]{"id", "name", "sex"}, null, null, null, null, null);
                StringBuffer re=new StringBuffer();
                while(sor.moveToNext()){
                    int id=sor.getInt(sor.getColumnIndex("id"));
                    String name=sor.getString(sor.getColumnIndex("name"));
                    String sex=sor.getString(sor.getColumnIndex("sex"));
                    re.append(String.format("id=%d,name=%s,sex=%s%n",id,name,sex));
                }
                rdb.close();
                Toast.makeText(this,re.toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSqlRList:
                refreshData();
                break;
        }
    }

    void refreshData(){
        SQLiteDatabase dbRead=helper.getReadableDatabase();
        Cursor cur=dbRead.query("tbl_test", new String[]{"id", "name", "sex"}, null, null, null, null, null);
        List<Map<String,Object>> data=new ArrayList<>();
        while(cur.moveToNext()){
            Map<String,Object> map=new HashMap<>();
            map.put("id",cur.getInt(cur.getColumnIndex("id")));
            map.put("name",cur.getString(cur.getColumnIndex("name")));
            map.put("sex",cur.getString(cur.getColumnIndex("sex")));
            data.add(map);
        }
        adapter=new SimpleAdapter(this,data,
                R.layout.activity_sqlite_list,
                new String[]{"id","name","sex"},
                new int[]{R.id.tvSqlTestId,R.id.tvSqlTestName,R.id.tvSqlTestSex});
        this.setListAdapter(adapter);
    }

}
