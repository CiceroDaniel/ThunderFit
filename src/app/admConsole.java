package app;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

import repository.ExercicioRepository;
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
    private final ExercicioRepository exRepo;
	private final ExercicioService exServi; 
	private final TreinoRepository treRepo;
	private final TreinoService treServi;
    private final Catraca catraca;
    private final CatracaService catracaSer;
    private final GraficoPesoService graPesoServi;

	
	public admConsole(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services, 
			PagamentoRepository pagRepo, PagamentoService pagService, RelatorioPresencaService relatorioPresencaService,
			RelatorioFinanceiroService relatorioFinanceiroService, PlanoService planoService, PresencaRepository presencaRepo,
			PresencaService presencaService,ExercicioRepository exRepo,ExercicioService exServi, TreinoRepository treRepo, TreinoService treServi,Catraca catraca,
			CatracaService catracaSer, GraficoPesoService graPesoServi) {
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
		this.exRepo = exRepo;
	    this.exServi= exServi;
	    this.treRepo= treRepo;
	    this.treServi=treServi;
        this.catraca=catraca;
        this.catracaSer=catracaSer;
        this.graPesoServi = graPesoServi;
        
        this.user = new usuarioConsole(scanner, services, auth, pagRepo, pagService, presencaRepo, exServi, treRepo, treServi,
        		presencaService, catraca, catracaSer, graPesoServi, relatorioPresencaService);
        this.tutor = new tutorConsole(scanner, repo, auth, services, exRepo, exServi, treRepo, treServi, pagRepo, pagService);
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
			System.out.println("║  7. 💳 GERENCIAR PAGAMENTOS            ║");
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
	            case 7: menuPagamentos();
	            	break;
	            case 0: System.out.println("SAINDO DO SISTEMA.......");
			            auth.logout();
			            return;
	            default: System.out.println("OPÇÃO INVALIDA!");
	        }
	    } while(op != 0);
		
	}
	
	public void menuPagamentos() {
	    int op;
	    do {
	        System.out.println("\n╔════════════════════════════════════════╗");
	        System.out.println("║          💳 MENU PAGAMENTOS            ║");
	        System.out.println("╠════════════════════════════════════════╣");
	        System.out.println("║                                        ║");
	        System.out.println("║  1. ➕ Registrar pagamento              ║");
	        System.out.println("║  2. 📄 Listar pagamentos de aluno       ║");
	        System.out.println("║  3. ⏳ Pagamentos pendentes             ║");
	        System.out.println("║  4. ⛔ Pagamentos vencidos              ║");
	        System.out.println("║  5. 🔍 Buscar pagamento por ID         ║");
	        System.out.println("║  6. ✏️ Atualizar data de pagamento      ║");     
	        System.out.println("║  7. 🗑️ Remover pagamento                 ║");
	        System.out.println("║  0. 🔙 Voltar ao menu anterior          ║");
	        System.out.println("║                                        ║");
	        System.out.println("╚════════════════════════════════════════╝");
	        System.out.print("\n▸ SELECIONE UMA OPÇÃO: ");
	        op = scanner.nextInt();
	        scanner.nextLine();

	        try {
	            switch (op) {
	                case 1:
	                    registrarPagamento();
	                    break;
	                case 2:
	                    listarPagamentosDeAluno();
	                    break;
	                case 3:
	                    listarPendentes();
	                    break;
	                case 4:
	                    listarVencidos();
	                    break;
	                case 5:
	                	buscarPagamentoPorId();	                    
	                    break;
	                case 6:
	                	atualizarDataPagamento();
	                    break;
	                case 7:
	                	removerPagamento();
	                    break;
	                case 0:
	                    System.out.println("Retornando ao menu anterior...");
	                    break;
	                default:
	                    System.out.println("Opção inválida!");
	            }
	        } catch (Exception e) {
	            System.out.println("Erro: " + e.getMessage());
	        }

	    } while (op != 0);
	}

	private void registrarPagamento() {
	    try {
	        System.out.print("CPF do aluno: ");
	        String cpf = scanner.nextLine();

	        Aluno aluno = (Aluno) services.buscarPorCpf(cpf);
	        if (aluno == null) {
	            System.out.println("Aluno não encontrado.");
	            return;
	        }

	        System.out.print("Valor pago: ");
	        double valorPago = scanner.nextDouble();
	        scanner.nextLine();

	        System.out.print("Data do pagamento (AAAA-MM-DD): ");
	        String dataStr = scanner.nextLine();
	        LocalDate dataPagamento = LocalDate.parse(dataStr);

	        Pagamento pagamento = pagService.registrarPagamento(aluno, valorPago, dataPagamento);

	        System.out.println("✅ Pagamento registrado com sucesso:");
	        System.out.println("ID: " + pagamento.getId());
	        System.out.println("Aluno: " + aluno.getNome());
	        System.out.println("Valor: R$ " + pagamento.getValorPago());
	        System.out.println("Data: " + pagamento.getDataPagamento());

	    } catch (SecurityException se) {
	        System.out.println("🚫 Acesso negado: " + se.getMessage());
	    } catch (IllegalArgumentException iae) {
	        System.out.println("❌ Erro nos dados: " + iae.getMessage());
	    } catch (Exception e) {
	        System.out.println("❗ Erro ao registrar pagamento: " + e.getMessage());
	    }
	}

	private void listarPagamentosDeAluno() {
	    try {
	        System.out.print("Digite o CPF do aluno: ");
	        String cpf = scanner.nextLine();

	        List<Pagamento> pagamentos = pagService.listarPagamentosPorAluno(cpf);

	        if (pagamentos.isEmpty()) {
	            System.out.println("📭 Nenhum pagamento encontrado para este aluno.");
	            return;
	        }

	        System.out.println("\n📄 Lista de Pagamentos:");
	        System.out.println("═══════════════════════════════════════════════════════");
	        for (Pagamento pagamento : pagamentos) {
	            System.out.println("ID: " + pagamento.getId());
	            System.out.println("Valor: R$ " + pagamento.getValorPago());
	            System.out.println("Data de Pagamento: " + (pagamento.getDataPagamento() != null ? pagamento.getDataPagamento() : "N/A"));
	            System.out.println("Vencimento: " + pagamento.getDataVencimento());
	            System.out.println("Status: " + (pagamento.getPago() ? "✅ Pago" : "⏳ Pendente"));
	            System.out.println("-------------------------------------------------------");
	        }

	    } catch (IllegalArgumentException e) {
	        System.out.println("❌ Erro: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("❗ Erro ao listar pagamentos: " + e.getMessage());
	    }
	}

	private void listarPendentes() {
	    try {
	        List<Pagamento> pendentes = pagService.listarPagamentoPendentes();

	        if (pendentes.isEmpty()) {
	            System.out.println("🎉 Nenhum pagamento pendente encontrado.");
	            return;
	        }

	        System.out.println("\n⏳ Pagamentos Pendentes:");
	        System.out.println("═══════════════════════════════════════════════════════");
	        for (Pagamento pagamento : pendentes) {
	            System.out.println("ID: " + pagamento.getId());
	            System.out.println("Aluno: " + pagamento.getAluno().getNome());
	            System.out.println("Valor: R$ " + pagamento.getValorPago());
	            System.out.println("Vencimento: " + pagamento.getDataVencimento());
	            System.out.println("Status: ⏳ Pendente");
	            System.out.println("-------------------------------------------------------");
	        }

	    } catch (SecurityException se) {
	        System.out.println("🚫 Acesso negado: " + se.getMessage());
	    } catch (Exception e) {
	        System.out.println("❗ Erro ao listar pagamentos pendentes: " + e.getMessage());
	    }
	}

	private void listarVencidos() {
	    try {
	        List<Pagamento> vencidos = pagService.listarPagamentoVencidos();

	        if (vencidos.isEmpty()) {
	            System.out.println("🎉 Nenhum pagamento vencido encontrado.");
	            return;
	        }

	        System.out.println("\n⚠️ Pagamentos Vencidos:");
	        System.out.println("═══════════════════════════════════════════════════════");
	        for (Pagamento pagamento : vencidos) {
	            System.out.println("ID: " + pagamento.getId());
	            System.out.println("Aluno: " + pagamento.getAluno().getNome());
	            System.out.println("Valor: R$ " + pagamento.getValorPago());
	            System.out.println("Vencimento: " + pagamento.getDataVencimento());
	            System.out.println("Status: ❌ Vencido");
	            System.out.println("-------------------------------------------------------");
	        }

	    } catch (SecurityException se) {
	        System.out.println("🚫 Acesso negado: " + se.getMessage());
	    } catch (Exception e) {
	        System.out.println("❗ Erro ao listar pagamentos vencidos: " + e.getMessage());
	    }
	}

	private void buscarPagamentoPorId() {
	    try {
	        System.out.print("Digite o ID do pagamento: ");
	        int id = Integer.parseInt(scanner.nextLine());

	        Pagamento pagamento = pagService.buscarPorId(id);

	        System.out.println("\n🔍 Pagamento Encontrado:");
	        System.out.println("═══════════════════════════════════════════════════════");
	        System.out.println("ID: " + pagamento.getId());
	        System.out.println("Aluno: " + pagamento.getAluno().getNome());
	        System.out.println("CPF: " + pagamento.getAluno().getCpf());
	        System.out.println("Valor: R$ " + pagamento.getValorPago());
	        System.out.println("Data de Pagamento: " + (pagamento.getDataPagamento() != null ? pagamento.getDataPagamento() : "N/A"));
	        System.out.println("Vencimento: " + pagamento.getDataVencimento());
	        System.out.println("Status: " + (pagamento.getPago() ? "✅ Pago" : "⏳ Pendente"));

	    } catch (IllegalArgumentException e) {
	        System.out.println("❌ Erro: " + e.getMessage());
	    } catch (SecurityException se) {
	        System.out.println("🚫 Acesso negado: " + se.getMessage());
	    } catch (Exception e) {
	        System.out.println("❗ Erro ao buscar pagamento: " + e.getMessage());
	    }
	}

	private void atualizarDataPagamento() {
	    try {
	        System.out.print("Digite o ID do pagamento: ");
	        int id = Integer.parseInt(scanner.nextLine());

	        System.out.print("Digite a nova data de pagamento (AAAA-MM-DD): ");
	        String dataStr = scanner.nextLine();
	        LocalDate novaData = LocalDate.parse(dataStr);

	        pagService.atualizarDataDePagamento(id, novaData);

	        System.out.println("✅ Data de pagamento atualizada com sucesso!");

	    } catch (IllegalArgumentException e) {
	        System.out.println("❌ Erro: " + e.getMessage());
	    } catch (SecurityException se) {
	        System.out.println("🚫 Acesso negado: " + se.getMessage());
	    } catch (Exception e) {
	        System.out.println("❗ Erro ao atualizar data: " + e.getMessage());
	    }
	}

	private void removerPagamento() {
	    try {
	        System.out.print("Digite o ID do pagamento que deseja remover: ");
	        int id = Integer.parseInt(scanner.nextLine());

	        boolean removido = pagService.removerPagamento(id);

	        if (removido) {
	            System.out.println("✅ Pagamento removido com sucesso!");
	        } else {
	            System.out.println("⚠️ Nenhum pagamento foi removido. Verifique se o ID está correto.");
	        }

	    } catch (SecurityException se) {
	        System.out.println("🚫 Acesso negado: " + se.getMessage());
	    } catch (Exception e) {
	        System.out.println("❗ Erro ao remover pagamento: " + e.getMessage());
	    }
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
	        
	        planoService.atualizarValorPlano(plano, novoValor);
	        System.out.println("✔ Valor do plano atualizado com sucesso!");
	        
	    } catch (Exception e) {
	        System.out.println("❌ Erro: " + e.getMessage());
	    }
	}

	private void listarPlanos() {
	    System.out.println("\n===== PLANOS DISPONÍVEIS =====");
	    System.out.println(Plano.mostrarPlanos());
	}


	public void gerenciarRelatoriosFinanceiros() {
	    int op;
	    do {
	        toolbox.espacoMenu();
	        
	        System.out.println("\n╔════════════════════════════════════════╗");
	        System.out.println("║        💰 RELATÓRIOS FINANCEIROS        ║");
	        System.out.println("╠════════════════════════════════════════╣");
	        System.out.println("║                                        ║");
	        System.out.println("║  1. 📅 RELATÓRIO MENSAL                ║");
	        System.out.println("║  0. ↩ VOLTAR                           ║");
	        System.out.println("║                                        ║");
	        System.out.println("╚════════════════════════════════════════╝");
	        System.out.print("\n▸ SELECIONE UMA OPÇÃO: ");
	        
	        op = scanner.nextInt();
	        scanner.nextLine();
	        
	        if(op == 1) {
	            exibirRelatorioFinanceiroMensal();
	        } else if(op != 0) {
	            System.out.println("❌ OPÇÃO INVÁLIDA!");
	        }
	    } while(op != 0);
	}

	private void exibirRelatorioFinanceiroMensal() {
	    try {
	        toolbox.espacoMenu();
	        
	        System.out.println("\n╔════════════════════════════════════════╗");
	        System.out.println("║        📅 RELATÓRIO FINANCEIRO         ║");
	        System.out.println("╠════════════════════════════════════════╣");
	        System.out.println("║                                        ║");
	        System.out.print  ("║  MÊS (1-12): ");
	        int mes = scanner.nextInt();
	        System.out.print  ("║  ANO: ");
	        int ano = scanner.nextInt();
	        scanner.nextLine();
	        System.out.println("║                                        ║");
	        System.out.println("╚════════════════════════════════════════╝");
	        
	        YearMonth yearMonth = YearMonth.of(ano, mes);
	        System.out.println("\n=== PAGAMENTOS PARA " + yearMonth + " ===");
        pagRepo.listarTodos().stream()
            .filter(p -> YearMonth.from(p.getDataPagamento()).equals(yearMonth))
            .forEach(p -> System.out.printf("%s | R$ %.2f | %s%n", 
                p.getDataPagamento(), 
                p.getValorPago(),
                p.getAluno().getNome()));
        
        RelatorioFinanceiro relatorio = relatorioFinanceiroService.gerarRelatorioMensal(yearMonth);
	        
	        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
	        System.out.println("║                📊 RELATÓRIO FINANCEIRO MENSAL               ║");
	        System.out.println("╠══════════════════════════════════════════════════════════════╣");
	        System.out.printf ("║ Período: %02d/%d %45s ║\n", mes, ano, "");
	        System.out.println("╠══════════════════════════════════════════════════════════════╣");
	        System.out.printf ("║ Receita Total: R$ %-10.2f %35s ║\n", relatorio.getReceitaTotal(), "");
	        System.out.printf ("║ Despesas (salários): R$ %-10.2f %28s ║\n", relatorio.getDespesasTotal(), "");
	        System.out.printf ("║ Lucro: R$ %-10.2f %44s ║\n", relatorio.getLucro(), "");
	        System.out.println("╚══════════════════════════════════════════════════════════════╝");
	        
	    } catch (InputMismatchException e) {
	        System.out.println("❌ Erro: Digite valores numéricos para mês e ano.");
	        scanner.nextLine(); // Limpa o buffer
	    } catch (DateTimeException e) {
	        System.out.println("❌ Erro: Data inválida. Verifique o mês (1-12) e ano.");
	    } catch (Exception e) {
	        System.out.println("❌ Erro ao gerar relatório: " + e.getMessage());
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
