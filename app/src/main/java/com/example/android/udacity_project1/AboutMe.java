package com.example.android.udacity_project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class AboutMe extends AppCompatActivity {

    WebView website = null;
    final String domain = "https://twitter.com/sambhavvjain";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        if (getResources().getDisplayMetrics().widthPixels > getResources().getDisplayMetrics().
                heightPixels) {
            Toast.makeText(this, R.string.land, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.port, Toast.LENGTH_SHORT).show();
        }

        this.website = (WebView)findViewById(R.id.webview);
        website.getSettings().setJavaScriptEnabled(true);
        website.setWebViewClient(new WebViewClient());

        website.loadUrl(domain);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.website.canGoBack()) {
            this.website.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}


