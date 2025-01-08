package com.example.juegos.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.juegos.R
import com.example.juegos.databinding.FragmentSettingsBinding

class Settings : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el layout usando el ViewBinding
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)


        binding.encApa.setOnClickListener {
            if (binding.encApa.text == "Encendido") {
                binding.encApa.text = "Apagado"

            } else {
                binding.encApa.text = "Encendido"

            }
        }

      navegacion()



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Evita las fugas de memoria
        _binding = null
    }

    fun navegacion() {

        binding.cambiar.setOnClickListener {

            findNavController().navigate(R.id.action_settings_to_settingsBackground2)
        }


        binding.volver.setOnClickListener {

            findNavController().navigate(R.id.action_settings_to_home2)

        }

        binding.cambiar2.setOnClickListener {

            findNavController().navigate(R.id.action_settings_to_settingsMusic2)
        }

    }
}
