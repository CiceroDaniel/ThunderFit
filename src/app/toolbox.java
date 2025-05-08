package app;

import app.tutorConsole;
import app.usuarioConsole;
import app.admConsole;

public class toolbox {
	tutorConsole tutor = new tutorConsole();
	usuarioConsole user = new usuarioConsole();
	admConsole adm = new admConsole();
	
	public void preCad() {
		adm.cdAdm();
		tutor.cdTutor();
		user.cdUser();
		espacoMenu();
		
	}
	
	public static void espacoMenu() {
		for(int i = 0; i <= 10;i++) {
			System.out.println("  ");
		}
	}
}
