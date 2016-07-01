package com.example.coral.mywork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by Administrator on 2016/6/28.
 */
public class NewsDetail extends Activity {
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsdetail);
        wv= (WebView) findViewById(R.id.webview);
        String url= getIntent().getStringExtra("data");
        wv.loadUrl(url);


    }
}
