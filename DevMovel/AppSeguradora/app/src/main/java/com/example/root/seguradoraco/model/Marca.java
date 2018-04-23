package com.example.root.seguradoraco.model;

public class Marca {
    private int id;
    private String nome;
    private String chave;


    //Gets
    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getChave(){
        return this.chave;
    }



    //Sets
    public void setId(int i){
        this.id = i;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public void setChave(String c){
        this.chave = c;
    }

}
