package repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;
import model.Pagamento;

public class PagamentoRepository implements InterfaceRepository<Pagamento>{
	private List<Pagamento> pagamentos= new ArrayList<>();
	private int proxId=1;

	//----------------CRIAR----------------
	
	@Override
	public void cadastro(Pagamento pagamento) {
		Objects.requireNonNull(pagamento,"Pagamento não pode ser nulo!");
		pagamento.setId(proxId++);
		pagamentos.add(pagamento);
	}

	//----------------LISTAR---------------
	
	@Override
	public List<Pagamento> listarTodos() {
		return new ArrayList<>(pagamentos);
	}
	
	public List<Pagamento> listarPorAluno(String cpfAluno){
		return pagamentos.stream().filter(p -> p.getAluno().getCpf().equals(cpfAluno)).collect(Collectors.toList());
	}

	//----------------BUSCAR----------------
	
	public Optional<Pagamento> buscarPorId(int id){
		return pagamentos.stream().filter(p -> p.getId() == id).findFirst();
	}
	
	@Override
	public List<Pagamento> buscarPorNomeLista(String nome) {
		 throw new UnsupportedOperationException("Funcionalidade não implementada!");//Nao necessaria para esta classe
	}

	@Override
	public Pagamento buscarPorNome(String nome) {
		 throw new UnsupportedOperationException("Funcionalidade não implementada!");//Nao necessaria para esta classe
	}
	
	//-----------------ATUALIZAR--------------
	
	public void atualizar(Pagamento pagamentoAtualizado) {
		pagamentos.replaceAll(p -> p.getId() == pagamentoAtualizado.getId() ? pagamentoAtualizado : p);
	}
	
	
	//----------------REMOVER----------------
	
	public boolean remover(int id) {
        return pagamentos.removeIf(p -> p.getId() == id);
    }
	

}
