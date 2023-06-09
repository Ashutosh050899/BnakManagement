package bankmanagementsystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class MiniStatement extends JFrame implements ActionListener{
    JButton back;
    String pinNUmber;
    
    MiniStatement(String pinNumber)
    {
        this.pinNUmber=pinNumber;
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
            JLabel mini = new JLabel();
        add(mini); 
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
       
        try{
        Conn con  = new Conn();
        ResultSet rs = con.stmt.executeQuery("select * from login where pin = '"+pinNumber+"' ");
        while(rs.next())
        {
            card.setText("Card number: "+ rs.getString("cardnumber").substring(0,4)+"xxxxxxxx"+ rs.getString("cardnumber").substring(12));
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        try{
        Conn con = new Conn();
        ResultSet rs = con.stmt.executeQuery("Select * from bank where pin = '"+pinNumber+"' ");
        
        while(rs.next())
        {
            mini.setText(mini.getText() + "<html>"+ rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br></html>");
        }
                
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        mini.setBounds(20,140,400,200);
        
        
        back = new JButton("Back");
        back.setBounds(200,400,150,30);
       
        back.addActionListener(this);
        add(back); 
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new MiniStatement("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   
        setVisible(false);
        new Transactions(pinNUmber);
    }
}
