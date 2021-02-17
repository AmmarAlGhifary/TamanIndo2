package com.blogspot.yourfavoritekaisar.tamanindo2.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.blogspot.yourfavoritekaisar.tamanindo2.R
import com.blogspot.yourfavoritekaisar.tamanindo2.databinding.FragmentHome2Binding
import com.blogspot.yourfavoritekaisar.tamanindo2.onClick
import com.blogspot.yourfavoritekaisar.tamanindo2.ui.generate.GenerateActivity
import com.blogspot.yourfavoritekaisar.tamanindo2.ui.generate.GeneratePenginapanActivity
import com.blogspot.yourfavoritekaisar.tamanindo2.viewBinding

class HomeFragment2 : Fragment(R.layout.fragment_home2) {

    private val binding by viewBinding(FragmentHome2Binding::bind)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnMasuk.onClick {
            val intent = Intent (activity, GenerateActivity::class.java)
            activity?.startActivity(intent)
        }
        binding.btnMalam.onClick {
            val intent = Intent (activity, GeneratePenginapanActivity::class.java)
            activity?.startActivity(intent)
        }
    }
}