import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Intro extends JFrame implements ActionListener{

	private JPanel contentPane;
	JLabel l1,l2;
	JTextField t1,t2;
	JButton b1,b2;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Intro frame = new Intro();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		public Intro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1800, 800);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Intro.class.getResource("/rest1.jpg")));
		lblNewLabel.setBounds(10, 11,1348,500);
		panel.add(lblNewLabel);
		
		JButton btnAdminLogin = new JButton("Login");
		btnAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdminLogin.setBounds(555, 551, 327, 101);
		btnAdminLogin.addActionListener(this);
		panel.add(btnAdminLogin);
		
	/*	JButton btnAbout = new JButton("About");
		btnAbout.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAbout.setBounds(606, 579, 349, 101);
		btnAbout.addActionListener(this);;
		panel.add(btnAbout);*/
	
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Login"))
		{
			Restaurantlogin l = new Restaurantlogin();
			this.setVisible(false);
			//l.setVisible(true);
			l.setVisible(true);
			l.setExtendedState(JFrame.MAXIMIZED_BOTH);
			
			
		}
	}

}
