package com.study.customex

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

/**
 * @param context
 * @param content
 * @param btnContent
 * @param parameterFunction
 */
class MyCustomDialog(
    private val context: Context,
    private val content: String,
    private val btnContent: String,
    private val parameterFunction: () -> Unit,
) {

    companion object {
        var isDialogShowing = false
        val TAG = "testLog"
    }

    private val dialog: Dialog
    private var view: View

    init {
        dialog = object : Dialog(context, R.style.Theme_Dialog) {
            override fun create() {
                super.create()
                isDialogShowing = true
            }

            override fun dismiss() { //다이얼로그가 사라졌을 때
                super.dismiss()
                isDialogShowing = false
            }

            override fun onBackPressed() { //다이얼로그가 떠있는 상태에서 시스템 Back 클릭 했을 때
                super.onBackPressed()
            }
        }

        val layoutParams = LinearLayout.LayoutParams(
            /*width*/ LinearLayout.LayoutParams.MATCH_PARENT,
            /*height*/LinearLayout.LayoutParams.MATCH_PARENT
        )

        view = buildView(context)

        dialog.setContentView(view, layoutParams)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    private fun buildView(context: Context): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.membership_custom_popup, null)
        (view.findViewById(R.id.txt_content) as TextView).text = content
        (view.findViewById(R.id.btn_confirm) as Button).text = btnContent

        (view.findViewById(R.id.btn_confirm) as Button).setOnClickListener() {
            dialog.dismiss()
            parameterFunction()
        }

        return view
    }

    fun showDialog() {
        if (isDialogShowing) { //dialog 객체가 이미 떠있는 상태라면 중복으로 띄우지 않음
            return
        }
        dialog.show()
        isDialogShowing = true
    }
}