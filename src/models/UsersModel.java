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

	public UsersModel() {
		// TODO Auto-generated constructor stub
	}

	public List getAll() {

		String query = "select * from users";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "8163264gA?¡");
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
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "8163264gA?¡");
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
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "8163264gA?¡");
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
}