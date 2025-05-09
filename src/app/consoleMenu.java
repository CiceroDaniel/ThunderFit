package app;

import app.*;
import repository.UsuarioRepository;
import services.AuthService;
import services.UsuarioService;

import java.util.Scanner;


public class consoleMenu {
	//Scanner scan = new Scanner(System.in);
	//usuarioConsole userConsole = new usuarioConsole();
	//admConsole admConsole = new admConsole();
	//tutorConsole  tutorConsole = new tutorConsole();
	//toolbox tools = new toolbox();
	
	
	
	private UsuarioRepository repo;
	usuarioConsole userConsole;
	admConsole admConsole;
	tutorConsole tutorConsole;
	private Scanner scanner;
	private toolbox tools;
	private AuthService auth;
	private UsuarioService services;

	public consoleMenu(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services) {
		this.scanner = scanner;
	    this.repo = repo;
	    this.auth = auth;
	    this.services = services;
	    
	    this.tutorConsole = new tutorConsole(scanner, repo, auth, services);
	    this.userConsole = new usuarioConsole(scanner, services);
	    this.admConsole = new admConsole(scanner, repo, auth, services);
	    this.tools = new toolbox(userConsole, admConsole, tutorConsole);
	}
	
	

	

	

	// YSABELLE PASSE LONGE DESSE ARQUIVO PELO AMOR DE SAMARA!
	public void init(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services) {
		
		int op;
		do {
			System.out.println("==========MENU INICIAL=========== \n"
					+ "1 - CADASTRO \n"
			 		+ "2 - LOGIN \n"
					+ "3 - SAIR \n"
					+ "ESCOLHA A OPÇÃO: ");
			op = scanner.nextInt();
			scanner.nextLine();
			//testando pra victor hugo
			switch(op) {
				case 1 :  Cadastro(scanner, repo, auth, services);
					break;
				case 2 :  login(scanner, repo, auth, services);
					break;
				case 3 :System.out.println("SAINDO DO SISTEMA.......");
				System.exit(0);
				default: System.out.println("OPÇÃO INVALIDA!");
			}
		}while(op!=0);
		
	}
	
	public void Cadastro(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services) {
		int op;
		do {
			
			System.out.println("============CADASTRAR============"
					+ "\n1 - CLIENTE"
					+ "\n2 - TUTOR"
					+ "\n3 - VOLTAR"
					+ "\nESCOLHA UMA OPÇÃO: ");
			op = scanner.nextInt();
			scanner.nextLine();
			
			switch(op) {
			case 1: userConsole.cadastroMenu(scanner, repo, auth, services);
			break;
			case 2: tutorConsole.cadastroMenu(scanner, repo, auth, services);
			break;
			case 3: init(scanner, repo, auth, services);
			}
			
		}while(op!=0);
	}
	
	public void login(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services) {
		int op;
		do {
			tools.espacoMenu();
			
			System.out.println("============LOGIN============"
					+ "\n1 - CLIENTE"
					+ "\n2 - TUTOR"
					+ "\n3 - ADIMINISTRADOR"
					+ "\n4 - VOLTAR"
					+ "\nESCOLHA UMA OPÇÃO: ");
			op = scanner.nextInt();
			scanner.nextLine();
			
			switch(op) {
			case 1: userConsole.loginMenu(scanner, repo, auth, services);
			break;
			case 2: tutorConsole.loginMenu(scanner, repo, auth, services);;
			break;
			case 3: admConsole.loginMenu();
			case 4: init(scanner, repo, auth, services);
			}
			
		}while(op!=0);
	}

	public toolbox getTools() {
		return tools;
	}

	public void setTools(toolbox tools) {
		this.tools = tools;
	}
	
	/*public void mostarAdm() {
		admConsole.cdAdm();
	}*/
}
