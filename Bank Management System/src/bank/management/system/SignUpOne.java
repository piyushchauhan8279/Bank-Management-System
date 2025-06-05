
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;
public class SignUpOne extends JFrame implements ActionListener {
    
    
    long random;
    JTextField nameTF, fnameTF,emailTF,addressTF,stateTF,cityTF,pinCodeTF;
    JDateChooser jdc;
    JRadioButton male,female,married,unmarried,other;
    JButton next,back;
            
    SignUpOne(){
        
        
        setSize(850,800);
        setVisible(true);
        setLayout(null);
        setLocation(350,10);
      
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
        getContentPane().setBackground(Color.WHITE);
        
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel formNo =new JLabel("Application Form No. "+random);
        formNo.setBounds(180,20,600,40);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        add(formNo);
        
        
        JLabel personalDetails =new JLabel("Page 1: Personal Details");
        personalDetails.setBounds(290,80,400,30);
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        add(personalDetails);
        
        
        
        JLabel name =new JLabel("Name:");
        name.setBounds(100,140,100,30);
        name.setFont(new Font("Raleway",Font.BOLD,22));
        add(name);
        
        nameTF=new JTextField();
        nameTF.setBounds(300,140,400,30);
        nameTF.setFont(new Font("Raleway",Font.BOLD,14));
        add(nameTF);
        
        JLabel fname =new JLabel("Father's Name:");
        fname.setBounds(100,190,200,30);
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        add(fname);
        
        fnameTF=new JTextField();
        fnameTF.setBounds(300,190,400,30);
        fnameTF.setFont(new Font("Raleway",Font.BOLD,14));
        add(fnameTF);
        
        
        JLabel dob=new JLabel("Date of Birth:");
        dob.setBounds(100,240,200,30);
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        add(dob);
        
        jdc=new JDateChooser();
        jdc.setBounds(300,240,400,30);
        jdc.setForeground(new Color(105,105,105));
        add(jdc);
        
        
        
        JLabel Email=new JLabel("Email Id:");
        Email.setBounds(100,290,200,30);
        Email.setFont(new Font("Raleway",Font.BOLD,22));
        add(Email);
        
        emailTF=new JTextField();
        emailTF.setBounds(300,290,400,30);
        emailTF.setFont(new Font("Raleway",Font.BOLD,14));
        add(emailTF);
        
        
        JLabel gender=new JLabel("Gender:");
        gender.setBounds(100,340,200,30);
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        add(gender);
        
        
        male=new JRadioButton("Male");
        male.setBounds(300,340,100,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(400,340,100,30);
        female.setBackground(Color.WHITE);
        add(female);
       
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        
        JLabel marital=new JLabel("Marital Status:");
        marital.setBounds(100,390,200,30);
        marital.setFont(new Font("Raleway",Font.BOLD,22));
        add(marital);
        
        
        married=new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(400,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other=new JRadioButton("Other");
        other.setBounds(500,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);

       
       ButtonGroup maritalGroup=new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);
                
        
        
        JLabel address=new JLabel("Address:");
        address.setBounds(100,440,200,30);
        address.setFont(new Font("Raleway",Font.BOLD,22));
        add(address);
        
        addressTF=new JTextField();
        addressTF.setBounds(300,440,400,30);
        addressTF.setFont(new Font("Raleway",Font.BOLD,14));
        add(addressTF);
        
        
        JLabel city=new JLabel("City:");
        city.setBounds(100,490,200,30);
        city.setFont(new Font("Raleway",Font.BOLD,22));
        add(city);
        
        cityTF=new JTextField();
        cityTF.setBounds(300,490,400,30);
        cityTF.setFont(new Font("Raleway",Font.BOLD,14));
        add(cityTF);
        
        JLabel state=new JLabel("State:");
        state.setBounds(100,540,200,30);
        state.setFont(new Font("Raleway",Font.BOLD,22));
        add(state);
        
        stateTF=new JTextField();
        stateTF.setBounds(300,540,400,30);
        stateTF.setFont(new Font("Raleway",Font.BOLD,14));
        add(stateTF);
        
        JLabel pinCode=new JLabel("PIN Code:");
        pinCode.setBounds(100,590,200,30);
        pinCode.setFont(new Font("Raleway",Font.BOLD,22));
        add(pinCode);
        
        pinCodeTF=new JTextField();
        pinCodeTF.setBounds(300,590,400,30);
        pinCodeTF.setFont(new Font("Raleway",Font.BOLD,14));
        add(pinCodeTF);
        
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setBounds(600,640,80,30);
        next.addActionListener(this);
        add(next);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway",Font.BOLD,18));
        back.setBounds(100,640,80,30);
        back.addActionListener(this);
        add(back);
                
              
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Login().setVisible(true);
        }
        else if(ae.getSource()==next){
        String formNo=""+random;
        String name=nameTF.getText();
        String fname=fnameTF.getText();
        String dob = ((JTextField) jdc.getDateEditor().getUiComponent()).getText();
        String gender="";
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender="Female";
        }
        
        String email=emailTF.getText();
        
        String marital="";
        if(married.isSelected()){
            marital="Married";
        }
        else if(unmarried.isSelected()){
            marital="Unmarried";
        }
        else if(other.isSelected()){
            marital="Other";
        }
        String address=addressTF.getText();
        String city=cityTF.getText();
        String state=stateTF.getText();
        String pinCode=pinCodeTF.getText();
        
        
        // Exception Handling since database is an external entity
        
        try{
            // validation 
            
            
            
            
            if(name.equals("")||fname.equals("")||dob.equals("")||email.equals("")||gender.equals("")||marital.equals("")||address.equals("")
                    ||city.equals("")||state.equals("")||pinCode.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter all the details");
                
            }
            else{
                Conn c=new Conn();
                
                String query="insert into signup values ('"+formNo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pinCode+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignUpTwo(formNo).setVisible(true);
            }
                    
                
        }
        catch( Exception e){
            System.out.println(e);

        }
        }
            
        
    }
    
    public static void main(String args[]){
        new SignUpOne();
        
    }
    
}
