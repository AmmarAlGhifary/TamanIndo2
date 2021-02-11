package com.blogspot.yourfavoritekaisar.tamanindo2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.blogspot.yourfavoritekaisar.tamanindo2.R


class HomeFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_sekali_masuk -> {

            }
            R.id.btn_malam -> {

            }
        }
    }
}