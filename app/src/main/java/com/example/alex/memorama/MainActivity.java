package com.example.alex.memorama;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnimg[];
    int indices[];
    LinearLayout linear[];
    int[] IMG;
    int tvolteadas=0;
    int volteadas[];
    int pares=0;
    Bundle bundle;
    int intentos=0;
    LinkedList list;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IMG=new int[10];
        indices=new int[6];
        btnimg=new ImageButton[6];
        linear=new LinearLayout[6];
        volteadas=new int[2];
        list=new LinkedList();
        bundle=getIntent().getExtras();
        IMG[0] = R.drawable.carta0;
        IMG[1] = R.drawable.carta1;
        IMG[2] = R.drawable.carta2;
        IMG[3] = R.drawable.carta3;
        btnimg[0] = (ImageButton)findViewById(R.id.imgbtn1);
        btnimg[1] = (ImageButton)findViewById(R.id.imgbtn2);
        btnimg[2] = (ImageButton)findViewById(R.id.imgbtn3);
        btnimg[3] = (ImageButton)findViewById(R.id.imgbtn4);
        btnimg[4] = (ImageButton)findViewById(R.id.imgbtn5);
        btnimg[5] = (ImageButton)findViewById(R.id.imgbtn6);
        linear[0]=(LinearLayout)findViewById(R.id.l1);
        linear[1]=(LinearLayout)findViewById(R.id.l2);
        linear[2]=(LinearLayout)findViewById(R.id.l3);
        linear[3]=(LinearLayout)findViewById(R.id.l4);
        linear[4]=(LinearLayout)findViewById(R.id.l5);
        linear[5]=(LinearLayout)findViewById(R.id.l6);
        aleatorio();
        for (int i=0;i<6;i++) {
            btnimg[i].setImageResource(IMG[indices[i]]);
            btnimg[i].setVisibility(View.INVISIBLE);
            btnimg[i].setOnClickListener(this);
            linear[i].setOnClickListener(this);
        }
    }

    public void aleatorio() {
        int n = 3;  //numeros aleatorios
        int k = n;  //auxiliar;
        int[] numeros = new int[n];
        int[] resultado = new int[n];
        Random rnd = new Random();
        int res;
        for (int i = 0; i < n; i++) {
            numeros[i] = i + 1;
        }

        for (int i = 0; i < n; i++) {
            res = rnd.nextInt(k);
            resultado[i] = numeros[res];
            numeros[res] = numeros[k - 1];
            k--;

        }

        for(int i=0;i<n;i++){
            indices[i]=resultado[i];
        }
        for (int i = 0; i < n; i++) {
            numeros[i] = i + 1;
        }
        k=n;
        for (int i = 0; i < n; i++) {
            res = rnd.nextInt(k);
            resultado[i] = numeros[res];
            numeros[res] = numeros[k - 1];
            k--;

        }
        for(int i=0;i<n;i++){
            indices[i+3]=resultado[i];
        }
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.l1:
                if(tvolteadas==2){
                    if (indices[volteadas[0]]==indices[volteadas[1]]){
                        pares++;
                        list.push("Acertó");
                    }
                    else {
                        btnimg[volteadas[0]].setVisibility(View.INVISIBLE);
                        btnimg[volteadas[1]].setVisibility(View.INVISIBLE);
                        list.push("Falló");
                    }
                    intentos++;
                    tvolteadas = 0;
                }
                if(btnimg[0].getVisibility()!=View.VISIBLE ){
                    btnimg[0].setVisibility(View.VISIBLE);
                    volteadas[tvolteadas]=0;
                    tvolteadas++;
                }


                break;
            case R.id.l2:
                if(tvolteadas==2){
                    if (indices[volteadas[0]]==indices[volteadas[1]]){
                        pares++;
                        list.push("Acertó");
                    }
                    else {
                        btnimg[volteadas[0]].setVisibility(View.INVISIBLE);
                        btnimg[volteadas[1]].setVisibility(View.INVISIBLE);
                        list.push("Falló");
                    }
                    intentos++;
                    tvolteadas = 0;
                }
                if(btnimg[1].getVisibility()!=View.VISIBLE ){
                    btnimg[1].setVisibility(View.VISIBLE);
                    volteadas[tvolteadas]=1;
                    tvolteadas++;
                }
                break;
            case R.id.l3:
                if(tvolteadas==2){
                    if (indices[volteadas[0]]==indices[volteadas[1]]){
                        pares++;
                        list.push("Acertó");
                    }
                    else {
                        btnimg[volteadas[0]].setVisibility(View.INVISIBLE);
                        btnimg[volteadas[1]].setVisibility(View.INVISIBLE);
                        list.push("Falló");
                    }
                    intentos++;
                    tvolteadas = 0;
                }
                if(btnimg[2].getVisibility()!=View.VISIBLE){
                    btnimg[2].setVisibility(View.VISIBLE);
                    volteadas[tvolteadas]=2;
                    tvolteadas++;
                }

                break;
            case R.id.l4:
                if(tvolteadas==2){
                    if (indices[volteadas[0]]==indices[volteadas[1]]){
                        pares++;
                        list.push("Acertó");
                    }
                    else {
                        btnimg[volteadas[0]].setVisibility(View.INVISIBLE);
                        btnimg[volteadas[1]].setVisibility(View.INVISIBLE);
                        list.push("Falló");
                    }
                    intentos++;
                    tvolteadas = 0;
                }
                if(btnimg[3].getVisibility()!=View.VISIBLE ){
                    btnimg[3].setVisibility(View.VISIBLE);
                    volteadas[tvolteadas]=3;
                    tvolteadas++;
                }
                break;
            case R.id.l5:
                if(tvolteadas==2){
                    if (indices[volteadas[0]]==indices[volteadas[1]]){
                        pares++;
                        list.push("Acertó");
                    }
                    else {
                        btnimg[volteadas[0]].setVisibility(View.INVISIBLE);
                        btnimg[volteadas[1]].setVisibility(View.INVISIBLE);
                        list.push("Falló");
                    }
                    intentos++;
                    tvolteadas = 0;
                }
                if(btnimg[4].getVisibility()!=View.VISIBLE ) {
                    btnimg[4].setVisibility(View.VISIBLE);
                    volteadas[tvolteadas] = 4;
                    tvolteadas++;
                }
                break;
            case R.id.l6:
                if(tvolteadas==2){
                    if (indices[volteadas[0]]==indices[volteadas[1]]){
                        pares++;
                        list.push("Acertó");
                    }
                    else {
                        btnimg[volteadas[0]].setVisibility(View.INVISIBLE);
                        btnimg[volteadas[1]].setVisibility(View.INVISIBLE);
                        list.push("Falló");
                    }
                    intentos++;
                    tvolteadas = 0;
                }
                if(btnimg[5].getVisibility()!=View.VISIBLE ){
                    btnimg[5].setVisibility(View.VISIBLE);
                    volteadas[tvolteadas]=5;
                    tvolteadas++;
                }
                break;
        }
        boolean siguiente=true;
        for(int i=0;i<btnimg.length;i++){
            if (btnimg[i].getVisibility()==View.INVISIBLE){
                siguiente=false;
                break;
            }
        }
        if (siguiente){
            list.push("Acertó");
            String estados[]=new String[list.size()];
            for (int i=0;i<list.size();i++){
                estados[i]=list.get(i).toString();
            }
            Intent i=new Intent(this,Puntuaje.class);
            i.putExtra("estados",estados);
            i.putExtra("nombre",bundle.get("nombre").toString());
            startActivity(i);
            finish();
        }
    }
}
