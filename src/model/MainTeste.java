package model;

import model.Aluno.Metas;
import model.Aluno.Plano;
import repository.UsuarioRepository;

public class MainTeste {

	public static void main(String[] args) {
		Usuario a1=new Aluno("victor","10945481300","vic.hdd@gmail.com","12345678",1, 1, Metas.perderPeso,"Perder 8kg", Plano.planoAnual);
		System.out.println(a1.gerarCredenciais());
		
	}

}
