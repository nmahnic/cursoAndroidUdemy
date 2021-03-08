package com.udemycourse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult

class SecondFragment : Fragment(R.layout.fragment_second) {

    private var nombre : String? = ""
    private var edad : Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nombre = requireArguments().getString(MI_NOMBRE)
        edad = requireArguments().getInt(MI_EDAD)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val texto = view.findViewById<TextView>(R.id.txt_second_fragment)
        texto.text = "$nombre $edad"

        val boton = view.findViewById<Button>(R.id.btn_navegar_to_frag1)
        boton.setOnClickListener {
            val result = "Resultado"
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
        }
    }

    companion object {
        private const val MI_NOMBRE = "nombre"
        private const val MI_EDAD = "edad"

        fun newInstance(nombre: String, edad: Int) = SecondFragment().apply {
            arguments = bundleOf(MI_NOMBRE to nombre, MI_EDAD to edad)
        }
    }
}