package app;

import  java.util.Scanner;	
import app.consoleMenu;
import app.toolbox;
import repository.UsuarioRepository;
public class teste {
	
	
	public static void main(String[] args) {
		
		UsuarioRepository repo = new UsuarioRepository();
		consoleMenu menu = new consoleMenu(repo);
		
		Scanner scan = new Scanner(System.in);
		//consoleMenu menu = new consoleMenu();
		//toolbox tools = new toolbox();
		toolbox.espacoMenu();
		
		
		menu.init();
		//menu.mostarAdm();
		//menu.cadTutor();
	}
	
}