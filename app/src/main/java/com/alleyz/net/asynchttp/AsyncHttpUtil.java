package com.alleyz.net.asynchttp;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

/**
 *  参考资料
 *      http://loopj.com/android-async-http/
 */
public class AsyncHttpUtil {
    /**
     * Recommended Usage: Make a Static Http Client
     *  官方推荐使用静态HttpClient对象
     */
    private static AsyncHttpClient ahc=new AsyncHttpClient();

    public static void get(Context context,String url,RequestParams params,ResponseHandlerInterface handler){
        ahc.get(context,url,params,handler);
    }
    public static void post(Context context,String url,RequestParams params,ResponseHandlerInterface handler){
        ahc.post(context,url,params,handler);
    }
}
