package com.study.customex

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.study.customex.DialogConst.PNG_IMG_URL
import com.study.customex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dialogManager: DialogManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivity = this
        dialogManager = DialogManager(this)
    }

    //Ex1
    fun onEx1() {
//        dialogManager.showAdOneBtnDialog(
//            positiveBtnContent =  "확인 >",
//            positiveFun = ::testFun,
//            localImgResPNG = null,
//            remoteImgResUrl = PNG_IMG_URL
//        )

    }

    //Ex2
    fun onEx2() {
//        dialogManager.showAdTwoBtnDialog(
//            "teststest",
//            "확인",
//            positiveFun = ::testFun,
//            negativeFun = ::testFun
//        )

    }

    //Ex3
    fun onEx3() {
//        dialogManager.showEx5Dialog(
//            "Title",
//            "Message",
//            "YES",
//            "NO",
//            ::testFun
//        )
        showBottomSheetDialog()
    }

    fun showBottomSheetDialog() {
        val bottomSheet = BottomSheet()
        //bottomSheet.show(supportFragment)
        bottomSheet.show(supportFragmentManager, bottomSheet.tag)
    }






    private fun testFun() {
        val intent = Intent(applicationContext, SubActivity::class.java)
        startActivity(intent)
    }

    private fun testFun2() {
        Toast.makeText(this, "TOAST Button", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }
}