//7. Write a program to perform jdbc batch processing - 
//    a. update customers balance (add 10000) where city is hyd and pune
//    b. Delete customers if balance is lessthan 50000
//    c & d. insert 2 customer records - 
//    e. update customers with balance with + 15000 if cid between 3000 and 7000
// * @author sachin

package Assignments;
import java.sql.*;
import java.util.Scanner;

public class BatchProcess {
    public static void main(String[] args) throws Exception {
        DBConnection dbcon= new DBConnection();
        Connection con= dbcon.getDBConnection();
        if(con != null)
            System.out.println("Connected!");
        
        con.setAutoCommit(false);
        
        Scanner sc= new Scanner(System.in);
//        System.out.println("Enter Source cid: ");
//        int scid= sc.nextInt();
//        System.out.println("Enter destination cid: ");
//        int dcid= sc.nextInt();
        System.out.println("Enter amount to add: ");
        double amt= sc.nextDouble();
        
        Statement st= con.createStatement();
        String q1= "update customer set balance= balance+ "+amt+" where city= 'hyd' or city = 'pune'";
        String q2= "delete from customer where balance< 50000";
        String q3= "insert into customer values(8888, 'LMAO', 56000, 'Patna' ), (9999, 'ROTFL', 61000, 'Gaya')";
        String q4= "update customer set balance= balance+15000 where cid between 3000 and 7000";
        
        st.addBatch(q1);
        st.addBatch(q2);
        st.addBatch(q3);
        st.addBatch(q4);
        
        st.executeBatch();
        
        con.commit();
        System.out.println("Transaction committed!");
        
        
        con.close();
        st.close();
    }
}
