
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EmployeeSection extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField updateid;
	private JTextField textField_6;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeSection frame = new EmployeeSection();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 */
	public EmployeeSection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,1292,788);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 153, 255));
		panel.setBounds(0, 0, 1276, 749);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEmployeeName = new JLabel("Employee Id");
		lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeName.setBounds(65, 82, 190, 48);
		panel.add(lblEmployeeName);
		
		JLabel lblEmployeeId = new JLabel("Employee name");
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeId.setBounds(65, 154, 163, 48);
		panel.add(lblEmployeeId);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContactNo.setBounds(65, 219, 163, 53);
		panel.add(lblContactNo);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDesignation.setBounds(65, 292, 163, 48);
		panel.add(lblDesignation);
		
		textField = new JTextField();
		textField.setBounds(230, 84, 240, 48);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(230, 151, 240, 48);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(230, 219, 240, 48);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(230, 294, 240, 48);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSalary.setBounds(65, 367, 136, 45);
		panel.add(lblSalary);
		
		textField_4 = new JTextField();
		textField_4.setBounds(230, 367, 240, 48);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewEmployee = new JLabel("     New Employee details");
		lblNewEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewEmployee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewEmployee.setBounds(124, 23, 286, 40);
		panel.add(lblNewEmployee);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int no = Integer.parseInt(textField.getText());
				String nm = textField_1.getText();
				String cno = textField_2.getText();
				String des = textField_3.getText();
				Float sal= Float.parseFloat(textField_4.getText());
				Connection con = getConnection();
				
				PreparedStatement st, st1, st2;
				ResultSet rs;
				
				try {
					st = con.prepareStatement("insert into employee values(?,?,?,?,?)");
					st.setInt(1,no);
					st.setString(2,nm);
					st.setString(3,cno);
					st.setString(4,des);
					st.setFloat(5,sal);
					int ins = st.executeUpdate();
					JOptionPane.showOptionDialog(null, "Employee Added Succesfully ", "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
	
		});
		btnAddEmployee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddEmployee.setBounds(168, 461, 207, 59);
		panel.add(btnAddEmployee);
		
		JLabel lblSearchEmployee = new JLabel("Search Employee");
		lblSearchEmployee.setToolTipText("Search employee on the basis of name");
		lblSearchEmployee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSearchEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchEmployee.setBounds(828, 25, 217, 36);
		panel.add(lblSearchEmployee);
		
		JLabel lblNewLabel = new JLabel("Employee Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(692, 84, 175, 48);
		panel.add(lblNewLabel);
		
		JLabel lblContactNo_1 = new JLabel("Contact No");
		lblContactNo_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContactNo_1.setBounds(692, 159, 175, 48);
		panel.add(lblContactNo_1);
		
		updateid = new JTextField();
		updateid.setToolTipText("Enter emloyee Id");
		updateid.setBounds(894, 91, 263, 48);
		panel.add(updateid);
		updateid.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(894, 167, 263, 48);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblDesignation_1 = new JLabel("Designation");
		lblDesignation_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDesignation_1.setBounds(692, 235, 149, 48);
		panel.add(lblDesignation_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(894, 241, 263, 48);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblDeleteEmployee = new JLabel("Delete Employee");
		lblDeleteEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteEmployee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDeleteEmployee.setBounds(773, 395, 286, 48);
		panel.add(lblDeleteEmployee);
		
		JLabel lblEmployeeId_1 = new JLabel("Employee Id");
		lblEmployeeId_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeId_1.setBounds(679, 467, 163, 48);
		panel.add(lblEmployeeId_1);
		
		textField_7 = new JTextField();
		textField_7.setBounds(894, 469, 263, 48);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblEmployeeName_1 = new JLabel("Employee Name");
		lblEmployeeName_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeName_1.setBounds(679, 553, 149, 45);
		panel.add(lblEmployeeName_1);
		
		textField_8 = new JTextField();
		textField_8.setBounds(894, 553, 263, 48);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int empid = Integer.parseInt(textField_7.getText());

				Connection con = getConnection();
				PreparedStatement st;
				
				try {
					st = con.prepareStatement("delete from employee where empid=?");
					st.setInt(1,empid);
					int del = st.executeUpdate();
					JOptionPane.showOptionDialog(null, "Employee Deleted Succesfully ", "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(780, 641, 191, 53);
		panel.add(btnNewButton);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = getConnection();
				PreparedStatement st;
				ResultSet rs;
				
				try {
					st = con.prepareStatement("select contact,designation from employee where empid=?");
					st.setInt(1,Integer.parseInt(updateid.getText()));
					rs = st.executeQuery();
					while(rs.next())
					{
						textField_6.setText(rs.getString("contact"));
						textField_5.setText(rs.getString("designation"));
					}
										
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearch.setBounds(808, 317, 163, 48);
		panel.add(btnSearch);
		
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
		btnBack.setBounds(10, 11, 104, 23);
		panel.add(btnBack);
	}
	static Connection getConnection() {
		
		
		Connection con = null;
		try {
			
			Class.forName("org.postgresql.Driver");
			 con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/restaurant","postgres","swara");
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;
		
		}
}
