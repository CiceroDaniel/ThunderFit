package app;
import app.consoleMenu;
import java.time.LocalDate;
import java.util.*;

import repository.UsuarioRepository;
import services.AuthService;
import services.UsuarioService;

public class tutorConsole {
private UsuarioRepository uRepo;
private Scanner scanner;
private UsuarioService services;
private AuthService auth;

	
	
	public tutorConsole(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services) {
		this.scanner = scanner;
	    this.uRepo = repo;  // Usa o repositório injetado
	    this.auth = auth;   // Usa o auth injetado
	    this.services = services; // Usa o service injetado
	}

	public void cadastroMenu(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services) {
		toolbox.espacoMenu();
		
		System.out.println("==============CADASTRO=================");
		System.out.println("1. NOME DE USUÁRIO");
		
		String nome = scanner.nextLine();
		
		System.out.println("2. CPF DO USUÁRIO");
		String cpf = scanner.nextLine();
		
		System.out.println("3. E-MAIL DO USUÁRIO");
		String email = scanner.nextLine();
		
		System.out.println("4. SENHA DO USUÁRIO");
		String senha = scanner.nextLine();
		
		System.out.println("5. DATA DE NASCIMENTO (AAAA-MM-DD");
		String dataScn = scanner.nextLine();
		LocalDate dataDeNascimento = LocalDate.parse(dataScn);
		
		System.out.println("6. QUAL O SALÁRIO DO TUTOR?");
		float salario = scanner.nextFloat();
		
		services.cadastroTutor(nome, email, senha, cpf, dataDeNascimento, salario);
	}
	
	public void loginMenu(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services) {
		toolbox.espacoMenu();
		
		System.out.println("==============LOGIN===============");
		System.out.println("E-MAIL: ");
		String emailLogin = scanner.nextLine();
		
		System.out.println("SENHA: ");
		String senhaLogin = scanner.nextLine();
		
		auth.login(emailLogin, senhaLogin);
		System.out.println(auth.getUsuarioLogado());
		
		if(auth.getUsuarioLogado() == true) {
			System.out.println("logaaaaaaaaaaaaaaaaaaaado");
			tutorMenu(scanner, repo, auth, services);
		}
		
	}
	
	public void tutorMenu(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services) {
		toolbox.espacoMenu();
		System.out.println("================== TUTOR ===================");
	}
	
	public void cdTutor() {
	    String dataScn = "2006-10-23";
	    LocalDate dataDeNascimento = LocalDate.parse(dataScn);

	    try {
	        services.cadastroTutor("daniel", "daniel@gmail.com", "123456789", "14725836910", dataDeNascimento, 1520);
	    } catch (IllegalArgumentException e) {
	        System.out.println(e.getMessage());
	    }

	    dataScn = "2005-06-18";
	    LocalDate dataDeNascimento1 = LocalDate.parse(dataScn);
	    try {
	        services.cadastroTutor("Ysabelle", "bell@gmail.com", "ysabelle01", "96385274101", dataDeNascimento1, 1900);
	    } catch (IllegalArgumentException e) {
	        System.out.println(e.getMessage());
	    }
	}

	
}
