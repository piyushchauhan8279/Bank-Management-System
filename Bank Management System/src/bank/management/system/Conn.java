
package bank.management.system;

import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
  
    public Conn(){
        
        try{
            
            // 1.) Register driver
            
//            Class.forName(com.mysql.cj.jdbc.Driver);
            
            // 2.) create connection 
            
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","root");
            
            // 3.) create Statement 
            
            s=c.createStatement();
            
            
            
        }
        catch(Exception e){
            
            System.out.println(e);
            
        }
    }
    
    
    
}
