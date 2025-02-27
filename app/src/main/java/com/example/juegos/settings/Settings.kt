package com.example.juegos.settings

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.fragment.findNavController
import com.example.juegos.MainActivity
import com.example.juegos.R
import com.example.juegos.databinding.FragmentSettingsBinding
import com.example.juegos.pref.Prefs

class Settings : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var prefs: Prefs
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el layout usando el ViewBinding
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        prefs = Prefs(requireContext())




        binding.encApa.setOnClickListener {
            if (binding.encApa.text == "Encendido") {
                binding.encApa.text = "Apagado"
                (activity as MainActivity).stopMusic()

            } else {
                binding.encApa.text = "Encendido"
                startMusic()
            }

            prefs.saveSongOnOf(binding.encApa.text.toString())
            binding.encApa.text = prefs.getSongOnOf()

        }

      navegacion()



        return binding.root
    }

    fun startMusic() {

        val music = prefs.getSong()
        mediaPlayer = MediaPlayer.create(requireContext(), music)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

    }

    override fun onDestroyView() {
        super.onDestroyView()

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

        binding.historial.setOnClickListener {
            findNavController().navigate(R.id.action_settings_to_history)
        }

    }
}
