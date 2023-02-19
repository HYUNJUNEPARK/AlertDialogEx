package com.study.customex

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton

class AlertDialogManager(
    private val context: Context,
    private val parameterYFunction: () -> Unit,
    ): View.OnClickListener {
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
                Log.d("testLog", "testFun: inner")
                //Toast.makeText(context, "INT : $int", Toast.LENGTH_SHORT).show()
                parameterYFunction()

            }
            .setNegativeButton(negativeButtonText) { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            .show()
    }
    private val dialog: Dialog
    private var view: View

    init {
        dialog = object : Dialog(context, R.style.Theme_Dialog) {

            override fun onBackPressed() {
                super.onBackPressed()
            }

            override fun dismiss() {
                super.dismiss()
            }
        }
        val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        view = buildView(context)
        dialog.setContentView(view, lp)
        //set transparent to see the rounded corners
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun showDialog() {
        dialog.show()
    }

    private fun buildView(context: Context): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.custom_sample_dialog_01, null)
        (view.findViewById(R.id.btnPositive) as AppCompatButton).setOnClickListener {
            dialog.dismiss()
            parameterYFunction

        }
        return view
    }

    override fun onClick(v: View?) {
        //TODO("Not yet implemented")
    }

}