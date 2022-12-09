package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import reservationDao.reservationDao;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ModifyOrder extends JInternalFrame {
	private JTable table;
	reservationDao rd = new reservationDao();
	int n=1;
	ArrayList<String[]> list = rd.getData(n);
	DefaultTableModel branchCarModel;
	Object[] branchCarData ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reservationRecord frame = new reservationRecord();
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
	public ModifyOrder() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 603, 300);
		
		JLabel lblNewLabel = new JLabel("Order Information");
		
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		String[] index = {"id","Car_Brand","User_Name","StartDate","EndDate","Carid","price","type","color"};
		Object[][] data = new Object[list.size()][index.length];
		for(int i=0; i<list.size(); i++) {
			String[] curr = list.get(i);
			data[i][0] = curr[0];
			data[i][1] = curr[1];
			data[i][2] = curr[2];
			data[i][3] = curr[3];
			data[i][4] = curr[4];
			data[i][5] = curr[5];
			data[i][6] = curr[6];
			data[i][7] = curr[7];
			data[i][8] = curr[8];
			
		}
				
		DefaultTableModel defaultModel = new DefaultTableModel(data, index);
        table=new JTable(defaultModel) {
        	public boolean isCellEditable(int row, int column) { return false; }
        };
       
 
    /*    JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);*/
        
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() <= 0) {
					JOptionPane.showMessageDialog(null, "Please choose the order!");
					return;
				}
				int result = JOptionPane.showConfirmDialog(null, "Please confirm whether to delete？");
				// 判断用户是否点击
				String num = (String) table.getValueAt(table.getSelectedRow(), 0);
				//System.out.print(num+"\n");
				//System.out.print(table.getSelectedRowCount()+"\n");
				if (result == JOptionPane.OK_OPTION) {
					if(rd.deleteInfo(num)) {
						JOptionPane.showMessageDialog(null, "Delete successfully");
						dispose();
						return;
					}
				}
			}
		});      
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(btnNewButton_1)
							.addGap(40)
							.addComponent(btnNewButton_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(table, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
								.addComponent(lblNewLabel))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		

	}


}
