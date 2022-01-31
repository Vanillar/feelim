package org.techtown.feelim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import org.techtown.feelim.R

class moreInfo : AppCompatActivity() {
    lateinit var webview: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)

        webview = findViewById(R.id.webview)


        //가져온 이름으로 웹뷰에서 해당 페이지를 열도록 한다.
        if(intent.hasExtra("intent_name")){
            val mvName = intent.getStringExtra("intent_name")
            val url = "https://search.daum.net/search?q=$mvName&w=tot&DA=S43"
            //val url = "https://movie.daum.net/search?q=$mvName&w=tot&DA=S43"

            //웹뷰 처리
            println("영화 이름 : " + mvName)
            val webSettings = webview.settings
            webSettings.javaScriptEnabled = true
            webview.loadUrl(url)
            webview.webViewClient = WebViewClient()
        }
    }
}