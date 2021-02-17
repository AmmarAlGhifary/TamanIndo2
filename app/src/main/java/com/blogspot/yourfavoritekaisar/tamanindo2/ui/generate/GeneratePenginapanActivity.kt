package com.blogspot.yourfavoritekaisar.tamanindo2.ui.generate

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.ImageView
import android.widget.Toast
import com.blogspot.yourfavoritekaisar.tamanindo2.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.android.synthetic.main.fragment_home2.*

class GeneratePenginapanActivity : AppCompatActivity() {

    private lateinit var intentIntegrator: IntentIntegrator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate_penginapan)
        intentIntegrator = IntentIntegrator(this)
        generateQR("100,000")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (intentResult!= null){
            btn_masuk.text = intentResult.contents
            btn_malam.text = intentResult.contents

        } else{
            Toast.makeText(this, "Dibatalkan", Toast.LENGTH_SHORT).show()
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun generateQR(s: String): Bitmap {
        val width = 500
        val height = 500
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val codeWriter = MultiFormatWriter()
        try {
            val bitMatrix = codeWriter.encode(s, BarcodeFormat.QR_CODE, width, height)
            for (x in 0 until width) {
                for (y in 0 until height) {
                    bitmap.setPixel(x, y,
                        if (bitMatrix[x, y]) Color.BLACK
                        else Color.WHITE)
                }
            }
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.createBitmap(bitMatrix)
            val image : ImageView = findViewById(R.id.iv_barcode)
            image.setImageBitmap(bitmap)
        } catch (e : WriterException) {
            d(GenerateActivity.TAG, "generateQRcode: ${e.message}")
        }
        return bitmap
    }
}