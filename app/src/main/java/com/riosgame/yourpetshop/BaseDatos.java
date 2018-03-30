package com.riosgame.yourpetshop;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PublicKey;
import java.util.ArrayList;

import static com.riosgame.yourpetshop.ConstantesBaseDatos.DATABASE_VERSION;

/**
 * Created by Jose on 3/23/2018.
 */

public class BaseDatos extends SQLiteOpenHelper{
    private Context context;
    public BaseDatos(Context context) {
      // super(context, "mascotas", null, 1);
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaLikesMascotas = "CREAR TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS + "(" +
                                         ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID       +"INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                         ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS      +"INTEGER, "+
                                         ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMEROS_LIKES    +"INTEGER, "+
                                         "FOREING KEY  (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS + ") "+
                                         "REFERENCES " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS + "("+ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID + ") "+
                                          ")";
        db.execSQL(queryCrearTablaLikesMascotas);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int olVersion, int newVersion) {
      //  db.execSQL("DROP TABLE IF EXISTS "+ ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS "+ ConstantesBaseDatos.TABLE_LIKES_MASCOTAS);
        onCreate(db);
    }
    public ArrayList<Animales> obtenerTodasLasMascotas(){
        ArrayList <Animales> Animales = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registro =  db.rawQuery(query,null);
        while (registro.moveToNext()){
            Animales AnimalActual = new Animales();
            AnimalActual.setId(registro.getInt(0));
            AnimalActual.setNombre(registro.getString(1));
            AnimalActual.setTelefono(registro.getString(2));
            AnimalActual.setEmail(registro.getString(3));
            AnimalActual.setFoto(registro.getInt(4));
            Animales.add(AnimalActual);


           /* String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS + "=" + contactoActual.getId();
            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                contactoActual.setLikes(registrosLikes.getInt(0));
            }else {
                contactoActual.setLikes(0);
            }
            contactos.add(contactoActual);
            x*/

        }
        db.close();

        return Animales;
    }
 //   public void insertarMascotas(ContentValues contentValues){
  //      SQLiteDatabase bd = this.getWritableDatabase();
   //   bd.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS,null, contentValues);
    //   bd.close();

    //}

    public void insertarLikesMascotas(ContentValues contentValues) {
        SQLiteDatabase bd = this.getWritableDatabase();
        bd.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS,null, contentValues);
        bd.close();
    }
    public int obtenetLikesMascotas (Animales animales){
        int likes = 0;
        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMEROS_LIKES+")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS + "="+animales.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();



        return  likes;

    }
}
