package app;

import  java.util.Scanner;	
import app.consoleMenu;
import app.toolbox;
import model.Catraca;
import repository.ExercicioRepository;
import repository.PagamentoRepository;
import repository.PresencaRepository;
import repository.TreinoRepository;
import repository.UsuarioRepository;
import services.AuthService;
import services.CatracaService;
import services.ExercicioService;
import services.PagamentoService;
import services.PresencaService;
import services.TreinoService;
import services.UsuarioService;
public class teste {
	
	
	public static void main(String[] args) {
		
		final Catraca catraca = new Catraca();
		final TreinoRepository treRepo = new TreinoRepository();
		final ExercicioRepository exRepo = new ExercicioRepository();
		final ExercicioService exServi = new ExercicioService(exRepo);
		final UsuarioRepository repo = new UsuarioRepository();
		final UsuarioService services = new UsuarioService(repo);
		final TreinoService treServi = new TreinoService(treRepo, exServi, repo, services);
		final PagamentoRepository pagRepo = new PagamentoRepository();
		final PagamentoService pagService = new PagamentoService(pagRepo, services);
		final PresencaRepository presencaRepo = new PresencaRepository();
		final PresencaService presencaServi = new PresencaService(presencaRepo);
		final CatracaService catracaSer = new CatracaService(catraca, pagRepo, presencaServi);
		final AuthService auth = new AuthService(repo,services);
		Scanner scan = new Scanner(System.in);
		
		
		consoleMenu menu = new consoleMenu(scan,repo,auth,services, exRepo, exServi, treRepo, treServi, pagRepo,
				pagService, null, null, null, presencaRepo, presencaServi, catraca, catracaSer);
		menu.tools.preCad();
		
		
	
		
		toolbox.espacoMenu();
		menu.init(scan, repo, auth, services);
		//menu.mostarAdm();
		//menu.cadTutor();
		
		
		scan.close();
	}
	
}