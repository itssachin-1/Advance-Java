/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author sachin
 */

package javaapplicationwithant;
import java.sql.*;
import java.util.Scanner;

public class CRUD {
    public static void main(String[] args)throws Exception{
        DBConnection dbcon = new DBConnection(); // class - getDBConnection()
        Connection con = dbcon.getDBConnection();
        if(con != null)
            System.out.println("Connected!!");
        
        Scanner input = new Scanner(System.in);
        System.out.println("pls enter cid and balance to update");
        int id = input.nextInt();
        double bal = input.nextDouble();

        
        Statement st = con.createStatement();
        // creating table
        String q0= "create table if not exists customer(cid int, cname varchar(16), balance double, city varchar(10), primary key(cid))";
        int c= st.executeUpdate(q0);
        System.out.println(c);
        
        // inserting data
        String q= "insert ignore into customer values(1111, 'XYZ', 40000, 'Pune') ,(2222, 'PQR', 60000, 'Delhi')";
        int i= st.executeUpdate(q);
        
        if(i>0)
            System.out.println(i + "record(s) inserted");
        else
            System.out.println("record(s) not inserted...pls check your input");
        
        // updating data
        String q1 = "update customer set balance = "+bal+"  where cid ="+id;
        int x = st.executeUpdate(q1);
        
        if(x>0)
            System.out.println(x + "record(s) updated");
        else
            System.out.println("record(s) not updated...pls check your input");
        
        // retriving data
        String q2 = "select * from customer where balance > 30000";
        ResultSet rs = st.executeQuery(q2);
        
        System.out.println("------------------------------");
        System.out.println("cid\tcname\tbalance\tcity");
        System.out.println("----\t-----\t-------\t----");
        while(rs.next()){
        System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
        }
        System.out.println("------------------------------");

        con.close();
        st.close();
        rs.close();
     }
}