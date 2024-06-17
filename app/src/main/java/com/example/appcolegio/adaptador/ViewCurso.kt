package com.example.appcolegio.adaptador

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appcolegio.R

class ViewCurso(vista:View):RecyclerView.ViewHolder(vista){

    var imgFoto:ImageView
    var tvCodigo:TextView
    var tvNombreCurso:TextView

    //Bloque Init

    init {
        imgFoto = vista.findViewById(R.id.imgFotoDocente)
        tvCodigo = vista.findViewById(R.id.tvCodigo)
        tvNombreCurso = vista.findViewById(R.id.tvNombreCurso)
    }




}