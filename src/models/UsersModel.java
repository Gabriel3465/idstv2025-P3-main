package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersModel {

	private List<User> usuarios = new ArrayList<>();
	
	String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_Base_de_datos_renta?useSSL=false";
	String usuario = "freedb_G_user";
	String contraseña = "";

	public UsersModel() {
		// TODO Auto-generated constructor stub
	}

	public List getAll() {

		String query = "select * from users";
		

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, contraseña);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String role = rs.getString(4);
				String phone = rs.getString(5);
 				

				System.out.println("empId:" + id);
				System.out.println("firstName:" + name);

				System.out.println("");

				usuarios.add(new User(id, name, email, role, phone, null, null));
			}

			rs.close();

			return usuarios;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
			}
		}

		return usuarios;
	}

	public boolean remove(int id) {

		String query = "DELETE FROM users WHERE id = " + id;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, contraseña);
			stmt = conn.createStatement();

			stmt.executeUpdate(query);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
			}
		}

		return false;

	}
	
	public boolean add(String name, String email, String role, String phone) {

		String query = "INSERT INTO users (name, email, role, phone) VALUES ('" 
                + name + "', '" 
                + email + "', '" 
                + role + "', " 
                + (phone != null ? "'" + phone + "'" : "NULL") + ")";
		
		
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, contraseña);
			stmt = conn.createStatement();

			stmt.executeUpdate(query);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
			}
		}

		return false;

	}
	
	public boolean update(int id, String name, String email, String role, String phone) {
	    String query = "UPDATE users SET name = '" + name + 
	                   "', email = '" + email + 
	                   "', role = '" + role + 
	                   "', phone = " + (phone != null ? "'" + phone + "'" : "NULL") + 
	                   " WHERE id = " + id;
		
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, contraseña);
			stmt = conn.createStatement();

			stmt.executeUpdate(query);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
			}
		}

		return false;

	}
	
	public User get(int id) {

		String query = "select * from users WHERE id = " + id;

		Connection conn = null;
		Statement stmt = null;

		User myUser = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, usuario, contraseña);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				
				String name = rs.getString(2);
				String email = rs.getString(3);
				String role = rs.getString(4);
				String phone = rs.getString(5);

				System.out.println("empId:" + id);
				System.out.println("firstName:" + name);

				System.out.println("");

				
				myUser = new User(id, name, email, role, phone, null, null);
			}

			rs.close();

			return myUser;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
			}
		}

		return myUser;
	}
}