package com.study.customex

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.button.MaterialButton

/**
 * @param context
 */
class DialogManager(private val context: Context) {
    private val dialog: Dialog = Dialog(context, R.style.Them_Dialog_Ex_01)
    private var layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
        /*width*/ LinearLayout.LayoutParams.MATCH_PARENT,
        /*height*/LinearLayout.LayoutParams.MATCH_PARENT
    )

    //TODO 서버에서 받은 이미지를 이미지 뷰에 띄울 수 있어야함
    /**
     * 원버튼 광고성 다이얼로그(이미지)
     */
    fun showAdOneBtnDialog(
        positiveBtnContent: String,
        positiveFun: (() -> Unit)? = null
    ) {
        //build view
        val view =  LayoutInflater.from(context).inflate(R.layout.dialog_ex_01, null)
        (view.findViewById(R.id.btn_confirm) as Button).text = positiveBtnContent
        (view.findViewById(R.id.btn_close) as Button).setOnClickListener { //닫기 버튼
            dialog.dismiss()
        }
        (view.findViewById(R.id.btn_confirm) as Button).setOnClickListener { //확인 버튼
            positiveFun?.invoke()
            dialog.dismiss()
        }

        //set
        dialog.setContentView(view, layoutParams)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        //show
        dialog.show()
    }

    //TODO 서버에서 받은 이미지를 이미지 뷰에 띄울 수 있어야함
    /**
     * 투버튼 광고성 다이얼로그(이미지)
     */
    fun showAdTwoBtnDialog(
        positiveBtnContent: String,
        negativeBtnContent: String? = null,
        positiveFun: (() -> Unit)? = null,
        negativeFun: (() -> Unit)? = null,
    ) {
        //build view
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_ex_02, null)
        (view.findViewById(R.id.ex_02_positive_btn) as TextView).text = positiveBtnContent
        (view.findViewById(R.id.ex_02_negative_btn) as TextView).text = negativeBtnContent
        (view.findViewById(R.id.ex_02_positive_btn) as MaterialButton).setOnClickListener {
            dialog.dismiss()
            positiveFun?.invoke()
        }
        (view.findViewById(R.id.ex_02_negative_btn) as MaterialButton).setOnClickListener {
            dialog.dismiss()
            negativeFun?.invoke()
        }

        //set
        dialog.setContentView(view, layoutParams)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT)) //set transparent to see the rounded corners

        //show
        dialog.show()
    }

    /**
     * 원버튼 시스템 다이얼로그(텍스트)
     */
    fun showEx3Dialog(){

    }

    /**
     * 투버튼 시스템 다이얼로그(텍스트)
     */
    fun showEx4Dialog(){

    }

    /**
     * 기본 다이얼로그(텍스트)
     */
    fun showEx5Dialog(
        title: String,
        content: String,
        positiveBtnContent: String,
        negativeBtnContent: String? = null,
        positiveFun: (() -> Unit)? = null,
        negativeFun: (() -> Unit)? = null,
    ) {
        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(content)
            .setPositiveButton(positiveBtnContent) { _, _ ->
                positiveFun?.invoke()
            }
            .setNegativeButton(negativeBtnContent) { dialogInterface, _ ->
                negativeFun?.invoke()
                dialogInterface.dismiss()
            }
            .show()
    }
}