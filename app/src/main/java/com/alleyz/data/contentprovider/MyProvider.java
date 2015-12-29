package com.alleyz.data.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Mr on 2015/12/25.
 */
public class MyProvider extends ContentProvider {
    public static final Uri URI= Uri.parse("content://com.alleyz.data.contentprovider.MyProvider");
    SQLiteDatabase database=null;
    @Override
    public boolean onCreate() {
        database=getContext().openOrCreateDatabase("mydb.db3", Context.MODE_PRIVATE,null);
        String sql="SELECT count(*) FROM sqlite_master WHERE type='table' AND name='tbl_my1'";
        Cursor cur=database.rawQuery(sql,null);
        if(cur.moveToNext()){
            int i=cur.getInt(0);
            if(i>0)
                return true;
        }
        database.execSQL("create table tbl_my1(_id Integer primary key,name text)");
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Log.i("PRO","query is running");
        return database.query("tbl_my1",null,null,null,null,null,null);
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long l=database.insert("tbl_my1","_id",values);
        Toast.makeText(getContext(),"写入成功"+l,Toast.LENGTH_SHORT).show();
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
