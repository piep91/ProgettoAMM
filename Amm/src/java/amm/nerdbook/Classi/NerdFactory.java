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
import java.util.ArrayList;
import java.util.List;
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
    
    //Gestione DB
    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    //Fine gestione DB
    
    private ArrayList<Nerd> listaNerd = new ArrayList<Nerd>();
    
    private NerdFactory(){}
    
    public Nerd getNerdById(int id){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "pieppo", "pieppo");
            String query = 
                      "select * from nerd "
                    + "where nerd_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
            // ciclo sulle righe restituite
            if(res.next()){
                Nerd current = new Nerd();
                current.setId(res.getInt("nerd_id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setPassword(res.getString("password"));
                current.setPres(res.getString("pres"));
                current.setUrlFotoProfilo(res.getString("url_foto"));
                
                stmt.close();
                conn.close();
                return current;
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List getNerdList(){
        return listaNerd;
    }
    
    public int getIdByUserAndPassword(String nome, String password){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "pieppo", "pieppo");
            
            String query = 
                      "select nerd_id from nerd "
                    + "where nome = ? and password = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, nome);
            stmt.setString(2, password);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
            // ciclo sulle righe restituite
            if (res.next()) {
                int id = res.getInt("nerd_id");

                stmt.close();
                conn.close();
                return id;
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
}
