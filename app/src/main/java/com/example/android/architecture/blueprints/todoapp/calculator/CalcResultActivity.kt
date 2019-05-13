package com.example.android.architecture.blueprints.todoapp.calculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android.architecture.blueprints.todoapp.R
import kotlinx.android.synthetic.main.activity_calc_result.*


class CalcResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_result)
        setSupportActionBar(toolbar)

        val text = intent.getStringExtra("CALC_RESULT")
        val calcView = findViewById<TextView>(R.id.calc_result)
        calcView.text = text


    }

}
