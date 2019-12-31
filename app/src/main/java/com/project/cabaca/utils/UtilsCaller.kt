package com.project.cabaca.utils

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog


fun showDialogJustPositive(context: Context?, title: String, message: String?, positive: String, onClickListener: DialogInterface.OnClickListener) {
    val dialog = context?.let { AlertDialog.Builder(it) }
    dialog?.setTitle(title)
    dialog?.setCancelable(false)
    dialog?.setMessage(message)
    dialog?.setPositiveButton(positive, onClickListener)
    dialog?.show()
}

fun checkNullStrip(string: String?): String {
    return if (string == "" || string == "null" || string == "null\nnull" || string == "null null" || string == null) {
        "-"
    } else {
        string.toString()
    }
}