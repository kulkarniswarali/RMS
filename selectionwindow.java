import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class SelectionWindow extends JFrame {

	private JPanel contentPane;

	public SelectionWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1555,749);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Employee Section");
		btnNewButton.setIcon(new ImageIcon(SelectionWindow.class.getResource("/restaurant-staff_1316x212.jpg")));
		btnNewButton.setBounds(10, 45, 1316, 212);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmployeeSection es = new EmployeeSection();
				setVisible(false);
				es.setVisible(true);
				es.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Kitchen Inventory Management");
		btnNewButton_1.setIcon(new ImageIcon(SelectionWindow.class.getResource("/kitchen_inevntory_1316x212.jpg")));
		btnNewButton_1.setBounds(10, 491, 1316, 212);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InventorySection frame = new InventorySection();
				setVisible(false);
				frame.setVisible(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(" Menu Section");
		btnNewButton_2.setIcon(new ImageIcon(Intro.class.getResource("/Food-Wallpaper_1316x212.jpg")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuSection ms = new MenuSection();
				setVisible(false);
				ms.setVisible(true);
				ms.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
			}
		});
		btnNewButton_2.setBounds(10, 268, 1316, 212);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(btnNewButton_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Restaurantlogin rl = new Restaurantlogin();
				rl.setVisible(true);
				rl.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
			}
		});
		btnBack.setBounds(10, 11, 96, 23);
		panel.add(btnBack);
	}
}
