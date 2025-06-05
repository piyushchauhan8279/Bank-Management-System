package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
    
    
    JButton hundred,fivehundred,thousand,twothousand,fivethousand,tenthousand,back;
    String pinnumber;
    
    FastCash(String pinnumber){
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
        
        
        JLabel text=new JLabel("Please Select Withdrawl Account");
        text.setBounds(215,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        
        image.add(text);
        
        hundred=new JButton("Rs 100");
        hundred.setBounds(170,415,150,30);
        hundred.setFont(new Font("Raleway",Font.BOLD,14));
        hundred.addActionListener(this);
        image.add(hundred);
        
        fivehundred=new JButton("Rs 500");
        fivehundred.setBounds(355,415,150,30);
        fivehundred.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(fivehundred);
        fivehundred.addActionListener(this);
        
        thousand=new JButton("Rs 1000");
        thousand.setBounds(170,450,150,30);
        thousand.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(thousand);
        thousand.addActionListener(this);
        
        twothousand=new JButton("Rs 2000");
        twothousand.setBounds(355,450,150,30);
        twothousand.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(twothousand);
        twothousand.addActionListener(this);
        
        fivethousand=new JButton("Rs 5000");
        fivethousand.setBounds(170,485,150,30);
        fivethousand.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(fivethousand);
        fivethousand.addActionListener(this);
        
        tenthousand=new JButton("Rs 10000");
        tenthousand.setBounds(355,485,150,30);
        tenthousand.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(tenthousand);
        tenthousand.addActionListener(this);
        
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(back);
        back.addActionListener(this);
     
        
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else if(ae.getSource()!=back){
            String amount=((JButton)ae.getSource()).getText().substring(3);
           
            Conn c=new Conn();
            try{
                
                String query = "select * from bank where pinnumber = '"+pinnumber+"'"; // ddl cmd :- select
                int balance = 0;
                ResultSet rs = c.s.executeQuery(query);
                
                
                while (rs.next()) { // help in row looping 
                if (rs.getString("type").equals("Deposit")) {
                balance += Integer.parseInt(rs.getString("amount")); // Use the correct column name
                } else {
                 balance -= Integer.parseInt(rs.getString("amount"));
                }
                }
             
                
                // check if balance is less than the entered ammount 
                if(ae.getSource()!= back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance to Withdraw");
                    return;
                    
                }
                 
                Date date=new Date();
                
                String query2="insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Rs"+amount+"Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
                
            }
            
        }
        
    }
    
    
    public static void main(String args[]){
        new FastCash("");
    }
    
   
}