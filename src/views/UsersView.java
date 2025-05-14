package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

//		String[] columnNames = {"Nombre", "Email", "Rol", "Teléfono"};
//		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//		
//		int x = 100;
//		for (Iterator iterator = usuarios.iterator(); iterator.hasNext();) {
//			User usuario = (User) iterator.next();
//			
//			JLabel user = new JLabel(usuario.name);
//			user.setForeground(new Color(0, 0, 0)); 
//			user.setBounds(50, x, 210, 26);
//			user.setHorizontalAlignment(JLabel.CENTER);
//			panel.add(user);
//			
//			x+= 35;
//			
//		}

		// Crear unan tabla
		String[] columnNames = { "ID", "Nombre" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Hacer que la tabla no sea editable
			}
		};

		// Llenar la tabla con datos
		for (Iterator iterator = usuarios.iterator(); iterator.hasNext();) {
			User usuario = (User) iterator.next();
			Object[] rowData = { usuario.getId(), usuario.getName() };
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

		ventana.add(panel);
		ventana.repaint();
		ventana.revalidate();
	}
}