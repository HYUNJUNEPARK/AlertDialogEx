package com.study.customex

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.button.MaterialButton

/**
 * @param context
 * @param content
 * @param positiveBtnContent
 * @param positiveFun
 */
class MyCustomDialog(
    private val context: Context,
    private val content: String,
    private val positiveBtnContent: String,
    private val negativeBtnContent: String? = null,
    private val positiveFun: (() -> Unit)? = null,
    private val negativeFun: (() -> Unit)? = null,
) {
    companion object {
        var isDialogShowing = false //dialog 객체가 이미 떠있는 상태라면 중복으로 띄우지 않음
    }

    private val dialog: Dialog
    private var layoutParams: LinearLayout.LayoutParams

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

//            override fun onBackPressed() { //다이얼로그가 떠있는 상태에서 시스템 Back 클릭 했을 때
//                super.onBackPressed()
//            }
        }

       layoutParams = LinearLayout.LayoutParams(
            /*width*/ LinearLayout.LayoutParams.MATCH_PARENT,
            /*height*/LinearLayout.LayoutParams.MATCH_PARENT
        )
    } //init

    private fun buildEx1View(context: Context): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.dialog_ex_01, null)
        (view.findViewById(R.id.txt_content) as TextView).text = content
        (view.findViewById(R.id.btn_confirm) as Button).text = positiveBtnContent
        (view.findViewById(R.id.btn_confirm) as Button).setOnClickListener {
            dialog.dismiss()
            positiveFun?.invoke()
        }

        return view
    }

    private fun buildEx2View(context: Context): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.membership_custom_withyn_popup, null)
        (view.findViewById(R.id.btn_no_custompopup_withyn) as TextView).text = positiveBtnContent
        (view.findViewById(R.id.btn_yes_custompopup_withyn) as TextView).text = negativeBtnContent

        //(view.findViewById(R.id.btn_no_custompopup_withyn) as TextView).setTextColor(colorNbtnText)
        //(view.findViewById(R.id.btn_yes_custompopup_withyn) as TextView).setTextColor(colorYbtnText)
        //<editor-fold desc="for temp. for 1차 스프린트.">

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            if (ybtnText == "탈퇴하기") {
//                (view.findViewById(R.id.btn_yes_custompopup_withyn) as TextView).setTypeface(
//                    activity.resources.getFont(R.font.pretendard_bold))
//            }
//            if (ybtnText == "본인 인증") {
//                (view.findViewById(R.id.txt_content_custompopup_withyn) as TextView).text =
//                    Html.fromHtml(activity.resources.getString(R.string.app_name))
//                (view.findViewById(R.id.btn_yes_custompopup_withyn) as TextView).setTypeface(
//                    activity.resources.getFont(R.font.pretendard_bold))
//            } else {
//                (view.findViewById(R.id.txt_content_custompopup_withyn) as TextView).text = content
//            }
//        }

        (view.findViewById(R.id.btn_no_custompopup_withyn) as MaterialButton).setOnClickListener {
            dialog.dismiss()
            //parameterNFunction()
        }
        //</editor-fold>

        (view.findViewById(R.id.btn_yes_custompopup_withyn) as MaterialButton).setOnClickListener {
            dialog.dismiss()
            //negativeFun()
        }
        return view
    }

    /**
     *
     */
    fun showEx1Dialog() {
        if (isDialogShowing) {
            return
        }
        val view = buildEx1View(context)
        dialog.setContentView(view, layoutParams)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT)) //set transparent to see the rounded corners

        dialog.show()
        isDialogShowing = true
    }

    fun showEx2Dialog() {
        if (isDialogShowing) {
            return
        }
        val view = buildEx2View(context)
        dialog.setContentView(view, layoutParams)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT)) //set transparent to see the rounded corners
        dialog.show()

        isDialogShowing = true
    }


}