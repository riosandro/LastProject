package com.riosgame.yourpetshop;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class ListadoMascotas extends AppCompatActivity {
    private Resources resources;

    private ArrayList<Animales> mascotas;
    private RecyclerView rv_mascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_mascotas);

        Toolbar mytulbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(mytulbar);
        getSupportActionBar().setTitle(null);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        rv_mascotas = findViewById(R.id.rv_mascotas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_mascotas.setLayoutManager(layoutManager);

        setData();
        setAdapter();

    }

    public void setAdapter() {
        Animales_Adapter mascotaAdapter = new Animales_Adapter(mascotas, this);
        rv_mascotas.setAdapter(mascotaAdapter);
    }

    public void setData() {
        mascotas = new ArrayList<>();
        mascotas.add(new Animales(R.drawable.conejo, "Bunny", 5));
        mascotas.add(new Animales(R.drawable.loros, "Lorenzo y Laura", 5));
        mascotas.add(new Animales(R.drawable.pecesito, "Susos", 5));
        mascotas.add(new Animales(R.drawable.gato_1, "Katy", 5));
        mascotas.add(new Animales(R.drawable.gatito_en_el_pasto, "Danna", 5));
    }
    }

