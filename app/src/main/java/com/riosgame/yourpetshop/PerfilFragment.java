package com.riosgame.yourpetshop;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
    public class PerfilFragment extends Fragment {
    private ArrayList<Animales> mascotas;
    private RecyclerView rv_mascotas;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_perfil, container, false);
        rv_mascotas = (RecyclerView)v.findViewById(R.id.rv_mascotas);
      //  LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
       rv_mascotas.setLayoutManager(glm);


        setData();
       // AnimalesAdap();
        setAdapter();
        return v;
    }

    public void setAdapter() {
        PerfilAdapter mascotaAdapter = new PerfilAdapter(mascotas,getActivity());
        rv_mascotas.setAdapter(mascotaAdapter);
    }

    public void setData() {
        mascotas = new ArrayList<>();
        mascotas.add(new Animales(R.drawable.gatito_en_el_pasto, "Danna", 5));
        mascotas.add(new Animales(R.drawable.gatoperfil2, "Danna", 5));
        mascotas.add(new Animales(R.drawable.gatoperfil3, "Danna", 3));
        mascotas.add(new Animales(R.drawable.gatoperfil4, "Danna", 4));
        mascotas.add(new Animales(R.drawable.gatoperfil5, "Danna", 5));
        mascotas.add(new Animales(R.drawable.gatoperfil6, "Danna", 5));
        mascotas.add(new Animales(R.drawable.gatoperfil7, "Danna", 3));
        mascotas.add(new Animales(R.drawable.gatoperfil8, "Danna", 5));
        mascotas.add(new Animales(R.drawable.gatoperfil9, "Danna", 5));
       // mascotas.add(new Animales(R.drawable.gatito_en_el_pasto, "Danna", 5));
       // mascotas.add(new Animales(R.drawable.loros, "Lorenzo y Laura", 5));
       // mascotas.add(new Animales(R.drawable.pecesito, "Susos", 5));
       // mascotas.add(new Animales(R.drawable.gato_1, "Katy", 5));
       // mascotas.add(new Animales(R.drawable.gatito_en_el_pasto, "Danna", 5));
    }

}
