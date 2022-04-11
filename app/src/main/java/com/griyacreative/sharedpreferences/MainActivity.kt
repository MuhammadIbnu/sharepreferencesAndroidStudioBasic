package com.griyacreative.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("mypref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        btnsave.setOnClickListener {
            val name = edtname.text.toString()
            val age = edtage.text.toString().toInt()
            val isAdult = cbadult.isChecked

            editor.apply {
                putString("name", name)
                putInt("age", age)
                putBoolean("isAdult", isAdult)
                apply()
            }
        }

        btnload.setOnClickListener {
            val name = sharedPref.getString("name", null)
            val age = sharedPref.getInt("age",0)
            val isAdult = sharedPref.getBoolean("usAdult", false)
            edtname.setText(name)
            edtage.setText(age.toString())
            cbadult.isChecked = isAdult
        }
    }
}