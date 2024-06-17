package com.example.appcolegio.utils

import android.app.Application
import android.content.Context
import android.os.Build.VERSION
import com.example.appcolegio.data.InitBD

class appConfig:Application() {

    //Declaramos atributos globales
    //Declarar e inicializar atributos de tipo Primitivo
    companion object{
        lateinit var CONTEXTO:Context
        lateinit var BD:InitBD
        var nombreBD="cole.bd"
        var VERSION=1
    }

    //Instanciar
    override fun onCreate() {
        super.onCreate()
        CONTEXTO=applicationContext
        BD=InitBD()

    }
}