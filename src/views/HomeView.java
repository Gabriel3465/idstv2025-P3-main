package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controllers.UsersController;
import models.AuthModel;

public class HomeView {

	public HomeView() {
	}

	public void home()
	{
		JFrame ventana = new JFrame();
		
		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("Login"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setResizable(true);  
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		//this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600); 
		
		JLabel lblNewLabel = new JLabel("UABCS - DASC\n");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(107, 35, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel);
		
		
		JButton btnNewButton2 = new JButton("Usuarios");
		btnNewButton2.setBackground(new Color(0, 0, 0));
		btnNewButton2.setOpaque(true);
		btnNewButton2.setForeground(new Color(0, 0, 0));
		btnNewButton2.setBounds(205, 190, 200, 200);
		btnNewButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ventana.dispose(); 
				
				UsersController uc = new UsersController();
				uc.index();

				//e.getSource().
				 
				
			}});
		panel.add(btnNewButton2);
			
		
		ventana.add(panel);
		ventana.repaint();
		ventana.revalidate();
	}
}
