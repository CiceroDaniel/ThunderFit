package app;
import app.consoleMenu;
import model.Aluno;
import model.Exercicio;
import model.Metas;
import model.Nivel;
import model.Treino;
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
		return;
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

	        if (auth.getUsuarioLogado()) {
	            Usuario logado = auth.getUsuario();

	            if (logado instanceof Tutor) {
	                tutorMenu(scanner, repo, auth, services);
	            }  else {
	            	System.out.println("❌ Apenas tutores podem acessar este menu. Faça login na área correta.");
	                auth.logout();
	            }
	        }

	    } catch (Exception e) {
	        System.out.println("Erro no login: " + e.getMessage());
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
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        🏋️  GERENCIAMENTO DE TREINOS      ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║                                        ║");
        System.out.println("║  1. 📝 CRIAR NOVO TREINO               ║");
        System.out.println("║  2. 👥 ASSOCIAR TREINO A ALUNO         ║");
        System.out.println("║  3. 📋 LISTAR TREINOS DE UM ALUNO      ║");
        System.out.println("║  4. ✏️ EDITAR TREINO                   ║");
        System.out.println("║  5. ❌ REMOVER TREINO                  ║");
        System.out.println("║  0. ↩ VOLTAR                          ║");
        System.out.println("║                                        ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("\n▸ SELECIONE UMA OPÇÃO: ");
        
        op = scanner.nextInt();
        scanner.nextLine();
        
        switch(op) {
            case 1:
                criarTreino();
                break;
            case 2:
                associarTreinoAluno();
                break;
            case 3:
                listarTreinosDoAluno();
                break;
            case 4:
                editarTreino();
                break;
            case 5:
                removerTreino();
                break;
            case 0:
                return;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
        }
    } while(op != 0);
}

public void editarTreino() {
    System.out.println("\n╔════════════════════════════════════════╗");
    System.out.println("║          ✏️ EDITAR TREINO              ║");
    System.out.println("╠════════════════════════════════════════╣");
    
    // Solicitar CPF do aluno
    System.out.print("║ CPF DO ALUNO (somente números): ");
    String cpfAluno = scanner.nextLine();
    
    try {
        // Verificar se aluno existe
        Aluno aluno = (Aluno) services.buscarPorCpf(cpfAluno);
        
        // Listar treinos do aluno
        List<Treino> treinos = treServi.listarTreinosDoAluno(cpfAluno, auth.getUsuario());
        
        if (treinos.isEmpty()) {
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║   ❌ ALUNO NÃO POSSUI TREINOS CADASTRADOS ║");
            System.out.println("╚════════════════════════════════════════╝");
            return;
        }
        
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║        TREINOS DISPONÍVEIS             ║");
        System.out.println("╠════════════════════════════════════════╣");
        
        for (int i = 0; i < treinos.size(); i++) {
            System.out.printf("║ %d. %-20s (Nível: %-12s) ║\n", 
                            i+1, 
                            treinos.get(i).getNome(), 
                            treinos.get(i).getNivelDif());
        }
        
        // Selecionar treino para edição
        System.out.println("╠════════════════════════════════════════╣");
        System.out.print("║ SELECIONE O TREINO PARA EDITAR (NÚMERO): ");
        int opcaoTreino = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        if (opcaoTreino < 1 || opcaoTreino > treinos.size()) {
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║           ❌ OPÇÃO INVÁLIDA!           ║");
            System.out.println("╚════════════════════════════════════════╝");
            return;
        }
        
        Treino treinoSelecionado = treinos.get(opcaoTreino - 1);
        String nomeTreinoOriginal = treinoSelecionado.getNome();
        
        // Menu de edição
        int opcaoEdicao;
        do {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.printf ("║ EDITANDO: %-29s ║\n", nomeTreinoOriginal);
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║ 1. ✏️  RENOMEAR TREINO                 ║");
            System.out.println("║ 2. 🔄  ALTERAR NÍVEL DE DIFICULDADE   ║");
            System.out.println("║ 3. ➕  ADICIONAR EXERCÍCIO             ║");
            System.out.println("║ 4. ➖  REMOVER EXERCÍCIO               ║");
            System.out.println("║ 5. 📋  LISTAR EXERCÍCIOS               ║");
            System.out.println("║ 0. ↩  VOLTAR                           ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.print("║ SELECIONE UMA OPÇÃO: ");
            
            opcaoEdicao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            switch (opcaoEdicao) {
                case 1: // Renomear treino
                    System.out.print("║ NOVO NOME DO TREINO: ");
                    String novoNome = scanner.nextLine();
                    
                    if (!novoNome.trim().isEmpty()) {
                        treinoSelecionado.setNome(novoNome);
                        treServi.atualizarTreino(treinoSelecionado);
                        System.out.println("╠════════════════════════════════════════╣");
                        System.out.println("║       ✅ NOME ALTERADO COM SUCESSO     ║");
                        nomeTreinoOriginal = novoNome; // Atualiza
                    } else {
                        System.out.println("╠════════════════════════════════════════╣");
                        System.out.println("║    ❌ NOME NÃO PODE SER VAZIO!         ║");
                    }
                    break;
                    
                case 2: // Alterar nivel
                    System.out.println("╠════════════════════════════════════════╣");
                    System.out.println("║ SELECIONE O NOVO NÍVEL:               ║");
                    System.out.println("║ 1. INICIANTE                          ║");
                    System.out.println("║ 2. INTERMEDIÁRIO                     ║");
                    System.out.println("║ 3. AVANÇADO                           ║");
                    System.out.print("║ OPÇÃO: ");
                    
                    int opcaoNivel = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    
                    Nivel novoNivel;
                    switch (opcaoNivel) {
                        case 1: novoNivel = Nivel.INICIANTE; break;
                        case 2: novoNivel = Nivel.INTERMEDIARIO; break;
                        case 3: novoNivel = Nivel.AVANCADO; break;
                        default:
                            System.out.println("╠════════════════════════════════════════╣");
                            System.out.println("║      ❌ OPÇÃO DE NÍVEL INVÁLIDA!      ║");
                            continue;
                    }
                    
                    treinoSelecionado.setNivelDif(novoNivel);
                    treServi.atualizarTreino(treinoSelecionado);
                    System.out.println("╠════════════════════════════════════════╣");
                    System.out.println("║    ✅ NÍVEL ALTERADO COM SUCESSO!      ║");
                    break;
                    
                case 3: // Adicionar exercicio
                    System.out.println("╠════════════════════════════════════════╣");
                    System.out.println("║       ADICIONAR EXERCÍCIO             ║");
                    System.out.println("╠════════════════════════════════════════╣");

                    // Listar todos os exercícios disponiveis
                    List<Exercicio> exerciciosDisponiveis = exServi.listarTodosExercicios();
                    int paginaAtual = 0;
                    int exerciciosPorPagina = 10;
                    boolean sair = false;

                    do {
                        System.out.println("╠════════════════════════════════════════╣");
                        System.out.printf("║ PÁGINA %-2d DE %-2d %26s ║\n", 
                                        paginaAtual + 1, 
                                        (int) Math.ceil((double)exerciciosDisponiveis.size()/exerciciosPorPagina),
                                        "");
                        System.out.println("╠════════════════════════════════════════╣");

                        int inicio = paginaAtual * exerciciosPorPagina;
                        int fim = Math.min(inicio + exerciciosPorPagina, exerciciosDisponiveis.size());

                        for (int i = inicio; i < fim; i++) {
                            Exercicio ex = exerciciosDisponiveis.get(i);
                            System.out.printf("║ %2d. %-25s (%s) ║\n", 
                                            i+1, 
                                            ex.getNome(),
                                            ex.getGrupoMuscular());
                        }

                        System.out.println("╠════════════════════════════════════════╣");
                        System.out.println("║ n. PRÓXIMA PÁGINA                     ║");
                        System.out.println("║ p. PÁGINA ANTERIOR                    ║");
                        System.out.println("║ s. SELECIONAR EXERCÍCIO                ║");
                        System.out.println("║ 0. VOLTAR                              ║");
                        System.out.println("╠════════════════════════════════════════╣");
                        System.out.print("║ OPÇÃO: ");
                        String opcaoExercicio = scanner.nextLine();

                        switch (opcaoExercicio.toLowerCase()) {
                            case "n":
                                if ((paginaAtual + 1) * exerciciosPorPagina < exerciciosDisponiveis.size()) {
                                    paginaAtual++;
                                } else {
                                    System.out.println("╠════════════════════════════════════════╣");
                                    System.out.println("║      ❌ ÚLTIMA PÁGINA ALCANÇADA!      ║");
                                }
                                break;
                                
                            case "p":
                                if (paginaAtual > 0) {
                                    paginaAtual--;
                                } else {
                                    System.out.println("╠════════════════════════════════════════╣");
                                    System.out.println("║      ❌ PRIMEIRA PÁGINA ALCANÇADA!    ║");
                                }
                                break;
                                
                            case "s":
                                System.out.print("║ NÚMERO DO EXERCÍCIO: ");
                                try {
                                    int numExercicio = Integer.parseInt(scanner.nextLine()) - 1;
                                    
                                    if (numExercicio >= 0 && numExercicio < exerciciosDisponiveis.size()) {
                                        Exercicio exercicioSelecionado = exerciciosDisponiveis.get(numExercicio);
                                        
                                        System.out.print("║ NÚMERO DE REPETIÇÕES: ");
                                        int repeticoes = scanner.nextInt();
                                        scanner.nextLine(); // Limpar buffer
                                        
                                        treServi.adicionarExercicios(nomeTreinoOriginal, 
                                                                   exercicioSelecionado.getNome(), 
                                                                   auth.getUsuario(), 
                                                                   repeticoes);
                                        
                                        System.out.println("╠════════════════════════════════════════╣");
                                        System.out.printf("║ ✅ %-25s ADICIONADO! ║\n", 
                                                        exercicioSelecionado.getNome());
                                        sair = true;
                                    } else {
                                        System.out.println("╠════════════════════════════════════════╣");
                                        System.out.println("║        ❌ NÚMERO INVÁLIDO!            ║");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("╠════════════════════════════════════════╣");
                                    System.out.println("║     ❌ DIGITE UM NÚMERO VÁLIDO!        ║");
                                }
                                break;
                                
                            case "0":
                                sair = true;
                                break;
                                
                            default:
                                System.out.println("╠════════════════════════════════════════╣");
                                System.out.println("║        ❌ OPÇÃO INVÁLIDA!              ║");
                        }
                    } while (!sair);
                    break;
                    
                case 4: // Remover exercicio
                    List<Exercicio> exerciciosAtuais = treServi.listarTreinosDoAluno(
                        cpfAluno, nomeTreinoOriginal, auth.getUsuario());
                    
                    if (exerciciosAtuais.isEmpty()) {
                        System.out.println("╠════════════════════════════════════════╣");
                        System.out.println("║  ❌ TREINO NÃO TEM EXERCÍCIOS!         ║");
                        break;
                    }
                    
                    System.out.println("╠════════════════════════════════════════╣");
                    System.out.println("║ EXERCÍCIOS ATUAIS:                     ║");
                    for (int i = 0; i < exerciciosAtuais.size(); i++) {
                        System.out.printf("║ %d. %-20s (%d reps)       ║\n",
                                        i+1,
                                        exerciciosAtuais.get(i).getNome(),
                                        exerciciosAtuais.get(i).getQuantidade());
                    }
                    
                    System.out.print("║ NÚMERO DO EXERCÍCIO A REMOVER: ");
                    int exercicioRemover = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    
                    if (exercicioRemover < 1 || exercicioRemover > exerciciosAtuais.size()) {
                        System.out.println("╠════════════════════════════════════════╣");
                        System.out.println("║        ❌ OPÇÃO INVÁLIDA!             ║");
                        break;
                    }
                    
                    String nomeExercicioRemover = exerciciosAtuais.get(exercicioRemover-1).getNome();
                    treServi.removerExercicios(nomeTreinoOriginal, nomeExercicioRemover, auth.getUsuario());
                    System.out.println("╠════════════════════════════════════════╣");
                    System.out.println("║  ✅ EXERCÍCIO REMOVIDO COM SUCESSO!    ║");
                    break;
                    
                case 5: // Listar exercicios
                    listarExerciciosTreino(nomeTreinoOriginal);
                    break;
                    
                case 0: // Sair
                    System.out.println("╠════════════════════════════════════════╣");
                    System.out.println("║      ALTERAÇÕES SALVAS COM SUCESSO!   ║");
                    break;
                    
                default:
                    System.out.println("╠════════════════════════════════════════╣");
                    System.out.println("║           ❌ OPÇÃO INVÁLIDA!           ║");
            }
            
        } while (opcaoEdicao != 0);
        
        System.out.println("╚════════════════════════════════════════╝");
        
    } catch (SecurityException e) {
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ ❌ ACESSO NEGADO: " + e.getMessage() + " ║");
        System.out.println("╚════════════════════════════════════════╝");
    } catch (Exception e) {
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ ❌ ERRO: " + e.getMessage());
        System.out.println("╚════════════════════════════════════════╝");
    }
}

public void listarTreinosDoAluno() {
    System.out.println("\n╔════════════════════════════════════════╗");
    System.out.println("║        📋 LISTAR TREINOS DE ALUNO       ║");
    System.out.println("╠════════════════════════════════════════╣");
    
    System.out.print("║ CPF DO ALUNO (somente números): ");
    String cpfAluno = scanner.nextLine();
    
    try {
        // Verifica se o usuario logado tem permissao
        Usuario solicitante = auth.getUsuario();
        List<Treino> treinos = treServi.listarTreinosDoAluno(cpfAluno, solicitante);
        
        if (treinos.isEmpty()) {
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║   ❌ ALUNO NÃO POSSUI TREINOS CADASTRADOS ║");
            System.out.println("╚════════════════════════════════════════╝");
            return;
        }
        
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║          TREINOS ENCONTRADOS           ║");
        System.out.println("╠════════════════════════════════════════╣");
        
        int i = 1;
        for (Treino treino : treinos) {
            System.out.printf("║ %d. %-20s (Nível: %-12s) ║\n", 
                            i++, 
                            treino.getNome(), 
                            treino.getNivelDif());
        }
        
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ Deseja ver os exercícios de algum treino? (S/N) ");
        System.out.print("║ ▸ ");
        String opcao = scanner.nextLine();
        
        if (opcao.equalsIgnoreCase("S")) {
            System.out.print("║ NÚMERO DO TREINO: ");
            int numTreino = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            if (numTreino > 0 && numTreino <= treinos.size()) {
                Treino treinoSelecionado = treinos.get(numTreino - 1);
                listarExerciciosTreino(treinoSelecionado.getNome());
            } else {
                System.out.println("║ ❌ NÚMERO INVÁLIDO!");
            }
        }
        
        System.out.println("╚════════════════════════════════════════╝");
        
    } catch (SecurityException e) {
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ ❌ ACESSO NEGADO: " + e.getMessage());
        System.out.println("╚════════════════════════════════════════╝");
    } catch (Exception e) {
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ ❌ ERRO: " + e.getMessage());
        System.out.println("╚════════════════════════════════════════╝");
    }
}
	

	
	
	//listar treinos
	public void listarTreinoDoAluno() {
		System.out.println("QUAL O ALUNO?\nCPF: ");
		String cpf = scanner.nextLine();
		System.out.println(treServi.listarTreinosDoAluno(cpf, auth.getUsuario()));
	}
	// editar treino
	
	private void listarExerciciosTreino(String nomeTreino) {
	    try {
	    	
	        Usuario usuarioLogado = auth.getUsuario();
	        
	        // Verificaçao se é aluno
	        String cpfAluno;
	        if (usuarioLogado instanceof Aluno) {
	            cpfAluno = usuarioLogado.getCpf();
	        } else {
	            // Se for tutor/adm, pedimos o CPF do aluno
	            System.out.print("║ CPF DO ALUNO: ");
	            cpfAluno = scanner.nextLine();
	        }

	        List<Exercicio> exercicios = treServi.listarTreinosDoAluno(cpfAluno, nomeTreino, auth.getUsuario());
	        
	        System.out.println("\n╔══════════════════════════════════════════════╗");
	        System.out.printf ("║ EXERCÍCIOS DO TREINO: %-21s ║\n", nomeTreino);
	        System.out.println("╠══════════════════════════════════════════════╣");
	        
	        if (exercicios.isEmpty()) {
	            System.out.println("║          NENHUM EXERCÍCIO CADASTRADO          ║");
	        } else {
	            for (Exercicio ex : exercicios) {
	                System.out.printf("║ ► %-25s (%d repetições) ║\n", 
	                                ex.getNome(), 
	                                ex.getQuantidade());
	                System.out.printf("║   Grupo: %-20s Equip: %-10s ║\n",
	                                ex.getGrupoMuscular(),
	                                ex.getEquipamento());
	                System.out.println("╠══════════════════════════════════════════════╣");
	            }
	        }
	        System.out.println("╚══════════════════════════════════════════════╝");
	        
	    } catch (Exception e) {
	        System.out.println("╔════════════════════════════════════════╗");
	        System.out.println("║ ❌ ERRO: " + e.getMessage());
	        System.out.println("╚════════════════════════════════════════╝");
	    }
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
	    System.out.println("│ 1. INICIANTE          │");
	    System.out.println("│ 2. INTERMEDIARIO      │");
	    System.out.println("│ 3. AVANCADO           │");
	    System.out.print("│ Opção: ");
	    
	    int opcao = scanner.nextInt();
	    scanner.nextLine(); // Limpar buffer
	    
	    Nivel nivel;
	    switch(opcao) {
	        case 1: nivel = Nivel.INICIANTE; break;
	        case 2: nivel = Nivel.INTERMEDIARIO; break;
	        case 3: nivel = Nivel.AVANCADO; break;
	        default: 
	            System.out.println("Opção inválida! Usando nível INICIANTE como padrão.");
	            nivel = Nivel.INICIANTE;
	    }
	    
	    treServi.criarTreino(nome, nivel);
	    System.out.println("└───────────────────────┘");
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
	    System.out.println("\n╔════════════════════════════════════╗");
	    System.out.println("║        ❌ REMOVER TREINO           ║");
	    System.out.println("╠════════════════════════════════════╣");
	    
	    // Listar todos os treinos
	    List<Treino> todosTreinos = treRepo.listarTodos();
	    
	    if (todosTreinos.isEmpty()) {
	        System.out.println("║ Nenhum treino cadastrado          ║");
	        System.out.println("╚════════════════════════════════════╝");
	        return;
	    }
	    
	    // Mostrar treinos
	    for (int i = 0; i < todosTreinos.size(); i++) {
	        System.out.printf("║ %d. %-30s ║\n", i+1, todosTreinos.get(i).getNome());
	    }
	    
	    System.out.print("║ Digite o número do treino: ");
	    int opcao = scanner.nextInt();
	    scanner.nextLine();
	    
	    if (opcao < 1 || opcao > todosTreinos.size()) {
	        System.out.println("╠════════════════════════════════════╣");
	        System.out.println("║ ❌ Opção inválida!                ║");
	        System.out.println("╚════════════════════════════════════╝");
	        return;
	    }
	    
	    String nomeTreino = todosTreinos.get(opcao-1).getNome();
	    
	    try {
	        // Confirma
	        System.out.println("╠════════════════════════════════════╣");
	        System.out.println("║ ATENÇÃO: Esta ação é irreversível! ║");
	        System.out.print("║ Confirmar remoção? (S/N): ");
	        String confirmacao = scanner.nextLine();
	        
	        if (confirmacao.equalsIgnoreCase("S")) {
	            treServi.removerTreino(nomeTreino);
	            System.out.println("╠════════════════════════════════════╣");
	            System.out.println("║ ✅ TREINO REMOVIDO COM SUCESSO!    ║");
	        } else {
	            System.out.println("╠════════════════════════════════════╣");
	            System.out.println("║ Operação cancelada pelo usuário    ║");
	        }
	    } catch (Exception e) {
	        System.out.println("╠════════════════════════════════════╣");
	        System.out.println("║ ❌ ERRO: " + e.getMessage());
	    }

	    System.out.println("╚════════════════════════════════════╝");
	}

	
	
	public void cdTutor() {
	    String dataScn = "2006-10-23";
	    LocalDate dataDeNascimento = LocalDate.parse(dataScn);

	    try {
	        services.cadastroTutor("yuri", "yuri@gmail.com", "123456789", "14725836910", dataDeNascimento, 1200);
	    } catch (IllegalArgumentException e) {
	        System.out.println(e.getMessage());
	    }

	    dataScn = "2005-06-18";
	    LocalDate dataDeNascimento1 = LocalDate.parse(dataScn);
	    try {
	        services.cadastroTutor("Ysabelle", "bell@gmail.com", "ysabelle01", "96385274101", dataDeNascimento1, 1200);
	        services.atualizaDataDeCadastro("96385274101", LocalDate.of(2025, 04, 01));
	    } catch (IllegalArgumentException e) {
	        System.out.println(e.getMessage());
	    }
	}

	
}
