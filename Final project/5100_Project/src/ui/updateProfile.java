package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import connectionDatabase.conData;
import profileDao.upInfoDao;
import loginDao.UserDao;
import loginDao.stringUtil;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class updateProfile extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	upInfoDao up =new upInfoDao();
	String[] pd = up.getPersonalData();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateProfile frame = new updateProfile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public updateProfile() {
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 297, 427);
		
		JLabel lblNewLabel = new JLabel("Full Name");
		
		JLabel lblNewLabel_1 = new JLabel("Driver Lisence Number");
		
		JLabel lblNewLabel_2 = new JLabel("UserName");
		
		JLabel lblNewLabel_3 = new JLabel("Passward");
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateInfo(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		
		JLabel lblNewLabel_5 = new JLabel("Age");
		
		
		textField = new JTextField(pd[1]);
		textField.setColumns(10);
		
		textField_1 = new JTextField(pd[0]);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(pd[2]);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField(pd[3]);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField(pd[4]);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField(pd[5]);
		textField_5.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
									.addComponent(btnNewButton_1))
								.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_4)
										.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_5)
										.addGap(69)
										.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
									.addComponent(lblNewLabel_1))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblNewLabel_2))
									.addGap(29)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(111)))
					.addGap(81))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(219, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(28))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void updateInfo(ActionEvent e) {
		// TODO Auto-generated method stub
		String guest = textField.getText();
		String Number = textField_1.getText();
		String user = textField_2.getText();
		String pass = textField_3.getText();
		String age = textField_4.getText();
		String gender = textField_5.getText();
		
		if(stringUtil.isEmpty(guest)) {
			JOptionPane.showMessageDialog(null, "Name cannot be blank！");
			return;
		}
		if(stringUtil.isEmpty(Number)) {
			JOptionPane.showMessageDialog(null, "Driver's license number cannot be blank！");
			return;
		}
		if(stringUtil.isEmpty(pass)) {
			JOptionPane.showMessageDialog(null, "Password cannot be blank！");
			return;
		}
		if(stringUtil.isEmpty(user)) {
			JOptionPane.showMessageDialog(null, "UserName cannot be blank！！");
			return;
		}
		try {
			
            if(up.upInfo(guest, Number,user,pass,age,gender))
            {
           	 JOptionPane.showMessageDialog(null, "修改成功！");
           	 dispose();
           	 new menu().setVisible(true);	
            }
            else
            {
                JOptionPane.showMessageDialog(null, "修改失败");
            }
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
