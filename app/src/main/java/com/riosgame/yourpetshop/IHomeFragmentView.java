package com.riosgame.yourpetshop;

import java.util.ArrayList;

/**
 * Created by Jose on 3/23/2018.
 */

public interface IHomeFragmentView {
    public void generarLinearLayoutVertical();
    public Animales_Adapter crearAdaptador(ArrayList<Animales> animales);
    public void inicializarAdaptadorRv(Animales_Adapter adapter);

}
