package bankmanagementsystem;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class SignUp2 extends JFrame implements ActionListener{
    
    Long random;
    
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income, education, occupation;
    String formno;
    
    SignUp2(String formno)
    {
        this.formno = formno;
        setLayout(null);
         
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE : 2");
        
        
        
        JLabel additionalDetails=new JLabel("Page2: Additional details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30 );
        add(additionalDetails);
        
        //Religion
        JLabel name=new JLabel("Religion: ");
        name.setFont(new Font("Raleway",Font.BOLD, 20));
        name.setBounds(100,140,100,30 );
        add(name);
        
        //For dropdown
        String religionarr[] = {"--select--","Christian", "Hindu", "Muslim", "Sikh", "Other"};
         religion = new JComboBox(religionarr); 
        religion.setBounds(300,140 ,400,30 );
        religion.setBackground(Color.WHITE);
        add(religion);
       
        
        // Category
        JLabel fname=new JLabel("Category: ");
        fname.setFont(new Font("Raleway",Font.BOLD, 20));
        fname.setBounds(100,190,200,30 );
        add(fname);
        
        
        String categoryArr[] = {"--select--","Open", "OBC", "SC", "ST", "Other"};
         category = new JComboBox(categoryArr); 
        category.setBounds(300,190 ,400,30 );
        category.setBackground(Color.WHITE);
        add(category);
       
        
        
        
        //Income
        JLabel dob=new JLabel("Income: ");
        dob.setFont(new Font("Raleway",Font.BOLD, 20));
        dob.setBounds(100,240 ,200,30 );
        add(dob);
        
        String incomeArr[] = {"--select--","<2 lakhs", "2-5 lakhs", "5-10 lakhs", "10-20 lakhs", "> 20 lakhs"};
         income = new JComboBox(incomeArr); 
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
       
        
        
        
        //Education
        JLabel gender=new JLabel("Educational  ");
        gender.setFont(new Font("Raleway",Font.BOLD, 20));
        gender.setBounds(100,290 ,200,30 );
        add(gender);
        
        
        //Qualification
        JLabel email=new JLabel("Qualification: ");
        email.setFont(new Font("Raleway",Font.BOLD, 20));
        email.setBounds(100,315 ,200,30 );
        add(email);
        
        
        String educationArr[] = {"--select--","Non Graduate", "Graduation", "Post graduation", "Doctorate", "Others"};
         education = new JComboBox(educationArr); 
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
       
        
       
        
        //Occupation
        JLabel maritial=new JLabel("Occupation: ");
        maritial.setFont(new Font("Raleway",Font.BOLD, 20));
        maritial.setBounds(100,390 ,200,30 );
        add(maritial);
        
        
        
        String occupationArr[] = {"--select--","Salaried", "Self-employed", "Bussinessman", "Student", "Retired", "Others"};
         occupation = new JComboBox(occupationArr);  
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        
        
        //Pan number
        JLabel address=new JLabel("Pan number: ");
        address.setFont(new Font("Raleway",Font.BOLD, 20));
        address.setBounds(100,440 ,200,30 );
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300,440 ,400,30 );
        add(pan);
        
        //Aadhar
        JLabel city=new JLabel("Aadhar number: ");
        city.setFont(new Font("Raleway",Font.BOLD, 20));
        city.setBounds(100,490 ,200,30 );
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300,490 ,400,30 );
        add(aadhar);
        
        //Senior citizen
        JLabel state=new JLabel("Senior citizen: ");
        state.setFont(new Font("Raleway",Font.BOLD, 20));
        state.setBounds(100,540 ,200,30 );
        add(state);
        
        syes = new JRadioButton("YES");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
         sno = new JRadioButton("NO");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
         // To select only one for the radio
        ButtonGroup maritailGroup = new ButtonGroup();
        maritailGroup.add(syes);
        maritailGroup.add(sno);


        
         
        //Existing account
        JLabel pincode=new JLabel("Existing account: ");
        pincode.setFont(new Font("Raleway",Font.BOLD, 20));
        pincode.setBounds(100,590 ,200,30 );
        add(pincode);
        
        eyes = new JRadioButton("YES");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
         eno = new JRadioButton("NO");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
         // To select only one for the radio
        ButtonGroup emaritailGroup = new ButtonGroup();
        emaritailGroup.add(eyes);
        emaritailGroup.add(eno);

        
    
        
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
        new SignUp2("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String sreligion = (String) religion.getSelectedItem();  
        String scategory = (String)category.getSelectedItem();
         String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
       String seniorcitizen = null;
        if(syes.isSelected())
        {
            seniorcitizen="Yes";
        }
        else if(sno.isSelected())
        {
          seniorcitizen = "No";
        }
        
       
        String existingaccount= null;
        if(eyes.isSelected())
        {
        existingaccount = "Yes";
        }
        else if(eno.isSelected())
        {
        existingaccount = "No";
        }
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        try{
            Conn c = new Conn();
                String query  = "insert into signupTwo values(' "+formno+" ',' "+sreligion+" ',' "+scategory+" ',' "+sincome+" ',' "+seducation+" ',' "+soccupation+" ',' "+seniorcitizen+" ', ' "+existingaccount+" ',' "+span+" ',' "+saadhar+" ' )";
                c.stmt.executeUpdate(query);
                    //Object of Signup 3
                    setVisible(false);
                    new SignupThree(formno).setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
            
        
    }
}











