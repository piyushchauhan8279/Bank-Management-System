
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    
    String pinnumber;
    JButton back;
    
    
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        
        
        setSize(900,900);
        setLayout(null);
        setLocation(300,0);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        int balance=0;
        Conn c=new Conn();
        try{
            String query = "select * from bank where pinnumber = '"+pinnumber+"'"; // ddl cmd :- select
                
                ResultSet rs = c.s.executeQuery(query);
                
                
                while (rs.next()) { // help in row looping 
                if (rs.getString("type").equals("Deposit")) {
                balance += Integer.parseInt(rs.getString("amount")); // Use the correct column name
                } else {
                 balance -= Integer.parseInt(rs.getString("amount"));
                }
                }
            
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
        JLabel text=new JLabel("Your Current Account Balance: "+balance);
        text.setBounds(180,300,400,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,17));
        image.add(text);
        
        
        
        setUndecorated(true);
        setVisible(true);
        
        
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
    
}
