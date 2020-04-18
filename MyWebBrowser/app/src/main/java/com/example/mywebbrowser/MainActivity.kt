package com.example.mywebbrowser

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.email
import org.jetbrains.anko.sendSMS
import org.jetbrains.anko.share

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* WebView Default Setting */
        webView.apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
        }
        webView.loadUrl("https://www.google.com")

        /* 세 개의 인자는 (View, Action ID, Event)를 의미한다. */
        urlEditText.setOnEditorActionListener { _, actionId, _ ->
            /* actionId가 검색 버튼에 해당하는 상수와 같으면 URL을 Load */
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                webView.loadUrl(urlEditText.text.toString())
                true
            }else{
                false
            }
        }

        registerForContextMenu(webView)
    }

    /* 뒤로 가기 버튼을 눌렀을때,
    *  이전 페이지로 갈 수 있으면 가고,
    *  그게 아니면, 종료한다. */
    override fun onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack()
        }
        else{
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        // True를 반환하면 Activity에 메뉴가 있다고 인식
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.action_google, R.id.action_home -> {
                webView.loadUrl("https://www.google.com")
                return true
            }
            R.id.action_naver -> {
                webView.loadUrl("https://www.naver.com")
                return true
            }
            R.id.action_daum -> {
                webView.loadUrl("https://www.daum.net")
                return true
            }
            R.id.action_call -> {
                // 암시적 인텐트
                val intent = Intent(Intent.ACTION_DIAL)
                // Uri는 전화번호를 나타내는 국제표준 방법
                intent.data = Uri.parse("tel:031-123-4567")
                
                // resolveActivity : 이 인텐트를 수행하는 액티비티가 있는지 검사 (테블릿의 경우는 전화 앱이 없으니)
                if(intent.resolveActivity(packageManager) != null){
                    startActivity(intent)
                }
            }
            R.id.action_send_text -> {
                sendSMS("010-9637-7938", webView.url)
                return true
            }
            R.id.action_email -> {
                email("khj94811@naver.com", "김현진", webView.url)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.action_share -> {
                share(webView.url)
            }
            R.id.action_browser -> {
                browse(webView.url)
            }
        }
        return super.onContextItemSelected(item)
    }
}
