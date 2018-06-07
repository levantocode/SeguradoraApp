package com.example.root.learnapp.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by root on 5/29/18.
 */

public class Pergunta {

    public List<String> listaPerguntas = new ArrayList<String>();

    private Random random = new Random();
    private int randomNumber;



    public Pergunta() {

    }






    //Gets
    public List<String> getListaPerguntas(){
        return this.listaPerguntas;
    }

    public int getRandomNumber(){
        return this.randomNumber;
    }



    //Sets
    public void setListaPerguntas(List<String> lp){
        this.listaPerguntas = lp;
    }

    public void setRandomNumber(int rn) {
        this.randomNumber = rn;
    }



    //Methods

    public String getRandomPergunta(){
        this.randomNumber = this.random.nextInt(this.listaPerguntas.size());

        return listaPerguntas.get(this.randomNumber);
    }
}
