package com.example.juegos.barajaEspanyola

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.juegos.R
import com.example.juegos.databinding.FragmentEspanyolaJugadorMemoryBinding
import com.example.juegos.databinding.FragmentEspanyolaSieteJugadorBinding


class EspanyolaSieteJugador : Fragment() {

    private var _binding : FragmentEspanyolaSieteJugadorBinding? = null
    private val  binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentEspanyolaSieteJugadorBinding.inflate(inflater,container,false)
        binding.onePlayer.setOnClickListener {

            findNavController().navigate(R.id.action_espanyolaJugador_to_memory)
        }


        return inflater.inflate(R.layout.fragment_espanyola_siete_jugador, container, false)
    }

}