package com.blogspot.yourfavoritekaisar.tamanindo2.ui.web

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.blogspot.yourfavoritekaisar.tamanindo2.R
import com.blogspot.yourfavoritekaisar.tamanindo2.databinding.ActivityShowPaymentBinding
import com.blogspot.yourfavoritekaisar.tamanindo2.databinding.ActivityShowTicketMalamBinding
import kotlinx.android.synthetic.main.activity_show_payment.*
import kotlinx.android.synthetic.main.activity_show_ticket_malam.*

class ShowTicketMalamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowTicketMalamBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_ticket_malam)
        binding = ActivityShowTicketMalamBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)
        binding.wvMenginap

        wv_menginap.settings.javaScriptEnabled = true
        wv_menginap.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl("https://app.sandbox.midtrans.com/payment-links/1613633738939")
                return true
            }
        }
    }
}