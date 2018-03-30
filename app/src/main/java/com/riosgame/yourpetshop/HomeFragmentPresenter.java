package com.riosgame.yourpetshop;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Jose on 3/23/2018.
 */

public class HomeFragmentPresenter implements IHomeFragmentPresenter {
    private IHomeFragmentView iHomeFragmentView;
    private Context context;
    private ConstructorContacto constructorContacto;
    private ArrayList<Animales>animales;
  public   HomeFragmentPresenter(IHomeFragmentView iHomeFragmentView, Context context){
      this.iHomeFragmentView = iHomeFragmentView;
      this.context = context;
      optenerContactosBaseDatos();

  }

    @Override
    public void optenerContactosBaseDatos() {
      constructorContacto = new ConstructorContacto(context);
      animales = constructorContacto.optenerDatos();
      mostrarContactosRv();

    }

    @Override
    public void mostrarContactosRv() {
      iHomeFragmentView.inicializarAdaptadorRv(iHomeFragmentView.crearAdaptador(animales));
      iHomeFragmentView.generarLinearLayoutVertical();

    }
}
