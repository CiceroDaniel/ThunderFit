package app;
import app.consoleMenu;
import model.Aluno;
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
import view.Perfil;

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
			ExercicioRepository exRepo,ExercicioService exServi, TreinoRepository treRepo, TreinoService treServi,
			PagamentoRepository pagRepo, PagamentoService pagService) {
		this.scanner = scanner;
	    this.uRepo = repo;  
	    this.auth = auth;  
	    this.services = services; 
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
		
		System.out.println("""
		        ============== CADASTRO =================
		        Preencha os dados abaixo:
		        """);
		
		System.out.println("1. NOME COMPLETO: ");
		
		String nome = scanner.nextLine();
		
		System.out.println("2. CPF (apenas numeros): ");
		String cpf = scanner.nextLine();
		
		System.out.println("3. E-MAIL: ");
		String email = scanner.nextLine();
		
		System.out.println("4. SENHA: ");
		String senha = scanner.nextLine();
		
		System.out.println("5. DATA DE NASCIMENTO (AAAA-MM-DD");
		String dataScn = scanner.nextLine();
		LocalDate dataDeNascimento = LocalDate.parse(dataScn);
		
		System.out.println("6. SALÁRIO: ");
		float salario = scanner.nextFloat();
		
		services.cadastroTutor(nome, email, senha, cpf, dataDeNascimento, salario);
	}
	
	public void loginMenu(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services) {
		toolbox.espacoMenu();
		
		System.out.println("\n╔════════════════════════╗");
	    System.out.println("║       🔐 LOGIN        ║");
	    System.out.println("╚════════════════════════╝");
		System.out.println("\n📧 Email: ");
		String emailLogin = scanner.nextLine();
		
		System.out.println("\n🔒 Senha: ");
		String senhaLogin = scanner.nextLine();
		
		System.out.println("\n╔════════════════════════╗");
	    System.out.println("║   Aguarde...          ║");
	    System.out.println("╚════════════════════════╝");
	    
	    try {
	    	auth.login(emailLogin, senhaLogin);
	    	System.out.println("\n✔ Login realizado com sucesso!");
	    	tutorMenu(scanner, repo, auth, services);
	    }catch(Exception e){
	    	System.out.println("\n✖ Erro: " + e.getMessage());
	    }
		
		
	}
	
public void atualizarDados() {
		
		Usuario usuario = auth.getUsuario();
		
		 System.out.println("\n╔══════════════════════════════════╗");
		    System.out.println("║          📝 ATUALIZAR DADOS      ║");
		    System.out.println("╚══════════════════════════════════╝");
		
		    System.out.println("\n╔══════════════════════════════════╗");
		    System.out.println("║          📝 DADOS ATUAIS     ║");
		    System.out.println("╚══════════════════════════════════╝");    
		    
		System.out.println("==========DADOS ATUAIS============="
				+"\n" + usuario.gerarCredenciaisCadastro() 
				+ "\n" + usuario.gerarCredenciaisLogin()
				);
		toolbox.espacoMenu();
		auth.getUsuario().getCpf();
		System.out.println("\n╔══════════════════════════════╗");
	    System.out.println("║    NOVOS DADOS                ║");
	    System.out.println("╚══════════════════════════════╝");
		System.out.println("\n📧 Email: ");
		String email = scanner.nextLine();
		
		System.out.println("\n⚖️ Peso atual ");
		double peso = scanner.nextDouble();
		scanner.nextLine();
		
		System.out.println("\n📏 Altura atual: ");
		double altura = scanner.nextDouble();
		scanner.nextLine();
		
		try {
			services.atualizarDados(auth.getUsuario().getCpf(), email, peso, altura, null);
			System.out.println("\n╔══════════════════════════════╗");
	        System.out.println("║    ✅ DADOS ATUALIZADOS!     ║");
	        System.out.println("╚══════════════════════════════╝");
			
		}catch(Exception e) {
			System.out.println("\n❌ Erro na atualização: " + e.getMessage());
		}
		
		
		
	}

public void AtualizarSenha() {
	System.out.println("\n╔══════════════════════════════════╗");
    System.out.println("║          📝 ATUALIZAR SENHA       ║");
    System.out.println("╚══════════════════════════════════╝");
	System.out.println("NOVA SENHA: ");
	String senha = scanner.nextLine();
	
	
	services.alterarSenha(auth.getUsuario().getCpf(), senha);
}
	
	public void menuGerenciarTreinos() {
	    int op;
	    do {
	    	 System.out.println("\n┌───────────────────────┐");
	    	    System.out.println("│   🏋️ Gerenciar Treinos  │");
	    	    System.out.println("├───────────────────────┤");
	    	    System.out.println("│ 1. Criar novo         │");
	    	    System.out.println("│ 2. Editar existente   │");
	    	    System.out.println("│ 3. Listar todos       │");
	    	    System.out.println("│ 4. Associar aluno     │");
	    	    System.out.println("│ 5. Remover            │");
	    	    System.out.println("│                       │");
	    	    System.out.println("│ 0. Voltar             │");
	    	    System.out.println("└───────────────────────┘");
	    	    System.out.print("Opção: ");
	        op = scanner.nextInt();
	        scanner.nextLine();
	        
	        switch(op) {
	            case 1: criarTreino();
	                break;
	            case 2: //editarTreino();
	                break;
	            case 3: //listarTreinos();
	            	listarTreinoDoAluno();
	                break;
	            case 4: associarTreinoAluno();
	                break;
	            case 5: removerTreino();
	            	break;
	            case 0:	tutorMenu(scanner, uRepo, auth, services);
	            default: System.out.println("Opção inválida!");
	        }
	    } while(true);
	}
	//listar treinos
	public void listarTreinoDoAluno() {
		System.out.println("QUAL O ALUNO?\nCPF: ");
		String cpf = scanner.nextLine();
		System.out.println(treServi.listarTreinosDoAluno(cpf, auth.getUsuario()));
	}
	// editar treino
	public void editTreino() {
		
	}
	
	public void tutorMenu(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services) {
		toolbox.espacoMenu();
		int op; 
		do {
			 System.out.println("\n┌──────────────────────────┐");
			    System.out.println("│   🧑🏫 Menu do Tutor      │");
			    System.out.println("├──────────────────────────┤");
			    System.out.println("│ 1. 👤 Meu perfil        │");
			    System.out.println("│ 2. 🏋️ Gerenciar treinos │");
			    System.out.println("│ 3. ✏️ Atualizar dados   │");
			    System.out.println("│ 4. 🔒 Alterar senha     │");
			    System.out.println("│                          │");
			    System.out.println("│ 0. ↩️ SAIR             │");
			    System.out.println("└──────────────────────────┘");
			    System.out.print("Opção: ");
			op = scanner.nextInt();
			scanner.nextLine();
			
			//
			switch(op) {
			case 1 : Perfil();
				break;
			case 2 :  menuGerenciarTreinos();
				break;
			case 3:	atualizarDados();
				break;
			case 4: AtualizarSenha();
			break;
			case 0: auth.logout();
			return;
				//loginMenu(scanner, repo, auth, services);;
			default: System.out.println("OPÇÃO INVALIDA!");
		}
			
		}while(op!=0);
	}
	
	public void Perfil() {
		toolbox.espacoMenu();
		
		 if (!auth.getUsuarioLogado()) {
		        System.out.println("Nenhum usuário logado.");
		        return;
		    }
		
		 Usuario tutor = auth.getUsuario();
		 
		 if(tutor instanceof Tutor) {
		 System.out.println("========== PERFIL DO ALUNO ==========\n");
		 System.out.println(tutor.gerarCredenciais());
		 }
		    
	}
	
	
	
	
	public void criarTreino() {
		System.out.println("\n┌───────────────────────┐");
	    System.out.println("│   🏋️ Criar Novo Treino │");
	    System.out.println("├───────────────────────┤");
	    
	    System.out.print("│ Nome: ");
	    String nome = scanner.nextLine();
	    
	    System.out.println("│ Nível:                │");
	    System.out.println("│ 1. Iniciante          │");
	    System.out.println("│ 2. Intermediário      │");
	    System.out.println("│ 3. Avançado           │");
	    System.out.print("│ Opção: ");
		String nivel = scanner.nextLine();
		
		treServi.criarTreino(nome, nivel, auth.getUsuario());
	}
	
	
	public void AssociarTreino() {
		System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        🏋️  ASSOCIAR TREINO A ALUNO     ║");
        System.out.println("╚════════════════════════════════════════╝");
        
       
        System.out.println("\n┌────────────────────────────────────────┐");
        System.out.println("│   🔍 DIGITE O CPF DO ALUNO:            │");
        System.out.println("└────────────────────────────────────────┘");
        System.out.print("│▸ ");
        String cpf = scanner.nextLine();
        
        
        System.out.println("\n┌────────────────────────────────────────┐");
        System.out.println("│   🏋️  QUAL TREINO QUER ASSOCIAR?       │");
        System.out.println("└────────────────────────────────────────┘");
        System.out.print("│▸ ");
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
