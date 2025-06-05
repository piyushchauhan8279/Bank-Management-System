
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignUpTwo extends JFrame implements ActionListener {
    
    String formNo;
    
    JTextField panTF,aadharTF;
    JRadioButton scYes,scNo,eaYes,eaNo;
    JComboBox religionCB,categoryCB,incomeCB,educationCB,occupationCB;
    JButton next,back;
            
    SignUpTwo(String formNo){
        this.formNo=formNo;
        
        setSize(850,800);
        setVisible(true);
        setLayout(null);
        setLocation(350,10);
      
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel AdditionalDetails =new JLabel("Page 2 : Additional Details");
        AdditionalDetails.setBounds(290,70,400,30);
        AdditionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        add(AdditionalDetails);
        
        
        
        JLabel religion =new JLabel("Religion:");
        religion.setBounds(100,140,100,30);
        religion.setFont(new Font("Raleway",Font.BOLD,22));
        add(religion);
        

        String religionArr[]={"Hindu","Muslim","Sikh","Isai","Other"};
        religionCB=new JComboBox(religionArr);
        religionCB.setBounds(300,140,400,30);
        religionCB.setFont(new Font("Raleway",Font.BOLD,14));
        religionCB.setBackground(Color.WHITE);
        add(religionCB);
          
        
        JLabel category =new JLabel("Category:");
        category.setBounds(100,190,200,30);
        category.setFont(new Font("Raleway",Font.BOLD,22));
        add(category);
        
        String categoryArr[]={"General","OBC","ST","SC","Other"};
        categoryCB=new JComboBox(categoryArr);
        categoryCB.setBounds(300,190,400,30);
        categoryCB.setFont(new Font("Raleway",Font.BOLD,14));
        categoryCB.setBackground(Color.WHITE);
        add(categoryCB);
        
     
        JLabel income=new JLabel("Income:");
        income.setBounds(100,240,200,30);
        income.setFont(new Font("Raleway",Font.BOLD,22));
        add(income);
        
        String incomeArr[]={"Less than 2 lakh","Less than 5 lakh","Less than 10 lakh","More than 10 lakh","Null"};
        incomeCB=new JComboBox(incomeArr);
        incomeCB.setBounds(300,240,400,30);
        incomeCB.setFont(new Font("Raleway",Font.BOLD,14));
        incomeCB.setBackground(Color.WHITE);
        add(incomeCB);
        
    
        JLabel education=new JLabel("Educational");
        education.setBounds(100,290,200,30);
        education.setFont(new Font("Raleway",Font.BOLD,22));
        add(education);
        
        JLabel qualifination=new JLabel("Qualification:");
        qualifination.setBounds(100,311,200,30);
        qualifination.setFont(new Font("Raleway",Font.BOLD,22));
        add(qualifination);
        
        String educationArr[]={"Non-Graduate","Under Graduate","Post Graduate","Doctrate","Others"};
        educationCB=new JComboBox(educationArr);
        educationCB.setBounds(300,290,400,30);
        educationCB.setFont(new Font("Raleway",Font.BOLD,14));
        educationCB.setBackground(Color.WHITE);
        add(educationCB);
        
        
        JLabel Occupation=new JLabel("Occupation:");
        Occupation.setBounds(100,350,200,30);
        Occupation.setFont(new Font("Raleway",Font.BOLD,22));
        add(Occupation);
        
        
        String OccupationArr[]={"Student","Self-Employed","Bussiness","Salaried","Retired","Others"};
        occupationCB=new JComboBox(OccupationArr);
        occupationCB.setBounds(300,350,400,30);
        occupationCB.setFont(new Font("Raleway",Font.BOLD,14));
        occupationCB.setBackground(Color.WHITE);
        add(occupationCB);
        
       
        JLabel pan=new JLabel("PAN Number:");
        pan.setBounds(100,390,200,30);
        pan.setFont(new Font("Raleway",Font.BOLD,22));
        add(pan);
        
        panTF=new JTextField();
        panTF.setBounds(300,390,400,30);
        panTF.setFont(new Font("Raleway",Font.BOLD,14));
        add(panTF);
        
  
        
        JLabel aadhar=new JLabel("Aadhar Number:");
        aadhar.setBounds(100,440,200,30);
        aadhar.setFont(new Font("Raleway",Font.BOLD,22));
        add(aadhar);
        
        aadharTF=new JTextField();
        aadharTF.setBounds(300,440,400,30);
        aadharTF.setFont(new Font("Raleway",Font.BOLD,14));
        add(aadharTF);
        
        
        
        
        JLabel citizen=new JLabel("Senior Citizen:");
        citizen.setBounds(100,490,200,30);
        citizen.setFont(new Font("Raleway",Font.BOLD,22));
        add(citizen);
        
        scYes=new JRadioButton("Yes");
        scYes.setBounds(300,490,100,30);
        scYes.setBackground(Color.WHITE);
        add(scYes);
        
        scNo=new JRadioButton("No");
        scNo.setBounds(400,490,100,30);
        scNo.setBackground(Color.WHITE);
        add(scNo);
        
        
       
        ButtonGroup citizenGroup=new ButtonGroup();
        citizenGroup.add(scYes);
        citizenGroup.add(scNo);
        
        
        
        JLabel account=new JLabel("Existing Account:");
        account.setBounds(100,540,200,30);
        account.setFont(new Font("Raleway",Font.BOLD,22));
        add(account);
        
        eaYes=new JRadioButton("Yes");
        eaYes.setBounds(300,540,100,30);
        eaYes.setBackground(Color.WHITE);
        add(eaYes);
        
        eaNo=new JRadioButton("No");
        eaNo.setBounds(400,540,100,30);
        eaNo.setBackground(Color.WHITE);
        add(eaNo);
        
        
       
        ButtonGroup accountGroup=new ButtonGroup();
        accountGroup.add(eaYes);
        accountGroup.add(eaNo);
        

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
            new SignUpOne().setVisible(true);
        }
        else if(ae.getSource()==next){
            String religion=(String) religionCB.getSelectedItem();
        String category=(String)categoryCB.getSelectedItem();
        String income=(String) incomeCB.getSelectedItem();
        String education=(String) educationCB.getSelectedItem();  
        String occupation=(String) occupationCB.getSelectedItem();
        
        
        String pan=panTF.getText();
        String aadhar=aadharTF.getText();
        
        
        String citizen="";
        if(scYes.isSelected()){
            citizen="Yes";
        }
        else if(scNo.isSelected()){
            citizen="No";
        }
        
       
        String account="";
        if(eaYes.isSelected()){
            account="Yes";
        }
        else if(eaNo.isSelected()){
            account="No";
        }
        
       
        
        // Exception Handling bcoz database is an external entity
        
        try{
            // validation 
            if(pan.equals("") || aadhar.equals("")||citizen.equals("")|| account.equals("") ){
                JOptionPane.showMessageDialog(null,"Please Enter all the details");
            }
            
            else{
                Conn c=new Conn();               
                String query="insert into signuptwo values ('"+formNo+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+citizen+"','"+account+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpThree(formNo).setVisible(true);
            }
       
        }
        catch( Exception e){
            System.out.println(e);

        }
        }
        
        
            

    }
    
    public static void main(String args[]){
        new SignUpTwo("");
        
    }
    
}