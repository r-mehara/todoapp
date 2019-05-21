package com.example.android.architecture.blueprints.todoapp.calculator

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android.architecture.blueprints.todoapp.R
import kotlinx.android.synthetic.main.activity_calc_result.*
import kotlinx.android.synthetic.main.content_calc_result.*


class CalcResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_result)
        setSupportActionBar(toolbar)

        val text = intent.getStringExtra("CALC_RESULT")
        val calcView = findViewById<TextView>(R.id.calc_result)
        calcView.text = text
        val n: Double = text.toDouble()

        imgView.setImageResource(selectImage(n))
    }

    private fun selectImage (calcResult: Double): Int{

        return when{

            calcResult%2==0.0 -> R.drawable.even
            calcResult%2==1.0 -> R.drawable.odd
            else -> R.drawable.other

        }
    }

}
