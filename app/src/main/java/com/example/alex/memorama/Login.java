package com.example.alex.memorama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener{
    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button=(Button)findViewById(R.id.aceptar);
        button.setOnClickListener(this);
        editText=(EditText)findViewById(R.id.nom);
    }

    @Override
    public void onClick(View view) {
        if(editText.getText().toString().isEmpty()){
            Toast.makeText(this,"Introduce un nombre para continuar",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i=new Intent(this,MainActivity.class);
            i.putExtra("nombre",editText.getText().toString());
            startActivity(i);
            finish();
        }
    }
}
