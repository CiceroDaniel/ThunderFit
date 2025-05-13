package app;

import  java.util.Scanner;	
import app.consoleMenu;
import app.toolbox;
import repository.ExercicioRepository;
import repository.TreinoRepository;
import repository.UsuarioRepository;
import services.AuthService;
import services.ExercicioService;
import services.TreinoService;
import services.UsuarioService;
public class teste {
	
	
	public static void main(String[] args) {

		final TreinoRepository treRepo = new TreinoRepository();
		final ExercicioRepository exRepo = new ExercicioRepository();
		final ExercicioService exServi = new ExercicioService(exRepo);
		final UsuarioRepository repo = new UsuarioRepository();
		final UsuarioService services = new UsuarioService(repo);
		final TreinoService treServi = new TreinoService(treRepo, exServi, repo, services);
		
		final AuthService auth = new AuthService(repo,services);
		Scanner scan = new Scanner(System.in);
		
		
		consoleMenu menu = new consoleMenu(scan,repo,auth,services, exRepo, exServi, treRepo, treServi);
		menu.tools.preCad();
		toolbox.espacoMenu();
		
		
		menu.init(scan, repo, auth, services);
		//menu.mostarAdm();
		//menu.cadTutor();
		
		
		scan.close();
	}
	
}