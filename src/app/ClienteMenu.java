package app;

import java.util.Scanner;

public class ClienteMenu {
	public static void menu() {
		Scanner scan = new Scanner(System.in);

		int op;
		do {
			System.out.println("==========MENU DO USUARIO=========== \n"
					+ "1 - LOGIN \n"
					+ "0 - SAIR \n4"
					+ "ESCOLHA A OPÇÃO: ");
			op = scan.nextInt();
			scan.nextLine();
			
			switch(op) {
			case 1 -> System.out.println("teste");
			}
			
		}while(op!=0);
	}
}
