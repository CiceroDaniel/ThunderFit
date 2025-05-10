package app;

import java.util.*;
import java.time.*;
import model.*;
import repository.UsuarioRepository;
import services.AuthService;
import services.UsuarioService;

public class usuarioConsole {
//	UsuarioRepository uRepo = new UsuarioRepository();
//	UsuarioService services = new UsuarioService(uRepo);
	//AuthService auth = new AuthService(Repo);
	//Scanner scanner = new Scanner(System.in);
	//toolbox tools = new toolbox();

	Nivel nivel;
	Metas metas;
	Plano plano;
	Genero genero;

	String descricao = null;
	private Scanner scanner;
	private UsuarioService services;
	private AuthService auth;
	
	
	public usuarioConsole(Scanner scanner, UsuarioService services,AuthService auth) {
		this.scanner = scanner;
	    this.services = services;
	    this.auth=auth;
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
		
		services.cadastroAluno(nome, email, senha, cpf, dataDeNascimento, altura, peso, nivel, metas, descricao, plano, genero);

	}
	/////////////////////////////////////////////////////////////////////////
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
			alunoMenu();
		}
	}
	
	
	////////////////////////////////////////////////////////////////////////
	public final void alunoMenu() {
		int op;
		do {
			System.out.println("========= MENU ALUNO =========="
					+ "\n1 - PERFIL"
					+ "\n2 - INSTRUTORES"
					+ "\n3 - CRONOGRAMA"
					+ "\n4 - PACOTES");
			op = scanner.nextInt();
			scanner.nextLine();
			
			switch(op) {
			case 1 :  //chama o perfil;
				break;
			case 2 :  listarTutor();
				break;
			case 3: //cronograma
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
	
	public void Perfil() {
		toolbox.espacoMenu();
		
		 if (!auth.getUsuarioLogado()) {
		        System.out.println("Nenhum usuário logado.");
		        return;
		    }
		
		 Usuario usuario = auth.getUsuario();
		 
		 
			
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
	
	public void descricaoMenu() {
		System.out.println("DESCRIÇÃO: ");
		descricao = scanner.nextLine();	
	}
	
	public void cdUser() {
		String dataScn = "2006-02-28";
		LocalDate dataDeNascimento = LocalDate.parse(dataScn);

		services.cadastroAluno("Victor Hugo", "vh@gmail.com","123456789", "10987654321", dataDeNascimento, 1.20, 15, nivel.INICIANTE, metas.ganharMassa, descricao, plano.planoAnual, genero.FEMININO);

	}
	
}
