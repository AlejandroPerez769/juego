package com.example.juegos.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.juegos.R
import com.example.juegos.databinding.FragmentLoginBinding
import com.example.juegos.databinding.FragmentRegisterBinding

class Register : Fragment() {

    private var _binding : FragmentRegisterBinding? = null
    private val  binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRegisterBinding.inflate(inflater,container,false)


        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_register2_to_login)
        }

        binding.loginRedirect.setOnClickListener {
            findNavController().navigate(R.id.action_register2_to_login)
        }


        return binding.root
    }

}