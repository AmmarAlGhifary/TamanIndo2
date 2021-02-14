package com.blogspot.yourfavoritekaisar.tamanindo2

import android.view.View

fun View.onClick(clickListener: (View) -> Unit) {
    setOnClickListener(clickListener)
}