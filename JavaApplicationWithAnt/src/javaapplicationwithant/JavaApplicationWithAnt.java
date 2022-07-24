/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplicationwithant;
import java.sql.*;

// @author sachin

public class JavaApplicationWithAnt {
//     * @param args the command line arguments
     
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        
        // Step-1 load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Step-2 connect to db
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "mysql01)");
        if(con != null){
            System.out.println("Connection Established!\n");
            
        // Step-3 create statement
        Statement st= con.createStatement();    // to use sql query
        String query= "select * from worker";
//      String query2 = "insert into worker values(5, 'Jerry', 'Mountain Shadow')";
// 
        // Step-4 Obtain and process result
          ResultSet rs= st.executeQuery(query);
//        int x= st.executeUpdate(query2);
//        if(x>0){
//            System.out.println(x+" record(s) inserted!");
//        }
        
                while(rs.next()){
                    System.out.println(rs.getInt(1)+" |\t"+rs.getString(2)+"\t| "+rs.getString(3));
                }
        // Step-5 close connection
                con.close();
                st.close();
                rs.close();
        }
    }
}
