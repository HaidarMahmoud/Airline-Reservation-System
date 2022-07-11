package airline;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Journey_Details extends JFrame{  

    JTable table;
    JLabel ReservationDetails,Pnrno,Ticketid,Fcode,Jnydate,Jnytime,Source,Destination,label,label1;
    JButton Show;

    public static void main(String[] args){
        new Journey_Details();
    }
    
    public Journey_Details(){
        
        setTitle("JOURNEY DETAILS");
	getContentPane().setBackground(Color.WHITE);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setLayout(null);
        setVisible(true);
		
	Source = new JLabel("SOURCE");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Source.setBounds(60, 100, 150, 27);
	add(Source);
	
        Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Destination.setBounds(350, 100, 150, 27);
	add(Destination);
		
	
		
	Show = new JButton("SHOW");
	Show.setBounds(680, 100, 100, 30);
	add(Show);

	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	ReservationDetails = new JLabel("JOURNEY DETAILS");
	ReservationDetails.setForeground(new Color(100, 149, 237));
	ReservationDetails.setFont(new Font("Tahoma", Font.BOLD, 31));
	ReservationDetails.setBounds(280, 27, 359, 31);
	add(ReservationDetails);
		
	Pnrno = new JLabel("PNR NO");
	Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Pnrno.setBounds(79, 270, 83, 20);
	add(Pnrno);
		
	Ticketid = new JLabel("TICKET ID");
	Ticketid.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Ticketid.setBounds(162, 270, 71, 20);
	add(Ticketid);
		
	Fcode = new JLabel("FLIGHT CODE");
	Fcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Fcode.setBounds(260, 270, 103, 20);
	add(Fcode);
		
	Jnydate = new JLabel("JOURNY DATE");
	Jnydate.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Jnydate.setBounds(380, 270, 94, 20);
	add(Jnydate);
		
	Jnytime = new JLabel("JOURNY TIME");
	Jnytime.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Jnytime.setBounds(504, 270, 83, 20);
	add(Jnytime);
		
	Source = new JLabel("SOURCE");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Source.setBounds(623, 270, 94, 20);
	add(Source);
		
	Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Destination.setBounds(717, 270, 94, 20);
	add(Destination);
        
	String[] items1 =  {"DAMASQUS", "ALLEPO", "DOHA", "DUBAI","RIYADH","JEDDAH"};
	JComboBox comboBox = new JComboBox(items1);
	comboBox.setBounds(150, 100, 150, 27);
	add(comboBox);
		
		
	String[] items2 =  {"DAMASQUS", "ALLEPO", "DOHA", "DUBAI","RIYADH","JEDDAH"};
	JComboBox comboBox_1 = new JComboBox(items2);
	comboBox_1.setBounds(500, 100, 150, 27);
	add(comboBox_1);
		
	Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		try{
                    String starting_location  = (String) comboBox.getSelectedItem();
                    String destination  = (String) comboBox_1.getSelectedItem();
                    
                    conn c = new conn();
                    
                    String str = "select * from reservations where starting_location = '"+starting_location+"' and destination = '"+destination +"'";
                    ResultSet rs= c.s.executeQuery(str);
                    
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    				
                    
					
		}catch(Exception e){}
            }
	});
        
        table = new JTable();
	table.setBounds(38, 310, 770, 130);
	add(table);
        
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(23, 250, 800, 300);
        pane.setBackground(Color.WHITE);
        add(pane);
		
	setSize(860,600);
        setLocation(400,200);
	setVisible(true);
		
    }
}
