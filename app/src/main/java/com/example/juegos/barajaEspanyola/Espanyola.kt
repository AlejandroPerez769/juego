package com.example.juegos.barajaEspanyola

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.juegos.R
import com.example.juegos.databinding.FragmentEspanyolaBinding

class Espanyola : Fragment() {

    private var _binding : FragmentEspanyolaBinding? = null
    private val  binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEspanyolaBinding.inflate(inflater,container,false)

        val animationDrawable = binding.games.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(2500)
        animationDrawable.start()

        binding.memory.setOnClickListener {

            findNavController().navigate(R.id.action_espanyola_to_espanyolaJugador)
        }


        return binding.root
    }


}