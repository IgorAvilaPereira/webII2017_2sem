/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author iapereira
 */
public class Convidado {
    private int id;
    private String nome;
    private String fantasia;

    public Convidado() {
    }
    
    

    public Convidado(String nome, String fantasia) {
        this.nome = nome;
        this.fantasia = fantasia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }
    
    
    
    
    
    
}
