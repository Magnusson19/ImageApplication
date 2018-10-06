package org.me.image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nilmc
 */
public class Imagen {
    int id;
    String title;
    String creaDate;
    String author;
    String keywords;
    
    public void Imagen(int id, String title, String creaDate, String author, String keywords) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.creaDate = creaDate;
        this.keywords = keywords;
    }
    
    public void SetID (int id) {
        this.id = id;
    }
    
    public void SetTitle (String title) {
        this.title = title;
    }
    
    public void SetCreaDate (String creaDate) {
        this.creaDate = creaDate;
    }
    
    public void SetAuthor (String author) {
        this.author = author;
    }
    
    public void SetKeyWords (String keywords) {
        this.keywords = keywords;
    }
    
    public int GetID () {
        return this.id;
    }
    
    public String GetTitle () {
        return this.title;
    }
    
    public String GetCreaDate () {
        return this.creaDate;
    }
    
    public String GetAuthor () {
        return this.author;
    }
    
    public String GetKeyWords () {
        return this.keywords;
    }
}
