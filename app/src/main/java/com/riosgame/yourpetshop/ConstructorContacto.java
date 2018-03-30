package com.riosgame.yourpetshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Jose on 3/23/2018.
 */

public class ConstructorContacto {
    private static final Integer LIKE = 1;
    private Context context;
    public ConstructorContacto(Context context){
        this.context = context;
    }
    public ArrayList<Animales> optenerDatos(){

       BaseDatos bd = new BaseDatos(context);
        //insertartresMascotas(bd);
        return bd.obtenerTodasLasMascotas();

    }
  /*  public void insertartresMascotas (BaseDatos bd){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE," Bunny");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_TELEFONO," +971508709087");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_EMAIL," bunny@hotmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.conejo);
        bd.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE," Toby");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_TELEFONO," +971508709066");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_EMAIL," tobyy@hotmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.perrito_blanco);
        bd.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE," Katy");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_TELEFONO," +971508478087");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_EMAIL," katy@hotmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.gato_1);
        bd.insertarMascotas(contentValues);

    }*/
  public void likesMascotas ( Animales animales){
      BaseDatos db = new BaseDatos(context);
      ContentValues contentValues = new ContentValues();
      contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS, animales.getId());
      contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMEROS_LIKES, LIKE);
      db.insertarLikesMascotas(contentValues);

  }
  public int obtenetLikesMascotas (Animales animales){
      BaseDatos db = new BaseDatos(context);
      return db.obtenetLikesMascotas(animales);
  }

}
