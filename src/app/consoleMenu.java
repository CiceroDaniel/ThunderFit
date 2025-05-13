package app;

import app.*;
import repository.ExercicioRepository;
import repository.PagamentoRepository;
import repository.TreinoRepository;
import repository.UsuarioRepository;
import services.AuthService;
import services.ExercicioService;
import services.PagamentoService;
import services.PlanoService;
import services.PresencaService;
import services.RelatorioFinanceiroService;
import services.RelatorioPresencaService;
import services.TreinoService;
import services.UsuarioService;

import java.util.Scanner;


public class consoleMenu {
	Scanner scan = new Scanner(System.in);
	
	
	
	private UsuarioRepository repo;
	usuarioConsole userConsole;
	admConsole admConsole;
	tutorConsole tutorConsole;
	private Scanner scanner;
	toolbox tools;
	private AuthService auth;
	private UsuarioService services;
	private ExercicioRepository exRepo;
	private ExercicioService exServi; 
	private TreinoRepository treRepo;
	private TreinoService treServi;
	private PagamentoRepository pagRepo;
	private PagamentoService pagService;

	private final RelatorioPresencaService relatorioPresencaService;
    private final RelatorioFinanceiroService relatorioFinanceiroService;
    private final PlanoService planoService;
    private final PresencaService presencaService;
	

	public consoleMenu(Scanner scanner, UsuarioRepository repo, AuthService auth,UsuarioService services,ExercicioRepository exRepo,ExercicioService exServi, TreinoRepository treRepo, TreinoService treServi, PagamentoRepository pagRepo, PagamentoService pagService, RelatorioPresencaService relatorioPresencaService, RelatorioFinanceiroService relatorioFinanceiroService, PlanoService planoService, PresencaService presencaService ) {
		this.scanner = scanner;
	    this.repo = repo;
	    this.auth = auth;
	    this.services = services;
	    this.exRepo= exRepo;
	    this.exServi= exServi;
	    this.treRepo= treRepo;
	    this.treServi=treServi;
	    this.pagRepo = pagRepo;
	    this.pagService = pagService;
	    
	    this.relatorioPresencaService = relatorioPresencaService;
        this.relatorioFinanceiroService = relatorioFinanceiroService;
        this.planoService = planoService;
        this.presencaService = presencaService;
	    
	    this.tutorConsole = new tutorConsole(scanner, repo, auth, services, exRepo, exServi, treRepo, treServi, pagRepo, pagService);
	    this.userConsole = new usuarioConsole(scanner, services, auth, pagRepo, pagService);
	    this.admConsole = new admConsole(scanner, repo, auth, services, pagRepo, pagService, relatorioPresencaService, relatorioFinanceiroService, planoService, presencaService);
	    this.tools = new toolbox(userConsole, admConsole, tutorConsole);
	}
	
	


	

	// YSABELLE PASSE LONGE DESSE ARQUIVO PELO AMOR DE SAMARA!
	public void init(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services) {
		
		int op;
		do {
			System.out.println("==========MENU INICIAL=========== \n"
			 		+ "1 - LOGIN \n"
					+ "0 - SAIR \n"
					+ "ESCOLHA A OPÇÃO: ");
			op = scanner.nextInt();
			scanner.nextLine();
			//testando pra victor hugo
			switch(op) {
				case 1 :  login(scanner, repo, auth, services);
					break;
				case 0 :System.out.println("SAINDO DO SISTEMA.......");
				System.exit(0);
				default: System.out.println("OPÇÃO INVALIDA!");
			}
		}while(op!=0);
		
	}
	
	public void Cadastro(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services) {
		int op;
		do {
			
			System.out.println("============CADASTRAR============"
					+ "\n1 - CLIENTE"
					+ "\n2 - TUTOR"
					+ "\n0 - VOLTAR"
					+ "\nESCOLHA UMA OPÇÃO: ");
			op = scanner.nextInt();
			scanner.nextLine();
			
			switch(op) {
			case 1: userConsole.cadastroMenu(scanner, repo, auth, services);
			break;
			case 2: tutorConsole.cadastroMenu(scanner, repo, auth, services);
			break;
			case 0: init(scanner, repo, auth, services);
			}
			
		}while(op!=0);
	}
	
	public void login(Scanner scanner, UsuarioRepository repo, AuthService auth, UsuarioService services) {
		int op;
		do {
			tools.espacoMenu();
			
			System.out.println("============LOGIN============"
					+ "\n1 - CLIENTE"
					+ "\n2 - TUTOR"
					+ "\n3 - ADIMINISTRADOR"
					+ "\n0 - VOLTAR"
					+ "\nESCOLHA UMA OPÇÃO: ");
			op = scanner.nextInt();
			scanner.nextLine();
			
			//
			switch(op) {
			case 1: userConsole.loginMenu(scanner, repo, auth, services);
			break;
			case 2: tutorConsole.loginMenu(scanner, repo, auth, services);;
			break;
			case 3: admConsole.loginMenu();
			break;
			case 0: init(scanner, repo, auth, services);
			break;
			default: System.out.println("OPÇAÕ INVALIDA!");
			}
			
		}while(op!=0);
	}

	
	public toolbox getTools() {
		return tools;
	}

	public void setTools(toolbox tools) {
		this.tools = tools;
	}
	
	/*public void mostarAdm() {
		admConsole.cdAdm();
	}*/
}
