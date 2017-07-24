package com.example.alex.memorama.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Sqlite {
    SqliteHelper sqliteHelper;
    SQLiteDatabase database;

    public Sqlite(Context context) {
        sqliteHelper = new SqliteHelper(context);
    }

    public void abrir() {
        database = sqliteHelper.getReadableDatabase();
    }

    public void cerrar() {
        sqliteHelper.close();
    }

    /////////Escribir Cursor//////////////////////////////////////////////////7
    public List<String> escribe(Cursor cursor, int n) {
        List<String> lista = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                for (int num = 0; num < n; num++) {
                    lista.add(cursor.getString(num));
                }
            } while (cursor.moveToNext());
        }
        return lista;
    }

    /////////////////////Selects/////////////////////////////////////////////////////////
    public Cursor selectjugadores() {
        String[] select = new String[]{
                sqliteHelper.jugador_id,
                sqliteHelper.jugador_nombre,
                sqliteHelper.jugador_intentos
        };
        //Tablas,columnas,where,arqumetoswhere,groupby,having,orderby
        return database.query(sqliteHelper.jugadores, select, null, null, null, null, null);
    }

    //Inserts//////////////////////////////////////////////////////////////////////////
    public long insertajugador(Integer id, String nombre,int intentos) {
        ContentValues values = new ContentValues();
        values.put(sqliteHelper.jugador_id, id);
        values.put(sqliteHelper.jugador_nombre, nombre);
        values.put(sqliteHelper.jugador_intentos, intentos);
        return database.insert(sqliteHelper.jugadores, null, values);
    }

    ////////////////Updatesss/////////////////////////////////////////////////////////////
    public int updatejugador(Integer id, String nombre,int intentos) {
        ContentValues values = new ContentValues();
        values.put(sqliteHelper.jugador_nombre, nombre);
        values.put(sqliteHelper.jugador_intentos, intentos);
        String where = " id=?";
        String[] arg = new String[]{id.toString()};
        return database.update(sqliteHelper.jugadores, values, where, arg);
    }



    /////////////////////////////////////////////////////////////////////////////////////////////////////DELETE
    public int borrarD(Integer id, String nombre) {
        String where = " id=?";
        String[] arg = new String[]{id.toString()};
        return database.delete(sqliteHelper.jugadores, where, arg);
    }

}
