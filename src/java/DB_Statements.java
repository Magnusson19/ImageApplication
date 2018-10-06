
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    
    public void DB_Statements () {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\nilmc\\Desktop\\LAB2.db");
        } catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
    }
    
    public void Insert (ImageWS image) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("insert into imagenes values (?,?,?,?,?)");
            statement.setInt(1, image.GetID());
            statement.setString(2, image.GetTitle());
            statement.setString(3, image.GetCreaDate());
            statement.setString(4, image.GetAuthor());
            statement.setString(5, image.GetKeyWords());
        } catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
    }
    
}
