package com.example.appcolegio.data

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.appcolegio.utils.appConfig

class InitBD:SQLiteOpenHelper(appConfig.CONTEXTO,
                               appConfig.nombreBD,null,
                                appConfig.VERSION){


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table tb_curso(" +
                "cod integer primary key autoincrement," +
                "nomCurso varchar(40)," +
                "credito double," +
                "horas int," +
                "carrera varchar(30)," +
                "foto varchar(15))")

        //Registro
        db.execSQL("insert into tb_curso values(null,'Historia',140.0,12,'ingenieria','d05')")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


}