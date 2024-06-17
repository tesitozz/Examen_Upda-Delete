package com.example.appcolegio.adaptador

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.appcolegio.CursoActualizarActivity
import com.example.appcolegio.R
import com.example.appcolegio.entidad.Curso
import com.example.appcolegio.utils.appConfig

class CursoAdapter(var lista:ArrayList<Curso>):RecyclerView.Adapter<ViewCurso>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewCurso {
        var info = LayoutInflater.from(parent.context).inflate(R.layout.item_curso,parent,false)
        return ViewCurso(info)
    }

    override fun getItemCount(): Int {
        //Retornar la cantidad de objetos que existan el arreglo "lista"
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewCurso, position: Int) {

        //Mostrar los valores
        holder.tvCodigo.setText(lista.get(position).codigo.toString())
        holder.tvNombreCurso.setText(lista.get(position).nombreCurso)
        //Asignar evento click al parametro holder
        holder.itemView.setOnClickListener {
            var intent=Intent(appConfig.CONTEXTO,CursoActualizarActivity::class.java)
            //Adicionar clave
            intent.putExtra("codigo",lista.get(position).codigo)
            intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            ContextCompat.startActivity(appConfig.CONTEXTO,intent,null)

        }

    }


}