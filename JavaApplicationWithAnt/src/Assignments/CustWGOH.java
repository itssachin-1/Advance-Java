/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * @author sachin
 * 10. Program to demonstrate where, group by, order by, havaing with customers table
    ( find customers groug by city and provide details)
    ( find rich customer group by city) 
    ( Use aggregate functions)
 **/

package Assignments;
import java.sql.*;

public class CustWGOH {
    public static void main(String[] args) throws Exception {
        DBConnection dbcon = new DBConnection(); // class - getDBConnection()
        Statement st;
        ResultSet rs, rs1, rs2;
        try (Connection con = dbcon.getDBConnection()) {
            if(con != null)
                System.out.println("Connected!!");
            
            st = con.createStatement();
            
            String q= "SELECT count(*), city FROM customer GROUP BY city";
            String q1= "SELECT max(balance), city, count(*) FROM customer GROUP BY city having count(*)>0 order by max(balance) desc";
            String q2= "SELECT count(*), min(balance), max(balance), sum(balance) FROM customer";
//            
            rs = st.executeQuery(q);
            System.out.println("SELECT count(*), city FROM customer GROUP BY city;");
            System.out.println("+-----------------+");
            System.out.println("count\tcity");
            System.out.println("----\t-------");
            
            while(rs.next()){
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
            }   System.out.println("+-----------------+");
//            
            rs1 = st.executeQuery(q1);
            System.out.println("\nSELECT max(balance), city, count(*) FROM customer GROUP BY city having count(*)>0 order by max(balance) desc;");
            System.out.println("+-----------------------------------+");
            System.out.println("max_balance\tcity\t\tcount");
            System.out.println("-----\t\t-------\t\t-----");
            
            while(rs1.next()){
                System.out.println(rs1.getDouble(1)+"\t\t"+rs1.getString(2)+"\t\t"+rs1.getInt(3));
            }   System.out.println("+-----------------------------------+");
            
            rs2 = st.executeQuery(q2);
            System.out.println("\nSELECT count(*), min(balance), max(balance), sum(balance) FROM customer;");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("row_count\tmin_balance\tmax_balance\tsum_balance");
            System.out.println("----\t\t--------\t--------\t--------");
            
            while(rs2.next()){
                System.out.println(rs2.getInt(1)+"\t\t"+rs2.getDouble(1)+"\t\t"+rs2.getDouble(1)+"\t\t"+rs2.getDouble(2));
            }   System.out.println("+----------------------------------------------------------+");
        }
        
        st.close();
        rs1.close();
    }
}
