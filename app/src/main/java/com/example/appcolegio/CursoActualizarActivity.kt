package com.example.appcolegio

import android.content.DialogInterface
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

class CursoActualizarActivity : AppCompatActivity() {

    private lateinit var txtCodigo:TextInputEditText
    private lateinit var txtNomCurso: TextInputEditText
    private lateinit var txtCredito: TextInputEditText
    private lateinit var txtHoras: TextInputEditText
    private lateinit var spnCarrera: AutoCompleteTextView
    private lateinit var btnGrabar: Button
    private lateinit var btnVolver: Button
    private lateinit var btnEliminar:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.curso_actualizar_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtCodigo=findViewById(R.id.txtCodigo)
        txtNomCurso=findViewById(R.id.txtNomCursoActualizar)
        txtCredito=findViewById(R.id.txtCreditoActualizar)
        txtHoras=findViewById(R.id.txtHorasActualizar)
        spnCarrera=findViewById(R.id.spnCarrerasActualizar)
        btnGrabar=findViewById(R.id.btnActualizar)
        btnVolver=findViewById(R.id.btnVolver)
        btnEliminar=findViewById(R.id.btnEliminar)

        btnGrabar.setOnClickListener { grabar() }
        btnVolver.setOnClickListener { volver() }
        btnEliminar.setOnClickListener { eliminar() }

        mostrarDatos()
    }

    fun grabar(){
        //Leer controles
        var cod=txtCodigo.text.toString().toInt()
        var nomCurso=txtNomCurso.text.toString()
        var credito=txtCredito.text.toString().toDouble()
        var horas=txtHoras.text.toString().toInt()
        var carrera=spnCarrera.text.toString()
        //Crear objeto de la clase docente
        var bean= Curso(cod,nomCurso,credito,horas,carrera,"")
        //Invocar al metodo save
        var salida= CursoController().update(bean)
        //Validar salida
        if(salida>0)
            showAlert("Curso Actualizado")
        else
            showAlert("Error en la Actualizacion")
    }

    fun eliminar(){
        //var intent=Intent(this,ListaDocenteActivity::class.java)
        //startActivity(intent)
        var cod=txtCodigo.text.toString().toInt()
        showAlertEliminar("Seguro de Eliminar Curso con ID:  "+cod,cod)
    }

    fun showAlert(men:String){
        val builder= AlertDialog.Builder(this)
        builder.setTitle("Notificacion")
        builder.setMessage(men)
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
    }



    fun mostrarDatos(){
        //Recuperar claves

        var info=intent.extras!!
        //Invocar funcion findById
        var bean=CursoController().findById(info.getInt("codigo"))
        //mostrar en los atributos el contenido de Info
        txtCodigo.setText(bean.codigo.toString())
        txtNomCurso.setText(bean.nombreCurso)
        txtCredito.setText(bean.credito.toString())
        txtHoras.setText(bean.horas.toString())
        spnCarrera.setText(bean.carrera,false)

    }

    fun showAlertEliminar(men:String,cod:Int){
        val builder=AlertDialog.Builder(this)
        builder.setTitle("Notificacion")
        builder.setMessage(men)
        builder.setPositiveButton("Aceptar", DialogInterface.OnClickListener{
                dialog: DialogInterface?, which: Int ->
            //Invocar al metodo delete
            var salida=CursoController().delete(cod)
            if(salida>0)
                showAlert("Curso Eliminado")
            else {
                showAlert("Error en la eliminacion")
            }

        })
        builder.setNegativeButton("Cancelar",null)
        val dialog:AlertDialog=builder.create()
        dialog.show()
    }




    fun volver(){
        var intent= Intent(this,ListaCursoActivity::class.java)
        startActivity(intent)

    }


}