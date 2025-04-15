package model;

import model.Aluno.Metas;

public class MainTeste {

	public static void main(String[] args) {
		Aluno a1=new Aluno("Victr","111.111.111-22","VIC.HDD", 1.75, 54, Metas.perderPeso,"Perder 8kg", Plano.Anual);
		System.out.println(a1.gerarCredenciais());
		
	}

}
