import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MenuSection extends JFrame {

	private JPanel contentPane;
	private JLabel lblMenu;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	
	public MenuSection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1378, 788 );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(191, 61, 1062, 224);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblMenu = new JLabel("Menu");
		lblMenu.setBounds(572, 11, 268, 39);
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblMenu);
		
		DefaultTableModel m = new DefaultTableModel();
		Object [] cnm = new Object[5];
		cnm[0]= "Itemno";
		cnm[1]= "Item name";
		cnm[2]= "category";
		cnm[3]= "status";
		cnm[4]= "Price";
		m.setColumnIdentifiers(cnm);
		table.setModel(m);
		fillTable(table);
		
		JLabel lblNewLabel = new JLabel("Item No");
		lblNewLabel.setBounds(69, 317, 129, 44);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(69, 393, 129, 39);
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblItemName);
		
		textField = new JTextField();
		textField.setBounds(236, 319, 251, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(236, 392, 251, 44);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategory.setBounds(69, 457, 140, 44);
		contentPane.add(lblCategory);
		
		textField_2 = new JTextField();
		textField_2.setBounds(236, 459, 251, 45);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatus.setBounds(69, 525, 129, 39);
		contentPane.add(lblStatus);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"None", "Available", "Unavailable"}));
		comboBox.setBounds(236, 525, 251, 39);
		contentPane.add(comboBox);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(69, 588, 140, 39);
		contentPane.add(lblPrice);
		
		textField_3 = new JTextField();
		textField_3.setBounds(236, 587, 260, 40);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblItemNo = new JLabel("Item no");
		lblItemNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblItemNo.setBounds(991, 393, 158, 39);
		contentPane.add(lblItemNo);
		
		textField_4 = new JTextField();
		textField_4.setBounds(1079, 392, 244, 44);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = getConnection();
				PreparedStatement st;
				int i = table.getSelectedRow();
				if(i>0)
				{
					((DefaultTableModel)table.getModel()).removeRow(i);
				}
				
				try {
					
					st = con.prepareStatement("delete from menu where itemno=?");
					st.setInt(1,Integer.parseInt(textField_4.getText()));
					int d = st.executeUpdate();
					
					JOptionPane.showOptionDialog(null, "Item deleted succesfully ", "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnDeleteItem.setBounds(1106, 547, 182, 44);
		contentPane.add(btnDeleteItem);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ino = textField.getText();
				String nm = textField_1.getText();
				String cat = textField_2.getText();
				String pri = textField_3.getText();
				String stat = comboBox.getSelectedItem().toString();
				
				Connection con =getConnection();
				PreparedStatement st,st1;
				ResultSet rs;
				
				try {
					st = con.prepareStatement("insert into menu values(?,?,?,?,?)");
					st.setInt(1,Integer.parseInt(ino));
					st.setString(2,nm);
					st.setString(3,cat);
					st.setString(4,stat);
					st.setFloat(5,Float.parseFloat(pri));
					int up = st.executeUpdate();
					
					st1 = con.prepareStatement("select * from menu where item_name=?");
					st1.setString(1,nm);
					rs = st1.executeQuery();
					while(rs.next())
					{
						((DefaultTableModel)table.getModel()).addRow(new Object[]{rs.getInt("itemno"),rs.getString("item_name"),rs.getString("category"),rs.getString("status"),rs.getFloat("price")});
					
					}
					JOptionPane.showOptionDialog(null, "Item Added Succesfully ", "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(169, 652, 201, 50);
		contentPane.add(btnAdd);
		
		JLabel lblUpdateItem = new JLabel("Update item");
		lblUpdateItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateItem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateItem.setBounds(556, 317, 284, 44);
		contentPane.add(lblUpdateItem);
		
		JLabel lblItemNo_1 = new JLabel("Item no");
		lblItemNo_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblItemNo_1.setBounds(544, 392, 140, 44);
		contentPane.add(lblItemNo_1);
		
		JLabel lblCategory_1 = new JLabel("Category");
		lblCategory_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategory_1.setBounds(539, 457, 145, 44);
		contentPane.add(lblCategory_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(675, 392, 238, 45);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"None", "Available", "Unavailable"}));
		comboBox_1.setBounds(675, 460, 238, 39);
		contentPane.add(comboBox_1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String no =	textField_5.getText();
			String stat = comboBox_1.getSelectedItem().toString();
			int s =  table.getSelectedRow();
			
			PreparedStatement st,st1;
			ResultSet rs;
			
			Connection con = getConnection();
			try {
					st= con.prepareStatement("update menu set status=? where itemno=?");
					st.setString(1,stat);
					st.setInt(2,Integer.parseInt(no));
					int up = st.executeUpdate();
					
					st1 = con.prepareStatement("select status from menu where itemno=?");
					st1.setInt(1,Integer.parseInt(no));
					rs = st1.executeQuery();
					while(rs.next())
					{
						((DefaultTableModel)table.getModel()).setValueAt(rs.getString("status"),s,3);
					}
				
					JOptionPane.showOptionDialog(null, "Status updated succesfully ", "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(602, 547, 213, 44);
		contentPane.add(btnUpdate);
		
		JLabel lblNewLabel_1 = new JLabel("Delete Item");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(1030, 317, 284, 44);
		contentPane.add(lblNewLabel_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectionWindow w = new SelectionWindow();
				setVisible(false);
				w.setVisible(true);
				w.setSize(800,500);
				w.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnBack.setBounds(10, 11, 108, 23);
		contentPane.add(btnBack);
		
		
	
	}
	
	public void fillTable(JTable table)
	{
		
				Connection con = getConnection();
				Statement s;
				PreparedStatement st;
				ResultSet rs;
				try {
				s = con.createStatement();
				rs = s.executeQuery("select * from menu order by itemno asc ");
				ResultSetMetaData rsmd = rs.getMetaData();
				int ncls = rsmd.getColumnCount();
				
				while(rs.next())
				{
					Object [] rowdata = new Object[ncls];
					
					for(int i=1; i<=ncls ;i++)
					{
						rowdata[i-1] = rs.getObject(i);
					}
					((DefaultTableModel)table.getModel()).insertRow(rs.getRow()-1, rowdata);
				}
				}catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
	static Connection getConnection()
	{
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			 con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/restaurant","postgres","swara");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
		
		
			
	}
		
	}

