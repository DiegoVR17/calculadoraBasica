package com.example.calculadora

import android.graphics.Color
import android.util.TypedValue
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private var number_1 = 0.0
    private var number_2 = 0.0
    private var operac = 0

   val clear : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val operation : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val result : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private val _errorMsg: MutableLiveData<String> = MutableLiveData()
    val errorMsg: LiveData<String> = _errorMsg

    private val _errorMsg1: MutableLiveData<String> = MutableLiveData()
    val errorMsg1: LiveData<String> = _errorMsg1
    fun writeOpera(valButton: String, conteOpera: String){
        if (conteOpera.isEmpty()) {
            operation.value = valButton
        }
        else if (conteOpera == "." && valButton == "."){
            _errorMsg1.value = "No puede escribir más puntos decimales"
        }
        else{
            operation.value = conteOpera + valButton
        }

    }

    fun makeOpera(valButton:String,conteOpera: String){
        if (conteOpera.isEmpty()) {
            _errorMsg.value = "Debe escribir un número a operar"
        }
        else{
            when(valButton){
                "+" -> operac = 1
                "-" -> operac = 2
                "*" -> operac = 3
                "/" -> operac = 4
            }

            number_1 = conteOpera.toDouble()
            result.value = conteOpera + valButton
            operation.value = ""
        }
    }

    fun getResult(val1:String,val2: String) {
        if ((val1.isEmpty()) || (val2.isEmpty())){
            _errorMsg.value = "Debe escribir un número a operar"
        }
        else{
            result.value = val2 + val1
            number_2 = val1.toDouble()
            //number2.value = val1.toDouble()
            when(operac){
                1 -> operation.value = (number_1 + number_2).toString()
                2 -> operation.value = (number_1 - number_2).toString()
                3 -> operation.value = (number_1 * number_2).toString()
                4 -> operation.value = (number_1 / number_2).toString()
            }

        }
    }
    fun clear(){
        clear.value = ""
        number_1 = 0.0
        number_2 = 0.0
    }

}