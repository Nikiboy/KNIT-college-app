package com.knit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class NewsEvents extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_PROGRESS);
        this.setProgressBarVisibility(true);

        setContentView(R.layout.activity_news_events);

        WebView myWebView = (WebView) findViewById(R.id.newsWebView);

        WebViewClient WebClient = new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
//            @Override
//            public void onPageFinished(WebView view, String url) {
//
//                view.loadUrl("document.body.innerHTML = document.getElementById(\"board\");");
//
//            }
        };

        String url = "http://knit.ac.in";
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setTextZoom(0);
        myWebView.setWebViewClient(WebClient);
        myWebView.loadUrl(url);
    }

    public void bck_clicked(View v) {
        onBackPressed();
    }

}
