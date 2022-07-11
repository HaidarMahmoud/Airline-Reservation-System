package airline;

import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Add_Customer extends JFrame{ //Third Frame

    
	JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;

        public Add_Customer(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD CUSTOMER DETAILS");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
			
            JLabel Passport_number = new JLabel("PASSPORT NO");
            Passport_number.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Passport_number.setBounds(60, 80, 150, 27);
            add(Passport_number);
            
            textField = new JTextField();
            textField.setBounds(200, 80, 150, 27);
            add(textField);
			
            JLabel Pnr_no = new JLabel("PNR NO");
            Pnr_no.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Pnr_no.setBounds(60, 120, 150, 27);
            add(Pnr_no);
			
            textField_1 = new JTextField();
            textField_1.setBounds(200, 120, 150, 27);
            add(textField_1);
            
            JLabel Adress = new JLabel("ADDRESS");
            Adress.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Adress.setBounds(60, 170, 150, 27);
            add(Adress);
			
            textField_2 = new JTextField();
            textField_2.setBounds(200, 170, 150, 27);
            add(textField_2);
            		
            JLabel Nationality = new JLabel("NATIONALITY");
            Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Nationality.setBounds(60, 220, 150, 27);
            add(Nationality);
			
            textField_3 = new JTextField();
            textField_3.setBounds(200, 220, 150, 27);
            add(textField_3);
	
            JLabel Name = new JLabel("NAME");
            Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Name.setBounds(60, 270, 150, 27);
            add(Name);
	
            textField_4 = new JTextField();
            textField_4.setBounds(200, 270, 150, 27);
            add(textField_4);
	
            JLabel Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Gender.setBounds(60, 320, 150, 27);
            add(Gender);
		
            JRadioButton NewRadioButton = new JRadioButton("MALE");
            NewRadioButton.setBackground(Color.WHITE);
            NewRadioButton.setBounds(200, 320, 70, 27);
            add(NewRadioButton);
	
            JRadioButton Female = new JRadioButton("FEMALE");
            Female.setBackground(Color.WHITE);
            Female.setBounds(280, 320, 75, 27);
            add(Female);
            
            JLabel Phone_number = new JLabel("PHONE NO");
            Phone_number.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Phone_number.setBounds(60, 370, 150, 27);
            add(Phone_number);
            
             JButton Next = new JButton("SAVE");
            Next.setBounds(200, 420, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            add(Next);
			
            textField_5 = new JTextField();
            textField_5.setBounds(200, 370, 150, 27);
            add(textField_5);
	
            setVisible(true);
	
            JLabel AddPassengers = new JLabel("ADD CUSTOMER DETAILS");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Italian", Font.BOLD, 33));
            AddPassengers.setBounds(420, 24, 442, 35);
            add(AddPassengers);
			
    
            JLabel Flight_code = new JLabel("FLIGHT CODE");
            Flight_code.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Flight_code.setBounds(60, 30, 150, 27);
            add(Flight_code);

            textField_6 = new JTextField();
            textField_6.setBounds(200, 30, 150, 27);
            add(textField_6);
            
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/new_customer.png"));
            JLabel image = new JLabel(i1);
            image.setBounds(500,30,300,430);
            add(image);

            
            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String passport_number = textField.getText();
                    String pnr_no = textField_1.getText();
                    String adress =  textField_2.getText();
                    String nationality = textField_3.getText();
                    String name = textField_4.getText();
                    String flight_code = textField_6.getText();
                   
                    String gender = null;
                    String phone_no = textField_5.getText();
                    
                    if(NewRadioButton.isSelected()){
                        gender = "male";
                    
                    }else if(Female.isSelected()){
                        gender = "female";
                    }
                    
                    try {
                        conn c = new conn();
                        String str = "INSERT INTO passenger values( '"+pnr_no+"', '"+adress+"', '"+nationality+"'," + 
                                "'"+name+"', '"+gender+"', '"+phone_no+"','"+passport_number+"', '"+flight_code+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Customer Added");
                        setVisible(false);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}
            });
			
            setSize(900,600);
            setVisible(true);
            setLocation(400,200);
			
	}
        
    public static void main(String[] args){
        new Add_Customer();
    }   
}