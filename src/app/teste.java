package app;

import  java.util.Scanner;

import model.Catraca;
import repository.ExercicioRepository;
import repository.PagamentoRepository;
import repository.PresencaRepository;
import repository.TreinoRepository;
import repository.UsuarioRepository;
import services.AuthService;
import services.CatracaService;
import services.ExercicioService;
import services.GraficoPesoService;
import services.PagamentoService;
import services.PlanoService;
import services.PresencaService;
import services.RelatorioFinanceiroService;
import services.RelatorioPresencaService;
import services.TreinoService;
import services.UsuarioService;
public class teste {
	
	
	public static void main(String[] args) {
		
		final GraficoPesoService grafiPesoServi= new GraficoPesoService();
		final Catraca catraca = new Catraca();		
		final PlanoService planoServi = new PlanoService();
		final TreinoRepository treRepo = new TreinoRepository();
		final ExercicioRepository exRepo = new ExercicioRepository();
		final ExercicioService exServi = new ExercicioService(exRepo);
		final UsuarioRepository repo = new UsuarioRepository();
		final PagamentoRepository pagRepo = new PagamentoRepository();
		final UsuarioService services = new UsuarioService(repo,pagRepo);
		final TreinoService treServi = new TreinoService(treRepo, exServi, repo, services);
		final PagamentoService pagService = new PagamentoService(pagRepo, services);
		final PresencaRepository presencaRepo = new PresencaRepository();
		final PresencaService presencaServi = new PresencaService(presencaRepo);
		final RelatorioFinanceiroService relaFinanServi= new RelatorioFinanceiroService(pagRepo, services);
		final RelatorioPresencaService RePresencaServi = new RelatorioPresencaService(presencaRepo);
		final CatracaService catracaSer = new CatracaService(catraca, pagRepo, presencaServi);
		final AuthService auth = new AuthService(repo,services);
		Scanner scan = new Scanner(System.in);
		
		
		consoleMenu menu = new consoleMenu(scan,repo,auth,services, exRepo, exServi, treRepo, treServi, pagRepo,
				pagService,  RePresencaServi, relaFinanServi, planoServi, presencaRepo, presencaServi, catraca, catracaSer, grafiPesoServi);
		menu.tools.preCad();
		
		/*Luana para vc ter as informaçoes para login do usuario: "vh@gmail.com","123456789".
		 * do tutor "yuri@gmail.com", "123456789" e "bell@gmail.com", "ysabelle01"
		 * do adm "daniel@gmail.com","123123123"
		 */
	
		
		toolbox.espacoMenu();
		menu.init(scan, repo, auth, services);
		//menu.mostarAdm();
		//menu.cadTutor();
		
		
		scan.close();
	}
	
}