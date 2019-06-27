import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Restaurantlogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	String drivername = "org.postgresql.Driver";
	String dbnm = "jdbc:postgresql://localhost:5432/restaurant";
	Connection con = null;
	
	String user;
	String pass;
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Restaurantlogin frame = new Restaurantlogin();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Restaurantlogin() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("                  Admin Login");
		lblNewLabel.setBackground(new Color(255, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(132, 24, 492, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserName.setBounds(73, 113, 227, 57);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(73, 208, 254, 57);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(310, 115, 329, 57);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(118, 334, 206, 53);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(442, 334, 182, 53);
		btnCancel.addActionListener(this);
		contentPane.add(btnCancel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(310, 208, 329, 57);
		contentPane.add(passwordField);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Submit"))
		{
							
			try {
				
				Class.forName(drivername);
				con = DriverManager.getConnection(dbnm,"postgres","swara");
				
				PreparedStatement st;
				user = textField.getText();
				pass = new String(passwordField.getPassword());
				
							
				st = con.prepareStatement("select password,empname from logininfo where empname=?");
				st.setString(1,user);
				ResultSet rs = st.executeQuery();
				
				if(rs.next())
				{
					
					do
					{
						
						String p = rs.getString("password");
						String nm = rs.getString("empname"); 
												
						if(p.equals(pass) && nm.equalsIgnoreCase(user))
						{
							
							SelectionWindow w = new SelectionWindow();
							this.setVisible(false);
							w.setVisible(true);
							w.setSize(800,500);
							w.setExtendedState(JFrame.MAXIMIZED_BOTH);
							
						}
						else 
						{
								
							JOptionPane.showMessageDialog(this,"Invalid user name or password");
							
						}
					}while(rs.next());
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invalid user name or password");
					
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		else if(e.getActionCommand().equals("Cancel"))
		{
			
		}
		
	}
}
