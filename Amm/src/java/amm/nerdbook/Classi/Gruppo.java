/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.util.ArrayList;
/**
 *
 * @author Pierandrea
 */
public class Gruppo {
    
    private int id;
    private String nome;
    private ArrayList<Nerd> listaNerdGruppo = new ArrayList<Nerd>();
    
    public Gruppo(){
        id = 0;
        nome= "";
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the listaNerdGruppo
     */
    public ArrayList<Nerd> getListaNerdGruppo() {
        return listaNerdGruppo;
    }

    /**
     * @param listaNerdGruppo the listaNerdGruppo to set
     */
    public void setListaNerdGruppo(ArrayList<Nerd> listaNerdGruppo) {
        this.listaNerdGruppo = listaNerdGruppo;
    }
    
}
