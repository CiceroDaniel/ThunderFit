package app;

import java.util.Scanner;

public class consoleMenu {
	Scanner scan = new Scanner(System.in);
	usuarioConsole userConsole = new usuarioConsole();
	admConsole admConsole = new admConsole();
	tutorConsole  tutorConsole = new tutorConsole();
	// YSABELLE PASSE LONGE DESSE ARQUIVO PELO AMOR DE SAMARA!
	public void init() {
		
		int op;
		do {
			System.out.println("==========MENU INICIAL=========== \n"
					+ "1 - CADASTRO \n"
			 		+ "2 - LOGIN \n"
					+ "3 - SAIR \n"
					+ "ESCOLHA A OPÇÃO: ");
			op = scan.nextInt();
			scan.nextLine();
			//testando pra victor hugo
			switch(op) {
				case 1 :  userConsole.cadastroMenu(); ;
					break;
				case 2 :  //AQUI CHAMA O METODO DE LOGIN ;
					break;
				case 3 :System.out.println("SAINDO DO SISTEMA");
				System.exit(0);
				default: System.out.println("OPÇÃO INVALIDA!");
			}
		}while(op!=0);
		espacoMenu();
	}
	public void espacoMenu() {
		for(int i = 0; i <= 15;i++) {
			System.out.println("  ");
		}
	}
	public void cadTutor() {
		tutorConsole.cadastroMenu();
	}
	/*public void mostarAdm() {
		admConsole.cdAdm();
	}*/
}
