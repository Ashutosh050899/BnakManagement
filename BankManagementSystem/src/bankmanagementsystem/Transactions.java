package bankmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, withdraw, fastCash, miniStatement, pinChange, balance, exit;
    String pinNumber;
    
    
    Transactions(String pinNumber)
    {
        this.pinNumber = pinNumber;
        
        setLayout(null);
 
        // To insert image for the  whole frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        // To insert text on the image
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16)) ;
        image.add(text);
            
        //Buttons on the atm machine
        
        // DEPOSIT
         deposit = new JButton("DEPOSIT");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        // Withdrawal
         withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(355,415,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        // Fastcash
         fastCash = new JButton("FASTCASH");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        // Mini statement
         miniStatement = new JButton("MINI STATEMENT");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
            //PIN change
         pinChange = new JButton("PIN CHANGE");
        pinChange.setBounds(170,485,150,30);
       pinChange.addActionListener(this);
        image.add(pinChange);
        
        
//         //Balance enquiry
//         balance = new JButton("BALANCE ENQUIRY");
//        balance.setBounds(355,485,150,30);
//        balance.addActionListener(this);
//        image.add(balance);
//        
         
         //Exit button
         exit = new JButton("EXIT");
        exit.setBounds(355,485,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
                
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource()==exit)
        {
            System.exit(0);
        }
        
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        
        else if(ae.getSource()==withdraw)
        {
            setVisible(false);
            new Withdraw(pinNumber).setVisible(true);
        }
        
        else if(ae.getSource()==fastCash)
        {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
        
        else if(ae.getSource() == pinChange)
        {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }
        
        else if(ae.getSource() == balance)
        {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }
        
        else if(ae.getSource()==miniStatement)
        {
            setVisible(false);
            new MiniStatement(pinNumber);
        }

        
    }
    
    
    public static void main(String[] args) {
     new Transactions("");
    }

    
}




