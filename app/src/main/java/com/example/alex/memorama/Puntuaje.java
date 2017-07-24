package com.example.alex.memorama;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.alex.memorama.SQLite.Sqlite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Puntuaje extends AppCompatActivity {
    Bundle bundle;
    String estados[];
    String nombre="";
    TextView textView,textView2;
    String text="";
    Sqlite sqlite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaje);
        bundle=getIntent().getExtras();
        estados=bundle.getStringArray("estados");
        nombre=bundle.get("nombre").toString();
        textView=(TextView)findViewById(R.id.est);
        textView2=(TextView)findViewById(R.id.jugadores);
        for (int i=0;i<estados.length;i++){
            text+="Intento "+(i+1)+": "+estados[i]+"\n";
        }
        textView.setText(text);
        sqlite=new Sqlite(this);
        sqlite.abrir();
        Random random=new Random();
        sqlite.insertajugador(random.nextInt(),nombre,(estados.length+1));
        Cursor c=sqlite.selectjugadores();
        List list=sqlite.escribe(c,3);
        text="";
        int i=0;
        while (i<list.size()){
            text+=list.get(i+1)+"   "+list.get(i+2)+" intentos\n";
            i+=3;
        }
        textView2.setText(text);
    }
}
