package com.knit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;


public class RNO_Webview extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_PROGRESS);
        this.setProgressBarVisibility(true);

        setContentView(R.layout.activity_result);
        WebView myWebView = (WebView) findViewById(R.id.webview);

        final Activity activity = this;
        myWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                activity.setProgress(progress * 100);
            }
        });

        Intent i = getIntent();
        String url = i.getStringExtra("URL");
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setTextZoom(0);


        myWebView.loadUrl(url);

    }
}
