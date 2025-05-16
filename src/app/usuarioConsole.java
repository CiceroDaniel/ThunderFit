package app;

import java.util.*;
import java.time.*;
import model.*;
import repository.ExercicioRepository;
import repository.PagamentoRepository;
import repository.PresencaRepository;
import repository.TreinoRepository;
import repository.UsuarioRepository;
import services.AuthService;
import services.CatracaService;
import services.ExercicioService;
import services.GraficoPesoService;
import services.PagamentoService;
import services.PresencaService;
import services.RelatorioPresencaService;
import services.TreinoService;
import services.UsuarioService;

public class usuarioConsole {


	Nivel nivel;
	Metas metas;
	Plano plano;
	Genero genero;

	String descricao = null;
	private Scanner scanner;
	private UsuarioService services;
	private AuthService auth;
	private PagamentoRepository pagRepo;
	private PagamentoService pagService;
    private final PresencaRepository presencaRepo;
    private final PresencaService presencaService;
	private ExercicioService exServi; 
	private TreinoRepository treRepo;
	private TreinoService treServi;
    private final Catraca catraca;
    private final CatracaService catracaSer;
    private final GraficoPesoService graPesoServi;
    private final RelatorioPresencaService relatorioPresencaService;
    
	tutorConsole tutor;
	
	
	public usuarioConsole(Scanner scanner, UsuarioService services,AuthService auth, PagamentoRepository pagRepo,
			PagamentoService pagService, PresencaRepository presencaRepo, ExercicioService exServi,
			TreinoRepository treRepo, TreinoService treServi ,PresencaService presencaService,Catraca catraca, CatracaService catracaSer,
			GraficoPesoService graPesoServi, RelatorioPresencaService relatorioPresencaService) {
		this.scanner = scanner;
	    this.services = services;
	    this.auth=auth;
	    this.pagRepo = pagRepo;
	    this.pagService = pagService;
        this.presencaRepo=presencaRepo;
	    this.exServi= exServi;
	    this.treRepo= treRepo;
	    this.treServi=treServi;
        this.presencaService = presencaService;
        this.catraca=catraca;
        this.catracaSer =catracaSer;
        this.graPesoServi= graPesoServi;
        this.relatorioPresencaService= relatorioPresencaService;
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
		
		System.out.println("5. ALTURA DO USUÁRIO");
		double altura = scanner.nextDouble();
		
		System.out.println("6. PESO DE USUÁRIO");
		double peso = scanner.nextDouble();
		
		nivelMenu();
		
		metasMenu();
		
		planoMenu();
		
		Genero();
		
		services.cadastroAluno(nome, email, senha, cpf, dataDeNascimento, altura, peso, nivel, metas, descricao, plano, genero, LocalDate.now());
		
	}
	/////////////////////////////////////////////////////////////////////////
	public void loginMenu(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services) {
		toolbox.espacoMenu();
		System.out.println("==============LOGIN===============");
		System.out.println("E-MAIL: ");
		String emailLogin = scanner.nextLine();
		
		System.out.println("SENHA: ");
		String senhaLogin = scanner.nextLine();
		
		try {
	        auth.login(emailLogin, senhaLogin);

	        if (auth.getUsuarioLogado()) {
	            Usuario logado = auth.getUsuario();

	            if (logado instanceof Aluno) {
	                alunoMenu();
	            }  else {
	            	System.out.println("❌ Apenas alunos podem acessar este menu. Faça login na área correta.");
	                auth.logout();
	            }
	        }

	    } catch (Exception e) {
	        System.out.println("Erro no login: " + e.getMessage());
	    }
	}
	
	
	////////////////////////////////////////////////////////////////////////
	public final void alunoMenu() {
		int op;
		do {
			System.out.println("========= MENU ALUNO =========="
					+ "\n1 - PERFIL"
					+ "\n2 - INSTRUTORES"
					+ "\n3 - MEUS TREINOS"
					+ "\n4 - PLANOS"
					+ "\n5 - ATUALIZAR DADOS"
					+ "\n6 - ALTERAR SENHA"
					+ "\n7 - MEUS PAGAMENTOS"
					+ "\n8 - RELATÓRIOS"
					+ "\n9 - REGISTRAR ENTRADA NA ACADEMIA"
					+ "\n0 - SAIR");
			op = scanner.nextInt();
			scanner.nextLine();
			
			switch(op) {
			case 1 :  Perfil();
				break;
			case 2 :  listarTutor();
				break;
			case 3: listarTreinosDoAluno();
				break;
			case 4: System.out.println(Plano.mostrarPlanos());
				break;
			case 5: atualizarDados();
				break;
			case 6: AtualizarSenha();
				break;
			case 7: pagamentos();
				break;
			case 8: relatorio();
				break;
			case 9: registrarEntrada();
				break;
			case 0 :System.out.println("SAINDO DO SISTEMA.......");
			auth.logout();
			return;
			default: System.out.println("OPÇÃO INVALIDA!");
		}
			
		}while(op!=0);
		
	}
	//////////////////////////////////////////////////////////
	///
	private LocalDate ultimoDiaRegistro = null;
	public void registrarEntrada() {
		LocalDate hoje = LocalDate.now();
		  Usuario usuario = auth.getUsuario();
		
		if (ultimoDiaRegistro != null && ultimoDiaRegistro.equals(hoje)) {
	        System.out.println("⚠ Você já registrou entrada hoje!");
	        return;
	    }
		
	    
	    System.out.print("Você está fisicamente na academia agora? (S/N): ");
	    String resposta = scanner.nextLine().trim();
	    
	    if (resposta.equalsIgnoreCase("S")) {
	        if (usuario instanceof Aluno aluno) {  
	            boolean acessoLiberado = catracaSer.registrarPassagem(aluno);

	            if (acessoLiberado) {
	            	ultimoDiaRegistro = hoje;
	                System.out.println("✅ Catraca liberada para " + usuario.getNome() + "!");
	            } else {
	                System.out.println("❌ Acesso negado! Motivos:");
	                System.out.println("- Pagamento pendente OU");
	                System.out.println("- Plano vencido");
	            }
	        } else {
	            System.out.println("❌ Apenas alunos podem passar pela catraca.");
	        }
	    } else {
	        System.out.println("Entrada não registrada.");
	    }
	}

	
	
	
	////////////////////////////////////////////////////////////////////////
	
	public void relatorio() {
		System.out.println("========RELATORIO=========="
				+ "\n1 - PESO"
				+ "\n2 - FREQUENCIA"
				+ "\n0 -  VOLTAR");
		int op = scanner.nextInt();
		scanner.nextLine();
		
		switch(op) {
		case 1: relatorioPeso();
			break;
		case 2: relatorioPresenca();
			break;
		case 0: alunoMenu();
		}
		
	}
	
	public void relatorioPeso(){
		
		 if (!auth.getUsuarioLogado()) {
	     System.out.println("Nenhum usuário logado.");
	     return;
		 }
			 
		  Usuario usuario = auth.getUsuario();
		  
		  if (usuario instanceof Aluno) {
		    Aluno aluno = (Aluno) usuario;
	       graPesoServi.exibirGraficoEvolucaoPeso(aluno);
	   } else {
	       System.out.println("Apenas alunos podem visualizar o gráfico de peso.");
	   }
	}
	
	public void relatorioPresenca() {

	    System.out.println("Digite o mês (1-12):");
	    int mes = scanner.nextInt();
	    System.out.println("Digite o ano:");
	    int ano = scanner.nextInt();
	    scanner.nextLine();
	    
	    String relatorio = relatorioPresencaService.gerarFrequenciaMensal(auth.getUsuario().getCpf(), mes, ano);
	    System.out.println("\n" + relatorio + "\n");
		
	}
	
	////////////////////////////////////////////////////////////////////////
	
	public void Perfil() {
		toolbox.espacoMenu();
		
		 if (!auth.getUsuarioLogado()) {
		        System.out.println("Nenhum usuário logado.");
		        return;
		    }
		
		 Usuario usuario = auth.getUsuario();
		 
		 if(usuario instanceof Aluno) {
		 System.out.println("========== PERFIL DO ALUNO ==========\n");
		 System.out.println(usuario.gerarCredenciaisCadastro());
		 System.out.println(usuario.gerarCredenciaisLogin()+"\n");
		 }
		    
	}
	
	///////////////////////////////////////
	
	public void listarTreinosDoAluno() {
		
		 if (!auth.getUsuarioLogado()) {
		        System.out.println("Nenhum usuário logado.");
		        return;
		    }
		
		 Usuario usuario = auth.getUsuario();
		 Aluno aluno = (Aluno) usuario;
		 List<Treino> treinos = aluno.getTreinos();
		 
		 System.out.println("========== MEUS TREINOS ==========\n");
		  if (treinos.isEmpty()) {
		        System.out.println("Você não possui treinos cadastrados.");
		        System.out.println("Entre em contato com seu tutor para criar um treino personalizado.\n");
		        return;
		    }
		  for (int i = 0; i < treinos.size(); i++) {
		        Treino t = treinos.get(i);
		        System.out.printf("%d. %s (Nível: %s)%n", i + 1, t.getNome(), t.getNivelDif());
		        
		        List<Exercicio> exercicios = t.getExercicios();
		        if (exercicios.isEmpty()) {
		            System.out.println("   Nenhum exercício adicionado ainda.\n");
		        } else {
		            for (Exercicio e : exercicios) {
		                System.out.printf("   - %s | Grupo: %s | Equipamento: %s | 3 Repetições: %d%n",
		                        e.getNome(), e.getGrupoMuscular(), e.getEquipamento(), e.getQuantidade());
		            }
		        }

		    }
		
	}
	////////////////////////////////////////////////////////////////////////
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
		
		int op;
		toolbox.espacoMenu();
		System.out.println("======METAS DO ALUNO=============");
		System.out.println("\n1- Ganhar Massa"
				+ "\n2- Perder peso"
				+ "\n3 -Personalizada"
				+ "\n ESCOLHA UMA OPÇÃO");
		op = scanner.nextInt();
		scanner.nextLine();
		
		switch (op) {
		case 1: metas = Metas.ganharMassa;
		break;
		case 2: metas = Metas.perderPeso;
		break;
		case 3: metas = Metas.personalizada;
		descricaoMenu();
		break;
		default: System.out.println("opção invalida!");
		break;
		}
		
		services.atualizarDados(auth.getUsuario().getCpf(), email, peso, altura, metas);
		
		
		
	}
	////////////////////////////////////////////////////////////////////////
	
	public void AtualizarSenha() {
		System.out.println("=======ATUALIZAR SENHA=====");
		System.out.println("NOVA SENHA: ");
		String senha = scanner.nextLine();
		
		
		services.alterarSenha(auth.getUsuario().getCpf(), senha);
	}
	
	////////////////////////////////////////////////////////////////////////

	public void pagamentos() {
		pagService.listarPagamentosPorAluno(auth.getUsuario().getCpf());

		List <Pagamento> pagamentos = pagService.listarPagamentosPorAluno(auth.getUsuario().getCpf());
		if(pagamentos.isEmpty()) {
			System.out.println("Nenhum pagamento registrado!");
			return;
		}
		System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
	    System.out.println("║               📋 HISTÓRICO DE PAGAMENTOS               ║");
	    System.out.println("╠══════════════════════════════════════════════════════════════╣");
	    
	    int i = 1;
	    for(Pagamento pagamento: pagamentos) {
	        System.out.println("║                                                          ║");
	        System.out.printf("║ %d. Data: %s\n", i, pagamento.getDataPagamento());
	        System.out.printf("║    Valor do Plano: R$ %.2f\n", pagamento.getValorDoPlano());
	        System.out.printf("║    Valor Pago: R$ %.2f\n", pagamento.getValorPago());
	        System.out.printf("║    Vencimento: %s\n", pagamento.getDataVencimento());
	        System.out.printf("║    Status: %s\n", pagamento.getPago() ? "✅ PAGO" : "❌ PENDENTE");
	        if(pagamento.estaVencido()) {
	            System.out.println("║    ⚠ ATENÇÃO: PAGAMENTO VENCIDO!");
	        }
	        System.out.println("╠══════════════════════════════════════════════════════════════╣");
	        i++;
	    }
	    System.out.println("╚══════════════════════════════════════════════════════════════╝");
	
	}
	
	////////////////////////////////////////////////////////////////////////
	public void nivelMenu() {
		
		int op;
		toolbox.espacoMenu();
		System.out.println("======NIVEL DO ALUNO=============");
		System.out.println("\n1- iniciante"
				+ "\n2- intermediario"
				+ "\n3 - avançado"
				+ "\n ESCOLHA UMA OPÇÃO");
		op = scanner.nextInt();
		scanner.nextLine();
		
		switch (op) {
		case 1: nivel = Nivel.INICIANTE;
		break;
		case 2: nivel = Nivel.INTERMEDIARIO;
		break;
		case 3: nivel = Nivel.AVANCADO;
		break;
		default: System.out.println("opção invalida!");
		break;
		}
	}
	
	public void metasMenu() {
		int op;
		toolbox.espacoMenu();
		System.out.println("======METAS DO ALUNO=============");
		System.out.println("\n1- Ganhar Massa"
				+ "\n2- Perder peso"
				+ "\n3 -Personalizada"
				+ "\n ESCOLHA UMA OPÇÃO");
		op = scanner.nextInt();
		scanner.nextLine();
		
		switch (op) {
		case 1: metas = Metas.ganharMassa;
		break;
		case 2: metas = Metas.perderPeso;
		break;
		case 3: metas = Metas.personalizada;
		descricaoMenu();
		break;
		default: System.out.println("opção invalida!");
		break;
		}
	}
	public void planoMenu() {
		int op;
		toolbox.espacoMenu();
		System.out.println("======PLANO CONTRATADO=============");
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
	}
	public void Genero() {
		int op;
		toolbox.espacoMenu();
		System.out.println("======GENERO DO USUSÁRIO==========");
		System.out.println("\n1- Masculino"
				+ "\n2- Feminino"
				+ "\n3 -Outro"
				+ "\n ESCOLHA UMA OPÇÃO: ");
		op = scanner.nextInt();
		scanner.nextLine();
		
		switch (op) {
		case 1: genero = genero.MASCULINO;
		break;
		case 2: genero = genero.FEMININO;
		break;
		case 3: genero = genero.OUTRO;
		break;
		default: System.out.println("opção invalida!");
		break;
		}
	}
	
	public void listarTutor() {
		List <Tutor> tutores = services.listarTutores();
		if(tutores.isEmpty()) {
			System.out.println("Nenhum tutor cadastrado!");
			return;
		}
		System.out.println("=============== LISTA DE TUTORES ==================");
		int i=1;
		for(Tutor tutor: tutores) {
	        System.out.println("-------- Tutor " + i + " --------");
	        System.out.println("Nome: " + tutor.getNome());
	        System.out.println("Email: " + tutor.getEmail());
	        System.out.println("---------------------------------\n");
	        i++;
		}
		
	
	}
	
	public void descricaoMenu() {
		System.out.println("DESCRIÇÃO: ");
		descricao = scanner.nextLine();	
	}
	
	public void cdUser() {
		String dataScn = "2006-02-28";
		LocalDate dataDeNascimento = LocalDate.parse(dataScn);

		services.cadastroAluno("Victor Hugo", "vh@gmail.com","123456789", "10987654321", dataDeNascimento,
				1.20, 15, nivel.INICIANTE, metas.ganharMassa, descricao, plano.planoAnual, genero.FEMININO, LocalDate.of(2025, 04, 21));
		services.atualizarDados("10987654321", "vh@gmail.com", 20, 1.24, metas.ganharMassa);
		services.atualizarDados("10987654321", "vh@gmail.com", 25, 1.24, metas.ganharMassa);
		services.atualizarDados("10987654321", "vh@gmail.com", 50, 1.24, metas.ganharMassa);
		services.atualizarDados("10987654321", "vh@gmail.com", 45, 1.24, metas.ganharMassa);
		
		treServi.criarTreino("Treino A",nivel.INICIANTE);
		treServi.associarTreinoAluno("10987654321", "Treino A", null);
		treServi.adicionarExercicios("Treino A", "Supino reto", null, 12);
		treServi.adicionarExercicios("Treino A", "Flexão de braço", null, 12);
		treServi.adicionarExercicios("Treino A", "Puxada frontal", null, 12);
		treServi.adicionarExercicios("Treino A", "Remada baixa", null, 12);
	}
	
}
