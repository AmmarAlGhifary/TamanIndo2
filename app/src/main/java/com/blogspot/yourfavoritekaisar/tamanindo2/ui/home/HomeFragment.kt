package com.blogspot.yourfavoritekaisar.tamanindo2.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.blogspot.yourfavoritekaisar.tamanindo2.R
import com.blogspot.yourfavoritekaisar.tamanindo2.ui.generate.GenerateActivity


class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var btnMasuk : Button
    private lateinit var btnMalam : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        btnMasuk = container!!.findViewById(R.id.btn_masuk)
        btnMalam = container.findViewById(R.id.btn_malam)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_masuk -> {
                activity?.let{
                    val intent = Intent (it, GenerateActivity::class.java)
                    it.startActivity(intent)
                }
            }
            R.id.btn_malam -> {
                activity?.let{
                    val intent = Intent (it, GenerateActivity::class.java)
                    it.startActivity(intent)
                }
            }
        }
    }
}