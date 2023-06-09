package bankmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;


public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit, withdraw, fastCash, miniStatement, pinChange, balance, exit;
    String pinNumber;
    
    
    FastCash(String pinNumber)
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
        JLabel text = new JLabel("Please select withdraw amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16)) ;
        image.add(text);
            
        //Buttons on the atm machine
        
        // DEPOSIT
         deposit = new JButton("Rs-100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        // Withdrawal
         withdraw = new JButton("Rs-500");
        withdraw.setBounds(355,415,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        // Fastcash
         fastCash = new JButton("Rs-1000");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        // Mini statement
         miniStatement = new JButton("Rs-2000");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
            //PIN change
         pinChange = new JButton("Rs-5000");
        pinChange.setBounds(170,485,150,30);
       pinChange.addActionListener(this);
        image.add(pinChange);
        
        
         //Balance enquiry
         balance = new JButton("Rs-10000");
        balance.setBounds(355,485,150,30);
        balance.addActionListener(this);
        image.add(balance);
        
         
         //Exit button
         exit = new JButton("BACK");
        exit.setBounds(355,520,150,30);
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
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        
        else
        {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn con = new Conn();
            try{
                ResultSet rs = con.stmt.executeQuery("select * from bank where pin =  '"+pinNumber+"' "  );
                int balance =0;
                
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
                          if(ae.getSource() != exit && balance < Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                }
                
      
                
                Date date = new Date();
                String query = " insert into bank values ('"+pinNumber+"', '"+date+"', 'Withdraw', '"+amount+"') ";
                con.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs- "+amount+ "Debbited");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
                
            }
            
            catch(Exception e)
            {
                System.out.println(e);
            }
                    
        }
        
    }
    
    
    public static void main(String[] args) {
     new FastCash("");
    }

    
}
