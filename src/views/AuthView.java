package views;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
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

		        frame.dispose();
				register();
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

	    JFrame frame = new JFrame("Registro");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(500, 800);
	    frame.setLocationRelativeTo(null);
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(500, 800);
//		setLocationRelativeTo(null);
		
		JPanel registro = new JPanel();
		registro.setBackground(Color.decode("#DCC8A0"));
		registro.setOpaque(true);
		registro.setSize(500, 800);
		registro.setLocation(0, 0);
		registro.setLayout(null);// quita todo el molde

		JLabel etiqueta1R = new JLabel("Registro");
		etiqueta1R.setSize(200, 40);
		etiqueta1R.setLocation(140, 20);
		etiqueta1R.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1R.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		registro.add(etiqueta1R);

		JLabel etiqueta2 = new JLabel("Ingrese su nombre: ");
		etiqueta2.setSize(200, 40);
		etiqueta2.setLocation(140, 79);
		etiqueta2.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		registro.add(etiqueta2);

		JTextField email = new JTextField();
		email.setSize(249, 40);
		email.setLocation(109, 113);
		email.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		registro.add(email);

		JLabel etiqueta3 = new JLabel("Ingrese su apellidos:");
		etiqueta3.setSize(200, 40);
		etiqueta3.setLocation(140, 151);
		etiqueta3.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		registro.add(etiqueta3);

		JButton volver = new JButton("Volver");
		volver.setSize(75, 40);
		volver.setLocation(20, 20);
		volver.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		registro.add(volver);

		ButtonGroup grupo = new ButtonGroup();

		JButton botonAcceder = new JButton("Acceder");
		botonAcceder.setSize(120, 40);
		botonAcceder.setLocation(185, 689);
		botonAcceder.setFont(new Font("Bahnschrift", Font.BOLD, 15));

		botonAcceder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Boolean bandera1 = false, bandera2 = false;

				if (email.getText().equals("")) {
					email.setBorder(BorderFactory.createLineBorder(Color.red, 4));
				} else {
					email.setBorder(BorderFactory.createLineBorder(Color.green, 4));
					bandera1 = true;
				}

//				String contraseña = new String(password.getPassword());
//
//				if (contraseña.equals("")) {
//
//					password.setBorder(BorderFactory.createLineBorder(Color.red, 4));
//
//				} else {
//					password.setBorder(BorderFactory.createLineBorder(Color.green, 4));
//					bandera2 = true;
//				}
//
//				if (comentario1.getText().equals("")) {
//					comentario1.setBorder(BorderFactory.createLineBorder(Color.red, 4));
//				} else {
//					comentario1.setBorder(BorderFactory.createLineBorder(Color.green, 4));
//				}

//				if (bandera1 && bandera2) {
//					if (email.getText().equals("gabriel@alu")) {
//						if (contraseña.equals("12345")) {
//							JOptionPane.showMessageDialog(null, "Inicio de secion exitoso", "Hello",
//									JOptionPane.DEFAULT_OPTION);
//						} else
//							JOptionPane.showMessageDialog(null, "INICIO DE SECION ERRONEO", "Fallido",
//									JOptionPane.CANCEL_OPTION);
//					} else
//						JOptionPane.showMessageDialog(null, "INICIO DE SECION ERRONEO", "Fallido",
//								JOptionPane.CANCEL_OPTION);
//				} else
//					JOptionPane.showMessageDialog(null, "INICIO DE SECION ERRONEO", "Fallido",
//							JOptionPane.CANCEL_OPTION);

			}
		});
		registro.add(botonAcceder);

		JButton irLogin = new JButton("Ir a login");
		irLogin.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		irLogin.setBounds(350, 21, 120, 40);

		irLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

//				router("login");
			}
		});
		registro.add(irLogin);
		
		JLabel lblIngreseLaEmpresa = new JLabel("Ingrese la empresa:");
		lblIngreseLaEmpresa.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblIngreseLaEmpresa.setBounds(140, 226, 200, 40);
		registro.add(lblIngreseLaEmpresa);
		
		JLabel lblIngreseLaEmpresa_1 = new JLabel("Ingrese la empresa:");
		lblIngreseLaEmpresa_1.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblIngreseLaEmpresa_1.setBounds(140, 323, 200, 40);
		registro.add(lblIngreseLaEmpresa_1);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(140, 360, 200, 25); // Ajusté el tamaño para mejor visualización
		comboBox.setFont(new Font("Bahnschrift", Font.PLAIN, 12));

		// Agregar opciones al JComboBox
		comboBox.addItem("Seleccione una opción"); // Opción por defecto
		comboBox.addItem("Tecnología");
		comboBox.addItem("Salud");
		comboBox.addItem("Educación");
		comboBox.addItem("Comercio");
		comboBox.addItem("Otro");

		registro.add(comboBox);
		
	    setContentPane(registro); 
	    
	    JLabel lblIngreseLaContrasea = new JLabel("Ingrese la contraseña:");
	    lblIngreseLaContrasea.setFont(new Font("Bahnschrift", Font.BOLD, 15));
	    lblIngreseLaContrasea.setBounds(140, 395, 200, 40);
	    registro.add(lblIngreseLaContrasea);
	    
	    JPasswordField passwordField_1 = new JPasswordField();
	    passwordField_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
	    passwordField_1.setBounds(116, 436, 242, 40);
	    registro.add(passwordField_1);
	    
	    JLabel lblRepitaLaConrasea = new JLabel("Repita la contraseña:");
	    lblRepitaLaConrasea.setFont(new Font("Bahnschrift", Font.BOLD, 15));
	    lblRepitaLaConrasea.setBounds(140, 486, 200, 40);
	    registro.add(lblRepitaLaConrasea);
	    
	    JPasswordField passwordField_2 = new JPasswordField();
	    passwordField_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
	    passwordField_2.setBounds(116, 525, 242, 40);
	    registro.add(passwordField_2);
	    
	    JLabel lblIngreseSuCorreo = new JLabel("Ingrese su correo:");
	    lblIngreseSuCorreo.setFont(new Font("Bahnschrift", Font.BOLD, 15));
	    lblIngreseSuCorreo.setBounds(140, 567, 200, 40);
	    registro.add(lblIngreseSuCorreo);
	    
	    JTextField textField = new JTextField();
	    textField.setFont(new Font("Bahnschrift", Font.BOLD, 15));
	    textField.setBounds(109, 187, 249, 40);
	    registro.add(textField);
	    
	    JTextField textField_1 = new JTextField();
	    textField_1.setFont(new Font("Bahnschrift", Font.BOLD, 15));
	    textField_1.setBounds(109, 262, 249, 40);
	    registro.add(textField_1);
	    
	    JTextField textField_2 = new JTextField();
	    textField_2.setFont(new Font("Bahnschrift", Font.BOLD, 15));
	    textField_2.setBounds(109, 610, 249, 40);
	    registro.add(textField_2);
	
		frame.add(registro);
	    frame.setVisible(true);
	}

	private void setContentPane(JPanel registro) {
		// TODO Auto-generated method stub
		
	}

	public void forgot() {
	}

}
