package com.example.android.architecture.blueprints.todoapp.calculator

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.architecture.blueprints.todoapp.R

import kotlinx.android.synthetic.main.activity_calc_result.*

class CalcResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_result)
        setSupportActionBar(toolbar)



    }

}
