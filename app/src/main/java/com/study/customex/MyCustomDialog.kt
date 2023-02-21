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

class MyCustomDialog(private val context: Context, private val content : String, private val btnContent : String, private val parameterFunction: () -> Unit) : View.OnClickListener
{
    companion object
    {
        var isShowing = false
    }
    private val dialog: Dialog
    private var view: View

    init
    {
        dialog = object : Dialog(context, R.style.Theme_Dialog)
        {
            override fun onBackPressed()
            {
                super.onBackPressed()
            }

            override fun create()
            {
                super.create()
                MyCustomDialog.isShowing = true
            }

            override fun dismiss()
            {
                super.dismiss()
                MyCustomDialog.isShowing = false
            }
        }
        val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        view = buildView(context)
        dialog.setContentView(view, lp)
        //set transparent to see the rounded corners
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun showDialog()
    {
        if (isShowing)
            return
        dialog.show()
        isShowing = true
    }

    private fun buildView(context: Context): View
    {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.membership_custom_popup, null)
        (view.findViewById(R.id.txt_content) as TextView).text = content
        (view.findViewById(R.id.btn_confirm) as Button).text = btnContent
        (view.findViewById(R.id.btn_confirm) as Button).setOnClickListener()
        {
            dialog.dismiss()
            parameterFunction()
        }
        Log.d("MyCustomDialg", "message : ${content}")
        //view.telTxt.setOnClickListener(this)
        return view
    }

    override fun onClick(view: View)
    {
        //if (view.id == R.id.close_button) dialog.dismiss()
    }
}