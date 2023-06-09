package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin, repin;
    JButton change, back;
    String pinNumber;
    
    PinChange(String pinNumber)
    {
        this.pinNumber=pinNumber;
        
        setLayout(null);
        
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);
    
    JLabel text = new JLabel("CHANGE YOUR PIN");
    text.setForeground(Color.white);
    text.setFont(new Font("Raleway", Font.BOLD,16));
    text.setBounds(250, 290,500,20);
    image.add(text);
    
        
    JLabel pinText = new JLabel("ENTER NEW PIN");
    pinText.setForeground(Color.white);
    pinText.setFont(new Font("Raleway", Font.BOLD,16));
    pinText.setBounds(165, 320,180,25);
    image.add(pinText);
    
     pin = new JPasswordField();
    pin.setFont(new Font("Raleway", Font.BOLD, 25) );
    pin.setBounds(330, 320,180,25);
    image.add(pin);
    
    JLabel rePinText = new JLabel("RE-ENTER NEW PIN");
    rePinText.setForeground(Color.white);
    rePinText.setFont(new Font("Raleway", Font.BOLD,16));
    rePinText.setBounds(165, 360,180,25);
    image.add(rePinText);
    
     repin = new JPasswordField();
    repin.setFont(new Font("Raleway", Font.BOLD, 25) );
    repin.setBounds(330, 360,180,25);
    image.add(repin);
    
    
    
     change = new JButton("CHANGE");
    change.setBounds(355,485,150,30);
    change.addActionListener(this);
    image.add(change);
    
     back = new JButton("BACK");
     back.setBounds(355,520,150,30);
   back.addActionListener(this);
     image.add( back);
       
    
    
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
                
    }
    
    
       @Override
    public void actionPerformed(ActionEvent ae) {
     
        if(ae.getSource()==change)
        {
        
    try{
        
        String npin = pin.getText();
        String rpin = repin.getText();
         
        if(!npin.equals(rpin))
        {
            JOptionPane.showMessageDialog(null, "Entered Pin is not matched");
            
        }
        
        if(npin.equals(""))
        {
        JOptionPane.showMessageDialog(null, "Please Enter Pin");
        }
        
        if(rpin.equals(""))
        {
        JOptionPane.showMessageDialog(null, "Please re-enter new pin");
        }
        
        
        Conn con =new Conn();
        String query1 = "update bank set pin  =  '"+rpin+"' where pin =  '"+pinNumber+"'  ";
        
        String query2 = "update login set pin  =  '"+rpin+"' where pin =  '"+pinNumber+"'  ";
        
        String query3 = "update signup_3  set pin_no  =  '"+rpin+"' where pin_no =  '"+pinNumber+"'  ";
        
        con.stmt.executeUpdate(query1);
       con.stmt.executeUpdate(query2);
        con.stmt.executeUpdate(query3);
        
        JOptionPane.showMessageDialog(null, "Pin changed Successfully");
        setVisible(false);
        new Transactions(rpin).setVisible(true);
    }
    
    catch(Exception e)
    {
        System.out.println(e);
    }
        }
        
        else{
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    
    
    
    public static void main(String[] args) {
    new PinChange("").setVisible(true);
    }

 
}
