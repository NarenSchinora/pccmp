package com.myappf.pricecomparison

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class favorite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        val wbview = findViewById<WebView>(R.id.wbviw)
        wbview.setWebViewClient(WebViewClient())
        wbview.loadUrl("http://www.google.com")
        val webSettings: WebSettings = wbview.getSettings()
        webSettings.javaScriptEnabled = true


    }

    override fun onBackPressed() {
        val wbview = findViewById<WebView>(R.id.wbviw)
        if (wbview.canGoBack()) {
            wbview.goBack()
        } else {
            super.onBackPressed()
        }
    }
}