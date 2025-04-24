package model;

import model.Aluno.Metas;
import model.Aluno.Plano;
import repository.UsuarioRepository;

public class MainTeste {

	public static void main(String[] args) {
		Usuario a1=new Aluno("victor","123456789q10fs","vic.hdd@gmail.com","12345678",1.75, 54, Metas.perderPeso,"Perder 8kg", Plano.planoAnual);
		a1.gerarCredenciais();
		
	}

}
