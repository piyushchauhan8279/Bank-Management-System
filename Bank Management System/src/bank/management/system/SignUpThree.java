package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
public class SignUpThree  extends JFrame implements ActionListener{
    
    JButton submit,cancel;
    JCheckBox atmcard,mobilebanking,internetbanking,alerts,chequebook,estatement,declare ;
    JRadioButton savingaccount,fdaccount,currentaccount,rdaccount;
    String formNo;
    SignUpThree(String formNo){
        this.formNo=formNo;
        
        
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        
        setSize(850,820);
        setLayout(null);
        setVisible(true);
        setLocation(350,10);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel accountdetails=new JLabel("Page 3: Account Details");
        accountdetails.setFont(new Font("Raleway",Font.BOLD,22));    
        accountdetails.setBounds(280,40,400,40);
        add(accountdetails);
        
        JLabel accounttype=new JLabel("Account Type:");
        accounttype.setFont(new Font("Raleway",Font.BOLD,22));    
        accounttype.setBounds(100,140,200,30);
        add(accounttype);
        
        
        savingaccount=new JRadioButton("Saving Account");
        savingaccount.setBounds(100,180,150,20);
        savingaccount.setFont(new Font("Raleway",Font.BOLD,16));
        savingaccount.setBackground(Color.WHITE);
        add(savingaccount);
        
        fdaccount=new JRadioButton("Fixed Deposit Account");
        fdaccount.setBounds(350,180,250,20);
        fdaccount.setFont(new Font("Raleway",Font.BOLD,16));
        fdaccount.setBackground(Color.WHITE);
        add(fdaccount);
        
        currentaccount=new JRadioButton("Current Account");
        currentaccount.setBounds(100,220,150,20);
        currentaccount.setFont(new Font("Raleway",Font.BOLD,16));
        currentaccount.setBackground(Color.WHITE);
        add(currentaccount);
        
        rdaccount=new JRadioButton("Reccuring Deposit Account");
        rdaccount.setBounds(350,220,250,20);
        rdaccount.setFont(new Font("Raleway",Font.BOLD,16));
        rdaccount.setBackground(Color.WHITE);
        add(rdaccount);
        
        ButtonGroup accounttypegroup=new ButtonGroup();
        accounttypegroup.add(savingaccount);
        accounttypegroup.add(fdaccount);
        accounttypegroup.add(currentaccount);
        accounttypegroup.add(rdaccount);
        
        
        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));    
        card.setBounds(100,260,200,30);
        add(card);
        
        JLabel carddetail=new JLabel("(Your 16 Digits Card Number)");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));    
        carddetail.setBounds(100,290,300,15);
        add(carddetail);
        
        
        JLabel cardnumber=new JLabel("XXXX-XXXX-XXXX-4545");
        cardnumber.setFont(new Font("Raleway",Font.BOLD,22));    
        cardnumber.setBounds(350,260,350,30);
        add(cardnumber);
        
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));    
        pin.setBounds(100,330,200,30);
        add(pin);
        
        JLabel pindetail=new JLabel("(Your PIN)");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));    
        pindetail.setBounds(100,360,200,15);
        add(pindetail);
        
        
        JLabel pinnumber=new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway",Font.BOLD,22));    
        pinnumber.setBounds(350,330,200,30);
        add(pinnumber);
        
        
        JLabel service=new JLabel("Services Required:");
        service.setFont(new Font("Raleway",Font.BOLD,22));    
        service.setBounds(100,400,300,30);
        add(service);
        
        
        atmcard=new JCheckBox("ATM Card");
        atmcard.setBounds(100,440,200,30);
        atmcard.setFont(new Font("Raleway",Font.BOLD,16));
        atmcard.setBackground(Color.WHITE);
        add(atmcard);
        
        internetbanking=new JCheckBox("Internet Banking");
        internetbanking.setBounds(350,440,200,30);
        internetbanking.setFont(new Font("Raleway",Font.BOLD,16));
        internetbanking.setBackground(Color.WHITE);
        add(internetbanking);
        
        mobilebanking=new JCheckBox("Mobile Banking");
        mobilebanking.setBounds(100,490,200,30);
        mobilebanking.setFont(new Font("Raleway",Font.BOLD,16));
        mobilebanking.setBackground(Color.WHITE);
        add(mobilebanking);
        
        alerts=new JCheckBox("Email & SMS Alerts");
        alerts.setBounds(350,490,200,30);
        alerts.setFont(new Font("Raleway",Font.BOLD,16));
        alerts.setBackground(Color.WHITE);
        add(alerts);
        
        chequebook=new JCheckBox("Cheque Book");
        chequebook.setBounds(100,540,200,30);
        chequebook.setFont(new Font("Raleway",Font.BOLD,16));
        chequebook.setBackground(Color.WHITE);
        add(chequebook);
        
        estatement=new JCheckBox("E-Statement");
        estatement.setBounds(350,540,200,30);
        estatement.setFont(new Font("Raleway",Font.BOLD,16));
        estatement.setBackground(Color.WHITE);
        add(estatement);
        
        declare=new JCheckBox("I here by declares that the above entered details are correct to the best of my knowledge");
        declare.setBounds(100,620,600,18);
        declare.setFont(new Font("Raleway",Font.BOLD,12));
        declare.setBackground(Color.WHITE);
        add(declare);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,12));
        submit.setBounds(280,680,100,30);
        add(submit);
        submit.addActionListener(this);
        
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,12));
        cancel.setBounds(420,680,100,30);
        add(cancel);
        cancel.addActionListener(this);
        
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accounttype="";
            if(savingaccount.isSelected()){
                accounttype="Saving Account";
            }
            else if(fdaccount.isSelected()){
                accounttype="Fixed Deposit Account";
            }
            else if(currentaccount.isSelected()){
                accounttype="Current Account";
            }
            else if(rdaccount.isSelected()){
                accounttype="Reccuring Deposit Account";
            }
            
            Random random=new Random();
            String cardnumber=""+ Math.abs((random.nextLong()%90000000L)+5040936000000000L);
            String pinnumber=""+ Math.abs((random.nextLong()%9000L)+1000L);
            
            String service="";
            
            if(atmcard.isSelected()){
                service+="ATM Card";
            }
            if(mobilebanking.isSelected()){
                service+=" Mobile Banking";
            }
            if(internetbanking.isSelected()){
                service+=" Internet Banking";
            }
            
            if(alerts.isSelected()){
                service+=" Emails and SMS Alerts";
            }
            if(chequebook.isSelected()){
                service+=" Cheque Book";
            }
            if(estatement.isSelected()){
                service+=" E-Statement";
            }
            
            try{
                // validation 
                if(accounttype.equals("") || service.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter all the details");
                }
                
                else if(!(declare.isSelected())){
                    JOptionPane.showMessageDialog(null,"Select the last CheckBox to Ensure that all the entered details are correct");
                }
                else{
                    Conn c=new Conn();
                    String query1="insert into signupThree values('"+formNo+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+service+"')";
                    c.s.executeUpdate(query1);
                    
                    
                    JOptionPane.showMessageDialog(null,"Your Card No. is "+cardnumber+"\nYour PIN is "+pinnumber);
                    
                    String query2="insert into login values('"+formNo+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query2);
                    
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                    
                }
                
            }
            catch(Exception e){
                System.out.println(e);
                
            }
          
        }
        else if(ae.getSource()==cancel){
             setVisible(false);
             new Login().setVisible(true);
            
        }
        
    }
    
    public static void main(String args[]){
        new SignUpThree("");
    }
    
    
    
}
