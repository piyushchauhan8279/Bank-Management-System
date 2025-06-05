
package bank.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener{
    JButton withdrawl,back;
    String pinnumber;
    JTextField amount;
    Withdraw(String pinnumber){
        this.pinnumber=pinnumber;
        
        
        setSize(900,900); // frame size 
       
        setLayout(null);
        setLocation(300,0);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(199,322,300,18);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        image.add(text);
        
        
        amount =new JTextField();
        amount.setBounds(170,350,320,25);
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        image.add(amount);
        
        withdrawl=new JButton("Withdraw");
        withdrawl.setBounds(355,485,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
         if(ae.getSource()==withdrawl){
             
             String number="";
             number=""+amount.getText();
             Date date=new Date();
             int balance = 0;
             try{
                Conn c=new Conn();
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
                 System.out.print(e);
                 
             }
             
             if(number.equals("")){
                 JOptionPane.showMessageDialog(null,"Please enter amount you want to Withdraw ");
             }
             
             else if(Integer.parseInt(number)>balance){
                 JOptionPane.showMessageDialog(null,"Insufficient Balance to Withdraw");
                     
                     }
             
             
             else{
                 try{
                     
                 Conn c=new Conn();
                 String query="insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+number+"')";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"Rs."+number+" Withdraw Sucessfully");
                 setVisible(false);
                 new Transactions(pinnumber).setVisible(true);
                     
                 }
                 catch(Exception e){
                     System.out.println(e);
                 }
                 
             }
             
             
            
        }
         else if(ae.getSource()==back){
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
         }
        
    }
    
    public static void main(String args[]){
        new Withdraw("");
    }
    
}

