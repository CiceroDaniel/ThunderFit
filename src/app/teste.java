package app;

import  java.util.Scanner;
		
public class teste {
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// YSABELLE PASSE LONGE DESSE ARQUIVO PELO AMOR DE SAMARA!
		int op;
		do {
				
				System.out.println("==========SELECIONE O TIPO DE USUARIO=========== \n"
						+ "1 - CLIENTE \n"
				 		+ "2 - TUTOR \n"
						+ "3 - ADIMINISTRADOR \n"
						+ "0 - SAIR \n4"
						+ "ESCOLHA A OPÇÃO: ");
				op = scan.nextInt();
				scan.nextLine();
				
				switch(op) {
					case 1 -> ClienteMenu.menu();
				}
			}while(op!=0);
				
		
		
		
		
		
		
		
		
		
			
		
	}

}
