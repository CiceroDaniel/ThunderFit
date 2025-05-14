package app;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

import repository.PagamentoRepository;
import repository.PresencaRepository;
import repository.TreinoRepository;
//import model.Plano;
import repository.UsuarioRepository;
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
    private final PresencaRepository presencaRepo;
    private final PresencaService presencaService;
	private ExercicioService exServi; 
	private TreinoRepository treRepo;
	private TreinoService treServi;
    private final Catraca catraca;
    private final CatracaService catracaSer;

	
	public admConsole(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services, 
			PagamentoRepository pagRepo, PagamentoService pagService, RelatorioPresencaService relatorioPresencaService,
			RelatorioFinanceiroService relatorioFinanceiroService, PlanoService planoService, PresencaRepository presencaRepo,
			PresencaService presencaService,ExercicioService exServi, TreinoRepository treRepo, TreinoService treServi,Catraca catraca,
			CatracaService catracaSer) {
		this.scanner = scanner;
	    this.repo = repo;
	    this.auth = auth;
	    this.services = services;
	    this.pagRepo= pagRepo;
	    this.pagService = pagService;
	    
	    this.relatorioPresencaService = relatorioPresencaService;
        this.relatorioFinanceiroService = relatorioFinanceiroService;
        this.planoService = planoService;
        this.presencaRepo=presencaRepo;
        this.presencaService = presencaService;
	    this.exServi= exServi;
	    this.treRepo= treRepo;
	    this.treServi=treServi;
        this.catraca=catraca;
        this.catracaSer=catracaSer;
        
        this.user = new usuarioConsole(scanner, services, auth, pagRepo, pagService, presencaRepo, exServi, treRepo, treServi,
        		presencaService, catraca, catracaSer);
        this.tutor = new tutorConsole(scanner, repo, auth, services, null, null, null, null, pagRepo, pagService);
	}

	
	public void loginMenu() {
		toolbox.espacoMenu();
		
		System.out.println("\n╔════════════════════════════════════════╗");
		System.out.println("║             🔐 ÁREA DE LOGIN          ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║                                        ║");
		System.out.print  ("║  ✉ E-MAIL: ");
		String emailLogin = scanner.nextLine();
		System.out.println("║                                        ║");
		System.out.print  ("║  🔒 SENHA: ");
		String senhaLogin = scanner.nextLine();
		System.out.println("║                                        ║");
		System.out.println("╚════════════════════════════════════════╝");
		
		try {
	        auth.login(emailLogin, senhaLogin);

	        if (auth.getUsuarioLogado()) {
	            Usuario logado = auth.getUsuario();

	            if (logado instanceof Administrador) {
	                admMenu();
	            }  else {
	            	System.out.println("❌ Apenas ADM's podem acessar este menu. Faça login na área correta.");
	                auth.logout();
	            }
	        }

	    } catch (Exception e) {
	        System.out.println("Erro no login: " + e.getMessage());
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
			 System.out.println("\n╔════════════════════════════════════════╗");
			 System.out.println("║           🧑🏫 PERFIL DO TUTOR         ║");
			 System.out.println("╠════════════════════════════════════════╣");
			 System.out.println("║                                        ║");
			 System.out.println("║  " + usuario.gerarCredenciaisCadastro().replace("\n", "\n║  "));
			 System.out.println("║                                        ║");
			 System.out.println("╚════════════════════════════════════════╝");
			 }
	}
	
	
	////////////////////////////////////////////////////////////////////////
	public final void admMenu() {
		int op;
		do {
			
			System.out.println("\n╔════════════════════════════════════════╗");
			System.out.println("║          👔 MENU ADMINISTRADOR         ║");
			System.out.println("╠════════════════════════════════════════╣");
			System.out.println("║                                        ║");
			System.out.println("║  1. 👤 PERFIL                          ║");
			System.out.println("║  2. 🏋️ INSTRUTORES                     ║");
			System.out.println("║  3. 👥 USUÁRIOS                        ║");
			System.out.println("║  4. 📅 RELATÓRIOS DE FREQUÊNCIA        ║");
			System.out.println("║  5. 💰 RELATÓRIOS FINANCEIROS          ║");
			System.out.println("║  6. 📊 GERENCIAR PLANOS                ║");
			System.out.println("║  0. 🚪 SAIR                            ║");
			System.out.println("║                                        ║");
			System.out.println("╚════════════════════════════════════════╝");
			System.out.print("\n▸ SELECIONE UMA OPÇÃO: ");
	        op = scanner.nextInt();
	        scanner.nextLine();
	        
	        switch(op) {
	            case 1: Perfil(); 
	            	break;
	            case 2: CrudTutor(); 
	            	break;
	            case 3: CrudAluno(); 
	            	break;
	            case 4:  gerenciarRelatoriosFrequencia(); 
	            	break;
	            case 5: gerenciarRelatoriosFinanceiros(); 
	            	break;
	            case 6: //System.out.println(Plano.mostrarPlanos());
	            		//alteraPlano();
	            	gerenciarPlanos();
	            	break;
	            case 0: System.out.println("SAINDO DO SISTEMA.......");
			            auth.logout();
			            return;
	            default: System.out.println("OPÇÃO INVALIDA!");
	        }
	    } while(op != 0);
		
	}
	
	private void gerenciarPlanos() {
	    int op;
	    do {
	        System.out.println("\n╔════════════════════════════════════════╗");
	        System.out.println("║          📊 GERENCIAR PLANOS           ║");
	        System.out.println("╠════════════════════════════════════════╣");
	        System.out.println("║                                        ║");
	        System.out.println("║  1. 📝 ALTERAR VALOR DO PLANO          ║");
	        System.out.println("║  2. 📋 LISTAR PLANOS                   ║");
	        System.out.println("║  0. ↩ VOLTAR                           ║");
	        System.out.println("║                                        ║");
	        System.out.println("╚════════════════════════════════════════╝");
	        System.out.print("\n▸ SELECIONE UMA OPÇÃO: ");
	        op = scanner.nextInt();
	        scanner.nextLine();
	        
	        switch(op) {
	            case 1: 
	                alteraPlano();
	                break;
	            case 2: 
	                listarPlanos();
	                break;
	            case 0: 
	                return;
	            default: 
	                System.out.println("OPÇÃO INVÁLIDA!");
	        }
	    } while(op != 0);
	}

	private void alteraPlano() {
	    try {
	        System.out.println("\n===== ALTERAR VALOR DO PLANO =====");
	        System.out.println("Selecione o plano:");
	        System.out.println("1. Mensal");
	        System.out.println("2. Trimestral");
	        System.out.println("3. Anual");
	        System.out.print("Opção: ");
	        int tipoPlano = scanner.nextInt();
	        
	        System.out.print("\nNovo valor: ");
	        double novoValor = scanner.nextDouble();
	        scanner.nextLine();
	        
	        Plano plano = null;
	        switch(tipoPlano) {
	            case 1: plano = Plano.planoMensal; break;
	            case 2: plano = Plano.planoTrimestral; break;
	            case 3: plano = Plano.planoAnual; break;
	            default: throw new IllegalArgumentException("Opção inválida");
	        }
	        
	        planoService.atualizarValorPlano(plano, novoValor, auth.getUsuario());
	        System.out.println("✔ Valor do plano atualizado com sucesso!");
	        
	    } catch (Exception e) {
	        System.out.println("❌ Erro: " + e.getMessage());
	    }
	}

	private void listarPlanos() {
	    System.out.println("\n===== PLANOS DISPONÍVEIS =====");
	    System.out.println(Plano.mostrarPlanos());
	}

	/*public void alteraPlano() {
		int op;
		Plano plano = null;
		System.out.println("======= ALTERAR VALOR DOS PLANOS ===========");
		System.out.println("Qual plano quer atualizar?");
		System.out.println("\n1- Mensal"
				+ "\n2- Trimestral"
				+ "\n3 -Anual"
				+ "\n ESCOLHA UMA OPÇÃO");
		op = scanner.nextInt();
		scanner.nextLine();
		
		
		switch (op) {
		case 1: plano = Plano.planoMensal;
		break;
		case 2: plano = Plano.planoTrimestral;
		break;
		case 3: plano = Plano.planoAnual;
		break;
		default: System.out.println("opção invalida!");
		break;
		}
		
		System.out.println("QUAL O NOVO VALOR?\n|> ");
		double valor = scanner.nextDouble();
		scanner.nextLine();
		
		planoService.atualizarValorPlano(plano, valor, auth.getUsuario());
		
	}*/
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
			System.out.println("\n╔════════════════════════════════════════╗");
			System.out.println("║          🧑🏫 CRUD DE TUTORES         ║");
			System.out.println("╠════════════════════════════════════════╣");
			System.out.println("║                                        ║");
			System.out.println("║  1. 📝 CADASTRAR TUTOR                ║");
			System.out.println("║  2. 🔄 ATUALIZAR TUTOR               ║");
			System.out.println("║  3. 🔍 PESQUISAR TUTOR              ║");
			System.out.println("║  4. ❌ DELETAR TUTOR                 ║");
			System.out.println("║  5. 📋 LISTAR TUTORES                ║");
			System.out.println("║  6. ↩ VOLTAR                         ║");
			System.out.println("║                                        ║");
			System.out.println("╚════════════════════════════════════════╝");
			System.out.print("\n▸ SELECIONE UMA OPÇÃO: ");
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
			System.out.println("\n╔════════════════════════════════════════╗");
			System.out.println("║           🧑🎓 CRUD DE ALUNOS          ║");
			System.out.println("╠════════════════════════════════════════╣");
			System.out.println("║                                        ║");
			System.out.println("║  1. 📝 CADASTRAR ALUNO                ║");
			System.out.println("║  2. 🔄 ATUALIZAR ALUNO               ║");
			System.out.println("║  3. 🔍 PESQUISAR ALUNO              ║");
			System.out.println("║  4. ❌ DELETAR ALUNO                 ║");
			System.out.println("║  5. 📋 LISTAR ALUNOS                 ║");
			System.out.println("║  6. ↩ VOLTAR                         ║");
			System.out.println("║                                        ║");
			System.out.println("╚════════════════════════════════════════╝");
			System.out.print("\n▸ SELECIONE UMA OPÇÃO: ");
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
		
		if(!u) {
			System.out.println("\n╔════════════════════════════════════════╗");
			System.out.println("║          ❌ DELETAR USUÁRIO          ║");
			System.out.println("╠════════════════════════════════════════╣");
			System.out.println("║                                        ║");
			System.out.println("║  QUAL USUÁRIO DESEJA DELETAR?          ║");
			System.out.println("║                                        ║");
			System.out.println("║  🆔 CPF:                               ║");
			System.out.println("║  ▸ ");
			String cpf = scanner.nextLine();
			System.out.println("║                                        ║");
			System.out.println("╚════════════════════════════════════════╝");
			//String cpf = scanner.nextLine();
			
			
			
			try {
			    if (services.removerUsuario(cpf, auth.getUsuario())) {
			        System.out.println("✔ Usuário removido com sucesso!");
			    } else {
			        System.out.println("⚠ Não foi possível remover o usuário");
			    }
			} catch (Exception e) {
			    System.out.println("❌ Erro: " + e.getMessage());
			}
			
		}else {
			System.out.println("=====DELETAR TUTOR=======");
			System.out.println("QUAL TUTOR DESEJA DELETAR?"
					+ "\nCPF: ");
			String cpf = scanner.nextLine();
			
			try {
			    if (services.removerUsuario(cpf, auth.getUsuario())) {
			        System.out.println("✔ Usuário removido com sucesso!");
			    } else {
			        System.out.println("⚠ Não foi possível remover o usuário");
			    }
			} catch (Exception e) {
			    System.out.println("❌ Erro: " + e.getMessage());
			}
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
	            case 1: buscarPorNome(u);
	            break;
	            case 2: buscarPorEmail(u);
	            break;
	            case 3: buscarPoCpf(u);
	            break;
	            case 4: if(u) CrudTutor();
	            else CrudAluno();
	            default: System.out.println("OPÇÃO INVALIDA");
	        }while(op!=0);
	      
    }
	
	public void listarAlunos() {
		List <Aluno> alunos = services.listarAlunos(auth.getUsuario());
		if(alunos.isEmpty()) {
			System.out.println("Nenhum aluno cadastrado!");
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
    
	public void buscarPorNome(boolean u){
	    
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
	               
	                pesquisar(u);
	            }
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Erro: " + e.getMessage());
	    }
	    
	}
	
	/////////NAO TA PRINTANDO O USUARIO
	
	public void buscarPorEmail(boolean u){
	    
	    System.out.println("QUAL O Email DO USUÁRIO QUE DESEJA PESQUISAR?"
	    + "\nEmail: ");
	    
	    String email = scanner.nextLine();
	    try {
	        Usuario usuario = services.buscarPorEmail(email);
	        if(usuario != null) {
	            System.out.println("======== USUÁRIO ENCONTRADO ========");
	            System.out.println("Nome: " + usuario.getNome());
	            System.out.println("Email: " + usuario.getEmail());
	            System.out.println("CPF: " + usuario.getCpf());
	            System.out.println("Tipo: " + (usuario instanceof Aluno ? "Aluno" : 
	                             usuario instanceof Tutor ? "Tutor" : "Administrador"));
	            pesquisar(u);
	        } else {
	            System.out.println("Nenhum usuário encontrado com esse email.");
	        }
	    } catch (Exception e) {
	        System.out.println("Erro: " + e.getMessage());
	    }
			
	}
	    
	public void buscarPoCpf(boolean u){
	    
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
	        pesquisar(u);
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
