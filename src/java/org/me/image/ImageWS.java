/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.image;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 *
 * @author nilmc
 */
@WebService(serviceName = "ImageWS", wsdlLocation = "WEB-INF/wsdl/ImageWS.wsdl")
public class ImageWS {

    /**
     * Web service operation
     * @param image
     * @return 
     */
    @WebMethod(operationName = "RegisterImage")
    public int RegisterImage(@WebParam(name = "image") Imagen image) {
        DB_Statements DB_S = new DB_Statements();
        int i = DB_S.Insert(image);
        DB_S.Close_DB();
        return i;
    }

    /**
     * Web service operation
     * @param image
     * @return 
     */
    @WebMethod(operationName = "ModifyImage")
    public int ModifyImage(@WebParam(name = "image") Imagen image) {
        DB_Statements DB_S = new DB_Statements();
        int i = DB_S.Update(image);
        DB_S.Close_DB();
        return i;
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "ListImages")
    public List<Imagen> ListImages() {
        try {
            //DB_Statements DB_S = new DB_Statements();
            Class.forName("org.sqlite.JDBC"); 
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\nilmc\\Desktop\\LAB2.db");
        
            List<Imagen> l = new ArrayList<>();
            //ResultSet rs = DB_S.Select();
            PreparedStatement statement = connection.prepareStatement("select * from imagenes");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Imagen I = new Imagen();
                I.SetID(rs.getInt("id_imagen"));
                I.SetTitle(rs.getString("titulo"));
                I.SetCreaDate(rs.getString("fecha_creacion"));
                I.SetAuthor(rs.getString("autor"));
                I.SetKeyWords(rs.getString("palabras_clave"));
                l.add(I);
                //System.out.println(l.get(l.size()-1).GetAuthor());
            }
            if(connection != null)
              connection.close();
            //DB_S.Close_DB();
            if (l.size() > 0) {
                System.out.println(l.get(l.size()-1).GetAuthor());
                return l;
            }
            else return null;
        } catch(Exception e)
        {
          System.err.println(e.getMessage());
        }
        return null;
    }

    /**
     * Web service operation
     * @param id
     * @return 
     */
    @WebMethod(operationName = "SearchbyId")
    public Imagen SearchbyId(@WebParam(name = "id") int id) {
        try {
            DB_Statements DB_S = new DB_Statements();
            ResultSet rs = DB_S.Select_id(id);
            Imagen I = new Imagen();
            I.SetID(rs.getInt("id_imagen"));
            I.SetTitle(rs.getString("titulo"));
            I.SetCreaDate(rs.getString("fecha_creacion"));
            I.SetAuthor(rs.getString("autor"));
            I.SetKeyWords(rs.getString("palabras_clave"));
            DB_S.Close_DB();
            return I;
        } catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        return null;
    }

    /**
     * Web service operation
     * @param title
     * @return 
     */
    @WebMethod(operationName = "SearchbyTitle")
    public List<Imagen> SearchbyTitle(@WebParam(name = "title") String title) {
         try {
            DB_Statements DB_S = new DB_Statements();
            List<Imagen> l = new ArrayList<>();
            ResultSet rs = DB_S.SearchByTitle(title);
            while (rs.next()) {
                Imagen I = new Imagen();
                I.SetID(rs.getInt("id_imagen"));
                I.SetTitle(rs.getString("titulo"));
                I.SetCreaDate(rs.getString("fecha_creacion"));
                I.SetAuthor(rs.getString("autor"));
                I.SetKeyWords(rs.getString("palabras_clave"));
                l.add(I);
            }
            DB_S.Close_DB();
            return l;
        } catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        return null;
    }

    /**
     * Web service operation
     * @param creaDate
     * @return 
     */
    @WebMethod(operationName = "SearchbyCreaDate")
    public List<Imagen> SearchbyCreaDate(@WebParam(name = "creaDate") String creaDate) {
         try {
            DB_Statements DB_S = new DB_Statements();
            List<Imagen> l = new ArrayList<>();
            ResultSet rs = DB_S.SearchByCreaDate(creaDate);
            while (rs.next()) {
                Imagen I = new Imagen();
                I.SetID(rs.getInt("id_imagen"));
                I.SetTitle(rs.getString("titulo"));
                I.SetCreaDate(rs.getString("fecha_creacion"));
                I.SetAuthor(rs.getString("autor"));
                I.SetKeyWords(rs.getString("palabras_clave"));
                l.add(I);
            }
            DB_S.Close_DB();
            return l;
        } catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        return null;
    }

    /**
     * Web service operation
     * @param author
     * @return 
     */
    @WebMethod(operationName = "SearchbyAuthor")
    public List<Imagen> SearchbyAuthor(@WebParam(name = "author") String author) {
          
        try {
            DB_Statements DB_S = new DB_Statements();
            List<Imagen> l = new ArrayList<>();
            ResultSet rs = DB_S.SearchByAuthor(author);
            while (rs.next()) {
                Imagen I = new Imagen();
                I.SetID(rs.getInt("id_imagen"));
                I.SetTitle(rs.getString("titulo"));
                I.SetCreaDate(rs.getString("fecha_creacion"));
                I.SetAuthor(rs.getString("autor"));
                I.SetKeyWords(rs.getString("palabras_clave"));
                l.add(I);
            }
            DB_S.Close_DB();
            return l;
        } catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        return null;
    }

    /**
     * Web service operation
     * @param keywords
     * @return 
     */
    @WebMethod(operationName = "SearchbyKeywords")
    public List<Imagen> SearchbyKeywords(@WebParam(name = "keywords") String keywords) {
          try {
            DB_Statements DB_S = new DB_Statements();
            List<Imagen> l = new ArrayList<>();
            ResultSet rs = DB_S.SearchByKeywords(keywords);
            while (rs.next()) {
                Imagen I = new Imagen();
                I.SetID(rs.getInt("id_imagen"));
                I.SetTitle(rs.getString("titulo"));
                I.SetCreaDate(rs.getString("fecha_creacion"));
                I.SetAuthor(rs.getString("autor"));
                I.SetKeyWords(rs.getString("palabras_clave"));
                l.add(I);
            }
            DB_S.Close_DB();
            return l;
        } catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        return null;
    }
    
}
