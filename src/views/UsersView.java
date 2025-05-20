package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//import controller.UserController;
import controllers.UsersController;
import models.User;
import models.UsersModel;

public class UsersView {

	public UsersView() {

	}

	public void index(List usuarios) {
		JFrame ventana = new JFrame();

		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null);
		ventana.setTitle("Login");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(true);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		// this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600);

		JLabel lblNewLabel = new JLabel("UABCS - DASC\n");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(107, 35, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel);

		// Crear unan tabla
		String[] columnNames = { "ID", "Nombre", "email", "Role", "Phone" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Hacer que la tabla no sea editable
			}
		};

		// Llenar la tabla con datos
		for (Iterator iterator = usuarios.iterator(); iterator.hasNext();) {
			User usuario = (User) iterator.next();
			Object[] rowData = { usuario.getId(), 
					usuario.getName(), usuario.getEmail(), usuario.getRole(), usuario.getPhone()
					};
			model.addRow(rowData);
		}

		// se crea la tabla
		JTable table = new JTable(model);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setRowHeight(25);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		table.setAutoCreateRowSorter(true); // ordenar por columnas

		// Agregar la tabla a un JScrollPane
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 100, 830, 400);
		panel.add(scrollPane);

		// Botón Eliminar
		JButton btnEliminar = new JButton("Eliminar Usuario Seleccionado");
		btnEliminar.setBounds(50, 520, 250, 30);
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();

				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(ventana, "Por favor seleccione un usuario", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				// Confirmamos eliminacion
				int confirm = JOptionPane.showConfirmDialog(ventana, "¿Está seguro que desea eliminar este usuario?",
						"Confirmar eliminación", JOptionPane.YES_NO_OPTION);

				if (confirm == JOptionPane.YES_OPTION) {
					// Obtener ID del usuario seleccionado
					int userId = (int) model.getValueAt(selectedRow, 0);

					// Eliminamos de la base de datos
					UsersModel um = new UsersModel();
					boolean eliminado = um.remove(userId);

					if (eliminado) {
						// Eliminar de la tabla
						model.removeRow(selectedRow);
						JOptionPane.showMessageDialog(ventana, "Usuario eliminado correctamente");
					} else {
						JOptionPane.showMessageDialog(ventana, "Error al eliminar el usuario", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		panel.add(btnEliminar);
		
		JButton update = new JButton("actualizar");
		update.setBounds(630, 520, 250, 30);
		update.addActionListener(e -> {
			
		    int selectedRow = table.getSelectedRow();

		    int userId = (int) model.getValueAt(selectedRow, 0);
		    String name = (String) model.getValueAt(selectedRow, 1);
		    String email = (String) model.getValueAt(selectedRow, 2);
		    String role = (String) model.getValueAt(selectedRow, 3);
		    String phone = (String) model.getValueAt(selectedRow, 4);
			
//			UsersController uc = new UsersController();
		    
		    UsersController uc = new UsersController();
			uc.update(userId);
		    
//	        ventana.dispose(); 
//		    editarUsuario(userId, name, email, role, phone);
		    
		});;
		panel.add(update);

		ventana.add(panel);
		ventana.repaint();
		ventana.revalidate();
	}
	
	public void editarUsuario(User user) {
	    JFrame editFrame = new JFrame("Editar Usuario");
	    editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cambiado a DISPOSE_ON_CLOSE
	    editFrame.setSize(500, 800);
	    editFrame.setLocationRelativeTo(null);

	    JPanel editPanel = new JPanel();
	    editPanel.setBackground(Color.decode("#DCC8A0"));
	    editPanel.setLayout(null);

	    // texto
	    JLabel titleLabel = new JLabel("Editar Usuario"); // Cambiado el título
	    titleLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
	    titleLabel.setBounds(140, 20, 200, 40);
	    titleLabel.setHorizontalAlignment(JLabel.CENTER);
	    editPanel.add(titleLabel);

	    // Campo Nombre (precargado)
	    JLabel nameLabel = new JLabel("Nombre completo:");
	    nameLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
	    nameLabel.setBounds(140, 79, 200, 40);
	    editPanel.add(nameLabel);

	    JTextField nameField = new JTextField(user.name); // Precargamos el nombre
	    nameField.setFont(new Font("Bahnschrift", Font.BOLD, 15));
	    nameField.setBounds(109, 113, 249, 40);
	    editPanel.add(nameField);

	    // Campo Teléfono (precargado)
	    JLabel phoneLabel = new JLabel("Teléfono:"); // Cambiado el texto
	    phoneLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
	    phoneLabel.setBounds(140, 226, 200, 40);
	    editPanel.add(phoneLabel);

	    JTextField phoneField = new JTextField(user.phone); // Precargamos el teléfono
	    phoneField.setFont(new Font("Bahnschrift", Font.BOLD, 15));
	    phoneField.setBounds(109, 262, 249, 40);
	    editPanel.add(phoneField);

	    // Combo Rol (precargado)
	    JLabel roleLabel = new JLabel("Rol:"); // Cambiado el texto
	    roleLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
	    roleLabel.setBounds(140, 323, 200, 40);
	    editPanel.add(roleLabel);

	    JComboBox<String> roleCombo = new JComboBox<>();
	    roleCombo.setBounds(140, 360, 200, 25);
	    roleCombo.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
	    roleCombo.addItem("Tecnología");
	    roleCombo.addItem("Salud");
	    roleCombo.addItem("Educación");
	    roleCombo.addItem("Comercio");
	    roleCombo.addItem("Otro");
	    
	    // Seleccionamos el rol actual
	    for (int i = 0; i < roleCombo.getItemCount(); i++) {
	        if (roleCombo.getItemAt(i).equals(user.role)) {
	            roleCombo.setSelectedIndex(i);
	            break;
	        }
	    }
	    editPanel.add(roleCombo);

	    // Campo Email (precargado)
	    JLabel emailLabel = new JLabel("Correo electrónico:");
	    emailLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
	    emailLabel.setBounds(140, 567, 200, 40);
	    editPanel.add(emailLabel);

	    JTextField emailField = new JTextField(user.getEmail()); // Precargamos el email
	    emailField.setFont(new Font("Bahnschrift", Font.BOLD, 15));
	    emailField.setBounds(109, 610, 249, 40);
	    editPanel.add(emailField);

	    // Botón Guardar Cambios (en lugar de Registrar)
	    JButton saveButton = new JButton("Guardar Cambios");
	    saveButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
	    saveButton.setBounds(185, 689, 120, 40);
	    saveButton.addActionListener(e -> {
	        // Validación de campos

	        String name = nameField.getText();
	        String email1 = emailField.getText();
	        String phone = phoneField.getText();
	        String role = (String) roleCombo.getSelectedItem();

	        JTextField[] fields = { nameField, phoneField, emailField };

	        for (int i = 0; i < fields.length; i++) {
	            if (fields[i].getText().isEmpty()) {
	                fields[i].setBorder(BorderFactory.createLineBorder(Color.red, 4));
	                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error",
	                        JOptionPane.ERROR_MESSAGE);
	                return;
	            } else {
	                fields[i].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
	            }
	        }

	        // Actualizar el usuario en la base de datos
	        UsersModel model = new UsersModel();
	        boolean actualizado = model.update(user.id, name, email1, role, phone);
	        
	        if (actualizado) {
	            JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente", "Éxito",
	                    JOptionPane.INFORMATION_MESSAGE);
	            editFrame.dispose();
	            
				UsersController uc = new UsersController();
	            uc.index();
	            
	        } else {
	            JOptionPane.showMessageDialog(null, "Error al actualizar el usuario", "Error",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    });
	    editPanel.add(saveButton);

	    editFrame.add(editPanel);
	    editFrame.setVisible(true);
	}
}