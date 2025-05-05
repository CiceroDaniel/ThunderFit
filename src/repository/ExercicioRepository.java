package repository;

import model.Exercicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExercicioRepository implements InterfaceRepository<Exercicio>{
	private final List<Exercicio> exercicios = new ArrayList<>();
	
	//--------------------CRIAR--------------------
	
	@Override
	public void cadastro(Exercicio exercicio) {
		Objects.requireNonNull(exercicio,"Erro: O exercicio não pode ser nulo!");
	exercicios.add(exercicio);
	System.out.println("Exercicio cadastrado com sucesso!");
	}
	
	//--------------------LISTAR--------------------
	@Override
	public List<Exercicio> listarTodos(){
		return new ArrayList<>(exercicios);
	}
	
	public List<Exercicio> listarGrupoMuscular(String grupoMuscular){
		List<Exercicio> encontrados = new ArrayList<>();
		
		for(Exercicio exercicio: exercicios) {
			if(exercicio.getGrupoMuscular().equalsIgnoreCase(grupoMuscular)) {
				encontrados.add(exercicio);
			}
		}
		return encontrados;
	}
	
	//--------------------BUSCAR--------------------
	
	@Override
	public Exercicio buscarPorNome(String nome) {
		for(Exercicio exercicio : exercicios) {
			if(exercicio.getNome().equalsIgnoreCase(nome)) {
				return exercicio;
				
			}
		}
		return null;
	}
	
	@Override
	public List<Exercicio> buscarPorNomeLista(String nome){
		 throw new UnsupportedOperationException("Funcionalidade não implementada!");//Nao necessaria para esta classe
	}
	
	//--------------------REMOVER--------------------
	
	  public boolean removerPorNome(String nome) {
	        Exercicio exercicio = buscarPorNome(nome);
	        if (exercicio != null) {
	            exercicios.remove(exercicio);
	            System.out.println("Exercicio removido com sucesso!");
	            return true;
	        }
	        System.out.println("Exercicio não encontrado.");
	        return false;
	    }
	
	
}
