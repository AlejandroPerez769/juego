package com.example.juegos.pref

import android.content.Context

class Prefs(val context: Context) {

    private val SHARED_NAME = "Background"
    private val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveSongOnOf(cad: String) {
        storage.edit().putString("Songs", cad).apply()
    }

    fun saveBackground(img: Int) {
        storage.edit().putInt("Background", img).apply()
    }

    fun saveSong(songResId: Int) {
        storage.edit().putInt("Song", songResId).apply()
    }

    fun getSongOnOf(): String? {
        return storage.getString("Songs","")
    }

    fun getBackground(): Int {
        return storage.getInt("Background", 0)
    }

    fun getSong(): Int {
        return storage.getInt("Song", 0)
    }

    fun clearPreferences() {
        storage.edit().clear().apply()
    }
}
