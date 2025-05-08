package app;

import  java.util.Scanner;	
import app.consoleMenu;
import app.toolbox;
public class teste {
	
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		consoleMenu menu = new consoleMenu();
		toolbox tools = new toolbox();
		
		
		tools.preCad();
		menu.init();
		//menu.mostarAdm();
		//menu.cadTutor();
	}
	
}