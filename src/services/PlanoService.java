package services;

import java.util.List;

import model.Plano;
import model.Usuario;

public class PlanoService {
	
	public List<Plano> ListarPlanos(){
		return List.of(Plano.values());
	}
	
	public void atualizarValorPlano(Plano plano, double novoValor, Usuario administrador) {
		if(!administrador.temAcessoAdmin()) {
			throw new SecurityException("Apenas administradores podem alterar valores de planos!");
		}
		
		plano.setValor(novoValor, administrador);
	}

}
