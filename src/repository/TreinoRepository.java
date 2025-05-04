package repository;

import model.Exercicio;
import model.Treino;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreinoRepository implements InterfaceRepository<Treino>{
	
	private final List<Treino> treinos = new ArrayList<>();
	

	  //--------------------CRIAR--------------------
	
	@Override
	public void cadastro(Treino treino) {
		Objects.requireNonNull(treino,"Erro: O treino não pode ser nulo!");
		treinos.add(treino);
		System.out.println("Treino cadastrado com sucesso!");
		}
	

	  //--------------------LISTAR--------------------
	
	@Override
	public List<Treino> listarTodos(){
		return new ArrayList<>(treinos);
	}
	

	  //--------------------ATUALIZAR--------------------

	public boolean atualizarTreino(Treino treinoUp){
		Objects.requireNonNull(treinoUp,"Treino não pode ser nulo!");
		 for (int i = 0; i < treinos.size(); i++) {
	            Treino treino = treinos.get(i);
	            if (treino.getNome().equalsIgnoreCase(treinoUp.getNome())) {
	                treinos.set(i, treinoUp); // substitui antigo pelo novo
	                return true;
	            }
	        }
		 return false;
	}
	

	  //--------------------BUSCAR--------------------
	
	@Override
	public Treino buscarPorNome(String nome) {
		for(Treino treino : treinos) {
			if(treino.getNome().equalsIgnoreCase(nome)) {
				return treino;
				
			}
		}
		return null;
	}
	
	@Override
	public List<Treino> buscarPorNomeLista(String nome){
		 throw new UnsupportedOperationException("Funcionalidade não implementada!");//Nao necessaria para esta classe
	}
	  
	  //--------------------REMOVER--------------------
	
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
	
	  public boolean removerExercicioNoTreino(String nomeTreino, Exercicio exercicio) {
		  Treino treino = buscarPorNome(nomeTreino);
		  if(treino != null) {
			 treino.removerExercicio(exercicio);
			 return true;
		  }
		  return false;
	  }
	  
	  //------------------------------------------------
	  public boolean adicionarExercicioNoTreino(String nomeTreino, Exercicio exercicio) {
		  Treino treino = buscarPorNome(nomeTreino);
		  if(treino != null) {
			  treino.adicionarExercicio(exercicio);
			  return true;
		  }
		  return false;
	  }
	  
}
