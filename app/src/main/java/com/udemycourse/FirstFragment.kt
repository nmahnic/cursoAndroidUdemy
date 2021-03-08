package com.udemycourse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener


class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val texto = view.findViewById<TextView>(R.id.txt_first_fragment)

        setFragmentResultListener("requestKey"){key, bundle ->
            val result = bundle.getString("bundleKey")
            result.let { texto.text = it }
        }

        val boton = view.findViewById<Button>(R.id.btn_navegar_to_frag2)
        boton.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                replace(R.id.fragment_container_view, SecondFragment.newInstance("Nico",26))
//               add(R.id.fragment_container_view, SecondFragment())
                addToBackStack("primerFragment") // id para poder navegar hacia aca
            }
        }
    }

}