package com.example.android.mycalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numClick(view:View){
        val buClicked = view as Button

        var buStr = etOpText.text.toString()    //whatever was there initially

        when(buClicked){
            bu1 -> buStr += "1"
            bu2 -> buStr += "2"
            bu3 -> buStr += "3"
            bu4 -> buStr += "4"
            bu5 -> buStr += "5"
            bu6 -> buStr += "6"
            bu7 -> buStr += "7"
            bu8 -> buStr += "8"
            bu9 -> buStr += "9"
            buDot -> buStr += "."
        }
        etOpText.setText(buStr)
    }

    fun clearText(view:View){
        etOpText.setText("")
        op1 = "0"
    }

    fun doOp(view: View){
        /*
        sets the operation to be done
        sets the first operand
         */

        val opSel = view as Button

        when(opSel.text){
            "*" -> operation = "mul"
            "+" -> operation = "add"
            "-" -> operation = "sub"
            "/" -> operation = "div"
        }
        op1 = etOpText.text.toString()
        etOpText.setText("")    //but don't set op1 to "" -> hence not calling clearText
    }

    var operation:String = "add" //default add
    var op1 = "0"   //default first operand

    fun compute(view: View){
/*
Gets the second operand and performs the operation
 */

        var op2 = etOpText.text.toString()
        var result = 0.0

        when(operation){
            "add" -> result = op1.toDouble() + op2.toDouble()
            "sub" -> result = op1.toDouble() - op2.toDouble()
            "mul" -> result = op1.toDouble() * op2.toDouble()
            "div" -> {
                if(op2.toDouble() < 0.0001)
                    result = 0.0
                else
                    result = op1.toDouble() / op2.toDouble()
            }
        }
        etOpText.setText(result.toString())
    }

    fun inv(view: View){

    }

}
