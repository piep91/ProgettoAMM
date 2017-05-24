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
public class PostFactory {
    
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) singleton = new PostFactory();
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
    
    
    private PostFactory(){}
    
    public Post getPostById(int id) {
        NerdFactory nerdFactory = NerdFactory.getInstance();
        try{
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "pieppo", "pieppo");
            
            String query =
                        "select * from posts "
                      + "join tipoPost on posts.tipo = tipoPost.tipoPost_id "
                      + "join postBacheca on posts.post_id = postBacheca.id_post "
                      + "where post_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
            // ciclo sulle righe restituite
            if (res.next()) {
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("post_id"));
                //imposto il contenuto del post
                current.setContent(res.getString("contenuto"));
                //imposto la possibile immagine allegata
                current.setUrlImg(res.getString("url_allegato"));
                //imposto il tipo del post
                current.setTipoPost(this.tipoPostFromString(res.getString("tipoPost_nome")));
                //imposto l'autore del post
                Nerd autore = nerdFactory.getNerdById(res.getInt("autore"));
                current.setUtente(autore);
                //imposto il proprietario della bacheca sulla quale è stato postato il post
                Nerd pBacheca = nerdFactory.getNerdById(res.getInt("proprietario"));
                current.setpBacheca(pBacheca);
                
                stmt.close();
                conn.close();
                return current;
            }
            stmt.close();
            conn.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void addPost(Post post){
        try{
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "pieppo", "pieppo");
            
            String query = 
                      "insert into posts (post_id, autore, contenuto, tipo) "
                    + "values (default, ? , ? , ?)";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, post.getUtente().getId());
            
            stmt.setString(2, post.getContent());
            
            stmt.setInt(3, this.tipoPostFromEnum(post.getTipoPost()));
            
            // Esecuzione query
            stmt.executeUpdate();
            
            String query2 =
                        "select post_id from posts "
                      + "where post_id not in "
                      + "(select id_post from postBacheca)";
            
             // Prepared Statement
            PreparedStatement stmt2 = conn.prepareStatement(query2);
            
            // Esecuzione query
            ResultSet res = stmt2.executeQuery();
            
            if(res.next()){
                int post_id = res.getInt("post_id");
                
                String query3 =
                        "insert into postBacheca (id_post, proprietario) "
                      + "values (?, ?)";
                
                // Prepared Statement
                PreparedStatement stmt3 = conn.prepareStatement(query3);
                
                stmt3.setInt(1, post_id);
                
                stmt3.setInt(2, post.getpBacheca().getId());
                
                // Esecuzione query
                stmt3.executeUpdate();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public List getPostList(Nerd nerd){
        List<Post> listaPostByUser = new ArrayList<Post>();
        NerdFactory nerdFactory = NerdFactory.getInstance();
        
        try{
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "pieppo", "pieppo");
            
            String query =
                        "select * from posts "
                      + "join tipoPost on posts.tipo = tipoPost.tipoPost_id "
                      + "join postBacheca on posts.post_id = postBacheca.id_post "
                      + "where autore = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, nerd.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
            while(res.next()){
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("post_id"));
                //imposto il contenuto del post
                current.setContent(res.getString("contenuto"));
                //imposto la possibile immagine allegata
                current.setUrlImg(res.getString("url_allegato"));
                //imposto il tipo del post
                current.setTipoPost(this.tipoPostFromString(res.getString("tipoPost_nome")));
                //imposto l'autore del post
                Nerd autore = nerdFactory.getNerdById(res.getInt("autore"));
                current.setUtente(autore);
                //imposto il proprietario della bacheca sulla quale è stato postato il post
                Nerd pBacheca = nerdFactory.getNerdById(res.getInt("proprietario"));
                current.setpBacheca(pBacheca);
                
                listaPostByUser.add(current);
            }
            stmt.close();
            conn.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPostByUser;
    }
    
    public List getPostListB(Nerd nerd){
        List<Post> listaPostByUserB = new ArrayList<Post>();
        NerdFactory nerdFactory = NerdFactory.getInstance();
        
        try{
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "pieppo", "pieppo");
            
            String query =
                        "select * from posts "
                      + "join tipoPost on posts.tipo = tipoPost.tipoPost_id "
                      + "join postBacheca on posts.post_id = postBacheca.id_post "
                      + "where proprietario = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, nerd.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
            while(res.next()){
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("post_id"));
                //imposto il contenuto del post
                current.setContent(res.getString("contenuto"));
                //imposto la possibile immagine allegata
                current.setUrlImg(res.getString("url_allegato"));
                //imposto il tipo del post
                current.setTipoPost(this.tipoPostFromString(res.getString("tipoPost_nome")));
                //imposto l'autore del post
                Nerd autore = nerdFactory.getNerdById(res.getInt("autore"));
                current.setUtente(autore);
                //imposto il proprietario della bacheca sulla quale è stato postato il post
                Nerd pBacheca = nerdFactory.getNerdById(res.getInt("proprietario"));
                current.setpBacheca(pBacheca);
                
                listaPostByUserB.add(current);
            }
            stmt.close();
            conn.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPostByUserB;
    }
    
    private Post.Tipo tipoPostFromString(String tipo){
        
        if(tipo.equals("TEXT"))
            return Post.Tipo.TEXT;
        
        return Post.Tipo.T_AND_I;
    }
    
    private int tipoPostFromEnum(Post.Tipo tipo){
        if(tipo == Post.Tipo.TEXT)
                return 1;
            else
                return 2;
    }
}
