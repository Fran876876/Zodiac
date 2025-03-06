package com.example.zodiac

import android.R
import android.content.Context

//sesion para guardar tus datos
class SessionManager(context: Context) {

    //Se crea una instancia de SharedPreferences llamada sharedPref
    private val sharedPref = context.getSharedPreferences("zodiac_session", Context.MODE_PRIVATE)




    fun setFavorite(id: String) {

        //Se obtiene un Editor de SharedPreferences (usando sharedPref.edit()),
        // que permite editar los datos.
        val editor = sharedPref.edit()
        editor.putString("FAVORITE_HOROSCOPE", id)
        editor.apply()
    }

    fun getFavorite(): String {
        return sharedPref.getString("FAVORITE_HOROSCOPE", "")!!
    }

    fun isFavorite(id: String): Boolean {
        return id == getFavorite()
    }
}