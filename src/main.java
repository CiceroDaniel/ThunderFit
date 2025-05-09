import java.util.Scanner;

import app.consoleMenu;
import app.toolbox;
import repository.UsuarioRepository;

public class main {

	public static void main(String[] args) {
		UsuarioRepository repo = new UsuarioRepository();
		consoleMenu menu = new consoleMenu(repo);
		
		Scanner scan = new Scanner(System.in);
		menu.getTools().preCad();
		toolbox.espacoMenu();
		
		
		menu.init();
		//menu.mostarAdm();
		//menu.cadTutor();

	}

}
