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
    
    private ArrayList<Post> listaPost = new ArrayList<Post>();
    
    private PostFactory(){
        
        NerdFactory nerdFactory = NerdFactory.getInstance();
        
        Post post1 = new Post();
        post1.setId(0);
        post1.setContent("Primo post in assoluto su Nerdbook!");
        post1.setUtente(nerdFactory.getNerdById(0));
        post1.setpBacheca(nerdFactory.getNerdById(1));
        
        Post post2 = new Post();
        post2.setId(1);
        post2.setContent("Sono arrivato tardi");
        post2.setUrlImg("img/allegato_post.jpg");
        post2.setUtente(nerdFactory.getNerdById(1));
        post2.setpBacheca(nerdFactory.getNerdById(0));
        post2.setTipoPost(Post.Tipo.T_AND_I);
        
        Post post3 = new Post();
        post3.setId(2);
        post3.setContent("Iscrivetevi a questo sito di cashback: http://it.beruby.com/promocode/uVjKCl");
        post3.setUtente(nerdFactory.getNerdById(2));
        post3.setpBacheca(nerdFactory.getNerdById(2));
        
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
    }
    
    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getId() == id) return post;
        }
        return null;
    }
    
    public void addPost(Post post){
        listaPost.add(post);
    }
    
    public List getPostList(Nerd nerd){
        List<Post> listaPostByUser = new ArrayList<Post>();
        
        for(Post post : this.listaPost){
            if(post.getUtente().equals(nerd)) listaPostByUser.add(post);
        }
        return listaPostByUser;
    }
    
    public List getPostListB(Nerd nerd){
        List<Post> listaPostByUserB = new ArrayList<Post>();
        
        for(Post post : this.listaPost){
            if(post.getpBacheca().equals(nerd)) listaPostByUserB.add(post);
        }
        return listaPostByUserB;
    }
}
