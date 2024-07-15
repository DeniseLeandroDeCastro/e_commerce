package com.denise.castro.e_commerce.util

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.view.inputmethod.InputMethodManager.SHOW_IMPLICIT
import androidx.fragment.app.Fragment

fun Fragment.hideKeyboard(view: View? = activity?.window?.decorView?.rootView) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        view?.hideKeyboard(view)
    } else {
        inputMethodManager()?.hideSoftInputFromWindow(view?.applicationWindowToken, 0)
    }
}

fun Fragment.showKeyboard(view: View? = activity?.currentFocus) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        view?.showKeyboard(view)
    } else {
        view?.let {
            it.postDelayed({
                it.requestFocus()
                inputMethodManager()?.showSoftInput(it, SHOW_IMPLICIT)
            }, 100)
        }
    }
}

fun Fragment.inputMethodManager() = context?.getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager