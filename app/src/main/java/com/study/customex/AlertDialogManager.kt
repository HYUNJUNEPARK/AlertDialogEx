package com.study.customex

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class AlertDialogManager(private val context: Context) {
    /**
     * 디자인이 되어 있지 않은 기본 다이얼로그를 띄워준다.
     *
     * @param title
     * @param message
     * @param positiveButtonText
     * @param negativeButtonText
     * @param positiveFun positiveButton 클릭 이벤트, ::positiveFun 형태로 전달
     * @param negativeFun negativeButton 클릭 이벤트, ::positiveFun 형태로 전달, nullable
     */
    fun showPlainAlertDialog(
        title: String,
        message: String,
        positiveButtonText: String,
        negativeButtonText: String,
        positiveFun: () -> Unit,
        negativeFun: (() -> Unit)? = null
    ) {
        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(positiveButtonText) { _, _ ->
                positiveFun()
            }
            .setNegativeButton(negativeButtonText) { dialogInterface, _ ->
                if (negativeFun != null) {
                    negativeFun()
                }
                dialogInterface.dismiss()
            }
            .show()
    }

    /**
     * 모듈 내 xml layout 을 사용한 다이얼로그를 띄워준다.
     *
     * @param title
     * @param message
     * @param positiveButtonText
     * @param negativeButtonText
     * @param positiveFun positiveButton 클릭 이벤트, ::positiveFun 형태로 전달
     * @param negativeFun negativeButton 클릭 이벤트, ::positiveFun 형태로 전달, nullable
     */
    fun showXmlLayoutDialog(
        title: String,
        message: String,
        positiveButtonText: String,
        negativeButtonText: String,
        positiveFun: () -> Unit,
        negativeFun: (() -> Unit)? = null
    ) {
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_ex_01, null)
        view.findViewById<TextView>(R.id.text_view_ex_01_title).text = title
        view.findViewById<TextView>(R.id.text_view_ex_01_content).text = message

        //dialog
        val alertDialog = AlertDialog.Builder(context, R.style.Theme_Dialog)
            .setView(view)
            .setCancelable(false) //
            .create()

        //positive
        view.findViewById<AppCompatButton>(R.id.button_ex_01_positive).apply {
            this.text = positiveButtonText
            this.setOnClickListener {
                Log.d("testLog", "showXmlLayoutDialog: 11")
                positiveFun
            }
        }

        //negative
        view.findViewById<AppCompatButton>(R.id.button_ex_01_negative).apply {
            this.text = negativeButtonText
            this.setOnClickListener {
                negativeFun
                alertDialog.dismiss()
            }
        }

        alertDialog.show()
    }


    /**
     * 광고성 다이얼로그를 띄워준다.
     */
    fun showAdDialog() {

    }


//    private val dialog: Dialog
//    private var view: View
//
//    init {
//        dialog = object : Dialog(context, R.style.Theme_Dialog) {
//
//            override fun onBackPressed() {
//                super.onBackPressed()
//            }
//
//            override fun dismiss() {
//                super.dismiss()
//            }
//        }
//        val lp = LinearLayout.LayoutParams(
//            LinearLayout.LayoutParams.MATCH_PARENT,
//            LinearLayout.LayoutParams.MATCH_PARENT
//        )
//        view = buildView(context)
//        dialog.setContentView(view, lp)
//        //set transparent to see the rounded corners
//        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//    }
//
//    fun showDialog() {
//        dialog.show()
//    }
//
//    private fun buildView(context: Context): View {
//        val inflater = LayoutInflater.from(context)
//        val view = inflater.inflate(R.layout.custom_sample_dialog_01, null)
//        (view.findViewById(R.id.btnPositive) as AppCompatButton).setOnClickListener {
//            dialog.dismiss()
//            parameterYFunction
//
//        }
//        return view
//    }


}