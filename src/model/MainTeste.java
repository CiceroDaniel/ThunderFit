package model;

import model.Aluno.Metas;
import model.Aluno.Plano;
import repository.UsuarioRepository;

public class MainTeste {

	public static void main(String[] args) {
		Usuario a1=new Aluno("Victr","111.111.111-22","VIC.HDD", 1.75, 54, Metas.perderPeso,"Perder 8kg", Plano.planoAnual);
		UsuarioRepository u=new UsuarioRepository();
		u.cadastro(a1);
		u.remover(a1);
		System.out.println(u.listarTodos());
		
		
	}

}
