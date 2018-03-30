package com.riosgame.yourpetshop;

/**
 * Created by Jose on 3/24/2018.
 */

public final class ConstantesBaseDatos {
    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    //public static final String TABLE_MASCOTAS_MASCOTAS = "mascota";
    public static final String TABLE_MASCOTAS = "mascota";
    public static final String TABLE_MASCOTAS_ID = "id";
    public static final String TABLE_MASCOTAS_NOMBRE= "nombre";
    public static final String TABLE_MASCOTAS_TELEFONO= "telefono";
    public static final String TABLE_MASCOTAS_EMAIL= "email";
    public static final String TABLE_MASCOTAS_FOTO = "foto";

    public static final String TABLE_LIKES_MASCOTAS = "mascotas_likes";
    public static final String TABLE_LIKES_MASCOTAS_ID = "id";
    public static final String TABLE_LIKES_MASCOTAS_ID_MASCOTAS = "id_contacto";
    public static final String TABLE_LIKES_MASCOTAS_NUMEROS_LIKES = "numero_likes";

}
