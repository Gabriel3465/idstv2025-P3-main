package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

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

				if (email.equals(data[2])) {
					if (password.equals(data[3])) {
						return true;
					}
				}

				System.out.println(line);
			}

			reader.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	//recibimos toda la infomacion de registro
	public boolean register(String name, String lastName, String email, String password,String campany, String sector) {
		try (FileWriter fw = new FileWriter("src/files/usuarios.txt", true);
				BufferedWriter bw = new BufferedWriter(fw)) {
			
			//entregamos la informacion a un solo string
			String userData = String.join(",",name, lastName, email, password, sector);

			// Escribe en el archivo
			bw.newLine();
			bw.write(userData);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return false;
	}

}
