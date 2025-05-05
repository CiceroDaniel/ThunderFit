package app;

import  java.util.Scanner;
		
public class teste {
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// YSABELLE PASSE LONGE DESSE ARQUIVO PELO AMOR DE SAMARA!
		int op;
		do {
				
				System.out.println("==========MENU INICIAL=========== \n"
						+ "1 - CADASTRO \n"
				 		+ "2 - LOGIN \n"
						+ "3 - SAIR \n4"
						+ "ESCOLHA A OPÇÃO: ");
				op = scan.nextInt();
				scan.nextLine();
				//testando pra victor hugo
				switch(op) {
					case 1 :  /*AQUI CHAMA O METODO DE REGISTRO*/ ;
						break;
					case 2 :  /*AQUI CHAMA O METODO DE LOGIN*/ ;
						break;
					case 3 :System.out.println("SAINDO DO SISTEMA");
					System.exit(0);
					default: System.out.println("OPÇÃO INVALIDA!");
				}
			}while(op!=0);
				
		
		
		
		
		
		
		
		
		
			
		
	}

}
