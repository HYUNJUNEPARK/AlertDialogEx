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
        MyCustomDialog(
            this,
            "teststest",
            "확인",
            positiveFun = ::testFun,
            negativeFun = ::testFun
        ).showEx2Dialog()
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
}