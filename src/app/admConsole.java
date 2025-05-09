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
	
	boolean u;
	
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
			u = false;
			//
			switch(op) {
			case 1 : tutor.cadastroMenu(scanner, repo, auth, services); ;
				break;
			case 2 :  //atualizar um tutor
				break;
			case 3: pesquisar(u);
				break;
			case 4: //DELETAR
				break;
			case 5: services.listarTutores();
			break;
			case 6: admMenu();
			default: System.out.println("OPÇÃO INVALIDA!");
		}
			
		}while(op!=0);
	}
	
	/////////////////////////////////////////////////////////////////////////
	public void CrudAluno() {
		int op; 
		do {
			System.out.println("======= CRUD DOS ALUNOS ======="
					+ "\n1 - CADASTRAR"
					+ "\n2 - ATUALIZAR"
					+ "\n3 - PESQUISAR"
					+ "\n4 - DELETAR"
					+ "\n5 - LISTAR"
					+ "\n6 - VOLTAR");
			op = scanner.nextInt();
			scanner.nextLine();
			u =  true;
			//
			switch(op) {
			case 1 : user.cadastroMenu(scanner, repo, auth, services);;
				break;
			case 2 :  //atualizar um tutor
				break;
			case 3: //PESQUISAR
				break;
			case 4: //DELETAR;
				break;
			case 5: //LISTAR;
			break;
			case 6: admMenu();
			default: System.out.println("OPÇÃO INVALIDA!");
		}
			
		}while(op!=0);
	}
	/////////////////////////////////////////////////////////
	public void pesquisar(boolean u){
        int op;
        boolean tipo;
        this.u = tipo;
        System.out.println("========= METODOS DE PESQUISA ========="
        + "\n PESQUISAT POR: "
        + "\n1 - NOME"
        + "\n2 - EMAIL"
        + "\n3 - CPF"
        + "\n4 - VOLTAR");
        
        op = scanner.nextInt();
        scanner.nextLine();
        
        switch(op){
            case 1: //pesquisar por nome
            break;
            case 2: //pesquisar pir email
            break;
            case 3: //pesquisar por cpf
            break;
            case 4: // volta para o menu antwrior
            default: System.out.println("OPÇÃO INVALIDA");
        }while(op!=0);
    }
    
public void buscarPorNome(){
    
    System.out.println("QUAL O NOME DO USUÁRIO QUE DESEJA PESQUISAR?"
    + "\nNOME: ");
    
    String nome = scanner.nextLine();
    if(nome == null) {
    	System.out.println("O NKME NAO PODER SER NULO");
    	
    }else{
            //chama a funcao pesquisat por nome e printa as informacoes delw
       }
    
}

public void buscarPorEmail(){
    
    System.out.println("QUAL O Email DO USUÁRIO QUE DESEJA PESQUISAR?"
    + "\nEmail: ");
    
    String email = scanner.nextLine();
    if(email == null) {
        System.out.println("O Email NAO PODER SER NULO");
}else{
            //chama a funcao pesquisat por emil e printa as informacoes delw
        }
    
}
    
public void buscarPorCpf(){
    
    System.out.println("QUAL O CPF DO USUÁRIO QUE DESEJA PESQUISAR?"
    + "\nCPF: ");
    
    String cpf = scanner.nextLine();
    if(cpf == null) {
        System.out.println("O NOME NAO PODER SER NULO");
    }else{
            //chama a funcao pesquisat por cpf e printa as informacoes delw
        }
    
}
	
	public void cdAdm() {
		String dataScn = "2006-10-23";
		LocalDate dataDeNascimento = LocalDate.parse(dataScn);
		services.cadastroAdministrador("daniel", "daniel@gmail.com","123123123", "12314563610", dataDeNascimento);
		
	}
}
