package Banking_management_system;

import javax.swing.*; //swing - comes from extended java package thats why we have inherited it in login class
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {//jframe is a class name

    JButton login , signup , clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    login() {



        setTitle("Automated banking management system");//give title to the jframe
        setLayout(null);//we have to set it to null otherwise it will give bydefault position to the icons which is center
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));//for placing the images in the frame and converting the image to a icon
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);//set the size of the icon
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);//creating an object and calling the
        label.setBounds(70,10,100,100);//to set custom dimensions
        add(label);

        JLabel text = new JLabel("Welcome to ATM");//we use the jlabel to write the text on the frame
        text.setFont(new Font("Osward" , Font.BOLD,38));
        add(text);
        text.setBounds(200,40,400,40);//to set the bounds of the text(left, up, height, width)

        JLabel cardNo = new JLabel("Card No:");//we use the jlabel to write the text on the frame
        cardNo.setFont(new Font("Raleway" , Font.BOLD,28));
        add(cardNo);
        cardNo.setBounds(120,150,150,30);//to set the bounds of the text

        JLabel pin = new JLabel("PIN:");//we use the jlabel to write the text on the frame
        pin.setFont(new Font("Raleway" , Font.BOLD,28));
        add(pin);
        pin.setBounds(120,220,250,30);//to set the bounds of the text

        cardTextField = new JTextField();//textfield of card number
        cardTextField.setBounds(300 , 150 , 230 , 30);
        cardTextField.setFont(new Font("Arial" , Font.BOLD , 14));
        add(cardTextField);

        pinTextField = new JPasswordField();//textfield of card number
        pinTextField.setBounds(300 , 220 , 230 , 30);
        pinTextField.setFont(new Font("Arial" , Font.BOLD , 14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);//to set the size of the window
        setVisible(true);//by default frame visbliity is false and if its false we cant see the window
        setLocation(450,200);//to set the location of a frame suppose in the middle or in the right , by default opens in top left corner if we cant use it


    }

    public void actionPerformed(ActionEvent ae) {
        //Object login;
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if (ae.getSource() == login) {
            conn conn = new conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '" + cardnumber + "' and pin = '" + pinnumber + "'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) { //execute when rs have some value
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }
            }catch(Exception e)  {
                System.out.println(e);
            }

        }
        else if (ae.getSource() == signup){
            setVisible(false);//helps to destroy the login frame when we click the signup button it will destroy the login framw
            new signupone().setVisible(true);//calling the application form frame
        }
    }


    public static void main(String[] args) {
        new login();
    }
}
