package com.example.zodiac

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder


// la clase HoroscopeAdapter extiende de ADAPTER, es un adaptador que se encargará de manejar una lista de elementos de tipo HOROSCOPE
//  y de crear y enlazar vistas para cada uno de esos elementos.

class HoroscopeAdapter(
    val items: List<Horoscope>,

   //metodo ONCLICK ->  Toma un int correspondiente al valor de cada elemento en la lista
   // UNIT -> Esta funcion se llamará cuando un elemento de la lista sea clicado.

    val onClick : (Int) -> Unit) : Adapter<HoroscopeViewHolder>() {


    //ON BIND VIEW HOLDER llama para mostrar los datos en una posición especifica.
    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {     //aqui se obtiene el HOROSCOPE correspondiente y se llama
                                                                                    //al metodo render del holder para mostrar los datos en la vista
        val horoscope: Horoscope = items[position]                                  //
        holder.render(horoscope)

        holder.itemView.setOnClickListener{                                        // Esta es una expresión lambda que se ejecuta cuando se hace clic en el itemView.
            onClick(position)                                                      //Dentro de la lambda, se llama a la función onClick(position),
                                                                                    //pasando como argumento la variable position,
                                                                                    //que generalmente es la posición del elemento en la lista.
        }
    }


    //este metodo se llama cuando se necesita crear un nuevo ViewHolder, aqui se infla el Layout(item horoscope) y se crea una instancia de
    // horoscopeViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        return HoroscopeViewHolder(view)
    }

        //retorna el numero de elementos de la lista, permite saber al RecyclerView cuantos elementos hay.
    override fun getItemCount(): Int {
        return items.size
    }
}

class HoroscopeViewHolder(view: View) : ViewHolder(view) {

    val iconImageView: ImageView = view.findViewById(R.id.iconImageView)
    val nameTextView: TextView = view.findViewById(R.id.nameTextView)
    val dateTextView: TextView = view.findViewById(R.id.dateTextView)

    fun render(horoscope: Horoscope) {
        iconImageView.setImageResource(horoscope.icon)
        nameTextView.setText(horoscope.name)
        dateTextView.setText(horoscope.dates)
    }
}



