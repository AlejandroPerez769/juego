package com.example.juegos

import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.juegos.databinding.FragmentHomeBinding
import com.example.juegos.model.SharedViewModel
import com.example.juegos.pref.Prefs

class Home : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var prefs: Prefs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        prefs = Prefs(requireContext())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //animacion()
        navegacion()

        binding.boton3.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
                mediaPlayer.release()

            }
            activity?.finishAndRemoveTask()
        }

        sharedViewModel.selectedBackground.observe(viewLifecycleOwner) { backgroundResId ->
            view.setBackgroundResource(backgroundResId)
            prefs.saveBackground(backgroundResId)
        }

        imagenFondo()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

        if (this::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }

    /*fun animacion() {
        val animationDrawable = binding.home.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(2500)
        animationDrawable.start()
    } */

    fun imagenFondo() {

        val savedBackground = prefs.getBackground()
        if (savedBackground != 0) {
            view?.setBackgroundResource(savedBackground)
        }
    }

    fun navegacion() {

        binding.boton1.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_games)
        }

        binding.boton2.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_settings)
        }

        binding.boton22.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_login)
        }

        binding.boton23.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_chat2)
        }
    }
}
