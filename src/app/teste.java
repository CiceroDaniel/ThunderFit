package app;

import  java.util.Scanner;	
import app.consoleMenu;
import app.toolbox;
import repository.UsuarioRepository;
import services.AuthService;
import services.UsuarioService;
public class teste {
	
	
	public static void main(String[] args) {
		
		
		final UsuarioRepository repo = new UsuarioRepository();
		final UsuarioService services = new UsuarioService(repo);
		final AuthService auth = new AuthService(repo,services);
		Scanner scan = new Scanner(System.in);
		
		
		consoleMenu menu = new consoleMenu(scan,repo,auth,services);
		menu.tools.preCad();
		toolbox.espacoMenu();
		
		
		menu.init(scan, repo, auth, services);
		//menu.mostarAdm();
		//menu.cadTutor();
	}
	
}