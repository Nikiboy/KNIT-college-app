package com.knit;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ContactActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_PROGRESS);
        this.setProgressBarVisibility(true);

        setContentView(R.layout.contact);

        WebView myWebView = (WebView) findViewById(R.id.contactWebView);

        WebViewClient WebClient = new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                view.loadUrl("document.getElementById(\"inner-wrap\").innerHTML = document.getElementById(\"cntnt\").innerHTML;");
//            }
        };

        String url = "http://knit.ac.in/contacts.htm";
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
