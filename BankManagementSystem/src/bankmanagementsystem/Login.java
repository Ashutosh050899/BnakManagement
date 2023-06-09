package bankmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    //Buttons and text field declaration global access
    JButton login, signUp, clear;
     JTextField cardTextField;
     JPasswordField pinTextField;
    
    Login(){
        setTitle("ATM");
        setLayout(null);
        //Loading the image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        
        
        //Changing the size of the image
        Image i2 = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        //Converrting the Image type into ImageIcon type
        ImageIcon icon2 = new ImageIcon(i2);
        
        //Putting the image on the frame
        JLabel label = new JLabel(icon2 );
        //Chage the position of the icon
        
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        //Add the text in the frame
        JLabel text = new JLabel("Welcome to the ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400,40);
        add(text);
        
        JLabel cardNo = new JLabel("Card No :");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 30));
        cardNo.setBounds(120, 150, 150,40);
        add(cardNo);
        
        // Input text field
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250,30);
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 200, 400,40);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 200, 250,30);
        add(pinTextField);
        
        //Buttons
        login = new JButton("Sign In");
        login.setBounds(300,300,100,45);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("Clear");
        clear.setBounds(430,300,100,45);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
       
        signUp = new JButton("SIGN UP");
        signUp.setBounds(300,350,230,45);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);
            
        //To change the background of the frame
        getContentPane().setBackground(Color.white);
        
        //Set the size of the frame and make it visible
        setSize(800,480);
        setVisible(true);   
        setLocation(350, 200);
    }
    
    
    
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clear)
        { 
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login)
        {
         Conn con = new Conn();
         String cardNumber = cardTextField.getText();
         String pinNumber = pinTextField.getText();
         
         String query = "select * from login where cardnumber =  '"+cardNumber+"' and pin = '"+pinNumber+"' ";
         
         try{
             ResultSet rs = con.stmt.executeQuery(query);
             if(rs.next())
             {
                 setVisible(false);
                 new Transactions(pinNumber).setVisible(true);
             }
             else
             {
             JOptionPane.showMessageDialog(null, "Incorrect Credentials ");
             }
         
         
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         
        }
        else if(ae.getSource()==signUp)
        {
            setVisible(false);
            new SignupOne().setVisible(true); 
        }
    }
    
}
