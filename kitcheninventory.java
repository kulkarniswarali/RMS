import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InventorySection extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;


	public InventorySection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInventoryManagement = new JLabel("Kitchen Inventory Management");
		lblInventoryManagement.setBounds(431, 22, 429, 46);
		lblInventoryManagement.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblInventoryManagement.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblInventoryManagement);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 99, 1118, 242);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	
		DefaultTableModel m = new DefaultTableModel();
		Object [] cnm = new Object[6];
		cnm[0]= "Item Id";
		cnm[1]= "Name";
		cnm[2]= "Category";
		cnm[3]= "unit";
		cnm[4]= "unit price";
		cnm[5]= "quantity";
		m.setColumnIdentifiers(cnm);
		table.setModel(m);
		fillTable(table);
		
		JLabel lblAddItem = new JLabel("Add Item");
		lblAddItem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddItem.setBounds(121, 379, 280, 37);
		contentPane.add(lblAddItem);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(31, 427, 75, 37);
		contentPane.add(lblId);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(31, 475, 75, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(31, 542, 96, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Unit");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(31, 605, 89, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Unit price");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(252, 427, 81, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Quantity");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(252, 481, 81, 31);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Other", "Flour", "Dairy", "vegetable", "spices", "fruits"}));
		comboBox.setBounds(107, 544, 197, 37);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(93, 437, 149, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(93, 480, 149, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(343, 437, 158, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText(" ");
		textField_3.setBounds(343, 485, 158, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "kilograms", "grams", "litres"}));
		comboBox_1.setBounds(108, 605, 196, 37);
		contentPane.add(comboBox_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textField.getText();
				String nm = textField_1.getText();
				String cat = comboBox.getSelectedItem().toString();
				String un = comboBox_1.getSelectedItem().toString();
				Float upri = (Float.parseFloat(textField_2.getText()));
				Float q = (Float.parseFloat(textField_3.getText()));
				
				
				Connection con = getConnection();
				PreparedStatement st,st1;
				ResultSet rs;
				
				try {
					st = con.prepareStatement("insert into inventory values(?,?,?,?,?,?)");
					st.setString(1,id);
					st.setString(2,nm);
					st.setString(3,cat);
					st.setString(4,un);
					st.setFloat(5,upri);
					st.setFloat(6,q);
					int u = st.executeUpdate();
					
					st1 = con.prepareStatement("select * from inventory where id=?");
					st1.setString(1,id);
					rs = st1.executeQuery();
					while(rs.next())
					{
						((DefaultTableModel)table.getModel()).addRow(new Object[]{rs.getString("id"),rs.getString("name"),rs.getString("category"),rs.getString("unit"),rs.getFloat("unit_price"),rs.getFloat("quantity")});

					}
					JOptionPane.showOptionDialog(null, "Item Added Succesfully ", "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
			
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(204, 653, 129, 37);
		contentPane.add(btnAdd);
		
		JLabel lblNewLabel_5 = new JLabel("Change quantity");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(656, 379, 185, 37);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Item No");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(562, 435, 123, 32);
		contentPane.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(666, 437, 175, 32);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(562, 498, 96, 31);
		contentPane.add(lblQuantity);
		
		textField_5 = new JTextField();
		textField_5.setBounds(668, 497, 173, 32);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textField_4.getText();
				Float q = Float.parseFloat(textField_5.getText());
				int loc = table.getSelectedRow();
				
				Connection con = getConnection();
				PreparedStatement st,st1;
				ResultSet rs;
				
				try {
					st = con.prepareStatement("update inventory set quantity=? where id=?");
					st.setFloat(1,q);
					st.setString(2,id);
					int up = st.executeUpdate();
					
					st1 = con.prepareStatement("select quantity from inventory where id=?");
					st1.setString(1,id);
					rs = st1.executeQuery();
					while(rs.next())
					{
						((DefaultTableModel)table.getModel()).setValueAt(rs.getFloat("quantity"),loc,5);
					}
				
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(634, 580, 158, 37);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				SelectionWindow w = new SelectionWindow();
				w.setVisible(true);
				w.setSize(800,500);
				w.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
			}
		});
		btnBack.setBounds(10, 11, 96, 23);
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
				rs = s.executeQuery("select * from inventory");
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

