package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.calculadora.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainActivityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        mainActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainActivityMainBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val clearObserver = Observer<String>{clear ->
            mainActivityMainBinding.editTextOpera.setText(clear)
            mainActivityMainBinding.editTextResult.setText(clear)
        }

        mainViewModel.clear.observe(this,clearObserver)

        val operatObserver = Observer<String>{operation ->
            mainActivityMainBinding.editTextOpera.setText(operation)
        }

        mainViewModel.operation.observe(this,operatObserver)

        val resultObserver = Observer<String>{result ->
            mainActivityMainBinding.editTextResult.setText(result)
        }

        mainViewModel.result.observe(this,resultObserver)

        val errorMsgObserver = Observer<String>{errorMsg ->
            Snackbar.make(view,errorMsg, Snackbar.LENGTH_INDEFINITE)
                .setAction("Continuar"){}
                .show()
        }

        mainViewModel.errorMsg.observe(this,errorMsgObserver)

        val errorMsg1Observer = Observer<String>{errorMsg ->
            Snackbar.make(view,errorMsg, Snackbar.LENGTH_INDEFINITE)
                .setAction("Continuar"){}
                .show()
        }

        mainViewModel.errorMsg1.observe(this,errorMsg1Observer)

        mainActivityMainBinding.btn0.setOnClickListener {
            mainViewModel.writeOpera("0",mainActivityMainBinding.editTextOpera.text.toString())
        }

        mainActivityMainBinding.btn1.setOnClickListener {
            mainViewModel.writeOpera("1", mainActivityMainBinding.editTextOpera.text.toString())
        }
        mainActivityMainBinding.btn2.setOnClickListener {
            mainViewModel.writeOpera("2", mainActivityMainBinding.editTextOpera.text.toString())
        }
        mainActivityMainBinding.btn3.setOnClickListener {
            mainViewModel.writeOpera("3", mainActivityMainBinding.editTextOpera.text.toString())
        }
        mainActivityMainBinding.btn4.setOnClickListener {
            mainViewModel.writeOpera("4", mainActivityMainBinding.editTextOpera.text.toString())
        }
        mainActivityMainBinding.btn5.setOnClickListener {
            mainViewModel.writeOpera("5", mainActivityMainBinding.editTextOpera.text.toString())
        }
        mainActivityMainBinding.btn6.setOnClickListener {
            mainViewModel.writeOpera("6", mainActivityMainBinding.editTextOpera.text.toString())
        }
        mainActivityMainBinding.btn7.setOnClickListener {
            mainViewModel.writeOpera("7", mainActivityMainBinding.editTextOpera.text.toString())
        }
        mainActivityMainBinding.btn8.setOnClickListener {
            mainViewModel.writeOpera("8", mainActivityMainBinding.editTextOpera.text.toString())
        }
        mainActivityMainBinding.btn9.setOnClickListener {
            mainViewModel.writeOpera("9", mainActivityMainBinding.editTextOpera.text.toString())
        }

        mainActivityMainBinding.btnDecimal.setOnClickListener {
            mainViewModel.writeOpera(".", mainActivityMainBinding.editTextOpera.text.toString())
        }

        mainActivityMainBinding.btnAdd.setOnClickListener {
            mainViewModel.makeOpera("+", mainActivityMainBinding.editTextOpera.text.toString())
        }

        mainActivityMainBinding.btnSubtract.setOnClickListener {
            mainViewModel.makeOpera("-", mainActivityMainBinding.editTextOpera.text.toString())
        }
        mainActivityMainBinding.btnMultiply.setOnClickListener {
            mainViewModel.makeOpera("*", mainActivityMainBinding.editTextOpera.text.toString())
        }

        mainActivityMainBinding.btnDivide.setOnClickListener {
            mainViewModel.makeOpera("/", mainActivityMainBinding.editTextOpera.text.toString())
        }

        mainActivityMainBinding.btnClear.setOnClickListener {
            mainViewModel.clear()
        }

        mainActivityMainBinding.btnResult.setOnClickListener {
            mainViewModel.getResult(mainActivityMainBinding.editTextOpera.text.toString(),
                mainActivityMainBinding.editTextResult.text.toString())
        }
    }

}