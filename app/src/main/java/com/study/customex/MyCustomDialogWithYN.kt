package com.study.customex

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class MyCustomDialogWithYN(
    private val context: Context,
    private val content: String,
    private val ybtnText: String,
    private val nBtnText: String,
    private val colorYbtnText: Int,
    private val colorNbtnText: Int,
    private val activity: Activity,
    private val parameterYFunction: () -> Unit,
    private val parameterNFunction: () -> Unit,
) : View.OnClickListener {

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
        val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT)
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
        val view = inflater.inflate(R.layout.membership_custom_withyn_popup, null)
        (view.findViewById(R.id.btn_no_custompopup_withyn) as TextView).text = nBtnText
        (view.findViewById(R.id.btn_no_custompopup_withyn) as TextView).setTextColor(colorNbtnText)
        (view.findViewById(R.id.btn_yes_custompopup_withyn) as TextView).text = ybtnText
        (view.findViewById(R.id.btn_yes_custompopup_withyn) as TextView).setTextColor(colorYbtnText)
        //<editor-fold desc="for temp. for 1차 스프린트.">
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (ybtnText == "탈퇴하기") {
                (view.findViewById(R.id.btn_yes_custompopup_withyn) as TextView).setTypeface(
                    activity.resources.getFont(R.font.pretendard_bold))
            }
            if (ybtnText == "본인 인증") {
                (view.findViewById(R.id.txt_content_custompopup_withyn) as TextView).text =
                    Html.fromHtml(activity.resources.getString(R.string.app_name))
                (view.findViewById(R.id.btn_yes_custompopup_withyn) as TextView).setTypeface(
                    activity.resources.getFont(R.font.pretendard_bold))
            } else {
                (view.findViewById(R.id.txt_content_custompopup_withyn) as TextView).text = content
            }
        }
        (view.findViewById(R.id.btn_no_custompopup_withyn) as MaterialButton).setOnClickListener {
            dialog.dismiss()
            parameterNFunction()
        }
        //</editor-fold>

        (view.findViewById(R.id.btn_yes_custompopup_withyn) as MaterialButton).setOnClickListener {
            dialog.dismiss()
            parameterYFunction()
        }
        return view
    }

    override fun onClick(view: View) {
        //if (view.id == R.id.close_button) dialog.dismiss()
    }

}