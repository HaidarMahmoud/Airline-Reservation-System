package airline;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Payment_Details extends JFrame{ 

    JTextField textField;
    JTable table;
    JLabel Sector;
    JLabel FlightCode, Capacity, Classcode, Classname, label;

    public static void main(String[] args) {
        new Payment_Details();
    }

    public Payment_Details(){
	initialize();
    }

    private void initialize(){
        setTitle("PAYMENT_DETAILS");
	getContentPane().setBackground(Color.WHITE);
	setSize(860,486);
	setLayout(null);
		
	JLabel Fcode = new JLabel("PNR NUMBER");
	Fcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Fcode.setBounds(40, 160, 130, 26);
	add(Fcode);
		
	textField = new JTextField();
	textField.setBounds(200, 160, 150, 26);
	add(textField);
	
        table = new JTable();
	table.setBounds(45, 329, 766, 87);
	add(table);
		
	JButton Show = new JButton("SHOW");
	Show.setFont(new Font("Tahoma", Font.BOLD, 17));
        Show.setBackground(new Color(100, 149, 237));
        Show.setForeground(Color.WHITE);
	Show.setBounds(200, 210, 150, 26);
	add(Show);
		
	Sector = new JLabel("PAYMENT DETAILS");
	Sector.setForeground(new Color(100, 149, 237));
	Sector.setFont(new Font("Tahoma", Font.BOLD, 31));
	Sector.setBounds(30, 40, 400, 39);
	add(Sector);
		
	FlightCode = new JLabel("PNR NUMBER");
	FlightCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
	FlightCode.setBounds(49, 292, 108, 26);
	add(FlightCode);
		
	Capacity = new JLabel("PAID AMOUNT");
	Capacity.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Capacity.setBounds(180, 298, 92, 14);
	add(Capacity);
		
	Classcode = new JLabel("PAY DATE");
	Classcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Classcode.setBounds(320, 294, 101, 24);
	add(Classcode);
		
	Classname = new JLabel("CHEQUE NO");
	Classname.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Classname.setBounds(435, 298, 114, 14);
	add(Classname);
		
	label = new JLabel("");
	label.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/Payment_2.png")));
	label.setBounds(480, 45, 239, 272);
	add(label);
		
	JLabel Cardno = new JLabel("CARD NUMBER");
	Cardno.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Cardno.setBounds(555, 295, 101, 19);
	add(Cardno);
		
	JLabel Phoneno = new JLabel("PHONE NO");
	Phoneno.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Phoneno.setBounds(678, 293, 86, 24);
	add(Phoneno);
        setVisible(true);
		
	Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		
                try {
                    String code  = textField.getText();
                    
                    conn c = new conn();
                    String str = "select pnr_number,paid_amount,pay_date,cheque_number,card_number,phone_number from payment where pnr_number = '"+code+"'";
					
                    ResultSet rs = c.s.executeQuery(str);
		
                    table.setModel(DbUtils.resultSetToTableModel(rs));
					
		}catch(SQLException e) {
                    e.printStackTrace();
                }
            }
	});
		
	setSize(960,590);
        setLocation(400,200);
	setVisible(true);

    }
}
