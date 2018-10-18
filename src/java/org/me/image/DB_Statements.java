package org.me.image;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nilmc
 */
public class DB_Statements {
    Connection connection = null;
    
    public DB_Statements () {
        try {
            Class.forName("org.sqlite.JDBC"); 
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\nilmc\\Desktop\\LAB2.db");
        } catch(Exception e)
        {
          System.err.println(e.getMessage());
        }
    }
    
    public int Insert (Imagen image) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("select max(id_imagen) from imagenes");
            ResultSet rs = statement.executeQuery();
            int id = 0;
            if (rs.next()) id = rs.getInt("id_imagen");
            else return 0;
            statement = this.connection.prepareStatement("insert into imagenes values (?,?,?,?,?)");
            statement.setInt(1, id);
            statement.setString(2, image.GetTitle());
            statement.setString(3, image.GetCreaDate());
            statement.setString(4, image.GetAuthor());
            statement.setString(5, image.GetKeyWords());
            return statement.executeUpdate();
        } catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public int Update (Imagen image) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("update imagenes set titulo = ?, fecha_creacion = ?,"
                                                                         + "autor = ?, palabras_clave = ? where id_imagen = ?");
            statement.setString(1, image.GetTitle());
            statement.setString(2, image.GetCreaDate());
            statement.setString(3, image.GetAuthor());
            statement.setString(4, image.GetKeyWords());
            statement.setInt(5, image.GetID());
            return statement.executeUpdate();
        } catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public ResultSet Select () {
        try {
            PreparedStatement statement = this.connection.prepareStatement("select * from imagenes");
            return statement.executeQuery();
        } catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        return null;
    }
    
    public ResultSet Select_id (int id) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("select * from imagenes where id_imagen = ?");
            statement.setInt(1, id);
            return statement.executeQuery();
        } catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        return null;
    }
    
    public ResultSet SearchByTitle (String title) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("select * from imagenes where titulo = ?");
            statement.setString(1, title);
            return statement.executeQuery();
        } catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        return null;
    }
     
      public ResultSet SearchByCreaDate (String creaDate) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("select * from imagenes where fecha_creacion = ?");
            statement.setString(1, creaDate);
            return statement.executeQuery();
        } catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        return null;
    }
      
       public ResultSet SearchByAuthor (String author) {
        
           try {
            PreparedStatement statement = this.connection.prepareStatement("select * from imagenes where autor = ?");
            statement.setString(1, author);
            return statement.executeQuery();
        } catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        return null;
    }
       
        public ResultSet SearchByKeywords (String keywords) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("select * from imagenes where palabras_clave = ?");
            statement.setString(1, keywords);
            return statement.executeQuery();
        } catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        return null;
    }
    
    public void Close_DB () {
        try
          {
            if(this.connection != null)
              this.connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
    }
    
}
