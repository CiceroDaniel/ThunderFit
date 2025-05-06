package view;

import java.time.LocalDate;

import model.Aluno;
import model.Metas;
import model.Nivel;
import model.Plano;
import model.Tutor;
import model.Aluno.Genero;

public class Main {
	
	public static void main(String[] args) {
		
		Aluno aluno = null;
		Tutor tutor = null;
		
		Aluno a1 = new Aluno("ysa","ysa@gmail.com","123123123","12312312312", LocalDate.of(2025, 01, 19),80, 1.80, Nivel.AVANCADO, Metas.ganharMassa, null, Plano.planoMensal, Genero.FEMININO, 123);
		//não tá adicionando o aluno ao array
		
		//new Perfil(aluno).setVisible(true);
		new TelaEscolhaUsuario(aluno, tutor).setVisible(true);
		//new Formulario(aluno).setVisible(true);
		
		
		
	}

}
