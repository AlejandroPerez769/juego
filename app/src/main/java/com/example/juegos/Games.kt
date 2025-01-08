package com.example.juegos

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.juegos.databinding.FragmentGamesBinding
import com.example.juegos.model.SharedViewModel
import com.example.juegos.pref.Prefs


class Games : Fragment() {

    private var _binding : FragmentGamesBinding? = null
    private val  binding get() = _binding!!
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var prefs: Prefs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentGamesBinding.inflate(inflater,container,false)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        prefs = Prefs(requireContext())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.selectedBackground.observe(viewLifecycleOwner) { backgroundResId ->
            view?.setBackgroundResource(backgroundResId)
            prefs.saveBackground(backgroundResId)
        }

        /*animacion()*/
        imagenFondo()
        navegacion()
    }





    fun imagenFondo() {

        val savedBackground = prefs.getBackground()
        if (savedBackground != 0) {
            view?.setBackgroundResource(savedBackground)
        }
    }

    fun navegacion() {

        binding.espanyol.setOnClickListener {

            findNavController().navigate(R.id.action_games_to_espanyola)
        }

        binding.volver.setOnClickListener {
            findNavController().navigate(R.id.action_games_to_home2)
        }

    }
}