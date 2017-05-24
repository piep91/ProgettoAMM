/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    //Gestione DB
    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    //Fine gestione DB
    
    private ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();
    
    private GruppoFactory(){}
    
    public Gruppo getGruppoById(int id){
        NerdFactory nerdFactory = NerdFactory.getInstance();
        PostFactory postFactory = PostFactory.getInstance();
        ArrayList<Nerd> listaNerd = new ArrayList<Nerd>();
        ArrayList<Post> listaPost = new ArrayList<Post>();
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "pieppo", "pieppo");
            String query = 
                      "select * from gruppi "
                    + "join membriGruppi on gruppi.gruppo_id = membriGruppi.id_gruppo "
                    + "join postGruppi on gruppi.gruppo_id = postGruppo.id_gruppo "
                    + "where gruppo_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
            int cont = 0;
            Gruppo gruppo = new Gruppo();
            // ciclo sulle righe restituite
            while(res.next()){
                if(cont == 0){
                    gruppo.setId(res.getInt("gruppo_id"));
                    gruppo.setNome(res.getString("gruppo_nome"));
                }
                listaNerd.add(nerdFactory.getNerdById(res.getInt("id_membro")));
                listaPost.add(postFactory.getPostById(res.getInt("id_post")));
                cont++;
            }
            gruppo.setListaNerdGruppo(listaNerd);
            gruppo.setListaPostGruppo(listaPost);
            
            stmt.close();
            conn.close();
            return gruppo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List getGruppoByUser(Nerd nerd){
        NerdFactory nerdFactory = NerdFactory.getInstance();
        PostFactory postFactory = PostFactory.getInstance();
        ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "pieppo", "pieppo");
            String query = 
                      "select gruppo_id from gruppi "
                    + "join membriGruppi on gruppi.gruppo_id = membriGruppi.id_gruppo "
                    + "where id_membro = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, nerd.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
            while(res.next()){
                listaGruppi.add(this.getGruppoById(res.getInt("gruppo_id")));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return listaGruppi;
    }    
}
