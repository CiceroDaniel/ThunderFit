package app;
import app.consoleMenu;
import model.Metas;
import model.Tutor;
import model.Usuario;

import java.time.LocalDate;
import java.util.*;

import repository.ExercicioRepository;
import repository.PagamentoRepository;
import repository.TreinoRepository;
import repository.UsuarioRepository;
import services.AuthService;
import services.ExercicioService;
import services.PagamentoService;
import services.TreinoService;
import services.UsuarioService;

public class tutorConsole {
	usuarioConsole user;
	admConsole adm;
	tutorConsole tutor;
	
	
	
	private UsuarioRepository uRepo;
	private Scanner scanner;
	private UsuarioService services;
	private AuthService auth;
	private ExercicioRepository exRepo;
	private ExercicioService exServi; 
	private TreinoRepository treRepo;
	private TreinoService treServi;
	private PagamentoRepository pagRepo;
	private PagamentoService pagService;
	
	
	public tutorConsole(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services,
			ExercicioRepository exRepo,ExercicioService exServi, TreinoRepository treRepo, TreinoService treServi, PagamentoRepository pagRepo, PagamentoService pagService) {
		this.scanner = scanner;
	    this.uRepo = repo;  // Usa o repositório injetado
	    this.auth = auth;   // Usa o auth injetado
	    this.services = services; // Usa o service injetado
	    this.exRepo= exRepo;
	    this.exServi= exServi;
	    this.treRepo= treRepo;
	    this.treServi=treServi;
	    this.pagRepo = pagRepo;
	    this.pagService = pagService;
	}

	//========================================================================
	public void associarTreinoAluno() {
	    System.out.println("\nDigite o CPF do aluno:");
	    String cpf = scanner.nextLine();
	    
	    System.out.println("Digite o nome do treino:");
	    String nomeTreino = scanner.nextLine();
	    
	    try {
	        treServi.associarTreinoAluno(cpf, nomeTreino, auth.getUsuario());
	        System.out.println("Treino associado com sucesso!");
	    } catch (Exception e) {
	        System.out.println("Erro: " + e.getMessage());
	    }
	}
	
	
	
	
	//====================================MENUS=======================================
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
	
public void atualizarDados() {
		
		Usuario usuario = auth.getUsuario();
		
		System.out.println("==========DADOS ATUAIS============="
				+"\n" + usuario.gerarCredenciaisCadastro() 
				+ "\n" + usuario.gerarCredenciaisLogin()
				);
		toolbox.espacoMenu();
		auth.getUsuario().getCpf();
		System.out.println("==========Atualizar dados dos alunos============");
		System.out.println("EMAIL: ");
		String email = scanner.nextLine();
		
		System.out.println("PESO: ");
		double peso = scanner.nextDouble();
		scanner.nextLine();
		
		System.out.println("ALTURA: ");
		double altura = scanner.nextDouble();
		scanner.nextLine();
		
		
		services.atualizarDados(auth.getUsuario().getCpf(), email, peso, altura, null);
		
		
		
	}

public void AtualizarSenha() {
	System.out.println("=======ATUALIZAR SENHA=====");
	System.out.println("NOVA SENHA: ");
	String senha = scanner.nextLine();
	
	
	services.alterarSenha(auth.getUsuario().getCpf(), senha);
}
	
	public void menuGerenciarTreinos() {
	    int op;
	    do {
	        System.out.println("\n----- GERENCIAR TREINOS -----"
	                + "\n1 - Criar novo treino"
	                + "\n2 - Editar treino"
	                + "\n3 - Listar treinos"
	                + "\n4 - Associar a aluno"
	                + "\n5 - Voltar");
	        op = scanner.nextInt();
	        scanner.nextLine();
	        
	        switch(op) {
	            case 1: criarTreino();
	                break;
	            case 2: //editarTreino();
	                break;
	            case 3: //listarTreinos();
	                break;
	            case 4: associarTreinoAluno();
	                break;
	            case 5: return;
	            default: System.out.println("Opção inválida!");
	        }
	    } while(true);
	}
	
	
	public void tutorMenu(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services) {
		toolbox.espacoMenu();
		System.out.println("================== TUTOR ===================");
		int op; 
		do {
			System.out.println("======= MENU DOS TUTORES ======="
					+ "\n1 - MEU PERFIL"
					+ "\n2 - GERENCIAR TREINOS" // MENU DE TREINOS COM CRUD, PARA ADICIONAR TREINO ELE LISTA OS EXERCICIOS
					+ "\n3 - ATUALIZAR DADOS"
					+ "\n4 - ALTERAR SENHA"  //MENU PARA LISTAR BUSCAR POR NOME, ATUALIZAR DADOS
					+ "\n0 - VOLTAR");
			op = scanner.nextInt();
			scanner.nextLine();
			
			//
			switch(op) {
			case 1 : tutor.cadastroMenu(scanner, repo, auth, services); ;
				break;
			case 2 :  gerenciarTreinos();
				break;
			case 3:	atualizarDados();
				break;
			case 4: AtualizarSenha();
			break;
			case 0: adm.admMenu();
			default: System.out.println("OPÇÃO INVALIDA!");
		}
			
		}while(op!=0);
	}
	
	
	public void gerenciarTreinos() {
		System.out.println("======GERENCIAR TREINOS=========");
		int op;
		do{
			System.out.println("\n1 - CRIAR NOVO TREINO"
					+ "\n2 - ASSOCIAR TREINO A ALUNO"
					+ "\n3 - REMOVER TREINO"
					+ "\n0 - VOLTAR");
			op = scanner.nextInt();
			scanner.nextLine();
			
			switch(op) {
			case 1: criarTreino();
				break;
			case 2: associarTreinoAluno();
				break;
			case 3: removerTreino();
				break;
			case 0: tutorMenu(scanner, uRepo, auth, services);
				break;
			default: System.out.println("OPÇÃO INVALIDA!");
			
			
			}
			
		}while(op!=0);
	}
	
	
	public void criarTreino() {
		System.out.println("=====CRIAR NOVOS TREINOS====="
				+ "\nNOME: ");
		String  nome = scanner.nextLine();
		
		System.out.println("NIVEL: ");
		String nivel = scanner.nextLine();
		
		treServi.criarTreino(nome, nivel, auth.getUsuario());
	}
	
	
	public void AssociarTreino() {
		System.out.println("=====ASSOCIAR TREINO A ALUNO======");
		System.out.println("DIGITE O CPF DO ALUNO");
		String cpf = scanner.nextLine();
		System.out.println("QUAL TREINO QUER ASSOCIAR?");
		String treino = scanner.nextLine();
		
		treServi.associarTreinoAluno(cpf, treino, auth.getUsuario());
		
		
	}
	
	public void removerTreino() {
		System.out.println("QUAL TREINO QUER DELETAR?"
				+ "\nNOME: ");
		String nome = scanner.nextLine();
		treServi.removerTreino(nome, auth.getUsuario());
	}
	
	
	
	public void cdTutor() {
	    String dataScn = "2006-10-23";
	    LocalDate dataDeNascimento = LocalDate.parse(dataScn);

	    try {
	        services.cadastroTutor("yuri", "yuri@gmail.com", "123456789", "14725836910", dataDeNascimento, 1520);
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
