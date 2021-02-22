package com.blogspot.yourfavoritekaisar.tamanindo2.ui.web

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.blogspot.yourfavoritekaisar.tamanindo2.R
import com.blogspot.yourfavoritekaisar.tamanindo2.databinding.ActivityShowPaymentBinding
import kotlinx.android.synthetic.main.activity_show_payment.*

class ShowPaymentActivity : AppCompatActivity() {

    private lateinit var binding : ActivityShowPaymentBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_show_payment)
        binding = ActivityShowPaymentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.wvSatuMalam
        wv_satu_malam.settings.javaScriptEnabled = true
        wv_satu_malam.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl("https://app.sandbox.midtrans.com/payment-links/1613633634232")
                return true
            }
        }
    }
}