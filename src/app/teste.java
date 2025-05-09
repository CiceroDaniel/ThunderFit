package app;

import  java.util.Scanner;	
import app.*;
import repository.UsuarioRepository;
import services.*;
public class teste {
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		UsuarioRepository repo = new UsuarioRepository();
		AuthService auth = new AuthService(repo);
		UsuarioService services = new UsuarioService(repo);
		
		System.out.println("ESCOLHA A INTERFACE"
				+ "\n1 - CONSOLE"
				+ "\n2 - SWING (INTERFACE GRÁFICA)"
				+ "\nESCOLAH UMA OPÇÃO: ");
		int op = Integer.parseInt(scanner.nextLine());
		if(op == 1) {
			consoleMenu menu = new consoleMenu(scanner, repo, auth, services);
			menu.getTools().preCad();
			menu.init(scanner, repo, auth, services);
		}else if(op == 2) {
			//chama a tela
		}else {
			System.out.println("OPÇÃO INVALIDAAAAAA!");
		}
		
		
		
		//menu.tools().preCad();
		toolbox.espacoMenu();
		
		
		
		//menu.mostarAdm();
		//menu.cadTutor();
	}
	
}