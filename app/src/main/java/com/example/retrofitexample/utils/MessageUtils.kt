package com.example.retrofitexample.utils

import android.content.Context
import android.view.ContextThemeWrapper
import android.widget.Toast
import com.example.retrofitexample.*
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MessageUtils {
    companion object {
        fun showMessage(msg: String) {
            Toast.makeText(App.instance, msg, Toast.LENGTH_SHORT).show()
        }

        fun getDialogShape(
            context: Context,
            title: String,
            text: String,
            type: Int
        ): MaterialAlertDialogBuilder {
            lateinit var builder: MaterialAlertDialogBuilder
            when (type) {
                DIALOG_TYPE_INFO -> {
                    builder = MaterialAlertDialogBuilder(
                        ContextThemeWrapper(
                            context,
                            R.style.CommonDialogTheme
                        )
                    )
                }
                DIALOG_TYPE_ERROR -> {
                    builder = MaterialAlertDialogBuilder(
                        ContextThemeWrapper(
                            context,
                            R.style.ErrorDialogTheme
                        )
                    )
                }
                DIALOG_TYPE_WARN -> {
                    builder = MaterialAlertDialogBuilder(
                        ContextThemeWrapper(
                            context,
                            R.style.WarnDialogTheme
                        )
                    )
                }
            }

            builder.setCancelable(false)
            builder.setTitle(title)
            builder.setMessage(text)
            builder.create()
            return builder
        }
    }
}