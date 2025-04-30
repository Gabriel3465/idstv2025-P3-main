package views;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import controllers.AuthController;
import models.AuthModel;

public class AuthView {

	public AuthView() {
	}

	public void login() {

		JFrame frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 800);
		frame.setLocationRelativeTo(null);

		JPanel contenedor = new JPanel();
		contenedor.setLayout(null); // Desactivar layout para colocar los paneles manualmente
		contenedor.setSize(500, 800);

		// Panel izquierdo (azul)
		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setBackground(Color.decode("#004E70"));
		panelIzquierdo.setBounds(0, 0, 500, 800); // Primera mitad
		panelIzquierdo.setLayout(null);

		// imagen de logo
		
		
		ImageIcon fondoLogo = new ImageIcon(getClass().getResource("/images/logo.png"));
		Image imagenEscalada3 = fondoLogo.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		JLabel fondoLabel3 = new JLabel(new ImageIcon(imagenEscalada3));
		fondoLabel3.setBounds(210, 20, 50, 50); // Ajustar al tamaño del panel
		panelIzquierdo.add(fondoLabel3);

		// icoono de usuario
		ImageIcon contraseña = new ImageIcon(getClass().getResource("/images/usuario.png"));
		Image imagenEscalada4 = contraseña.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel fondoLabel_4 = new JLabel(new ImageIcon(imagenEscalada4));
		fondoLabel_4.setBounds(110, 160, 40, 40);
		panelIzquierdo.add(fondoLabel_4);

		// icono de contraseña
		ImageIcon usuario = new ImageIcon(getClass().getResource("/images/contraseña.png"));
		Image imagenEscalada5 = usuario.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel fondoLabel_5 = new JLabel(new ImageIcon(imagenEscalada5));
		fondoLabel_5.setBounds(110, 260, 40, 40);
		panelIzquierdo.add(fondoLabel_5);

		// Etiqueta de título en el panel izquierdo
		JLabel etiqueta1 = new JLabel("Inicio de sesión");
		etiqueta1.setForeground(Color.WHITE);
		etiqueta1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		etiqueta1.setBounds(165, 70, 200, 40);
		panelIzquierdo.add(etiqueta1);

		// Campos de usuario y contraseña
		JLabel etiqueta2 = new JLabel("Ingrese su usuario");
		etiqueta2.setForeground(Color.WHITE);
		etiqueta2.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		etiqueta2.setBounds(120, 120, 200, 40);
		panelIzquierdo.add(etiqueta2);

		JTextField email = new JTextField();
		email.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		email.setBounds(160, 160, 200, 40);
		panelIzquierdo.add(email);

		JLabel etiqueta3 = new JLabel("Ingrese su contraseña:");
		etiqueta3.setForeground(Color.WHITE);
		etiqueta3.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		etiqueta3.setBounds(120, 220, 200, 40);
		panelIzquierdo.add(etiqueta3);

		JPasswordField password = new JPasswordField();
		password.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		password.setBounds(160, 260, 200, 40);
		panelIzquierdo.add(password);

		// Botón de acceder
		JButton botonAcceder = new JButton("Acceder");
		botonAcceder.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		botonAcceder.setBounds(190, 360, 120, 40);

		botonAcceder.addActionListener(new ActionListener() {

			Boolean bandera1 = false, bandera2 = false;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (email.getText().equals("")) {
					email.setBorder(BorderFactory.createLineBorder(Color.red, 4));
				} else {
					email.setBorder(BorderFactory.createLineBorder(Color.green, 4));
					bandera1 = true;
				}

				String contraseña = new String(password.getPassword());

				if (contraseña.equals("")) {
					password.setBorder(BorderFactory.createLineBorder(Color.red, 4));
				} else {
					password.setBorder(BorderFactory.createLineBorder(Color.green, 4));
					bandera2 = true;
				}

				if (bandera1 && bandera2) {
					if (email.getText().equals("gabriel@alu")) {
						if (contraseña.equals("12345")) {
							JOptionPane.showMessageDialog(null, "Inicio de secion exitoso", "Hello",
									JOptionPane.DEFAULT_OPTION);
						} else
							JOptionPane.showMessageDialog(null, "INICIO DE SECION ERRONEO", "Fallido",
									JOptionPane.CANCEL_OPTION);
					} else
						JOptionPane.showMessageDialog(null, "INICIO DE SECION ERRONEO", "Fallido",
								JOptionPane.CANCEL_OPTION);
				} else
					JOptionPane.showMessageDialog(null, "INICIO DE SECION ERRONEO", "Fallido",
							JOptionPane.CANCEL_OPTION);
			}
		});
		panelIzquierdo.add(botonAcceder);

		JLabel crearCuenta = new JLabel("<html>¿No tienes cuenta? <u>Crear cuenta</u></html>	");
		crearCuenta.setForeground(Color.WHITE);
		crearCuenta.setSize(200, 20);
		crearCuenta.setLocation(160, 415);
		crearCuenta.setFont(new Font("Bahnschrift", Font.ITALIC, 12));
		panelIzquierdo.add(crearCuenta);

		JLabel olvidoContrasena = new JLabel("¿Olvidó su contraseña?");
		olvidoContrasena.setForeground(Color.WHITE);
		olvidoContrasena.setSize(200, 20);
		olvidoContrasena.setLocation(240, 300);
		olvidoContrasena.setFont(new Font("Bahnschrift", Font.ITALIC, 12));
		panelIzquierdo.add(olvidoContrasena);

		JLabel help = new JLabel("¿Ayuda?");
		help.setForeground(Color.WHITE);
		help.setSize(200, 20);
		help.setLocation(20, 460);
		help.setFont(new Font("Bahnschrift", Font.ITALIC, 12));
		panelIzquierdo.add(help);

		JButton irRegistro = new JButton("Ir a registro");
		irRegistro.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		irRegistro.setBounds(190, 600, 120, 40);

		irRegistro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// router("register");
			}
		});

		panelIzquierdo.add(irRegistro);

		contenedor.add(panelIzquierdo);
		frame.add(contenedor);
		frame.setVisible(true);

		contenedor.add(panelIzquierdo);
		contenedor.repaint();
		contenedor.revalidate();
	}

	public void register() {
		
	}

	public void forgot() {
	}

}
