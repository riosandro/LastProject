package com.riosgame.yourpetshop;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    ArrayList<Animales> animales;
    private RecyclerView ListaAnimales;
    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View v =  inflater.inflate(R.layout.fragment_home, container, false);

        ListaAnimales = (RecyclerView) v.findViewById(R.id.rvanimales);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this, 2);
        ListaAnimales.setLayoutManager(llm);
        InicializarListaAnimales();
        InicializarAdapter();
        // Inflate the layout for this fragment
        return v;
    }

    public void InicializarAdapter(){
        Animales_Adapter adaptador = new Animales_Adapter(animales,getActivity());
        ListaAnimales.setAdapter(adaptador);

    }
    public void InicializarListaAnimales(){


        animales = new ArrayList<Animales>();

        animales.add(new Animales(R.drawable.conejo,"Bunny", 5));
        animales.add(new Animales(R.drawable.perrito_blanco,"Toby", 4));
        animales.add(new Animales(R.drawable.gato_1,"Katy", 5));
        animales.add(new Animales(R.drawable.loros,"Lorenzo y Laura", 5));
        animales.add(new Animales(R.drawable.pecesito,"Susos", 5));
        animales.add(new Animales(R.drawable.perro_buldo,"Rambo",4));
        animales.add(new Animales(R.drawable.gatito_en_el_pasto,"Danna",5));
        animales.add(new Animales(R.drawable.gatos_blancos,"Dory y Dora",5));
        animales.add(new Animales(R.drawable.perro_bestido,"Pety", 3));
        animales.add(new Animales(R.drawable.perrito_y_gatito,"Godo",4));


    }

}
