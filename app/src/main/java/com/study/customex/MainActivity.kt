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
        MyCustomDialog(
            this,
            "teststest !",
            "확인 !",
            positiveFun = ::testFun
        ).showEx1Dialog()
    }

    //Ex2
    fun onEx2() {
//        MyCustomDialog(
//            this,
//            "teststest",
//            "확인"
//        ) {/*확인 버튼 클릭 시 실행*/}.showEx2Dialog()
    }

    //Ex3
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