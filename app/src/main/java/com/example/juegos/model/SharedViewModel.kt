package com.example.juegos.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _selectedBackground = MutableLiveData<Int>()

    val selectedBackground: LiveData<Int> get() = _selectedBackground

    fun selectBackground(background: Int) {
        _selectedBackground.value = background
    }
}
