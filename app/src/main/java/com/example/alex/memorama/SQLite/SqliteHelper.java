package com.example.alex.memorama.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SqliteHelper extends SQLiteOpenHelper {
    private static final String _database_ = "bd";
    private static final int _version_ = 1   ;

    public SqliteHelper(Context context) {
        super(context, _database_, null, _version_);
    }

    public String jugador_id = "id";
    public String jugadores = "jugadores";
    public String jugador_nombre = "nombre";
    public String jugador_intentos="intentos";
    private String sql = "CREATE TABLE IF NOT EXISTS " + jugadores + "(" + jugador_id + " INTEGER PRIMARY KEY , " + jugador_nombre + " TEXT,"
            +jugador_intentos+" INTEGER )";



    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("base de datos", _database_ + "creada con exito");
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            ;
            db.execSQL("DROP TABLE IF EXISTS " + jugadores);
            db.execSQL(sql);
        }
    }
}
