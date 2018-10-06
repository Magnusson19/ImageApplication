/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.image;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author nilmc
 */
@WebService(serviceName = "ImageWS")
public class ImageWS {
    
    DB_Statements DB_S = new DB_Statements();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "RegisterImage")
    public int RegisterImage(@WebParam(name = "image") Imagen image) {
        return DB_S.Insert(image);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ModifyImage")
    public int ModifyImage(@WebParam(name = "image") Imagen image) {
        return DB_S.Update(image);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ListImages")
    public List ListImages() {
        try {
            List<Imagen> l = new ArrayList<Imagen>();
            ResultSet rs = DB_S.Select();
            while (rs.next()) {
                Imagen I = new Imagen();
                I.SetID(rs.getInt("id_imagen"));
                I.SetTitle(rs.getString("titulo"));
                I.SetCreaDate(rs.getString("fecha_creacion"));
                I.SetAuthor(rs.getString("autor"));
                I.SetKeyWords(rs.getString("palabras_clave"));
                l.add(I);
            }
            return l;
        } catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SearchbyId")
    public Imagen SearchbyId(@WebParam(name = "id") int id) {
        try {
            ResultSet rs = DB_S.Select_id(id);
            Imagen I = new Imagen();
            I.SetID(rs.getInt("id_imagen"));
            I.SetTitle(rs.getString("titulo"));
            I.SetCreaDate(rs.getString("fecha_creacion"));
            I.SetAuthor(rs.getString("autor"));
            I.SetKeyWords(rs.getString("palabras_clave"));
            return I;
        } catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SearchbyTitle")
    public List SearchbyTitle(@WebParam(name = "title") String title) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SearchbyCreaDate")
    public List SearchbyCreaDate(@WebParam(name = "creaDate") String creaDate) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SearchbyAuthor")
    public List SearchbyAuthor(@WebParam(name = "author") String author) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SearchbyKeywords")
    public List SearchbyKeywords(@WebParam(name = "keywords") String keywords) {
        //TODO write your implementation code here:
        return null;
    }

    
}
