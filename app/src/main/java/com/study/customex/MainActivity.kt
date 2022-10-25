package com.study.customex

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
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
        Dialog(this).apply {
            setContentView(R.layout.custom_sample_dialog_01)
            this.findViewById<TextView>(R.id.titleTextView).text = "Ex1 AlertDialog"
            this.findViewById<TextView>(R.id.contentTextView).text = "Alert Contents"

            this.findViewById<AppCompatButton>(R.id.btnNegative).apply {
                text = "N"
                setOnClickListener {
                    dismiss()
                }
            }

            this.findViewById<AppCompatButton>(R.id.btnPositive).apply {
                text = "Y"
                setOnClickListener {
                    Toast.makeText(context, "positive button", Toast.LENGTH_SHORT).show()
                }
            }
            show()
        }
    }

    //Ex4
    fun onEx2() {
        val view = LayoutInflater.from(this).inflate(R.layout.custom_sample_dialog_02, null)
        view.findViewById<TextView>(R.id.titleTextView).text = "Ex3 AlertDialog"
        val alertDialog = AlertDialog.Builder(this, R.style.CustomAlertDialog)
            .setView(view)
            .setCancelable(false)
            .create()
        view.findViewById<AppCompatButton>(R.id.btnPositive).apply {
            this.text = "Y"
            this.setOnClickListener {
                Toast.makeText(context, "positive button", Toast.LENGTH_SHORT).show()
            }
        }
        view.findViewById<AppCompatButton>(R.id.btnNegative).apply {
            this.text = "N"
            this.setOnClickListener {
                alertDialog.dismiss()
            }
        }
        alertDialog.show()
    }

    //Ex4
    fun onEx3() {
        AlertDialog.Builder(this)
            .setTitle("타이틀")
            .setMessage("알림 내용")
            .setPositiveButton("Y") { _, int ->
                Toast.makeText(this, "INT : $int", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("N") { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            .show()
    }
}