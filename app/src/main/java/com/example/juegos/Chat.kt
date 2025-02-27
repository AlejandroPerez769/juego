package com.example.juegos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.juegos.databinding.FragmentChatBinding
import com.example.juegos.databinding.FragmentHistoryBinding
import com.example.juegos.databinding.FragmentSettingsBinding


class Chat : Fragment() {

    private var _binding : FragmentChatBinding? = null
    private val  binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentChatBinding.inflate(inflater, container, false)


        binding.volver.setOnClickListener {

            findNavController().navigate(R.id.action_chat2_to_home2)
        }


        return binding.root
    }

}