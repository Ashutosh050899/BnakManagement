package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{

    
    JButton back;
    String pinNumber;
    
    BalanceEnquiry(String pinNumber)
    {
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        
        image.setBounds(0, 0,900,900);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back); 
        
        
         // to display the balance
        
         Conn con = new Conn();
               int balance = 0;
         
         try{
             ResultSet rs = con.stmt.executeQuery("select * from bank where pin =  '"+pinNumber+"' ");
       
             
             while(rs.next())
             {
                if(rs.getString("type").equals("DEPOSIT "))
                {
                   balance += Integer.parseInt( rs.getString("amount")); 
                }
                
                else
                {
                balance-= Integer.parseInt(rs.getString("amount"));
                }
             }
         }
         
         catch(Exception e)
         {
             System.out.println(e);
         }
         
        JLabel text = new JLabel("Your currennt account balance is : ");
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        text.setBounds(170,300,400,30);
        image.add(text);
        
        JLabel textBalance = new JLabel(""+balance);
        textBalance.setForeground(Color.white);
        textBalance.setFont(new Font("Raleway",Font.BOLD,25));
        textBalance.setBounds(300,350,400,30);
        image.add(textBalance);
        
        setSize(900,900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
           
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinNumber);
    }
    
    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }

    
    
}