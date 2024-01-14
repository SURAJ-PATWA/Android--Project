package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webViewVariable=findViewById<WebView>(R.id.webView)
        webViewSetUp(webViewVariable)
    }
    private fun webViewSetUp(a:WebView){
        a.webViewClient= WebViewClient()
        a.apply {
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
            loadUrl("https://onlinebusinessbar.com/product/i-see-you/")
        }
    }
}