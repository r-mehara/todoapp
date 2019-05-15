package com.example.android.architecture.blueprints.todoapp.calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.util.setupActionBar
import kotlinx.android.synthetic.main.content_calculator.*

class CalculatorActivity : AppCompatActivity() {

    var nStr : String = ""
    val nList = ArrayList<Double>() // 数式に含まれる数を保持する配列
    val oList = ArrayList<Char>() // 数式に含まれるオペレーション（四則演算）を保持する配列

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_calculator)

        setupActionBar(R.id.toolbar) {
            setTitle(R.string.calculator_title)
            setHomeAsUpIndicator(R.drawable.ic_menu)
            setDisplayHomeAsUpEnabled(true)
        }


        setContentView(R.layout.activity_calculator)

        next.setOnClickListener {
            val intent = Intent(this, CalcResultActivity::class.java)
            intent.putExtra("CALC_RESULT", formula.text)
            startActivity(intent)
        }

        num0.setOnClickListener {
            formula.text = "${formula.text}0" //表示する数式に0を追加
            nStr += "0"                       //数字の文字列に0を追加
        }

        num1.setOnClickListener {
            formula.text = "${formula.text}1" //表示する数式に1を追加
            nStr += "1"
        }

        num2.setOnClickListener {
            formula.text = "${formula.text}2"
            nStr += "2"
        }

        num3.setOnClickListener {
            formula.text = "${formula.text}3"
            nStr += "3"
        }

        num4.setOnClickListener {
            formula.text = "${formula.text}4"
            nStr += "4"
        }

        num5.setOnClickListener {
            formula.text = "${formula.text}5"
            nStr += "5"
        }

        num6.setOnClickListener {
            formula.text = "${formula.text}6"
            nStr += "6"
        }

        num7.setOnClickListener {
            formula.text = "${formula.text}7"
            nStr += "7"
        }

        num8.setOnClickListener {
            formula.text = "${formula.text}8"
            nStr += "8"
        }

        num9.setOnClickListener {
            formula.text = "${formula.text}9"
            nStr += "9"
        }
        point.setOnClickListener {
            formula.text = "${formula.text}."
            nStr += "."
        }

        equal.setOnClickListener {
            formula.text = "${formula.text}="
            addList(nStr)
            var result = calcualte().toString()
            formula.text = result
            nStr = result
            nList.clear()
            oList.clear()
        }

        add.setOnClickListener {
            formula.text = "${formula.text}+"
            addList(nStr,'+')                 //後述、nStrを小数に変換しnListに入れ、"+"をoListに入れる。
            nStr = ""                         //nStrを空に戻す
        }

        subtract.setOnClickListener {
            formula.text = "${formula.text}-"
            addList(nStr,'-')
            nStr = ""
        }

        multiply.setOnClickListener {
            formula.text = "${formula.text}*"
            addList(nStr,'*')
            nStr = ""
        }

        divide.setOnClickListener {
            formula.text = "${formula.text}/"
            addList(nStr,'/')
            nStr = ""
        }

        delete.setOnClickListener {
            var formulaStr = formula.text.toString()
            if (!formulaStr.isEmpty()) {
                formula.text = formulaStr.subSequence(0,formulaStr.lastIndex)
            }
            if (!nStr.isEmpty()) {
                nStr = nStr.substring(0, nStr.lastIndex)
            }
        }

        percent.setOnClickListener {
            formula.text = "${formula.text}%"
        }

        sign.setOnClickListener {

        }

        clear.setOnClickListener {
            formula.text = ""
            nStr = ""
            nList.clear()
            oList.clear()
        }

    }

    fun addList(str : String, ope : Char) {
        try {
            var num = str.toDouble()
            nList.add(num)
            oList.add(ope)
        } catch (e: Exception) {
            formula.text = "Numeric error"
        }
    }

    fun addList(str : String) {
        try {
            var num = str.toDouble()
            nList.add(num)
        }catch(e:Exception){
            formula.text = "Numeric error"
        }
    }

    fun calcualte() : Double {

        var i = 0
        while (i < oList.size) {
            //do multiplication and division first
            if(oList.get(i) == '*' || oList.get(i) == '/') {
                var result = if (oList.get(i) == '*') nList.get(i) * nList.get(i+1) else nList.get(i) / nList.get(i+1)
                nList.set(i,result)
                nList.removeAt(i+1)
                oList.removeAt(i)
                i--
            }
            // change subtraction to addition
            else if(oList.get(i) == '-'){
                oList.set(i,'+')
                nList.set(i+1,nList.get(i+1) * -1)
            }
            i++
        }

        // get sum
        var result = 0.0
        for (i in nList){
            result += i
        }

        return result
    }// end fun calcualte

}
