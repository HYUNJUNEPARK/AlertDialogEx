package com.study.customex

import android.content.Context
import androidx.appcompat.app.AlertDialog

class AlertDialogManager(private val context: Context) {
    /**
     *
     */
    fun showPlainAlertDialog(
        title: String,
        message: String,
        positiveButtonText: String,
        negativeButtonText: String
    ) {
        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(positiveButtonText) { _, int ->
                //Toast.makeText(context, "INT : $int", Toast.LENGTH_SHORT).show()
                //positiveFunc
            }
            .setNegativeButton(negativeButtonText) { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            .show()
    }
}