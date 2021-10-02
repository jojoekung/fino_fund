package com.example.finofund.utils

import android.os.Looper
import android.view.View

fun View.goneView() {
    this.visibility = View.GONE
}

fun View.visibleView() {
    this.visibility = View.VISIBLE
}

fun View.invisibleView() {
    this.visibility = View.INVISIBLE
}

fun View?.onSingleClick(onclick: () -> Unit) {
    val view = this
    view?.setOnClickListener { v ->
        v.isEnabled = false
        onclick.invoke()

        android.os.Handler(Looper.getMainLooper()).postDelayed({
            v.isEnabled = true
        }, 800)
    }
}
