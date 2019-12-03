package com.example.desafio

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btHTML: Button
    private lateinit var btCamera: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btHTML = findViewById(R.id.btHTML)
        this.btCamera = findViewById(R.id.btCamera)

        this.btHTML.setOnClickListener({ html(it) })
        this.btCamera.setOnClickListener({ camera(it) })
    }

    fun html(view: View){
        val uri = Uri.parse("http://www.ifpb.edu.br")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent    )
    }

    fun camera(view: View){
        val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(it)
    }

}
