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
public class NerdFactory {
    
    private static NerdFactory singleton;
    
    public static NerdFactory getInstance(){
        if (singleton == null) singleton = new NerdFactory();
        return singleton;
    }
    
    private ArrayList<Nerd> listaNerd = new ArrayList<Nerd>();
    
    private NerdFactory(){
        
        Nerd user1 = new Nerd();
        user1.setId(0);
        user1.setNome("Gigi");
        user1.setCognome("Pintus");
        user1.setEmail("gigi@gmail.com");
        user1.setPassword("1234");
        user1.setUrlFotoProfilo("img/Profile01.png");
        
        Nerd user2 = new Nerd();
        user2.setId(1);
        user2.setNome("Wowo");
        user2.setCognome("Pinna");
        user2.setEmail("wowo@gmail.com");
        user2.setPassword("1234");
        user2.setUrlFotoProfilo("img/Profile02.jpg");
        
        Nerd user3 = new Nerd();
        user3.setId(2);
        user3.setNome("Gianni");
        user3.setCognome("Scalas");
        user3.setEmail("gianni@gmail.com");
        user3.setPassword("1234");
        user3.setUrlFotoProfilo("img/Profile03.png");
        
        listaNerd.add(user1);
        listaNerd.add(user2);
        listaNerd.add(user3);
    }
    
    public Nerd getNerdById(int id){
        for (Nerd user : this.listaNerd){
            if(user.getId() == id) return user; 
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String nome, String password){
        for (Nerd user : this.listaNerd){
            if (user.getNome().equals(nome) && user.getPassword().equals(password))
                return user.getId();
        }
        return -1;
    }
    
}
