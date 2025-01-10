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
import com.example.juegos.databinding.FragmentEspanyolaJugadorBinding
import com.example.juegos.model.SharedViewModel
import com.example.juegos.pref.Prefs


class EspanyolaMemoryJugador : Fragment() {

    private var _binding : FragmentEspanyolaJugadorBinding? = null
    private val  binding get() = _binding!!
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var prefs: Prefs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEspanyolaJugadorBinding.inflate(inflater,container,false)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)


        binding.onePlayer.setOnClickListener {

            findNavController().navigate(R.id.action_espanyolaJugador_to_memory)
        }
        binding.twoPlayer.setOnClickListener {

            findNavController().navigate(R.id.action_espanyolaJugador_to_memory2Players)
        }


        return binding.root
    }


}