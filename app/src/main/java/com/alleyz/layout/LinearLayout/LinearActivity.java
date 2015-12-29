package com.alleyz.layout.LinearLayout;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import com.alleyz.layout.R;

/**
 * Created by Mr on 2015/12/22.
 */
public class LinearActivity extends AppCompatActivity {
    /*
     *   父级容器分割
     *      layout_weight 比例分割
     *
     *
     */
    public static final String ACTION="com.alleyz.layout.intent.action.LinearActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        final EditText et=(EditText)findViewById(R.id.etUrl);
        findViewById(R.id.btnGo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=et.getText().toString();
                if(url!=null){
                    Log.i("Linear", "view url is " + url);
                    final WebView wv=(WebView)findViewById(R.id.wv);
                    wv.setWebViewClient(new WebViewClient(){
                        @Override
                        public boolean shouldOverrideUrlLoading(WebView view, String url) {
                            wv.loadUrl(url);
                            return true;
                        }
                    });
                }
            }
        });
    }
}
