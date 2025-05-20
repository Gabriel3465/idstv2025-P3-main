package controllers;

import java.util.ArrayList;
import java.util.List;

import models.User;
import models.UsersModel;
import views.UsersView;

public class UsersController {
	
	private UsersView vista;
	private List<User> usuarios = new ArrayList<>();
	
	public UsersController() {
		
		vista = new UsersView();
	}
	
	public void index() {
		
		UsersModel um = new UsersModel();
		
		usuarios = um.getAll();
		
		vista.index(usuarios);
		
	}
	
	public void update(int id) {
		
		UsersModel um = new UsersModel();

		User myUser = um.get(id);
		
		vista.editarUsuario(myUser);
		
	}

}
