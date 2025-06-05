
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener {
    
    String pinnumber;
    
    JPasswordField enterpin,reenterpin;
    JButton change,back;
    
    
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        
        
        setSize(900,900);
        setLocation(300,0);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        
        add(image);
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,280,500,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JLabel pintext=new JLabel("Enter New PIN");
        pintext.setBounds(165,330,180,25);
        pintext.setFont(new Font("System",Font.BOLD,15));
        pintext.setForeground(Color.WHITE);
        image.add(pintext);
        
        enterpin=new JPasswordField();
        enterpin.setBounds(330,330,180,25);
        enterpin.setFont(new Font("Raleway",Font.BOLD,20));
        enterpin.setBackground(Color.WHITE);
        image.add(enterpin);
        
        
        JLabel repintext=new JLabel("Re-Enter new PIN");
        repintext.setBounds(165,370,180,25);
        repintext.setFont(new Font("System",Font.BOLD,15));
        repintext.setForeground(Color.WHITE);
        image.add(repintext);
        
        reenterpin=new JPasswordField();
        reenterpin.setBounds(330,370,180,25);
        reenterpin.setFont(new Font("Raleway",Font.BOLD,20));
        reenterpin.setBackground(Color.WHITE);
        image.add(reenterpin);
        
        
        change=new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
                
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==change){
             try{
                 
             String epin=enterpin.getText();
             String repin=reenterpin.getText();
             
             if(epin.equals("") && repin.equals("")){
                 JOptionPane.showMessageDialog(null,"Please enter new PIN and then re-enter it");
             }
             else if(epin.equals("")){
                 JOptionPane.showMessageDialog(null,"Please enter new PIN ");
                 
             } 
             else if(repin.equals("")){
                 JOptionPane.showMessageDialog(null,"Please re-enter new PIN ");
                 
             }
             else if(!(epin.equals(repin))){
                 JOptionPane.showMessageDialog(null,"Entered PIN do not Matched ");
             }
             else{
                 Conn c=new Conn();
                 String query1="Update bank set pinnumber= '"+repin+"' where pinnumber ='"+pinnumber+"' ";
                 String query2="Update login set pinnumber= '"+repin+"' where pinnumber ='"+pinnumber+"' ";
                 String query3="Update signupThree set pinnumber= '"+repin+"' where pinnumber ='"+pinnumber+"' ";
                 
                 // dml cmd so use executeUpdate
                 
                 c.s.executeUpdate(query1);
                 c.s.executeUpdate(query2);
                 c.s.executeUpdate(query3);
                 
                 JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                 
                 setVisible(false);
                 new Transactions(repin).setVisible(true);
                 
                 
             }
             
             
             
             
                 
             }
             catch(Exception e){
                 System.out.println(e);
             }
             
             
             
        }
        else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);    
            
        }
    }
    
    public static void main(String args[]){
        new PinChange("");
    }
    
    
}
