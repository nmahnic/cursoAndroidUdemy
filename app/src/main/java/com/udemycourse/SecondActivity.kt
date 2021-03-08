package com.udemycourse

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private var nombre : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val texto = findViewById<TextView>(R.id.txt_second)
        val boton = findViewById<Button>(R.id.btn_return)
        boton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("nombre2", "Hola esta es la respuesta")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        intent.extras?.let { bundle ->
            nombre = bundle.getString("nombre")!!
            nombre.let{ nombre ->
                Log.d("NM",nombre)
                texto.text = nombre
            }
            Log.d("NM",nombre)
        }



    }
}