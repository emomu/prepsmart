package com.kbuogrenci.prepsmart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
public class MainActivity extends AppCompatActivity {
    WebView webview;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview = findViewById(R.id.web);
        WebSettings webSettings = webview.getSettings();
        webview.getSettings().setJavaScriptEnabled(true);
        progressBar = findViewById(R.id.progressBar);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("https://preps.karabuk.edu.tr/Ogrenci/Anasayfa/Index");


    }
    public class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }
}