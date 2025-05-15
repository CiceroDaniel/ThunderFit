package services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import model.Plano;

public class PlanoService {
	
	public List<Plano> ListarPlanos(){
		return List.of(Plano.values());
	}
	
	public void atualizarValorPlano(Plano plano, double novoValor) {
		
		plano.setValor(novoValor);
	}
	
	public Plano buscarPlanoPorNome(String nome) {
        Optional<Plano> planoEncontrado = Arrays.stream(Plano.values())
            .filter(p -> p.getNome().equalsIgnoreCase(nome))
            .findFirst();
        
        return planoEncontrado.orElseThrow(() -> 
            new IllegalArgumentException("Plano inválido: " + nome));
    }

}
