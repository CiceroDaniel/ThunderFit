package app;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

import repository.PagamentoRepository;
//import model.Plano;
import repository.UsuarioRepository;
import services.AuthService;
import services.PagamentoService;
import services.*;
import model.*;


//FUNCIONANDO

public class admConsole {
	
	private UsuarioRepository repo;
	usuarioConsole user;
	admConsole adm;
	tutorConsole tutor;
	//
	private Scanner scanner;
	private toolbox tools;
	private AuthService auth;
	private UsuarioService services;
	private PagamentoRepository pagRepo;
	private PagamentoService pagService;
	private final RelatorioPresencaService relatorioPresencaService;
    private final RelatorioFinanceiroService relatorioFinanceiroService;
    private final PlanoService planoService;
    private final PresencaService presencaService;

	
	public admConsole(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services, PagamentoRepository pagRepo, PagamentoService pagService, RelatorioPresencaService relatorioPresencaService,RelatorioFinanceiroService relatorioFinanceiroService, PlanoService planoService, PresencaService presencaService) {
		this.scanner = scanner;
	    this.repo = repo;
	    this.auth = auth;
	    this.services = services;
	    this.pagRepo= pagRepo;
	    this.pagService = pagService;
	    
	    this.user = new usuarioConsole(scanner, services, auth, pagRepo, pagService);
	    this.tutor = new tutorConsole(scanner, repo, auth, services, null, null, null, null, pagRepo, pagService);
	    
	    this.relatorioPresencaService = relatorioPresencaService;
        this.relatorioFinanceiroService = relatorioFinanceiroService;
        this.planoService = planoService;
        this.presencaService = presencaService;
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
	                + "\n4 - PACOTES"
	                + "\n5 - RELATÓRIOS DE FREQUÊNCIA"
	                + "\n6 - RELATÓRIOS FINANCEIROS"
	                + "\n7 - GERENCIAR PLANOS"
	                + "\n0 - SAIR");
	        op = scanner.nextInt();
	        scanner.nextLine();
	        
	        switch(op) {
	            case 1: Perfil(); 
	            	break;
	            case 2: CrudTutor(); 
	            	break;
	            case 3: CrudAluno(); 
	            	break;
	            case 4: System.out.println(Plano.mostrarPlanos()); 
	            	break;
	            case 5: gerenciarRelatoriosFrequencia(); 
	            	break;
	            case 6: gerenciarRelatoriosFinanceiros(); 
	            	break;
	            case 7: listarAlunos(); 
	            	break;
	            case 0: System.out.println("SAINDO DO SISTEMA.......");
	            	break;
	            default: System.out.println("OPÇÃO INVALIDA!");
	        }
	    } while(op != 0);
		
	}
	

	public void gerenciarRelatoriosFinanceiros() {
	    int op;
	    do {
	        System.out.println("===== RELATÓRIOS FINANCEIROS ====="
	                + "\n1 - MENSAL"
	                + "\n2 - ANUAL"
	                + "\n0 - VOLTAR");
	        op = scanner.nextInt();
	        scanner.nextLine();
	        
	        if(op == 1) exibirRelatorioFinanceiroMensal();
	    } while(op != 0);
	}

	private void exibirRelatorioFinanceiroMensal() {
	    try {
	        System.out.println("Mês (1-12):");
	        int mes = scanner.nextInt();
	        System.out.println("Ano:");
	        int ano = scanner.nextInt();
	        scanner.nextLine();
	        
	        YearMonth yearMonth = YearMonth.of(ano, mes);
	        RelatorioFinanceiro relatorio = relatorioFinanceiroService.gerarRelatorioMensal(yearMonth, auth.getUsuario());
	        
	        System.out.println("\n======== RELATÓRIO FINANCEIRO ========");
	        System.out.printf("Período: %s/%d\n", yearMonth.getMonth(), yearMonth.getYear());
	        System.out.printf("Receita: R$ %.2f\n", relatorio.getReceitaTotal());
	        System.out.printf("Despesas (salários): R$ %.2f\n", relatorio.getDespesasTotal());
	        System.out.printf("Lucro: R$ %.2f\n", relatorio.getLucro());
	        System.out.println("==================================\n");
	    } catch (Exception e) {
	        System.out.println("Erro ao gerar relatório: " + e.getMessage());
	    }
	}
	
	private void gerenciarRelatoriosFrequencia() {
		// TODO Auto-generated method stub
		int op;
	    do {
	        System.out.println("===== RELATÓRIOS DE FREQUÊNCIA ====="
	                + "\n1 - POR ALUNO"
	                + "\n2 - GERAL POR PERÍODO"
	                + "\n0 - VOLTAR");
	        op = scanner.nextInt();
	        scanner.nextLine();
	        
	        switch(op) {
	            case 1:
	                System.out.println("Digite o CPF do aluno:");
	                String cpf = scanner.nextLine();
	                exibirFrequenciaAluno(cpf);
	                break;
	            case 2:
	                exibirRelatorioFrequenciaGeral();
	                break;
	        }
	    } while(op != 0);
		}
		
	private void exibirFrequenciaAluno(String cpf) {
	    try {
	        System.out.println("Mês (1-12):");
	        int mes = scanner.nextInt();
	        System.out.println("Ano:");
	        int ano = scanner.nextInt();
	        scanner.nextLine();
	        
	        String relatorio = relatorioPresencaService.gerarFrequenciaMensal(cpf, mes, ano);
	        System.out.println("\n" + relatorio + "\n");
	    } catch (Exception e) {
	        System.out.println("Erro: " + e.getMessage());
	    }
	}

	private void exibirRelatorioFrequenciaGeral() {
	    try {
	        System.out.println("Data inicial (AAAA-MM-DD):");
	        LocalDateTime inicio = LocalDate.parse(scanner.nextLine()).atStartOfDay();
	        System.out.println("Data final (AAAA-MM-DD):");
	        LocalDateTime fim = LocalDate.parse(scanner.nextLine()).atTime(23, 59);
	        
	        List<Presenca> presencas = relatorioPresencaService.gerarRelatorioPorPeriodo(inicio, fim);
	        
	        System.out.println("\n===== PRESENÇAS NO PERÍODO =====");
	        presencas.forEach(p -> System.out.printf("%s - %s%n", 
	            p.getAluno().getNome(), p.getDataHora().format(DateTimeFormatter.ISO_LOCAL_DATE)));
	    } catch (Exception e) {
	        System.out.println("Erro: " + e.getMessage());
	    }
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
			case 5: user.listarTutor();
			break;
			case 6: admMenu();
			default: System.out.println("OPÇÃO INVALIDA!");
		}
			
		}while(op!=0);
	}
	
	/////////////////////////////////////////////////////////////////////////
	public void CrudAluno() {
		if(!auth.getUsuarioLogado()) {
	        System.out.println("Necessário fazer login primeiro!");
	        return;
	    }
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
			
			//
			switch(op) {
			case 1 : user.cadastroMenu(scanner, repo, auth, services);
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
		if(!u) {
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
		
		
		if(u == false) {
			
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
        
	       switch(op){
	            case 1: buscarPorNome();
	            break;
	            case 2: buscarPorEmail();
	            break;
	            case 3: buscarPoCpf();
	            break;
	            case 4: if(u) CrudTutor();
	            else CrudAluno();
	            default: System.out.println("OPÇÃO INVALIDA");
	        }while(op!=0);
	      
    }
	
	public void listarAlunos() {
		List <Aluno> alunos = services.listarAlunos(auth.getUsuario());
		if(alunos.isEmpty()) {
			System.out.println("Nenhum tutor cadastrado!");
			return;
		}
		System.out.println("=============== LISTA DE ALUNOS ==================");
		int i=1;
		for(Aluno aluno: alunos) {
	        System.out.println("-------- Aluno " + i + " --------");
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
	    try {
	        List<Usuario> usuarios = services.buscarPorNome(nome);
	        if(usuarios.isEmpty()) {
	            System.out.println("Nenhum usuário encontrado com esse nome.");
	        } else {
	            System.out.println("======== RESULTADOS DA BUSCA ========");
	            for(Usuario usuario : usuarios) {
	                System.out.println("Nome: " + usuario.getNome());
	                System.out.println("Email: " + usuario.getEmail());
	                System.out.println("CPF: " + usuario.getCpf());
	                System.out.println("---------------------------------");
	            }
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Erro: " + e.getMessage());
	    }
	    
	}
	
	/////////NAO TA PRINTANDO O USUARIO
	
	public void buscarPorEmail(){
	    
	    System.out.println("QUAL O Email DO USUÁRIO QUE DESEJA PESQUISAR?"
	    + "\nEmail: ");
	    
	    String email = scanner.nextLine();
	    try {
	        Usuario usuario = services.buscarPorEmail(email, auth.getUsuario());
	        if(usuario != null) {
	            System.out.println("======== USUÁRIO ENCONTRADO ========");
	            System.out.println("Nome: " + usuario.getNome());
	            System.out.println("Email: " + usuario.getEmail());
	            System.out.println("CPF: " + usuario.getCpf());
	            System.out.println("Tipo: " + (usuario instanceof Aluno ? "Aluno" : 
	                             usuario instanceof Tutor ? "Tutor" : "Administrador"));
	        } else {
	            System.out.println("Nenhum usuário encontrado com esse email.");
	        }
	    } catch (Exception e) {
	        System.out.println("Erro: " + e.getMessage());
	    }
			
	}
	    
	public void buscarPoCpf(){
	    
	    System.out.println("QUAL O CPF DO USUÁRIO QUE DESEJA PESQUISAR?"
	    + "\nCPF: ");
	    
	    String cpf = scanner.nextLine();
	    
	    try {
	        Usuario usuario = services.buscarPorCpf(cpf);
	        System.out.println("======== USUÁRIO ENCONTRADO ========");
	        System.out.println("Nome: " + usuario.getNome());
	        System.out.println("Email: " + usuario.getEmail());
	        System.out.println("CPF: " + usuario.getCpf());
	        System.out.println("Tipo: " + (usuario instanceof Aluno ? "Aluno" : 
	                         usuario instanceof Tutor ? "Tutor" : "Administrador"));
	    } catch (IllegalArgumentException e) {
	        System.out.println("Erro: " + e.getMessage());
	    }
	    
	}
	
	public void cdAdm() {
		String dataScn = "2006-10-23";
		LocalDate dataDeNascimento = LocalDate.parse(dataScn);
		services.cadastroAdministrador("daniel", "daniel@gmail.com","123123123", "12314563610", dataDeNascimento);
		
	}
}
