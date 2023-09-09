package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainActivityMainBinding.root
        setContentView(view)

        var index = 0

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
        }

        mainActivityMainBinding.btnSubtract.setOnClickListener {  }

        mainActivityMainBinding.btnMultiply.setOnClickListener {  }

        mainActivityMainBinding.btnDivide.setOnClickListener {  }

        mainActivityMainBinding.btnClear.setOnClickListener {  }

        mainActivityMainBinding.btnResult.setOnClickListener {  }
            makeOpera("=", index)
            index = 0
    }

    private fun writeOpera(valButton:String){
        val valOpera = mainActivityMainBinding.editTextOpera.text.toString()
        if (valOpera.isEmpty()) {
            mainActivityMainBinding.editTextOpera.setText(valButton)
        }
        val textOpera = valOpera+valButton
        mainActivityMainBinding.editTextOpera.setText(textOpera)
    }

    private fun makeOpera(valButton:String,index: Int){
        val memoryArray = mutableListOf<Int>()
        val valOpera = mainActivityMainBinding.editTextOpera.text.toString()
        if (valOpera.isEmpty()) {
            Toast.makeText(this,"Debe escribir un número a operar", Toast.LENGTH_SHORT).show()
            return
        }
        else {memoryArray.add(index,valOpera.toInt())
             mainActivityMainBinding.editTextOpera.setText("")
        }

    }

}