package repository;

import java.util.List;

public interface InterfaceRepository<T> {

	void cadastro(T Object);
	List<T> listarTodos();
	List<T> buscarPorNomeLista(String nome);	
	T buscarPorNome(String nome);
}
