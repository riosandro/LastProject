package com.riosgame.yourpetshop;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class Formulario extends AppCompatActivity implements View.OnClickListener{
    TextInputEditText nombrec;
    TextInputEditText telefonoc;
    TextInputEditText emailc;
    TextInputEditText mensagec;
    Button btsiguiente;
    Button borrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Toolbar mytulbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(mytulbar);
        getSupportActionBar().setTitle(null);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        btsiguiente    = (Button) findViewById(R.id.Bsiguiente);
        nombrec        = (TextInputEditText) findViewById(R.id.tie_nombres);
        telefonoc      = (TextInputEditText) findViewById(R.id.ttelefono);
        emailc         = (TextInputEditText) findViewById(R.id.email);
        mensagec        = (TextInputEditText) findViewById(R.id.detalles);
        borrar         = (Button) findViewById(R.id.Borrar);

        borrar.setOnClickListener(this);
        btsiguiente.setOnClickListener(this);
    }

  /*  private void EnviarEmail(){
        String email = emailc.getText().toString().trim();
        String nombre = nombrec.getText().toString().trim();
        String detalle = detallesc.getText().toString().trim();

        EnviarEmail em = new EnviarEmail(this, email,nombre,detalle);
        em.execute();
    }*/

  /*  @Override
    public void onClick(View v) {
        EnviarEmail();

    }*/



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Bsiguiente:
                siguienteAtivity();
                break;
            case R.id.Borrar:
                BotonBorrar();
                break;
        }
    }

    private void siguienteAtivity() {
        String email = emailc.getText().toString().trim();
        String nombre = nombrec.getText().toString().trim();
        String mensage = mensagec.getText().toString().trim();
        String telefono = telefonoc.getText().toString().trim();

        EnviarEmail em = new EnviarEmail(this, email,nombre,mensage,telefono);
        em.execute();
        // String fecha = etFecha.getText().toString();
        /*Intent x = new Intent(this, DeveloperBio.class);//esto es un ejemplo falta agregar javamail
        x.putExtra("nombreco",nombrec.getText().toString());
        x.putExtra("telefonoco",telefonoc.getText().toString());
        x.putExtra("emailco",emailc.getText().toString());
        x.putExtra("detallesco",detallesc.getText().toString());
        startActivity(x);
        // finishAffinity();*/

    }
    private void BotonBorrar() {//para mi conocimiento, si dejo las comillas con espacion al precionar el boton borrar me bora todo incluyendo el hint text.
        nombrec.setText("");
        telefonoc.setText("");
        emailc.setText("");
        mensagec.setText("");
    }


    }

