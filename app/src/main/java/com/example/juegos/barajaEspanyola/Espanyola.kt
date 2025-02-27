package com.example.juegos.barajaEspanyola

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.juegos.R
import com.example.juegos.databinding.FragmentEspanyolaBinding
import com.example.juegos.model.SharedViewModel
import com.example.juegos.pref.Prefs

class Espanyola : Fragment() {

    private var _binding : FragmentEspanyolaBinding? = null
    private val  binding get() = _binding!!
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var prefs: Prefs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEspanyolaBinding.inflate(inflater,container,false)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        binding.memory.setOnClickListener {

            findNavController().navigate(R.id.action_espanyola_to_espanyolaJugador)
        }
        binding.sietemedio.setOnClickListener {

            findNavController().navigate(R.id.action_espanyola_to_espanyolaSieteJugador)
        }


        return binding.root
    }


}