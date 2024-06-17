package com.example.appcolegio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcolegio.adaptador.CursoAdapter
import com.example.appcolegio.controller.CursoController

class ListaCursoActivity:AppCompatActivity() {

    private  lateinit var rvCursos:RecyclerView
    private lateinit var btnNuevoCurso:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.lista_colegio_activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        rvCursos=findViewById(R.id.rvCursos)
        btnNuevoCurso=findViewById(R.id.btnNuevoCurso)
        btnNuevoCurso.setOnClickListener { nuevo()  }

        //Obtener la lsita de los docentes
        var info=CursoController().findAll()
        //Crear el adaptador
        var adaptador=CursoAdapter(info)
        //enviar el objeto "adaptador" al atributo rvCursos
        rvCursos.adapter=adaptador
        //mostrar los cursos en forma lineal
        rvCursos.layoutManager=LinearLayoutManager(this)

    }

    fun nuevo(){

        var intent=Intent(this,CursoActivity::class.java)
        startActivity(intent)



    }

}


