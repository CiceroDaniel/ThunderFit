package model;

import view.TelaEscolhaUsuario;
import view.Formulario;

public class Main {
	
	public static void main(String[] args) {
		
		Aluno aluno = null;
		
		new TelaEscolhaUsuario(aluno).setVisible(true);
		//new Formulario(aluno).setVisible(true);
		
		//Aluno aluno = new Aluno("ysa","ysa@gmail.com","123123123");
		
		
	}

}
