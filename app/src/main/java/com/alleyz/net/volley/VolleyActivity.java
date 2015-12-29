package com.alleyz.net.volley;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alleyz.layout.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Volley
     JSON，图像等的异步下载；
     网络请求的排序（scheduling）
     网络请求的优先级处理
     缓存
     多级别取消请求
     和Activity和生命周期的联动（Activity结束时同时取消所有网络请求）
 *
 *
 */
public class VolleyActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv;
    private ImageView iv;
    private NetworkImageView niv;
    ImageLoader.ImageCache imageCache;
    RequestQueue rq;//请求队列
    final LruCache<String,Bitmap> lruCache=new LruCache(20);//缓存
    ImageLoader loader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        findViewById(R.id.btnVolleyStart).setOnClickListener(this);
        findViewById(R.id.btnVolleyIv).setOnClickListener(this);
        findViewById(R.id.btnVolleyNiv).setOnClickListener(this);

        rq=VolleyApplication.getRequestQueue();
        imageCache=new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                Log.i("iv","-----------");
                return lruCache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                Log.i("iv",bitmap.toString());
                lruCache.put(url, bitmap);
                iv.setImageBitmap(bitmap);
            }
        };
        loader=new ImageLoader(rq,imageCache);
        tv = (TextView) findViewById(R.id.tvVolley);
        niv = (NetworkImageView) findViewById(R.id.nivVolley);
        iv = (ImageView) findViewById(R.id.ivVolley);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnVolleyStart:
                getJson();
                break;
            case R.id.btnVolleyIv:
                getImage();
                break;
            case R.id.btnVolleyNiv:
                getNivPic();
                break;
        }
    }

    public void getNivPic(){
        String url="http://a.hiphotos.baidu.com/album/h%3D800%3Bcrop%3D0%2C0%2C1280%2C800/sign=5f024b518326cffc762ab2b2893a29e2/72f082025aafa40fa3bcf315aa64034f79f019fb.jpg";
        niv.setDefaultImageResId(R.drawable.bg_opacity);
        niv.setErrorImageResId(0);
        niv.setImageUrl(url,loader);
    }

    public void getImage(){
        String url="http://a.hiphotos.baidu.com/album/h%3D800%3Bcrop%3D0%2C0%2C1280%2C800/sign=5f024b518326cffc762ab2b2893a29e2/72f082025aafa40fa3bcf315aa64034f79f019fb.jpg";
        ImageLoader.ImageListener il=ImageLoader.getImageListener(iv, R.drawable.btn_skin,0);
        loader.get(url, il);
    }

    public void getJson(){
        String url="http://10.8.177.204:8983/solr/solr-1130_shard3_replica1/select?q=*%3A*&wt=json&indent=true";
        rq.add(new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("JSON>>>>",response.toString());
                tv.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("",error.getMessage());
                tv.setText(error.getMessage());
            }
        }));
    }
}
