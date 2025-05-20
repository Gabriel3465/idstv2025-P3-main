package views;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import controllers.AuthController;
import controllers.HomeController;
import models.AuthModel;
import models.UsersModel;

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
		JLabel etiqueta2 = new JLabel("Ingrese su correo");
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
		password.setFont(new Font("Bahnschrift", Font.PLAIN, 35));
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

					AuthModel model = new AuthModel();
					boolean isLogin = model.login(email.getText(), password.getText());

					if (isLogin) {
						JOptionPane.showMessageDialog(null, "Inicio de secion exitoso", "Hello",
								JOptionPane.DEFAULT_OPTION);
						
						frame.dispose();
						HomeController hc = new HomeController();
						
						hc.home();
					} else {
						email.setBorder(BorderFactory.createLineBorder(Color.red, 4));
						password.setBorder(BorderFactory.createLineBorder(Color.red, 4));

						JOptionPane.showMessageDialog(null, "INICIO DE SECION ERRONEO", "Fallido",
								JOptionPane.CANCEL_OPTION);
					}

				}

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
				registroUsuario();
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
		JFrame registerFrame = new JFrame("Registro");
		registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registerFrame.setSize(500, 800);
		registerFrame.setLocationRelativeTo(null);

		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(Color.decode("#DCC8A0"));
		registerPanel.setLayout(null);

		// texto
		JLabel titleLabel = new JLabel("Registro");
		titleLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		titleLabel.setBounds(140, 20, 200, 40);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		registerPanel.add(titleLabel);

		JLabel nameLabel = new JLabel("Ingrese su nombre:");
		nameLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		nameLabel.setBounds(140, 79, 200, 40);
		registerPanel.add(nameLabel);

		JTextField nameField = new JTextField();
		nameField.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		nameField.setBounds(109, 113, 249, 40);
		registerPanel.add(nameField);

		JLabel lastNameLabel = new JLabel("Ingrese su apellidos:");
		lastNameLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lastNameLabel.setBounds(140, 151, 200, 40);
		registerPanel.add(lastNameLabel);

		JTextField lastNameField = new JTextField();
		lastNameField.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lastNameField.setBounds(109, 187, 249, 40);
		registerPanel.add(lastNameField);

		JLabel companyLabel = new JLabel("Ingrese su numero:");
		companyLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		companyLabel.setBounds(140, 226, 200, 40);
		registerPanel.add(companyLabel);

		JTextField companyField = new JTextField();
		companyField.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		companyField.setBounds(109, 262, 249, 40);
		registerPanel.add(companyField);

		JLabel sectorLabel = new JLabel("Seleccione el sector:");
		sectorLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		sectorLabel.setBounds(140, 323, 200, 40);
		registerPanel.add(sectorLabel);

		JComboBox<String> sectorCombo = new JComboBox<>();
		sectorCombo.setBounds(140, 360, 200, 25);
		sectorCombo.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		sectorCombo.addItem("Seleccione una opción");
		sectorCombo.addItem("Tecnología");
		sectorCombo.addItem("Salud");
		sectorCombo.addItem("Educación");
		sectorCombo.addItem("Comercio");
		sectorCombo.addItem("Otro");
		registerPanel.add(sectorCombo);

		JLabel passwordLabel = new JLabel("Ingrese la contraseña:");
		passwordLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		passwordLabel.setBounds(140, 395, 200, 40);
		registerPanel.add(passwordLabel);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setFont(new Font("Bahnschrift", Font.PLAIN, 35));
		passwordField.setBounds(116, 436, 242, 40);
		registerPanel.add(passwordField);

		JLabel confirmPasswordLabel = new JLabel("Repita la contraseña:");
		confirmPasswordLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		confirmPasswordLabel.setBounds(140, 486, 200, 40);
		registerPanel.add(confirmPasswordLabel);

		JPasswordField confirmPasswordField = new JPasswordField();
		confirmPasswordField.setFont(new Font("Bahnschrift", Font.PLAIN, 35));
		confirmPasswordField.setBounds(116, 525, 242, 40);
		registerPanel.add(confirmPasswordField);

		JLabel emailLabel = new JLabel("Ingrese su correo:");
		emailLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		emailLabel.setBounds(140, 567, 200, 40);
		registerPanel.add(emailLabel);

		JTextField emailField = new JTextField();
		emailField.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		emailField.setBounds(109, 610, 249, 40);
		registerPanel.add(emailField);

		// Botones
		JButton backButton = new JButton("Volver");
		backButton.setBounds(20, 20, 75, 40);
		backButton.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		backButton.addActionListener(e -> {
			registerFrame.dispose();
			login();
		});
		registerPanel.add(backButton);

		JButton registerButton = new JButton("Registrar");
		registerButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		registerButton.setBounds(185, 689, 120, 40);
		registerButton.addActionListener(e -> {

			// pasamos todos los field a string
			String name = nameField.getText();
			String lastName = lastNameField.getText();
			String email = emailField.getText();
			String password = new String(passwordField.getPassword());
			String confirmPassword = new String(confirmPasswordField.getPassword());
			String company = companyField.getText();
			String sector = (String) sectorCombo.getSelectedItem();

			// creamos un array con todos los field
			JTextField[] fields = { nameField, lastNameField, companyField, passwordField, confirmPasswordField,
					emailField };

			// repasamos todos los field y confirmamos que seleccione una copcion
			for (int i = 0; i < fields.length; i++) {

				// confirmamos que no este nada vacio
				if (fields[i].getText().isEmpty()) {
					fields[i].setBorder(BorderFactory.createLineBorder(Color.red, 4));
					JOptionPane.showMessageDialog(null, "NINGUN ESPACION PUEDE QUEDAR VACIO", "Fallido",
							JOptionPane.CANCEL_OPTION);
					return;
				} else {
					// restablesemos los bordes a defaul
					fields[i].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				}

			}

			// confirmamos que no quede en defaul
			if (sector.equals("Seleccione una opción")) {

				sectorCombo.setBorder(BorderFactory.createLineBorder(Color.red, 4));
				JOptionPane.showMessageDialog(null, "NINGUN ESPACION PUEDE QUEDAR VACIO", "Fallido",
						JOptionPane.CANCEL_OPTION);
				return;
			} else {
				sectorCombo.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			}

			// confirmamos que la contraseña sea igual
			if (!password.equals(confirmPassword)) {
				passwordField.setBorder(BorderFactory.createLineBorder(Color.red, 4));
				confirmPasswordField.setBorder(BorderFactory.createLineBorder(Color.red, 4));

				JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN", "Fallido",
						JOptionPane.CANCEL_OPTION);
				return;
			} else {
				passwordField.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			}

			// despues de todas las confirmaciones ya entregamos la informacion
			AuthModel model = new AuthModel();
			model.register(name, lastName, email, password, company, sector);
			
//			name, email, role, phone
			UsersModel model2= new UsersModel();
			model2.add(name, email, sector, company);
			
			// damos mensaje de inicio de secio
			JOptionPane.showMessageDialog(null, "Registro exitoso", "Confirmamos", JOptionPane.DEFAULT_OPTION);

			// cerramos el registro y abrimos login
			registerFrame.dispose();
			login();

		});
		registerPanel.add(registerButton);

		registerFrame.add(registerPanel);
		registerFrame.setVisible(true);

	}

	public void registroUsuario() {
		JFrame registerFrame = new JFrame("Registro");
		registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registerFrame.setSize(500, 800);
		registerFrame.setLocationRelativeTo(null);

		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(Color.decode("#DCC8A0"));
		registerPanel.setLayout(null);

		// texto
		JLabel titleLabel = new JLabel("Registro");
		titleLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		titleLabel.setBounds(140, 20, 200, 40);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		registerPanel.add(titleLabel);

		JLabel nameLabel = new JLabel("Ingrese su nombre completo:");
		nameLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		nameLabel.setBounds(140, 79, 200, 40);
		registerPanel.add(nameLabel);

		JTextField nameField = new JTextField();
		nameField.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		nameField.setBounds(109, 113, 249, 40);
		registerPanel.add(nameField);


		JLabel companyLabel = new JLabel("Ingrese su numero:");
		companyLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		companyLabel.setBounds(140, 226, 200, 40);
		registerPanel.add(companyLabel);

		JTextField companyField = new JTextField();
		companyField.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		companyField.setBounds(109, 262, 249, 40);
		registerPanel.add(companyField);

		JLabel sectorLabel = new JLabel("Seleccione el sector:");
		sectorLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		sectorLabel.setBounds(140, 323, 200, 40);
		registerPanel.add(sectorLabel);

		JComboBox<String> sectorCombo = new JComboBox<>();
		sectorCombo.setBounds(140, 360, 200, 25);
		sectorCombo.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		sectorCombo.addItem("Seleccione una opción");
		sectorCombo.addItem("Tecnología");
		sectorCombo.addItem("Salud");
		sectorCombo.addItem("Educación");
		sectorCombo.addItem("Comercio");
		sectorCombo.addItem("Otro");
		registerPanel.add(sectorCombo);


		JLabel emailLabel = new JLabel("Ingrese su correo:");
		emailLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		emailLabel.setBounds(140, 567, 200, 40);
		registerPanel.add(emailLabel);

		JTextField emailField = new JTextField();
		emailField.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		emailField.setBounds(109, 610, 249, 40);
		registerPanel.add(emailField);

		// Botones
		JButton backButton = new JButton("Volver");
		backButton.setBounds(20, 20, 75, 40);
		backButton.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		backButton.addActionListener(e -> {
			registerFrame.dispose();
			login();
		});
		registerPanel.add(backButton);

		JButton registerButton = new JButton("Registrar");
		registerButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		registerButton.setBounds(185, 689, 120, 40);
		registerButton.addActionListener(e -> {

			// pasamos todos los field a string
			String name = nameField.getText();
			String email = emailField.getText();
			String company = companyField.getText();
			String sector = (String) sectorCombo.getSelectedItem();

			// creamos un array con todos los field
			JTextField[] fields = { nameField, companyField,
					emailField };

			// repasamos todos los field y confirmamos que seleccione una copcion
			for (int i = 0; i < fields.length; i++) {

				// confirmamos que no este nada vacio
				if (fields[i].getText().isEmpty()) {
					fields[i].setBorder(BorderFactory.createLineBorder(Color.red, 4));
					JOptionPane.showMessageDialog(null, "NINGUN ESPACION PUEDE QUEDAR VACIO", "Fallido",
							JOptionPane.CANCEL_OPTION);
					return;
				} else {
					// restablesemos los bordes a defaul
					fields[i].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				}

			}

			// confirmamos que no quede en defaul
			if (sector.equals("Seleccione una opción")) {

				sectorCombo.setBorder(BorderFactory.createLineBorder(Color.red, 4));
				JOptionPane.showMessageDialog(null, "NINGUN ESPACION PUEDE QUEDAR VACIO", "Fallido",
						JOptionPane.CANCEL_OPTION);
				return;
			} else {
				sectorCombo.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			}
			
//			name, email, role, phone
			UsersModel model2= new UsersModel();
			model2.add(name, email, sector, company);
			
			// damos mensaje de inicio de secio
			JOptionPane.showMessageDialog(null, "Registro exitoso", "Confirmamos", JOptionPane.DEFAULT_OPTION);

			// cerramos el registro y abrimos login
			registerFrame.dispose();
			login();

		});
		registerPanel.add(registerButton);

		registerFrame.add(registerPanel);
		registerFrame.setVisible(true);

	}
	
	private void setContentPane(JPanel registro) {
		// TODO Auto-generated method stub
	}

	public void forgot() {
	}

}
