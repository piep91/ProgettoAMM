/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Pierandrea
 */
public class GruppoFactory {
    
    private static GruppoFactory singleton;

    public static GruppoFactory getInstance() {
        if (singleton == null) singleton = new GruppoFactory();
        return singleton;
    }
    
    private ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();
    
    private GruppoFactory(){
        
        NerdFactory nerdFactory = NerdFactory.getInstance();
        PostFactory postfactory = PostFactory.getInstance();
        
        Gruppo gruppo1 = new Gruppo();
        gruppo1.setId(0);
        gruppo1.setNome("Consolari");
        ArrayList<Nerd> listaNerdGruppo1 = new ArrayList<Nerd>();
        listaNerdGruppo1.add(nerdFactory.getNerdById(0));
        listaNerdGruppo1.add(nerdFactory.getNerdById(1));
        gruppo1.setListaNerdGruppo(listaNerdGruppo1);
        
        Gruppo gruppo2 = new Gruppo();
        gruppo2.setId(1);
        gruppo2.setNome("PCisti");
        ArrayList<Nerd> listaNerdGruppo2 = new ArrayList<Nerd>();
        listaNerdGruppo2.add(nerdFactory.getNerdById(1));
        listaNerdGruppo2.add(nerdFactory.getNerdById(2));
        gruppo1.setListaNerdGruppo(listaNerdGruppo2);
    }
    
    public Gruppo getGruppoById(int id){
        for (Gruppo gruppo : this.listaGruppi){
            if(gruppo.getId() == id) return gruppo;
        }
        return null;
    }
    
    
}
