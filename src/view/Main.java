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
	    AuthService authService = new AuthService(usuarioRepository);
		
		Alunocontroller alunocontroller = new Alunocontroller(authService, usuarioService);
		Tutorcontroller tutorcontroller = new Tutorcontroller();
		Admcontroller admController = new Admcontroller(authService,usuarioService);

		
		Aluno aluno = null;
		Tutor tutor = null;
		Administrador adm = null;
		
		
		
		//Administrador adm1 = new Administrador("Victor","Victor@gmail.com","12345678","11122233344", null);
		
		
		Tutor tutor1 = new Tutor("Naruto","naruto@gmail.com","123321123321","12345678910",LocalDate.of(2000,01,01),0);
		
		//tutor1.setSalario(1000);
		
		Aluno a1 = new Aluno("ysa","ysa@gmail.com","123123123","12312312312", LocalDate.of(2000, 01, 19),80, 1.80, Nivel.AVANCADO, Metas.ganharMassa,"", Plano.planoMensal, Genero.FEMININO);
		Aluno a2 = new Aluno("Bell","bell@gmail.com","123123123","32132132132", LocalDate.of(2000, 01, 19),80, 1.80, Nivel.AVANCADO, Metas.ganharMassa,"", Plano.planoMensal, Genero.FEMININO);
		
		
		admController.cadastroAlunoController(a1);
		
		admController.Cadastrotutor(tutor1);
		
		//Tcontroller.cadastroTutoresController(tutor1);
		
		
		
		//new Perfil(aluno).setVisible(true);
	    new TelaEscolhaUsuario(aluno, tutor, alunocontroller, admController).setVisible(true);
		//new Formulario(aluno).setVisible(true);
		//new TabelaCadastrosAdm().setVisible(true);
		//new Loginaluno(aluno).setVisible(true);
		
	}

}
