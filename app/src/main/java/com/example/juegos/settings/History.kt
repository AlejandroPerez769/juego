package com.example.juegos.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.juegos.R
import com.example.juegos.databinding.FragmentHistoryBinding
import com.example.juegos.databinding.FragmentLoginBinding
import com.example.juegos.databinding.FragmentRegisterBinding

class History : Fragment() {

    private var _binding : FragmentHistoryBinding? = null
    private val  binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHistoryBinding.inflate(inflater,container,false)

        binding.volver.setOnClickListener {

            findNavController().navigate(R.id.action_history_to_settings)

        }


        return binding.root
    }

}