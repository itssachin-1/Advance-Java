/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
 * @author sachin
 */
package javaapplicationwithant;
import java.sql.*;

public class DBConnection {
    static Connection c1= null;
    public Connection getDBConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c1= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "mysql01)");
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        
        return c1;
    }  
}
