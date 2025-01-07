package com.example.juegos.pref

import android.content.Context

class Prefs(val context: Context) {

    val SHARED_NAME = "Background"

    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveBackground(img:Int) {

        storage.edit().putInt("Background",img).apply()
    }

    fun getBackground() : Int {
        return storage.getInt("Background",0)!!

    }

}