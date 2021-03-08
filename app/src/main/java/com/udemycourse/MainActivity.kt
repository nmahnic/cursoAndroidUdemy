package com.udemycourse

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Agrega el fragment
        supportFragmentManager.commit {
            setReorderingAllowed(true) //ordena las animaciones
            add(R.id.fragment_container_view, FirstFragment())
        }
    }


}