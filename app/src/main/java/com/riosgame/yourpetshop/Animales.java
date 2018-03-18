package com.riosgame.yourpetshop;

/**
 * Created by Jose on 3/10/2018.
 */

public class Animales {
    private String nombre;
   // private int cantidad;
    private int foto;
    private int likes;



    public Animales(int foto, String nombre, int likes) {
        this.foto = foto;
        this.nombre = nombre;
        this.likes = likes;
    }
    public Animales(String nombre, int likes) {
        this.nombre = nombre;
        this.likes = likes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   // public int getCantidad() {
   //     return cantidad;
  //  }

  // public void setCantidad(int cantidad) {
   //     this.cantidad = cantidad;
   // }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

}
