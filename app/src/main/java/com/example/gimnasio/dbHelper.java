package com.example.gimnasio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {
    String table_registro = "CREATE TABLE tbl_registro (TextUsuario TEXT,TextNombre TEXT, TextApellido Text, dtFechaNacimiento DATETIME, intGenero INTEGER, dtFechaIngreso DATETIME)";
    public dbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table_registro);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
