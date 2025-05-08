package app;

import app.tutorConsole;
import app.usuarioConsole;
import app.admConsole;

public class toolbox {
	tutorConsole tutor;
	usuarioConsole user;
	admConsole adm;
	
	public toolbox(usuarioConsole user, admConsole adm, tutorConsole tutor) {
		this.user = user;
		this.adm = adm;
		this.tutor = tutor;
	}

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
