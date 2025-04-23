package model;

import model.Aluno.Metas;
import model.Aluno.Plano;
import repository.UsuarioRepository;

public class MainTeste {

	public static void main(String[] args) {
		Usuario a1=new Aluno("Victr","a123456789101112","VIC.HDD", 1.75, 54, Metas.perderPeso,"Perder 8kg", Plano.planoAnual);
		
		System.out.println(a1.gerarCredenciais());
		
		
	}

}
