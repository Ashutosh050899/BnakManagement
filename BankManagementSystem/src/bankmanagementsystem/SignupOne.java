package bankmanagementsystem;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class SignupOne extends JFrame implements ActionListener{
    
    Long random;
    
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;
    
    SignupOne()
    {
        setLayout(null);
        
        Random ran = new Random();
        random = ran.nextLong()%9000L + 1000L;
        
        JLabel formno=new JLabel("Application Form no :"+ random);
        formno.setFont(new Font("Raleway",Font.BOLD, 38));
        formno.setBounds(140,20,600,40 );
        add(formno);
        
        
        JLabel personalDetails=new JLabel("Page1: Personal details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD, 22));
        personalDetails.setBounds(290,80,400,30 );
        add(personalDetails);
        
        //Name
        JLabel name=new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD, 20));
        name.setBounds(100,140,100,30 );
        add(name);
       
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300,140 ,400,30 );
        add(nameTextField);
        
        // Fathers name
        JLabel fname=new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway",Font.BOLD, 20));
        fname.setBounds(100,190,200,30 );
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300,190 ,400,30 );
        add(fnameTextField);
        
        // DOB
        JLabel dob=new JLabel("Birth Date: ");
        dob.setFont(new Font("Raleway",Font.BOLD, 20));
        dob.setBounds(100,240 ,200,30 );
        add(dob);
        //For date input
         dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(Color.black);
        add(dateChooser);
        
        
        //GENDER
        JLabel gender=new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD, 20));
        gender.setBounds(100,290 ,200,30 );
        add(gender);
        //for radio 
         male = new JRadioButton("MALE");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
         female = new JRadioButton("FEMALE");
        female.setBounds(450,290,80,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        // To select only one for the radio
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        
        //EMAIL
        JLabel email=new JLabel("Email Address: ");
        email.setFont(new Font("Raleway",Font.BOLD, 20));
        email.setBounds(100,340 ,200,30 );
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300,340 ,400,30 );
        add(emailTextField);
        
        //MARITAIL
        JLabel maritial=new JLabel("Maritial Status: ");
        maritial.setFont(new Font("Raleway",Font.BOLD, 20));
        maritial.setBounds(100,390 ,200,30 );
        add(maritial);
        
         married = new JRadioButton("MARRIED");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
         unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
         other = new JRadioButton("OTHER");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        // To select only one for the radio
        ButtonGroup maritailGroup = new ButtonGroup();
        maritailGroup.add(married);
        maritailGroup.add(unmarried);
        maritailGroup.add(other);
        
        
        //ADDRESS
        JLabel address=new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD, 20));
        address.setBounds(100,440 ,200,30 );
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300,440 ,400,30 );
        add(addressTextField);
        
        //CITY
        JLabel city=new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD, 20));
        city.setBounds(100,490 ,200,30 );
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300,490 ,400,30 );
        add(cityTextField);
        
        //STATE
        JLabel state=new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD, 20));
        state.setBounds(100,540 ,200,30 );
        add(state);
        
         stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300,540 ,400,30 );
        add(stateTextField);
        
        //PINCODE
        JLabel pincode=new JLabel("Pincode: ");
        pincode.setFont(new Font("Raleway",Font.BOLD, 20));
        pincode.setBounds(100,590 ,200,30 );
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300,590 ,400,30 );
        add(pincodeTextField);
        
         next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620, 660, 80,30 );
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new SignupOne();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno =""+ random;
        String name = nameTextField.getText(); 
        String fName = fnameTextField.getText();
         String email = emailTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();// for the date
        String gender = null;
        if(male.isSelected())
        {
            gender="Male";
        }
        else if(female.isSelected())
        {
            gender = "Female";
        }
        
       
        String marital = null;
        if(married.isSelected())
        {
        marital = "Married";
        }
        else if(unmarried.isSelected())
        {
        marital = "Unmarried";
        }
        else if(other.isSelected())
        {
        marital = "Other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();
        
        try{
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else
            {
                Conn c = new Conn();
                String query  = "insert into signup1 values(' "+formno+" ',' "+name+" ',' "+fName+" ',' "+dob+" ',' "+gender+" ',' "+email+" ',' "+marital+" ', ' "+address+" ',' "+city+" ',' "+state+" ',' "+pin+" '  )";
                c.stmt.executeUpdate(query);
                
                setVisible(false);
                new SignUp2(formno).setVisible(true);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
            
        
    }
}











