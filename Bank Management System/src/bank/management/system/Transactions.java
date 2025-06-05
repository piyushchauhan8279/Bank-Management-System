package bank.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener{
    
    
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    Transactions(String pinnumber){
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
        
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("Please Select your Transaction");
        text.setBounds(215,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        
        image.add(text);
        
        deposit=new JButton("Cash Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.setFont(new Font("Raleway",Font.BOLD,14));
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl=new JButton("Cash Withdraw");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(withdrawl);
        withdrawl.addActionListener(this);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(fastcash);
        fastcash.addActionListener(this);
        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(ministatement);
        ministatement.addActionListener(this);
        
        pinchange=new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(pinchange);
        pinchange.addActionListener(this);
        
        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(balanceenquiry);
        balanceenquiry.addActionListener(this);
        
        
        exit=new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(exit);
        exit.addActionListener(this);
     
        
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        
        else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement){
            
            new MiniStatement(pinnumber).setVisible(true);
        }
        
        
       
        
    }
    
    
    public static void main(String args[]){
        new Transactions("");
    }
    
   
}
