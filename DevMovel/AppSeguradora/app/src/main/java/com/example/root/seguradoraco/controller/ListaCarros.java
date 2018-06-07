package com.example.root.seguradoraco.controller;


import com.example.root.seguradoraco.R;
import com.example.root.seguradoraco.model.Carro;

public class ListaCarros {

    private final Carro[] carros;

    private final int xmlMainActivity     = R.layout.activity_main;
    private final int containerID         = R.id.rlListaCarros;
    private final int txtListaPlaca       = R.id.txtListaPlaca;
    private final int txtListaMarcaModelo = R.id.txtListaMarcaModelo;
    private final int txtListaQtdEventos  = R.id.txtListaQtdEventos;


    public ListaCarros(Carro[] c){
        this.carros = c;

    }
}
