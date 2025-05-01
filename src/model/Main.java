package model;

import view.TelaEscolhaUsuario;

public class Main {
	
	public static void main(String[] args) {
		
		Aluno aluno = null;
		
		new TelaEscolhaUsuario(aluno).setVisible(true);
		
		//Aluno aluno = new Aluno("ysa","ysa@gmail.com","123123123");
		
		
	}

}
