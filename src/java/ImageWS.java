/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nilmc
 */
public class ImageWS {
    int id;
    String title;
    String creaDate;
    String author;
    String keywords;
    
    void SetID (int id) {
        this.id = id;
    }
    
    void SetTitle (String title) {
        this.title = title;
    }
    
    void SetCreaDate (String creaDate) {
        this.creaDate = creaDate;
    }
    
    void SetAuthor (String author) {
        this.author = author;
    }
    
    void SetKeyWords (String keywords) {
        this.keywords = keywords;
    }
    
    int GetID () {
        return this.id;
    }
    
    String GetTitle () {
        return this.title;
    }
    
    String GetCreaDate () {
        return this.creaDate;
    }
    
    String GetAuthor () {
        return this.author;
    }
    
    String GetKeyWords () {
        return this.keywords;
    }
}
