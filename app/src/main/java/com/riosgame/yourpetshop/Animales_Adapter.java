package com.riosgame.yourpetshop;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//import static com.riosgame.yourpetshop.Animales_Adapter.AnimalesViewHolder.tv_cantidad;

/**
 * Created by Jose on 3/10/2018.
 */

public class Animales_Adapter extends RecyclerView.Adapter<Animales_Adapter.AnimalesViewHolder>{
        ArrayList<Animales> animales;
        Activity activity;
public Animales_Adapter(ArrayList<Animales> animales, Activity activity){
        this.animales=animales;
        this.activity = activity;
}

@Override
public AnimalesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout,parent,false);
        return new AnimalesViewHolder(v);
        }

@Override
public void onBindViewHolder(AnimalesViewHolder animalesViewholder, int position) {
    final Animales animal = animales.get(position);
    animalesViewholder.imagen1.setImageResource(animal.getFoto());
    animalesViewholder.tv_nombre.setText(animal.getNombre());
    animalesViewholder.tv_cantidad.setText(String.valueOf(animal.getLikes()));

    animalesViewholder.imagen2.setOnClickListener(new View.OnClickListener() {//este click captura los clicks y los mestra en un TextView
        int clicks;

        @Override
        public void onClick(View view) {
            clicks++;
            Toast.makeText(activity, "has hecho " + clicks + " clicks", Toast.LENGTH_LONG).show();
        }
    });
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
    private ImageView imagen2;
    private ImageView imagen3;
    private TextView tv_nombre;
    private TextView tv_cantidad;

    public AnimalesViewHolder(View itemView) {
        super(itemView);
       // cv          = (CardView) itemView.findViewById(R.id.cv_contacto);
        imagen1     = (ImageView) itemView.findViewById(R.id.imagen1);
        imagen2     = (ImageView) itemView.findViewById(R.id.imagen2);
        imagen3     = (ImageView) itemView.findViewById(R.id.imagen3);
        tv_nombre   = (TextView) itemView.findViewById(R.id.tv_nombre);
        tv_cantidad = (TextView) itemView.findViewById(R.id.tv_cantidad);
       // tv_cantidad.setText(clicks);


    }
}


}
