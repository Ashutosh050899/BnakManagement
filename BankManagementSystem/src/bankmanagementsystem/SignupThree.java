package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    
    
    SignupThree(String formno)
    {
        
        this.formno = formno;
        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details ");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);
        
        
        JLabel type = new JLabel("Account type ");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);
        
        //Savings
        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,180,20);
        add(r1);
        
        //FD
        r2 = new JRadioButton("FD Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,180,20);
        add(r2);
        
        //Current
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,180,20);
        add(r3);
        
        //Recurring
        r4 = new JRadioButton("Recurring Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,180,20);
        add(r4);
        
        //Group for only selecting one option
        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);
            
        
        //Card number
        JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);
        
        //Example of account number
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4148 ");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);
        
         JLabel cardDetail = new JLabel("Your 16 digit card number ");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBounds(100, 330, 300, 20);
        add(cardDetail);
        
        //Pin number
        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);
        
        //Example of pin number
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);
        
        
         JLabel pinDetail = new JLabel("Your 4digit pin number ");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetail.setBounds(100, 400, 300, 12);
        add(pinDetail);
        
        // For the services section
        JLabel  services = new JLabel("Services Required : ");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 300, 30);
        add(services);
        
        //Add all the checkboxes
        
        //For ATM
        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1); 
        
        //For internet banking
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2); 
        
        //For Mobile banking
        c3=new JCheckBox("Mobile banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3); 
        
        //For email alerts
        c4=new JCheckBox("Email Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4); 
        
        //For Cheque book
        c5=new JCheckBox("Cheque book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5); 
        
        //For E Statement
        c6=new JCheckBox("E Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6); 
        
        //For ATM
        c7=new JCheckBox("I Herby declare that the above entered details are correct");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,600,30);
        add(c7); 
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(220,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
       
        
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
         getContentPane().setBackground(Color.white);
    }
    
    
    public static void main(String[] args) {
        new SignupThree("") ;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource() == submit)
    {
        String accountType = null;
       if(r1.isSelected())
       {
       accountType = "Savings Account";
        }
       else if(r2.isSelected())
       {
           accountType = "FD Account";
       }
       else if(r3.isSelected())
       {
           accountType = "Current Account";
       }
       else if(r4.isSelected())
       {
       accountType="Recurring Account";
       }
       
       // To generate 16 digits card number and 4 digit pin number
        Random random = new Random();
        
        //Cardno
        String cardNumber ="" +  Math.abs((random.nextLong()%90000000L) + 5040936000000000L);
        
        //Pin number
        String pinNumber = ""+Math.abs((random.nextLong() %9000L)+ 1000L);
        
        
        //Facilities for multiple checkbox
        String facility = "";
        if(c1.isSelected())
        {
        facility = facility+" ATM Card";
        }
        
        else if(c2.isSelected())
        {
        facility = facility+" Internet banking"; 
        }
        
        else if(c3.isSelected())
        {
        facility = facility+" Mobile banking"; 
        }
        
        else if(c4.isSelected())
        {
        facility = facility+" Email alert"; 
        }
        
        else if(c5.isSelected())
        {
        facility = facility+" Cheque book"; 
        }
        
        else if(c6.isSelected())
        {
        facility = facility+" E Statement"; 
        }
        
        
        
        try{
            if(accountType.equals(""))
            {
                JOptionPane.showMessageDialog(null, "account Type is required");
            }
            else
            {
                Conn con = new Conn();
                String query1 = "insert into signup_3 values('"+formno+"', '"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                String query2 = "insert into login values('"+formno+"', '"+cardNumber+"','"+pinNumber+"')";
                con.stmt.executeUpdate(query1);
                con.stmt.executeUpdate(query2);
                
                // To show the user the card number and pin
                JOptionPane.showMessageDialog(null, "Card Number: "+ cardNumber+ "\n Pin: "+pinNumber);
                
                setVisible(false);
                new Deposit(pinNumber).setVisible(true);
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
  
    }
    
    else if(ae.getSource() == cancel)
    {
        setVisible(false);
        new Login();
    }
    }
}
