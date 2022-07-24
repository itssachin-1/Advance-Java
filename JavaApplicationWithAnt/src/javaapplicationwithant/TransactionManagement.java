/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplicationwithant;
import java.sql.*;

/**
 *
 * @author sachin
 */
public class TransactionManagement {
    public static void main(String[] args) throws Exception{
    DBConnection dbcon = new DBConnection();  // class - getDBConnection()
    Connection con = dbcon.getDBConnection(); // load and connecting - return con
    if(con != null)
        System.out.println("Connected!!");
  
    con.setAutoCommit(false); // setting commit() false 
    
    Statement st= con.createStatement();
    // Start transaction
    String q1= "insert ignore into customer values(2222, 'john', 65000, 'Chicago')";
    String q2= "insert ignore into customer values(6666, 'iroll', 6000, 'xcity')";    
    String q3= "delete from customer where cid=2222";
    
    
    st.executeUpdate(q1);
    con.commit();
    System.out.println("Operations commited!");
//    st.executeQuery("select *from customer");
    
    st.executeUpdate(q2);
    Savepoint sp= con.setSavepoint();
    st.executeUpdate(q3);
    
//  Now we undo the delete operation.
    con.rollback(sp);
    System.out.println("Rolledback deleted operations!");
//    st.executeQuery("select *from customer");

//  Now we undo those last inserts and the delete.
    con.rollback();
    System.out.println("Rolledback uncommited operations!");
//    st.executeQuery("select *from customer");
    
    con.close();
    st.close();
    }
}
