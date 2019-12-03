package com.example.janelas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btOk: Button
    val TELA2 = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("APP_JANELAS", "Main - OnCreate")

        this.btOk = findViewById(R.id.btMainOk)
        this.btOk.setOnClickListener(OnClickBotao())
    }

    override fun onStart() {
        super.onStart()

        Log.i("APP_JANELAS", "Main - OnStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("APP_JANELAS", "Main - OnResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("APP_JANELAS", "Main - OnPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("APP_JANELAS", "Main - OnStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("APP_JANELAS", "Main - OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("APP_JANELAS", "Main - OnDestroy")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == TELA2){
                Log.e("APP_JANELAS", data?.getStringExtra("MSG_VOLTA"))
            }
        }else{
            Log.e("APP_JANELAS", "O usuário cancelou")
        }
    }


    inner class OnClickBotao: View.OnClickListener{
        override fun onClick(v: View?) {
            var intent = Intent(this@MainActivity, Tela2Activity::class.java)
            intent.putExtra("MSG", "Que bom!")
            //startActivity(intent)
            startActivityForResult(intent, TELA2)
        }
    }
}
