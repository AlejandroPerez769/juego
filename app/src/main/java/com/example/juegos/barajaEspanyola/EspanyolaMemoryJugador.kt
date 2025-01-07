package com.example.juegos.barajaEspanyola

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.juegos.R
import com.example.juegos.databinding.FragmentEspanyolaJugadorBinding


class EspanyolaMemoryJugador : Fragment() {

    private var _binding : FragmentEspanyolaJugadorBinding? = null
    private val  binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEspanyolaJugadorBinding.inflate(inflater,container,false)

        val animationDrawable = binding.games.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(2500)
        animationDrawable.start()

        binding.onePlayer.setOnClickListener {

            findNavController().navigate(R.id.action_espanyolaJugador_to_memory)
        }


        return binding.root
    }


}