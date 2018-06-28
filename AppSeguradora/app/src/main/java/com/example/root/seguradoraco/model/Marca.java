package com.example.root.seguradoraco.model;

public class Marca {
    private int id;
    private int idMarca;
    private String nome;
    private String chave;


    public Marca(int i, int im, String n){
        this.id = i;
        this.idMarca = im;
        this.nome = n;
    }




    //Gets
    public int getId(){
        return this.id;
    }

    public int getIdMarca() { return this.idMarca; }

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

    public void setIdMarca(int im) { this.idMarca = im; }

    public void setNome(String n){
        this.nome = n;
    }

    public void setChave(String c){
        this.chave = c;
    }

}
