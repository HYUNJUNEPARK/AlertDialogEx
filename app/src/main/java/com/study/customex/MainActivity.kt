package com.study.customex

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.study.customex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivity = this
    }

    //Ex1
    fun onEx1() {
        AlertDialogManager(this).showXmlLayoutDialog(
            "Title",
            "Message",
            "YES",
            "NO",
            ::testFun,
            ::testFun2
        )

//        Dialog(this).apply {
//            setContentView(R.layout.dialog_ex_01)
//            this.findViewById<TextView>(R.id.text_view_ex_01_title).text = "Ex1 AlertDialog"
//            this.findViewById<TextView>(R.id.contentTextView).text = "Alert Contents"
//
//            this.findViewById<AppCompatButton>(R.id.btnNegative).apply {
//                text = "N"
//                setOnClickListener {
//                    dismiss()
//                }
//            }
//
//            this.findViewById<AppCompatButton>(R.id.btnPositive).apply {
//                text = "Y"
//                setOnClickListener {
//                    Toast.makeText(context, "positive button", Toast.LENGTH_SHORT).show()
//                }
//            }
//            show()
//        }
    }

    //Ex4
    fun onEx2() {
//        val view = LayoutInflater.from(this).inflate(R.layout.custom_sample_dialog_02, null)
//        view.findViewById<TextView>(R.id.text_view_ex_01_title).text = "Ex3 AlertDialog"
//        val alertDialog = AlertDialog.Builder(this, R.style.Them_Dialog_Ex_01)
//            .setView(view)
//            .setCancelable(false)
//            .create()
//        view.findViewById<AppCompatButton>(R.id.btnPositive2).apply {
//            this.text = "Y"
//            this.setOnClickListener {
//                Toast.makeText(context, "positive button", Toast.LENGTH_SHORT).show()
//            }
//        }
//        view.findViewById<AppCompatButton>(R.id.btnNegative2).apply {
//            this.text = "N"
//            this.setOnClickListener {
//                alertDialog.dismiss()
//            }
//        }
//        alertDialog.show()
    }

    fun onEx3() {
        AlertDialogManager(this).showPlainAlertDialog(
            "Title",
            "Message",
            "YES",
            "NO",
            ::testFun
        )
    }

    private fun testFun() {
        Log.d("testLog", "showXmlLayoutDialog: 22")
        Toast.makeText(this, "TOAST Button", Toast.LENGTH_SHORT).show()
        val intent = Intent(applicationContext, SubActivity::class.java)
        startActivity(intent)
    }

    private fun testFun2() {
        Toast.makeText(this, "TOAST Button", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }

}