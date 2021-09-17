package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    private EditText nombre, id;
    private Button regBtn;
     String name, ident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        regBtn = findViewById(R.id.regBtn);
        nombre = findViewById(R.id.nombre);
        id = findViewById(R.id.id);

        regBtn.setOnClickListener(this);

    }

    public void onClick(View view) {

        //los toma y los vuelve String
        name = nombre.getText().toString();
        ident = id.getText().toString();


        Intent r = new Intent(this, EncuestaNE.class);
        r.putExtra("name", name);
        r.putExtra("ident", ident);
        startActivity(r);
        finish();

        }


    }


