package com.example.vargasok.bongeszo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class WebPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);

        WebView webView = (WebView) findViewById(R.id.webview);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.URL_MESSAGE);
        webView.loadUrl(message);

        Log.i("Message", message);
    }
}
