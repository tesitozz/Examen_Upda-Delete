package com.example.appcolegio

import android.content.Intent
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appcolegio.controller.CursoController
import com.example.appcolegio.entidad.Curso
import com.google.android.material.textfield.TextInputEditText

class CursoActivity:AppCompatActivity() {

    private lateinit var txtNomCurso:TextInputEditText
    private lateinit var txtCredito:TextInputEditText
    private lateinit var txtHoras:TextInputEditText
    private lateinit var spnCarrera:AutoCompleteTextView
    private lateinit var btnGrabar:Button
    private lateinit var btnVolver:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.curso_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtNomCurso=findViewById(R.id.txtNomCurso)
        txtCredito=findViewById(R.id.txtCredito)
        txtHoras=findViewById(R.id.txtHoras)
        spnCarrera=findViewById(R.id.spnCarreras)
        btnGrabar=findViewById(R.id.btnGrabarCurso)
        btnVolver=findViewById(R.id.btnRegresar)

        btnGrabar.setOnClickListener { grabar() }
        btnVolver.setOnClickListener { volver() }
    }

    fun grabar(){
        //Leer controles
        var nomCurso=txtNomCurso.text.toString()
        var credito=txtCredito.text.toString().toDouble()
        var horas=txtHoras.text.toString().toInt()
        var carrera=spnCarrera.text.toString()
        //Crear objeto de la clase docente
        var bean=Curso(0,nomCurso,credito,horas,carrera,"")
        //Invocar al metodo save
        var salida=CursoController().save(bean)
        //Validar salida
        if(salida>0)
            showAlert("Curso Registrado")
        else
            showAlert("Error en el registro")
    }

    fun showAlert(men:String){
        val builder= AlertDialog.Builder(this)
        builder.setTitle("Notificacion")
        builder.setMessage(men)
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
    }

    fun volver(){
        var intent= Intent(this,ListaCursoActivity::class.java)
        startActivity(intent)

    }


}