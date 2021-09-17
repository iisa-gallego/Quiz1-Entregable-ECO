package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class EncuestaNE extends AppCompatActivity implements View.OnClickListener {

    private CheckBox nE1, nE2, nE3, nE4, nE5;
    private Button contiBtn;
    int puntos;
    String name, ident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta_n_e);

        //Las ref de todos
        nE1 = findViewById(R.id.nE1);
        nE2 = findViewById(R.id.nE2);
        nE3 = findViewById(R.id.nE3);
        nE4 = findViewById(R.id.nE4);
        nE5 = findViewById(R.id.nE5);
        contiBtn = findViewById(R.id.contiBtn);

        //Botón
        contiBtn.setOnClickListener(this);
        //Checkbox
        nE1.setOnClickListener(this);
        nE2.setOnClickListener(this);
        nE3.setOnClickListener(this);
        nE4.setOnClickListener(this);
        nE5.setOnClickListener(this);
        //Lo que vale el puntaje en este punto
        puntos = 0;


        name = getIntent().getExtras().getString("name");
        ident = getIntent().getExtras().getString("ident");

        //Este es para que esté invisible cuando apenas entra la persona a esa pantalla
        if (nE1.isChecked() == false && nE2.isChecked() == false && nE3.isChecked() == false && nE4.isChecked() == false && nE5.isChecked() == false) {
            contiBtn.setVisibility(View.INVISIBLE);
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.contiBtn:

                Intent n = new Intent(this, EncuestaSint.class);
                n.putExtra("name",name);
                n.putExtra("ident",ident);
                n.putExtra("puntos", puntos);
                startActivity(n);
                finish();
                break;

            case R.id.nE1:
                nE1.isChecked();

                //los puntos que vale cada opción, si no lo presiona se quitan los puntos
                if(nE1.isChecked()){
                    puntos+=3;
                }else{
                    puntos-=3;
                }
                //Se pone a -ninguna de las anteriores- inhabilitada
                nE5.setChecked(false);
                break;

            case R.id.nE2:
                nE2.isChecked();
                if (nE2.isChecked()) {
                    puntos += 3; //Es igual a decir pnt = pnt+3
                }else{
                    puntos+=3;
                }
                nE5.setChecked(false);
                break;

            case R.id.nE3:
                nE3.isChecked();
                if (nE3.isChecked()) {
                    puntos += 3;
                }else{
                    puntos+=3;
                }
                nE5.setChecked(false);
                break;

            case R.id.nE4:
                nE4.isChecked();
                if (nE4.isChecked()) {
                    puntos += 3;
                }else{
                    puntos+=3;
                }
                nE5.setChecked(false);
                break;
             //Este es 0 porque es Ninguno de los anteriores
            case R.id.nE5:
                nE5.isChecked();
                if (nE5.isChecked()) {
                    puntos = 0;
                }
                nE1.setChecked(false);
                nE2.setChecked(false);
                nE3.setChecked(false);
                nE4.setChecked(false);
                break;

        }
        //Para que aparezca si presionaron una opción
        if (nE1.isChecked() || nE2.isChecked() || nE3.isChecked() || nE4.isChecked() || nE5.isChecked()) {
            contiBtn.setVisibility(View.VISIBLE);
        } else {
            contiBtn.setVisibility(View.INVISIBLE);
        }
    }
}