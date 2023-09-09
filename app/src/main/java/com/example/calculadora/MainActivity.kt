package com.example.calculadora

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var num1: Double = 0.0
    private var operac: Int = 0
    private var result: Double = 0.0
    private lateinit var mainActivityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainActivityMainBinding.root
        setContentView(view)

        mainActivityMainBinding.btn0.setOnClickListener {
            writeOpera("0")
        }

        mainActivityMainBinding.btn1.setOnClickListener {
            writeOpera("1")
        }
        mainActivityMainBinding.btn2.setOnClickListener {
            writeOpera("2")
        }
        mainActivityMainBinding.btn3.setOnClickListener {
            writeOpera("3")
        }
        mainActivityMainBinding.btn4.setOnClickListener {
            writeOpera("4")
        }
        mainActivityMainBinding.btn5.setOnClickListener {
            writeOpera("5")
        }
        mainActivityMainBinding.btn6.setOnClickListener {
            writeOpera("6")
        }
        mainActivityMainBinding.btn7.setOnClickListener {
            writeOpera("7")
        }
        mainActivityMainBinding.btn8.setOnClickListener {
            writeOpera("8")
        }
        mainActivityMainBinding.btn9.setOnClickListener {
            writeOpera("9")
        }

        mainActivityMainBinding.btnDecimal.setOnClickListener {
            writeOpera(".")
        }

        mainActivityMainBinding.btnAdd.setOnClickListener {
            makeOpera("+")
            operac = 1
        }

        mainActivityMainBinding.btnSubtract.setOnClickListener {
            makeOpera("-")
            operac = 2
        }
        mainActivityMainBinding.btnMultiply.setOnClickListener {
            makeOpera("*")
            operac = 3
        }

        mainActivityMainBinding.btnDivide.setOnClickListener {
            makeOpera("/")
            operac = 4
        }

        mainActivityMainBinding.btnClear.setOnClickListener {
            clear()
        }

        mainActivityMainBinding.btnResult.setOnClickListener {
            getResult()
        }
    }

    private fun writeOpera(valButton:String){
        val valOpera = mainActivityMainBinding.editTextOpera.text.toString()
        if (valOpera.isEmpty()) {
            mainActivityMainBinding.editTextOpera.setText(valButton)
        }
        val textOpera = valOpera+valButton
        mainActivityMainBinding.editTextOpera.setText(textOpera)
    }

    private fun makeOpera(valButton:String){
        val valOpera = mainActivityMainBinding.editTextOpera.text.toString()
        if (valOpera.isEmpty()) {
            Toast.makeText(this,"Debe escribir un número a operar", Toast.LENGTH_SHORT).show()
            return
        }
        else{
            num1 = mainActivityMainBinding.editTextOpera.text.toString().toDouble()
            val textResult = valOpera+valButton
            mainActivityMainBinding.editTextResult.setText(textResult)
            mainActivityMainBinding.editTextOpera.setText("")
        }
    }

    private fun getResult() {
        val valOpera = mainActivityMainBinding.editTextOpera.text.toString()
        val valOpera1 = mainActivityMainBinding.editTextResult.text.toString()
        if ((valOpera.isEmpty()) || (valOpera1.isEmpty())){
            Toast.makeText(this,"Debe escribir un número a operar", Toast.LENGTH_SHORT).show()
            return
        }
        else{
            val expres = valOpera1 + valOpera
            mainActivityMainBinding.editTextResult.setText(expres)
            val num2 = valOpera.toDouble()
            when(operac){
                1 -> result = num1 + num2
                2 -> result = num1 - num2
                3 -> result = num1 * num2
                4 -> result = num1 / num2
            }
            mainActivityMainBinding.editTextOpera.setText(result.toString())
            mainActivityMainBinding.editTextOpera.setTextColor(Color.parseColor("#3DF73A"))
        }
    }

    private fun clear(){
        mainActivityMainBinding.editTextResult.setText("")
        mainActivityMainBinding.editTextOpera.setText("")
        num1 = 0.0
        mainActivityMainBinding.editTextOpera.setTextColor(Color.parseColor("#111111"))
    }

}