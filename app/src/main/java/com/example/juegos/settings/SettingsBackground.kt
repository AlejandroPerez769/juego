package com.example.juegos.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.juegos.R
import com.example.juegos.databinding.FragmentSettingsBackgroundBinding
import com.example.juegos.model.SharedViewModel


class SettingsBackground : Fragment() {

    private var _binding : FragmentSettingsBackgroundBinding? = null
    private val  binding get() = _binding!!
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBackgroundBinding.inflate(inflater,container,false)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)


        navegacion()
        adapter()


        return binding.root
    }

    fun navegacion() {

        binding.salir.setOnClickListener {

            findNavController().navigate(R.id.action_settingsBackground2_to_settings)
        }

    }
    fun adapter() {

        val imageList = listOf(
            R.drawable.gradient_list,
            R.drawable.nieve,
            R.drawable.nieve_noche,
            R.drawable.idol
        )
        val textList = listOf("Vida Nocturna", "Nieve nocturna","Vida nocturna nevada","Idol")

        val adapter = BackgroundSettingsAdapter(imageList,textList) { selectedImage ->

            sharedViewModel.selectBackground(selectedImage)

        }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

    }






}