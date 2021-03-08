package com.udemycourse

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var texto : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById<TextView>(R.id.txt_enter)

        val boton = findViewById<Button>(R.id.btn_enter)
        boton.setOnClickListener {
            navegarSecondActivity()
        }
    }

    private fun navegarSecondActivity(){
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("nombre","Mash")
        startActivityForResult(intent,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                val nombre2 = data?.getStringExtra("nombre2")
                texto.text = nombre2
            }
        }
    }
}