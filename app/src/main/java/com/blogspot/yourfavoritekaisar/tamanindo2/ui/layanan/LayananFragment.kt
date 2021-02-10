package com.blogspot.yourfavoritekaisar.tamanindo2.ui.layanan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.blogspot.yourfavoritekaisar.tamanindo2.R

class LayananFragment : Fragment() {

    private lateinit var layananViewModal: LayananViewModal

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        layananViewModal =
                ViewModelProvider(this).get(LayananViewModal::class.java)
        val root = inflater.inflate(R.layout.fragment_layanan, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        layananViewModal.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}