package app;
import java.time.LocalDate;
import java.util.*;

import repository.PagamentoRepository;
//import model.Plano;
import repository.UsuarioRepository;
import services.AuthService;
import services.PagamentoService;
import services.UsuarioService;
import model.*;


//FUNCIONANDO

public class admConsole {;
	
	private UsuarioRepository repo;
	private usuarioConsole user;
	private admConsole adm;
	private tutorConsole tutor;
	//
	private Scanner scanner;
	private toolbox tools;
	private AuthService auth;
	private UsuarioService services;
	private PagamentoRepository pagRepo;
	private PagamentoService pagService;
	
	boolean u;
	
	public admConsole(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services, PagamentoRepository pagRepo, PagamentoService pagService) {
		this.scanner = scanner;
	    this.repo = repo;
	    this.auth = auth;
	    this.services = services;
	    this.pagRepo= pagRepo;
	    this.pagService = pagService;
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
	///////////////////////////////////////////////////////////////////////////
	
	public void Perfil() {
		toolbox.espacoMenu();
		
		 if (!auth.getUsuarioLogado()) {
		        System.out.println("Nenhum usuário logado.");
		        return;
		    }
		
		 Usuario usuario = auth.getUsuario();
		 
		 
		 if(usuario instanceof Administrador) {
	   	System.out.println("========== PERFIL DO TUTOR ==========");
		    System.out.println(usuario.gerarCredenciais()+"\n");
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
			case 1 :  Perfil();
				break;
			case 2 :  CrudTutor();
				break;
			case 3: CrudAluno();
				break;
			case 4: System.out.println(Plano.mostrarPlanos());
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
			case 2 :  atualizar(true);
				break;
			case 3: pesquisar(true);
				break;
			case 4: deletar(true);
				break;
			case 5: tutor.listarTutor();
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
			case 2 : atualizar(false);
				break;
			case 3: pesquisar(false);
				break;
			case 4: deletar(false);
				break;
			case 5: listarAlunos();
			break;
			case 6: admMenu();
			default: System.out.println("OPÇÃO INVALIDA!");
		}
			
		}while(op!=0);
	}
	
	/////////////////////////////////////////////////////////
	public void deletar(boolean u) {
		System.out.println(services.listarTutores());
		if(u = false) {
			System.out.println("=====DELETAR USUÁRIO=======");
			System.out.println("QUAL USUÁRIO DESEJA DELETAR?"
					+ "\nCPF: ");
			String cpf = scanner.nextLine();
			
			services.removerUsuario(cpf, auth.getUsuario());
			
		}else {
			System.out.println("=====DELETAR TUTOR=======");
			System.out.println("QUAL TUTOR DESEJA DELETAR?"
					+ "\nCPF: ");
			String cpf = scanner.nextLine();
			
			services.removerUsuario(cpf, auth.getUsuario());
		}
		
		}

	public void atualizar(boolean u) {
		
		
		if(u = false) {
			
			System.out.println("========ADM ATUALIZA ALUNO=======");
			System.out.println("\n1 - ATUALIZAR DADOS"
					+ "\n2 - ATUALIZAR SENHA"
					+ "\n3 -  VOLTAR");
			int op = scanner.nextInt();
			scanner.nextLine();
			
			switch(op) {
			case 1: user.atualizarDados();
			break;
			case 2: user.AtualizarSenha();
			break;
			case 3:CrudAluno();
			break;
			default: System.out.println("OPÇÃO INVALIDA");
			}
		}else {
			
			System.out.println("========ADM ATUALIZA TUTOR=======");
			System.out.println("\n1 - ATUALIZAR DADOS"
					+ "\n2 - ATUALIZAR SENHA"
					+ "\n3 -  VOLTAR");
			int op = scanner.nextInt();
			scanner.nextLine();
			
			switch(op) {
			case 1: tutor.atualizarDados();
			break;
			case 2: tutor.AtualizarSenha();
			break;
			case 3:CrudTutor();
			break;
			default: System.out.println("OPÇÃO INVALIDA");
			}
		}
		
		
		
		
	}
	
	/////////////////////////////////////////////////////////
	public void pesquisar(boolean u){
        int op;
        System.out.println("========= METODOS DE PESQUISA ========="
        + "\n PESQUISAT POR: "
        + "\n1 - NOME"
        + "\n2 - EMAIL"
        + "\n3 - CPF"
        + "\n4 - VOLTAR");
        
        op = scanner.nextInt();
        scanner.nextLine();
        
	        if(u = true) {
	        	switch(op){
	            case 1: buscarPorNome();
	            break;
	            case 2: buscarPorEmail();
	            break;
	            case 3: buscarPoCpf();
	            break;
	            case 4:CrudTutor();
	            default: System.out.println("OPÇÃO INVALIDA");
	        }while(op!=0);
	        
	       }else {
	        	switch(op){
	            case 1: buscarPorNome();
	            break;
	            case 2: buscarPorEmail();
	            break;
	            case 3: buscarPoCpf();
	            break;
	            case 4: CrudAluno();
	            default: System.out.println("OPÇÃO INVALIDA");
	        }while(op!=0);
        }
    }
	
	public void listarAlunos() {
		List <Aluno> alunos = services.listarAlunos(auth.getUsuario());
		if(alunos.isEmpty()) {
			System.out.println("Nenhum tutor cadastrado!");
			return;
		}
		System.out.println("=============== LISTA DE TUTORES ==================");
		int i=1;
		for(Aluno aluno: alunos) {
	        System.out.println("-------- Tutor " + i + " --------");
	        System.out.println("Nome: " + aluno.getNome());
	        System.out.println("Email: " + aluno.getEmail());
	        System.out.println("---------------------------------\n");
	        i++;
		}
		
	
	}
    
	public void buscarPorNome(){
	    
	    System.out.println("QUAL O NOME DO USUÁRIO QUE DESEJA PESQUISAR?"
	    + "\nNOME: ");
	    
	    String nome = scanner.nextLine();
	    if(nome == null) {
	    	System.out.println("O NKME NAO PODER SER NULO");
	    	
	    }else{
	    	services.buscarPorNome(nome);
	       }
	    
	}
	
	/////////NAO TA PRINTANDO O USUARIO
	
	public void buscarPorEmail(){
	    
	    System.out.println("QUAL O Email DO USUÁRIO QUE DESEJA PESQUISAR?"
	    + "\nEmail: ");
	    
	    String email = scanner.nextLine();
	    if(email == null) {
	        System.out.println("O Email NAO PODER SER NULO");
		}else{
			System.out.println("error");
		}
			
	}
	    
	public void buscarPoCpf(){
	    
	    System.out.println("QUAL O CPF DO USUÁRIO QUE DESEJA PESQUISAR?"
	    + "\nCPF: ");
	    
	    String cpf = scanner.nextLine();
	    if(cpf == null) {
	        System.out.println("O NOME NAO PODER SER NULO");
	    }else{
	            System.out.println(services.buscarPorCpf(cpf));
	        }
	    
	}
	
	public void cdAdm() {
		String dataScn = "2006-10-23";
		LocalDate dataDeNascimento = LocalDate.parse(dataScn);
		services.cadastroAdministrador("daniel", "daniel@gmail.com","123123123", "12314563610", dataDeNascimento);
		
	}
}
