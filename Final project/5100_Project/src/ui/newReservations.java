package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;

import connectionDatabase.conData;
import loginDao.UserDao;
import reservationDao.newRe;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class newReservations extends JFrame {

	private JPanel contentPane;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	
	JDateChooser select_rent;
	JDateChooser select_rent_1;
	JTextField textField_3;
	JTextField textField_4;
	JTextField textField_5;
	JTextField textField_6;
	JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newReservations frame = new newReservations();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param lblNewLabel_42 
	 * @param lblNewLabel_8 
	 */
    
	public newReservations() {
		setTitle("New Reservation");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 653, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		JLabel lblNewLabel = new JLabel("Reservation ID");
		lblNewLabel.setBounds(11, 11, 106, 27);
		
		JLabel lblNewLabel_1 = new JLabel("Car Brand");
		lblNewLabel_1.setBounds(11, 55, 60, 16);
		
		JLabel lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setBounds(11, 97, 68, 16);
		
		JLabel lblNewLabel_3 = new JLabel("Start Date");
		lblNewLabel_3.setBounds(19, 237, 62, 16);
		
		JLabel lblNewLabel_3_1 = new JLabel("Start Date");
		lblNewLabel_3_1.setBounds(19, 292, 62, 16);
		
		long t = System.currentTimeMillis();
		Date today = new Date(t);
		Date tomorrow = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(tomorrow); 
		c.add(Calendar.DATE, 1);
		tomorrow = c.getTime();
		select_rent = new JDateChooser();
		select_rent.setBounds(99, 237, 154, 26);
		select_rent.setMinSelectableDate(today);
		select_rent.setDate(today);
		
		select_rent_1 = new JDateChooser();
		select_rent_1.setBounds(99, 292, 154, 26);
		select_rent_1.setMinSelectableDate(tomorrow);
		select_rent_1.setDate(tomorrow);
		
		JButton btnNewButton = new JButton("Confrim");
		btnNewButton.setBounds(337, 267, 85, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(addNewReservation(e)) {
					dispose();
					JOptionPane.showMessageDialog(null, "Add successfully！");			
				}else {
					 JOptionPane.showMessageDialog(null, "Error！");
				}
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.setBounds(514, 267, 85, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		textField = new JTextField(getId());
		textField.setBounds(123, 11, 130, 26);
		textField.setEditable(false);
		textField.setColumns(10);

		
		textField_1 = new JTextField("");
		
		textField_1.setEditable(false);
		textField_1.setBounds(123, 50, 130, 26);
		textField_1.setColumns(10);
		
		UserDao u = new UserDao();
		String un = u.getCurrName();
		textField_2 = new JTextField(un);
		textField_2.setBounds(123, 97, 130, 26);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(textField);
		contentPane.add(lblNewLabel_1);
		contentPane.add(textField_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(textField_2);
		contentPane.add(lblNewLabel_3);
		contentPane.add(select_rent);
		contentPane.add(lblNewLabel_3_1);
		contentPane.add(select_rent_1);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setBounds(10, 141, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField("");
		textField_3.setEditable(false);
		textField_3.setBounds(123, 136, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("type");
		lblNewLabel_5.setBounds(11, 186, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField("");
		textField_4.setEditable(false);
		textField_4.setBounds(123, 181, 130, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Color");
		lblNewLabel_6.setBounds(324, 60, 61, 16);
		contentPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField("");
		textField_5.setEditable(false);
		textField_5.setBounds(372, 55, 130, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Car id");
		lblNewLabel_7.setBounds(324, 16, 61, 16);
		contentPane.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(372, 11, 130, 26);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
	}
	

	protected boolean addNewReservation(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection cn=null;
	    PreparedStatement ps=null;
		int n=0;
	    String sql="insert into ReservationTable (id,Car_Brand,User_Name,Start_Date,End_Date,Carid,price,type,Color,State) values(?,?,?,?,?,?,?,?,?,?)";
	    
		int id = Integer.valueOf(textField.getText());
		String carBrand = textField_1.getText();
		String Guest_Name = textField_2.getText();
		Date StartDate = select_rent.getDate();
        Date EndDate = select_rent_1.getDate();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        String r = dFormat.format(select_rent.getDate());
        String rentDate = r.substring(6)+"-"+r.substring(3,5)+"-"+r.substring(0,2);
		String r1 = dFormat.format(select_rent_1.getDate());
		String returnDate =r1.substring(6)+"-"+r1.substring(3,5)+"-"+r1.substring(0,2);
		
		String Carid = textField_6.getText();
		String price = textField_3.getText();
		String type = textField_4.getText();
		String color = textField_5.getText();
		try {
			cn=conData.getCon();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     
        try
        {
            ps=cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, carBrand);
            ps.setString(3, Guest_Name);
            ps.setString(4, rentDate);
            ps.setString(5, returnDate);
            ps.setString(6, Carid);
            ps.setString(7, price);
            ps.setString(8, type);
            ps.setString(9, color);
            ps.setInt(10, 1);
     
            n= ps.executeUpdate();
            if(n>0) {
            	flag=true;
            }
           
        } catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    
		return flag;
	}

	private String getId() {
		// TODO Auto-generated method stub
		Connection cn=null;
		Statement stmt = null;
		ResultSet rsst = null;
		String next = null;
		String sql = "select max(id) from ReservationTable";
		try {
			cn=conData.getCon();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {	
			stmt = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rsst = stmt.executeQuery(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rsst.next()) {
				int nextid = Integer.valueOf(rsst.getString(1))+1;
				//System.out.println(nextid);
				next = String.valueOf(nextid);
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return next;
	}


}
