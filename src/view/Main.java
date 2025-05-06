package view;

import model.Aluno;
import model.Tutor;

public class Main {
	
	public static void main(String[] args) {
		
		Aluno aluno = null;
		Tutor tutor = null;
		
		
		//new Perfil(aluno).setVisible(true);
		new TelaEscolhaUsuario(aluno, tutor).setVisible(true);
		//new Formulario(aluno).setVisible(true);
		
		//Aluno aluno = new Aluno("ysa","ysa@gmail.com","123123123");
		
		
	}

}
