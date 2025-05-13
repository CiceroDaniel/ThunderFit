package view;

import java.time.LocalDate;

import controller.Admcontroller;
//import controller.Admcontroller;
import controller.Alunocontroller;
import controller.Tutorcontroller;
import model.Administrador;
import model.Aluno;
import model.Genero;
import model.Metas;
import model.Nivel;
import model.Plano;
import model.Tutor;
import repository.UsuarioRepository;
import services.AuthService;
import services.UsuarioService;

public class Main {
	
	public static void main(String[] args) {
		
		
		
		UsuarioRepository usuarioRepository = new UsuarioRepository();
	    UsuarioService usuarioService = new UsuarioService(usuarioRepository);
	    AuthService authService = new AuthService(usuarioRepository, usuarioService);
		
		Alunocontroller alunocontroller = new Alunocontroller(authService, usuarioService);
		Tutorcontroller tutorcontroller = new Tutorcontroller(authService,usuarioService);
		Admcontroller admController = new Admcontroller(authService,usuarioService);

		
		Aluno aluno = null;
		Tutor tutor = null;
		Administrador adm = null;
		
		Administrador adm1 = new Administrador("Victor","Victor@gmail.com","12345678","11122233344",LocalDate.of(2000,01,01));
		Tutor tutor1 = new Tutor("Naruto","naruto@gmail.com","123321123321","12345678910",LocalDate.of(2000,01,01),0);
		Aluno a1 = new Aluno("ysa","ysa@gmail.com","123123123","12312312312", LocalDate.of(2000, 01, 19),1.80,80, Nivel.AVANCADO, Metas.ganharMassa,"", Plano.planoMensal, Genero.FEMININO);
		Aluno a2 = new Aluno("Bell","bell@gmail.com","123123123","32132132132", LocalDate.of(2000, 01, 19),1.50, 90, Nivel.AVANCADO, Metas.ganharMassa,"", Plano.planoMensal, Genero.FEMININO);
		
		
		admController.cadastroAlunoController(a1);
		admController.Cadastrotutor(tutor1);
		admController.cadastroAdmController(adm1);
		

		//new Perfil(aluno).setVisible(true);
	    new TelaEscolhaUsuario(aluno, tutor, adm, alunocontroller, tutorcontroller, admController).setVisible(true);
		//new Formulario(aluno).setVisible(true);
		//new TabelaCadastrosAdm(admController).setVisible(true);
		//new Loginaluno(aluno).setVisible(true);
		//new Tabelacadastrosdotutor(aluno, tutor, admController).setVisible(true);
		
	}

}
