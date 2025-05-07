package view;

import java.time.LocalDate;

//import controller.Admcontroller;
import controller.Alunocontroller;
import controller.Tutorcontroller;
import model.Administrador;
import model.Aluno;
import model.Metas;
import model.Nivel;
import model.Plano;
import model.Tutor;
import model.Aluno.Genero;

public class Main {
	
	public static void main(String[] args) {
		
		//FALTA CADASTRAR ADM E LOGIN ADM
		
		Alunocontroller controller = new Alunocontroller();
		Tutorcontroller Tcontroller = new Tutorcontroller();
		//Admcontroller Admcontroller = new Admcontroller();
		
		Aluno aluno = null;
		Tutor tutor = null;
		Administrador adm = null;
		
		Administrador adm1 = new Administrador("Victor","Victor@gmail.com","12345678","11122233344", null);
		
		
		Tutor tutor1 = new Tutor("Naruto","naruto@gmail.com","123321123321","12345678910",LocalDate.of(2000,01,01),0);
		
		tutor1.setSalario(1000);
		
		Aluno a1 = new Aluno("ysa","ysa@gmail.com","123123123","12312312312", LocalDate.of(2000, 01, 19),80, 1.80, Nivel.AVANCADO, Metas.ganharMassa,"", Plano.planoMensal, Genero.FEMININO, 123);
		Aluno a2 = new Aluno("Bell","bell@gmail.com","123123123","32132132132", LocalDate.of(2000, 01, 19),80, 1.80, Nivel.AVANCADO, Metas.ganharMassa,"", Plano.planoMensal, Genero.FEMININO, 123);
		
		
		Tcontroller.cadastroTutoresController(tutor1);
		
		controller.cadastroalunoController(a1);
		controller.cadastroalunoController(a2);
		
		
		//new Perfil(aluno).setVisible(true);
	    new TelaEscolhaUsuario(aluno, tutor).setVisible(true);
		//new Formulario(aluno).setVisible(true);
		//new TabelaCadastrosAdm().setVisible(true);
		//new Loginaluno(aluno).setVisible(true);
		
	}

}
