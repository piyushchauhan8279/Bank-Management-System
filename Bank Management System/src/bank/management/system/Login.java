
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton signUp,signIn,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        
        setSize(800,480);  // length and breadth of frame 
        setVisible(true);
        
        setLayout(null);
        
        setLocation(350,200); // left,right location 
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));



        Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(120,10,100,100); // 100,100 is img height and width
        
        add(label);
        
        
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Raleway",Font.BOLD,38));
        text.setBounds(250,40,400,40);
        add(text);
        
        JLabel cardNo=new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway",Font.BOLD,28));
        cardNo.setBounds(120,150,150,30);
        add(cardNo);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        add(cardTextField);
        
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,400,40);
        add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);
        
        signIn=new JButton("Sign In");
        signIn.setBounds(300, 350, 100,30);
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        add(signIn);
        signIn.addActionListener(this);
        
        clear=new JButton("Clear");
        clear.setBounds(430, 350, 100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        clear.addActionListener(this);
        
        signUp=new JButton("Sign Up");
        signUp.setBounds(300, 400, 230,30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        add(signUp);
        signUp.addActionListener(this);
        
             
              
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
            
        }
        else if(ae.getSource()==signIn){
            Conn c=new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            
           
            // ddl command :- select 
            String query="select * from login where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
            
            // query execution 
            
            try{
                // ResultSet Class Obj
                
                ResultSet rs=c.s.executeQuery(query); // ddl cmd hence execute query 
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else if(cardnumber.equals("") || pinnumber.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter your Card Number and PIN");
            }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Card Number or PIN");
                }
                
                
            }
            catch(Exception e){
                System.out.println(e);
                
            }
        }
        else if(ae.getSource()==signUp){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
        
}
    public static void main(String args[]){
        new Login();
                
       
    }
}
