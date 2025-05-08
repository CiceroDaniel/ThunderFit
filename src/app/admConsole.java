package app;
import java.time.LocalDate;
import java.util.*;

import repository.UsuarioRepository;
import services.AuthService;
import services.UsuarioService;

//FUNCIONANDO

public class admConsole {
	UsuarioRepository uRepo = new UsuarioRepository();
	UsuarioService services = new UsuarioService(uRepo);
	Scanner scanner = new Scanner(System.in);
	toolbox tools;
	AuthService auth = new AuthService(uRepo);
	
	public admConsole(UsuarioRepository repo) {
		this.uRepo = repo;
		this.services = new UsuarioService(repo);
		this.auth = new AuthService(repo);
	}

	public void cdAdm() {
		String dataScn = "2006-10-23";
		LocalDate dataDeNascimento = LocalDate.parse(dataScn);
		services.cadastroAdministrador("daniel", "daniel@gmail.com","123123123", "12314563610", dataDeNascimento);
		
	}
	
	public void loginMenu() {
		toolbox.espacoMenu();
		
		System.out.println("==============LOGIN===============");
		System.out.println("E-MAIL: ");
		String emailLogin = scanner.nextLine();
		
		System.out.println("SENHA: ");
		String senhaLogin = scanner.nextLine();
		
		auth.login(emailLogin, senhaLogin);
		System.out.println(auth.getUsuarioLogado());
		
	}
	
}
