package com.riosgame.yourpetshop;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Jose on 3/18/2018.
 */

public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.AnimalesViewHolder>{
    ArrayList<Animales> animales;
    Activity activity;
    public PerfilAdapter(ArrayList<Animales> animales, Activity activity){
        this.animales=animales;
        this.activity = activity;
    }

    @Override
    public PerfilAdapter.AnimalesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carviewperfil,parent,false);
        return new PerfilAdapter.AnimalesViewHolder(v);
    }


    @Override
    public void onBindViewHolder(PerfilAdapter.AnimalesViewHolder animalesViewholder, int position) {
        final Animales animal = animales.get(position);
        animalesViewholder.imagen1.setImageResource(animal.getFoto());
        animalesViewholder.tv_cantidad.setText(String.valueOf(animal.getLikes()));

    /*animalesViewholder.imagen3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            PopupMenu popup = new PopupMenu(this, imagen3);
            popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
               Toast .makeText(activity,"has hecho clicks", Toast.LENGTH_LONG).show();

        }
    });*/
    }
    @Override
    public int getItemCount() {
        return animales.size();//esto muestra la cantidad e elementos que contiene mi lista de animales
    }

    public static class AnimalesViewHolder extends RecyclerView.ViewHolder {
        //  private CardView cv;
        private ImageView imagen1;
        private ImageView imagen3;
        private TextView tv_cantidad;

        public AnimalesViewHolder(View itemView) {
            super(itemView);
            // cv          = (CardView) itemView.findViewById(R.id.cv_contacto);
            imagen1     = (ImageView) itemView.findViewById(R.id.imagen1);
            imagen3     = (ImageView) itemView.findViewById(R.id.imagen3);
            tv_cantidad = (TextView) itemView.findViewById(R.id.tv_cantidad);
            // tv_cantidad.setText(clicks);


        }
    }


}


