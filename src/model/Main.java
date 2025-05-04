package model;

import view.TelaEscolhaUsuario;
import view.Formulario;
import view.Perfil;

public class Main {
	
	public static void main(String[] args) {
		
		Aluno aluno = null;
		
		
		//new Perfil(aluno).setVisible(true);
		new TelaEscolhaUsuario(aluno).setVisible(true);
		//new Formulario(aluno).setVisible(true);
		
		//Aluno aluno = new Aluno("ysa","ysa@gmail.com","123123123");
		
		
	}

}
