/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;
/**
 *
 * @author Pierandrea
 */
public class Post {

    public enum Tipo {
        TEXT, T_AND_I
    };
    
    private int id;
    private Nerd utente;
    private Nerd pBacheca;
    private String content;
    private String urlImg;
    private Tipo tipoPost;
    
    public Post(){
        id = 0;
        utente = null;
        pBacheca = null;
        content = "";
        urlImg = "";
        tipoPost = Tipo.TEXT;
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
     * @return the utente
     */
    public Nerd getUtente() {
        return utente;
    }

    /**
     * @param utente the utente to set
     */
    public void setUtente(Nerd utente) {
        this.utente = utente;
    }

    /**
     * @return the pBacheca
     */
    public Nerd getpBacheca() {
        return pBacheca;
    }

    /**
     * @param pBacheca the pBacheca to set
     */
    public void setpBacheca(Nerd pBacheca) {
        this.pBacheca = pBacheca;
    }
    
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    /**
     * @return the urlImg
     */
    public String getUrlImg() {
        return urlImg;
    }

    /**
     * @param urlImg the urlImg to set
     */
    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
    
    /**
     * @return the tipoPost
     */
    public Tipo getTipoPost() {
        return tipoPost;
    }

    /**
     * @param tipoPost the tipoPost to set
     */
    public void setTipoPost(Tipo tipoPost) {
        this.tipoPost = tipoPost;
    }
    
}
