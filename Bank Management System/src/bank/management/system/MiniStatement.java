
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class MiniStatement extends JFrame {
    
    MiniStatement(String pinnumber){
        
        setLocation(20,20);
        setSize(400,600);
        setVisible(true);
        setLayout(null);
        setTitle("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel bank=new JLabel("My Bank");
        bank.setBounds(150,20,100,20);
        bank.setFont(new Font("Raleway",Font.BOLD,18));
        add(bank);
        
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        setFont(new Font("Raleway",Font.BOLD,20));
        add(card);
        
        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);
        setFont(new Font("Raleway",Font.BOLD,20));
        add(mini);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,400,200,18);
        setFont(new Font("Raleway",Font.BOLD,20));
        add(balance);
        
        
        try{
            Conn c=new Conn();
            String cardquery="Select * from login where pinnumber = '"+pinnumber+"' ";
            ResultSet rs=c.s.executeQuery(cardquery);
            while(rs.next()){
                card.setText("Card Number: "+ rs.getString("cardnumber").substring(0,4)+"XXXXXXXX" + rs.getString("cardnumber").substring(12));                
            }
         
        }
        catch(Exception e){
            System.out.println(e);
            
        }
        
        try{
            Conn c=new Conn();
            String miniquery="Select * from bank where pinnumber = '"+pinnumber+"' ";
            ResultSet rs=c.s.executeQuery(miniquery);
            while(rs.next()){ 
                // setText func override but we have to append 
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br> <br> <html>");                
            }
         
        }
        catch(Exception e){
            System.out.println(e);
            
        }
        
        try{
            Conn c=new Conn();
            String query = "select * from bank where pinnumber = '"+pinnumber+"'"; // ddl cmd :- select
                int bal = 0;
                ResultSet rs = c.s.executeQuery(query);
                
                
                while (rs.next()) { // help in row looping 
                if (rs.getString("type").equals("Deposit")) {
                bal += Integer.parseInt(rs.getString("amount")); // Use the correct column name
                } else {
                 bal -= Integer.parseInt(rs.getString("amount"));
                }
                }
                
                
                balance.setText("Your Current Balance is:"+bal);
            
        }
        catch(Exception e){
            System.out.println(e);
            
        }
        
        
        
        
        
    }
    
    public static void main(String args[]){
        
        new MiniStatement("");
    }
    
}
