package com.example.juegos

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.juegos.databinding.ActivityMainBinding
import com.example.juegos.model.SharedViewModel
import com.example.juegos.pref.Prefs

class MainActivity : AppCompatActivity() {

    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var prefs: Prefs
    private lateinit var binding: ActivityMainBinding
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sharedViewModel = ViewModelProvider(this).get(SharedViewModel::class.java)
        prefs = Prefs(this)


        mediaPlayer = MediaPlayer.create(this, R.raw.navidad)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        observarFondo()

        supportFragmentManager.beginTransaction()
            .replace(R.id.home, Home())
            .commit()

        val saveSong = prefs.getSong()

        if (saveSong != 0) {
            playMusic(saveSong)
        }
        else {
            playMusic(R.raw.navidad)
        }

    }

    private fun playMusic(songResId: Int) {
        if (mediaPlayer != null) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
        }

        val resourceToPlay = if (songResId == 0) R.raw.navidad else songResId

        mediaPlayer = MediaPlayer.create(this, resourceToPlay)
        mediaPlayer!!.isLooping = true
        mediaPlayer!!.start()
    }



    private fun observarFondo() {
        sharedViewModel.selectedBackground.observe(this) { backgroundResId ->
            binding.root.setBackgroundResource(backgroundResId)
            prefs.saveBackground(backgroundResId)
        }

        val savedBackground = prefs.getBackground()
        if (savedBackground != 0) {
            binding.root.setBackgroundResource(savedBackground)
        } else {
            binding.root.setBackgroundResource(R.drawable.gradient_list)
        }
    }

    fun changeMusic(songResId: Int) {
        prefs.saveSong(songResId)
        playMusic(songResId)
    }


}
