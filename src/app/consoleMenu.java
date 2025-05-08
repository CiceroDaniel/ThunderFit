package app;

import app.*;
import repository.UsuarioRepository;

import java.util.Scanner;


public class consoleMenu {
	Scanner scan = new Scanner(System.in);
	//usuarioConsole userConsole = new usuarioConsole();
	//admConsole admConsole = new admConsole();
	//tutorConsole  tutorConsole = new tutorConsole();
	//toolbox tools = new toolbox();
	
	
	
	UsuarioRepository repo;
	usuarioConsole userConsole;
	admConsole admConsole;
	tutorConsole tutorConsole;
	toolbox tools;

	
	
	public consoleMenu(UsuarioRepository repo) {
		this.userConsole = new usuarioConsole(repo);
		this.admConsole = new admConsole(repo);
		this.tutorConsole = new tutorConsole(repo);
		this.tools = new toolbox(userConsole, admConsole, tutorConsole);
	}

	// YSABELLE PASSE LONGE DESSE ARQUIVO PELO AMOR DE SAMARA!
	public void init() {
		
		int op;
		do {
			System.out.println("==========MENU INICIAL=========== \n"
					+ "1 - CADASTRO \n"
			 		+ "2 - LOGIN \n"
					+ "3 - SAIR \n"
					+ "ESCOLHA A OPÇÃO: ");
			op = scan.nextInt();
			scan.nextLine();
			//testando pra victor hugo
			switch(op) {
				case 1 :  Cadastro();
					break;
				case 2 :  login();
					break;
				case 3 :System.out.println("SAINDO DO SISTEMA.......");
				System.exit(0);
				default: System.out.println("OPÇÃO INVALIDA!");
			}
		}while(op!=0);
		
	}
	
	public void Cadastro() {
		int op;
		do {
			tools.espacoMenu();
			System.out.println("============CADASTRAR============"
					+ "\n1 - CLIENTE"
					+ "\n2 - TUTOR"
					+ "\n3 - VOLTAR"
					+ "\nESCOLHA UMA OPÇÃO: ");
			op = scan.nextInt();
			scan.nextLine();
			
			switch(op) {
			case 1: userConsole.cadastroMenu();
			break;
			case 2: tutorConsole.cadastroMenu();
			break;
			case 3: init();
			}
			
		}while(op!=0);
	}
	
	public void login() {
		int op;
		do {
			
			tools.espacoMenu();
			System.out.println("============LOGIN============"
					+ "\n1 - CLIENTE"
					+ "\n2 - TUTOR"
					+ "\n3 - ADIMINISTRADOR"
					+ "\n4 - VOLTAR"
					+ "\nESCOLHA UMA OPÇÃO: ");
			op = scan.nextInt();
			scan.nextLine();
			
			switch(op) {
			case 1: userConsole.loginMenu();
			break;
			case 2: tutorConsole.loginMenu();;
			break;
			case 3: //login do adm
			case 4: init();
			}
			
		}while(op!=0);
	}
	
	/*public void mostarAdm() {
		admConsole.cdAdm();
	}*/
}
