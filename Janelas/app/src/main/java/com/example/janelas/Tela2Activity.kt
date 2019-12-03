package com.example.janelas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class Tela2Activity : AppCompatActivity() {
    private lateinit var btOk: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        Log.i("APP_JANELAS", "Tela2 - OnCreate")

        this.btOk = findViewById(R.id.btTela2Ok)
        this.btOk.setOnClickListener(OnClickBotao())

        // exibir no Log a mensagem enviada pela MainActivity
        var mensagem = intent.getStringExtra("MSG")
        Log.e("APP_JANELAS", mensagem)
    }

    override fun onStart() {
        super.onStart()

        Log.i("APP_JANELAS", "Tela2 - OnStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("APP_JANELAS", "Tela2 - OnResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("APP_JANELAS", "Tela2 - OnPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("APP_JANELAS", "Tela2 - OnStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("APP_JANELAS", "Tela2 - OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("APP_JANELAS", "Tela2 - OnDestroy")
    }

    inner class OnClickBotao: View.OnClickListener{
        override fun onClick(v: View?) {
            var intent = Intent()
            intent.putExtra("MSG_VOLTA", "Eita!")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}
