package aplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;

import controllers.AuthController;

public class Main {

	public static void main(String[] args) {

		AuthController app = new AuthController();
		app.login();
		
	}

}
