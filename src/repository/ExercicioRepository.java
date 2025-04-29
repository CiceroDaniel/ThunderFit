package repository;

import model.Exercicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExercicioRepository {
	private final List<Exercicio> exercicios = new ArrayList<>();
	
	public void cadastroExercicio(Exercicio exercicio) {
		Objects.requireNonNull(exercicio,"Erro: O exercicio não pode ser nulo!");
	exercicios.add(exercicio);
	System.out.println("Exercicio cadastrado com sucesso!");
	}
	
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
	
	
	public Exercicio buscarPorNome(String nome) {
		for(Exercicio exercicio : exercicios) {
			if(exercicio.getNome().equalsIgnoreCase(nome)) {
				return exercicio;
				
			}
		}
		return null;
	}
	
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
