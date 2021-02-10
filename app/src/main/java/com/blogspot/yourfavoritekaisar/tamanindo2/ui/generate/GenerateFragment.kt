package com.blogspot.yourfavoritekaisar.tamanindo2.ui.generate

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blogspot.yourfavoritekaisar.tamanindo2.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import kotlinx.android.synthetic.main.fragment_generate.*

private const val TAG = "FragmentGenerate"

class GenerateFragment : Fragment(), View.OnClickListener  {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_generate, container, false)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_main -> {
                val text = edt_text.text.toString()

                if (text.isNotBlank()) {
                    val bitmap = generateQR(text)
                    iv_barcode.setImageBitmap(bitmap)
                }
            }
        }
    }

    private fun generateQR(s: String): Bitmap? {
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
        } catch (e : WriterException) {
            Log.d(TAG, "generateQRcode: ${e.message}")
        }
        return bitmap
    }

}