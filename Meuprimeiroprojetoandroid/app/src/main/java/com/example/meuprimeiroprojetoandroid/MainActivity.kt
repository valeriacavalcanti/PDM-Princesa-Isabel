package com.example.meuprimeiroprojetoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var numeros: TextView
    private lateinit var botaoOk: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.numeros = findViewById(R.id.tvNumeros)
        this.botaoOk = findViewById(R.id.btGerarNumeros)

        this.numeros.text = this.gerarNumeros()

        // Forma: 1
        // this.botaoOk.setOnClickListener({ onClickBotaoOk(it) })

        // Forma: 2
        /*
        this.botaoOk.setOnClickListener({
            this.numeros.text = this.gerarNumeros()
        })
         */

        // Forma: 3
        this.botaoOk.setOnClickListener(OnClickBotao())
    }

    fun gerarNumeros(): String{
        var lista = mutableSetOf<Int>()
        var random = Random()

        while (lista.size < 6){
            var num = random.nextInt(60) + 1
            lista.add(num)
        }

        return lista.toString()
    }

    // Forma: 1
    fun onClickBotaoOk(view:View){
        this.numeros.text = this.gerarNumeros()
    }

    inner class OnClickBotao: View.OnClickListener{
        override fun onClick(v: View?) {
            this@MainActivity.numeros.text = this@MainActivity.gerarNumeros()
            //numeros.text = gerarNumeros()
        }
    }

}// main
