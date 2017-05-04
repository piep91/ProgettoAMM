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
public class Nerd {
    
    private int id;
    private String nome;
    private String cognome;
    private String pres;
    private String password;
    private String urlFotoProfilo;
    
    public Nerd(){
        id = 0;
        nome = "";
        cognome = "";
        pres = "";
        password = "";
        urlFotoProfilo = "";
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
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the pres
     */
    public String getPres() {
        return pres;
    }

    /**
     * @param pres the pres to set
     */
    public void setPres(String pres) {
        this.pres = pres;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the urlFotoProfilo
     */
    public String getUrlFotoProfilo() {
        return urlFotoProfilo;
    }

    /**
     * @param urlFotoProfilo the urlFotoProfilo to set
     */
    public void setUrlFotoProfilo(String urlFotoProfilo) {
        this.urlFotoProfilo = urlFotoProfilo;
    }
    
    public int checkCompleteProfile(){
        if(this.nome.equals("") || this.cognome.equals("") || this.pres.equals("") || this.urlFotoProfilo.equals("")){
            return -1;
        }else{
            return 1;
        }
    }
    
    @Override
    public boolean equals(Object altroNerd){
        if (altroNerd instanceof Nerd)
            if (this.getId() == ((Nerd)altroNerd).getId()) return true;
        return false;
    }
    
}
