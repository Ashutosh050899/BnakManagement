    package bankmanagementsystem;

    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    import java.sql.SQLException;
    import java.util.Date;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.swing.*;

    public class Deposit extends JFrame implements ActionListener{

        JTextField amount;
        JButton deposit, back;
        String pinNumber;

        Deposit(String pinNumber)
        {
            this.pinNumber = pinNumber;

            setLayout(null);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0, 0, 900,900);
            add(image);

            // Deposit amount
            JLabel text  = new JLabel("Enter the amount you want to deposit");
            text.setForeground(Color.white);
            text.setFont(new Font("Raleway", Font.BOLD,16));
                text.setBounds(190,300,400,20);
            image.add(text);

             amount = new JTextField();
            amount.setFont(new Font("Raleway",Font.BOLD,22));
           amount.setBounds(175,350,320,25);
           image.add(amount);



            deposit = new JButton("DEPOSIT");
           deposit.setBounds(355,485,150,30);
           deposit.addActionListener(this);
           image.add(deposit);


            back = new JButton("BACK");
           back.setBounds(355,520,150,30);
          back.addActionListener(this);
           image.add(back);




            setSize(900,900);
            setLocation(300,0);
            setVisible(true);

        }

            @Override
        public void actionPerformed(ActionEvent e) {
        if(e.getSource()==deposit)
        {
        String number = amount.getText();
            Date date = new Date();
         if(number.equals(""))
         {
         JOptionPane.showMessageDialog(null, "Please enter an amout");
         }
         else
         {
         Conn con = new Conn();
         String query = "insert into bank values(  ' "+pinNumber+"  ', ' "+date+"  ', 'DEPOSIT ', ' "+number+"  '  )"; 

         try {
                con.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+number+" Deposited");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);

            }

         }
        }
        else if(e.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }

        }


        public static void main(String[] args) {
            new Deposit("");
        }


    }
