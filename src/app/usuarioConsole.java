package app;

import java.util.*;
import java.time.*;
import model.*;
import repository.UsuarioRepository;
import services.UsuarioService;

public class usuarioConsole {
	UsuarioRepository uRepo = new UsuarioRepository();
	UsuarioService services = new UsuarioService(uRepo);
	Scanner scanner = new Scanner(System.in);
	toolbox tools = new toolbox();

	Nivel nivel;
	Metas metas;
	Plano plano;

	String descricao = null;
	
	public void cadastroMenu() {
		tools.espacoMenu();
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
		

		
		services.cadastroAluno(nome, cpf, email, senha, dataDeNascimento, altura, peso, nivel, metas, descricao, plano);
	}
	/////////////////////////////
	
	
	
	////////////////////////////////////////////////////////////////////////
	public void nivelMenu() {
		
		int op;
		tools.espacoMenu();
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
		tools.espacoMenu();
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
		tools.espacoMenu();
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
	public void descricaoMenu() {
		System.out.println("DESCRIÇÃO: ");
		descricao = scanner.nextLine();	
	}
	
}
