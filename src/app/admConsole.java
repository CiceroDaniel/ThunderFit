package app;
import java.time.LocalDate;
import java.util.*;

//import model.Plano;
import repository.UsuarioRepository;
import services.AuthService;
import services.UsuarioService;
import model.*;


//FUNCIONANDO

public class admConsole {;
	
	private UsuarioRepository repo;
	usuarioConsole user;
	admConsole adm;
	tutorConsole tutor;
	//
	private Scanner scanner;
	private toolbox tools;
	private AuthService auth;
	private UsuarioService services;
	
	public admConsole(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services) {
		this.scanner = scanner;
	    this.repo = repo;
	    this.auth = auth;
	    this.services = services;
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
		
		if(auth.getUsuarioLogado() == true) {
			admMenu();
		}
		
	}
	
	////////////////////////////////////////////////////////////////////////
	public final void admMenu() {
		int op;
		do {
			System.out.println("========= MENU ADMINISTRADOR =========="
					+ "\n1 - PERFIL"
					+ "\n2 - INSTRUTORES"
					+ "\n3 - USUÁRIOS"
					+ "\n4 - PACOTES");
			op = scanner.nextInt();
			scanner.nextLine();
			
			switch(op) {
			case 1 :  //chama o perfil;
				break;
			case 2 :  CrudTutor();
				break;
			case 3: //cronograma
				break;
			case 4: //System.out.println(Plano.mostrarPlanos());
				break;
			case 5 :System.out.println("SAINDO DO SISTEMA.......");
			System.exit(0);
			default: System.out.println("OPÇÃO INVALIDA!");
		}
			
		}while(op!=0);
		
	}
	
	////////////////////////////////////////////////////////////////////////
	public final void CrudTutor() {
		int op; 
		do {
			System.out.println("======= CRUD DOS TUTORES ======="
					+ "\n1 - CADASTRAR"
					+ "\n2 - ATUALIZAR"
					+ "\n3 - PESQUISAR"
					+ "\n4 - DELETAR"
					+ "\n5 - LISTAR"
					+ "\n6 - VOLTAR");
			op = scanner.nextInt();
			scanner.nextLine();
			
			//
			switch(op) {
			case 1 : tutor.cadastroMenu(scanner, repo, auth, services); ;
				break;
			case 2 :  //atualizar um tutor
				break;
			case 3: //cronograma
				break;
			case 4: //System.out.println(Plano.mostrarPlanos());
				break;
			case 5: services.listarTutores();
			break;
			case 6: admMenu();
			default: System.out.println("OPÇÃO INVALIDA!");
		}
			
		}while(op!=0);
	}
	
	
	public void cdAdm() {
		String dataScn = "2006-10-23";
		LocalDate dataDeNascimento = LocalDate.parse(dataScn);
		services.cadastroAdministrador("daniel", "daniel@gmail.com","123123123", "12314563610", dataDeNascimento);
		
	}
}
