package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import reservationDao.newRe;
import reservationDao.reservationDao;

public class searchCars extends JInternalFrame {
	private JLabel lblNewLabel_1;
	private ArrayList<String> brandList;
	JList list;
	private DefaultTableModel branchCarModel = null;
	private Object[] branchCarData = null;
	private JTable table;
	ArrayList<String[]> lists ;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchCars frame = new searchCars();
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
	public searchCars() {
		reservationDao rd = new reservationDao();
		brandList =rd.getBrand();
		String[] str = new String[brandList.size()];
		for(int i=0; i<brandList.size(); i++) {
			str[i] = brandList.get(i);
		}
		
		setClosable(true);
		setTitle("Available Cars");
		setBounds(50, 50, 635, 550);
		getContentPane().setLayout(null);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(10, 10, 128, 16);
		getContentPane().add(lblNewLabel_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 27, 594, 449);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Car Search", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Car Brands");
		lblNewLabel.setBounds(6, 16, 144, 16);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(202, 34, 365, 172);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(380, 216, 184, 16);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(380, 253, 184, 16);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(380, 298, 184, 16);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(380, 341, 184, 16);
		panel.add(lblNewLabel_7);
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(287, 217, 61, 16);
		panel.add(lblNewLabel_8);

		JLabel lblNewLabel_3 = new JLabel(new ImageIcon(searchCars.class.getResource("/pic/default.png")));
		lblNewLabel_3.setBounds(6, 218, 274, 179);
		panel.add(lblNewLabel_3);
		
		table_1 = new JTable();
		scrollPane.setColumnHeaderView(table_1);
		
		table_1.getTableHeader().setReorderingAllowed(false);
		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
				    lblNewLabel_4.setText(table_1.getValueAt(table_1.getSelectedRow(), 1).toString());
				    lblNewLabel_5.setText(table_1.getValueAt(table_1.getSelectedRow(), 2).toString());
				    lblNewLabel_6.setText(table_1.getValueAt(table_1.getSelectedRow(), 3).toString());
				    lblNewLabel_7.setText(table_1.getValueAt(table_1.getSelectedRow(), 4).toString());
				    lblNewLabel_8.setText(table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
				   // String path = "/pic/"+lblNewLabel_8.getText()+".png";
				   // System.out.print(path+"      ");
				    String n = lblNewLabel_8.getText();
				    System.out.print(n);
					lblNewLabel_3.setIcon(new ImageIcon(searchCars.class.getResource("/pic/"+n+".png")));
				}catch (Exception ex) {
					lblNewLabel_3.setIcon(null);
					lblNewLabel_4.setText("");
					lblNewLabel_5.setText("");
					lblNewLabel_6.setText("");
					lblNewLabel_7.setText("");
					lblNewLabel_8.setText("");
				}
			}
		});
		
		
		
		branchCarModel = new DefaultTableModel();
		Object[] colBranchCar = new Object[5];
		colBranchCar[0] = "ID";
		colBranchCar[1] = "Brand";
		colBranchCar[2] = "Color";
		colBranchCar[3] = "Price";
		colBranchCar[4] = "type";
		branchCarModel.setColumnIdentifiers(colBranchCar);
		branchCarData = new Object[5];
		
		JLabel lblNewLabel_2 = new JLabel("Car type");
		lblNewLabel_2.setBounds(202, 16, 61, 16);
		panel.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 34, 184, 172);
		panel.add(scrollPane_1);
		
		list = new JList(str);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel clearModel = (DefaultTableModel) table_1.getModel();
				clearModel.setRowCount(0);
				String b = (String) list.getSelectedValue();
				lists = rd.getcurrData(b);
				for(int i = 0; i < lists.size(); i++) {
					branchCarData[0] = lists.get(i)[0];
					branchCarData[1] = lists.get(i)[1];
					branchCarData[2] = lists.get(i)[2];
					branchCarData[3] = lists.get(i)[3];
					branchCarData[4] = lists.get(i)[4];
					branchCarModel.addRow(branchCarData);
				}
				table_1.setModel(branchCarModel);

				lblNewLabel_3.setIcon(null);
				lblNewLabel_4.setText("");
				lblNewLabel_5.setText("");
				lblNewLabel_6.setText("");
				lblNewLabel_7.setText("");
				table_1.getColumnModel().getColumn(0).setPreferredWidth(40);
				table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
				table_1.getColumnModel().getColumn(2).setPreferredWidth(100);
				table_1.getColumnModel().getColumn(3).setPreferredWidth(100);
				table_1.getColumnModel().getColumn(4).setPreferredWidth(100);
				
			}
		});
		
		scrollPane_1.setViewportView(list);


		
		JButton btnNewButton = new JButton("Rent now");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = lblNewLabel_8.getText();
				String brand = lblNewLabel_4.getText();
				String color = lblNewLabel_5.getText();
				String price = lblNewLabel_6.getText();
				String type = lblNewLabel_7.getText();	
				if(id == "") {
					JOptionPane.showMessageDialog(null, "Please select a car first!");
					return;
								
				}else {
					newRe nr = new newRe(id,brand, color, price, type);
					newReservations rental = new newReservations();
					rental.textField_1.setText(brand);
					rental.textField_3.setText(price);
					rental.textField_4.setText(type);
					rental.textField_5.setText(color);
					rental.textField_6.setText(id);
					rental.setVisible(true);
					
					rental.setLocationRelativeTo(null);
					rental.setAlwaysOnTop( true );	
				}
				
			}
		});
		btnNewButton.setBounds(450, 368, 117, 29);
		panel.add(btnNewButton);

	}

}
