package com.example.root.learnapp.Controller;

import com.example.root.learnapp.Model.Pergunta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 5/29/18.
 */

public class ControllerPerguntas {

    Pergunta pergunta;

    public ControllerPerguntas(Pergunta p){
        this.pergunta = p;
    }




    //Methods
    public void definirPerguntas(){
        List<String> listaPerguntas = new ArrayList<String>();

        for(int x=0; x<8; x++) {
            listaPerguntas.add("BT " + Integer.toString(x+1) );
        }

        pergunta.setListaPerguntas(listaPerguntas);
    }

}
