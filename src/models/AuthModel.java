package models;

import java.io.BufferedReader;
import java.io.FileReader;

public class AuthModel {

	public AuthModel() {
		
	}

	public boolean login(String email, String password) {

		String url = this.getClass().getResource("/files/usuarios.txt").getPath();
		BufferedReader reader;

		try {

			reader = new BufferedReader(new FileReader(url));
			String line = reader.readLine();

			while (line != null) {
				String[] data = line.split(",");
				line = reader.readLine();
				
				if(email.equals(data[2])) {
					if(password.equals(data[3])) {
						return true;
					}
				}
				
				System.out.println(line);
				// read next line
//				line = reader.readLine();
			}

			   reader.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}
	
}
