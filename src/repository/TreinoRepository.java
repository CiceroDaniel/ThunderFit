package repository;

import model.Exercicio;
import model.Treino;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreinoRepository {
	
	private final List<Treino> treinos = new ArrayList<>();
	
	public void criarTreino(Treino treino) {
		Objects.requireNonNull(treino,"Erro: O treino não pode ser nulo!");
		treinos.add(treino);
		System.out.println("Treino cadstrado com sucesso!");
		}
	
	public List<Treino> listarTodos(){
		return new ArrayList<>(treinos);
	}

	public Treino buscarPorNome(String nome) {
		for(Treino treino : treinos) {
			if(treino.getNome().equalsIgnoreCase(nome)) {
				return treino;
				
			}
		}
		return null;
	}
		
	  public boolean removerPorNome(String nome) {
	        Treino treino = buscarPorNome(nome);
	        if (treino != null) {
	            treinos.remove(treino);
	            System.out.println("Treino removido com sucesso!");
	            return true;
	        }
	        System.out.println("Treino não encontrado.");
	        return false;
	    }

}
