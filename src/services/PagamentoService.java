package services;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;
import java.util.List;
import java.util.Objects;

import model.*;
import repository.PagamentoRepository;


public class PagamentoService {
	private final PagamentoRepository pagamentoRepository;
	private final UsuarioService usuarioService;
	
	public PagamentoService(PagamentoRepository pagamentoRepository, UsuarioService usuarioService) {
		this.pagamentoRepository = pagamentoRepository;
		this.usuarioService = usuarioService;
		
	}
	
	//--------------------CRIAÇAO---------------------
	
	public Pagamento registrarPagamento(Aluno aluno,double valorPago, LocalDate dataPagamento) {
		
		if (dataPagamento.isAfter(LocalDate.now())) {
	        throw new IllegalArgumentException("Data de pagamento não pode ser do futuro!");
	    }
		
		Pagamento novoPagamento = new Pagamento(aluno,valorPago ,dataPagamento,true);
		pagamentoRepository.cadastro(novoPagamento);
		return novoPagamento;
		
	}
	
	//--------------------LISTAR---------------------
	
	 public List<Pagamento> listarPagamentosPorAluno(String cpfAluno) {
			if (cpfAluno == null || cpfAluno.isBlank()) {
			    throw new IllegalArgumentException("CPF não pode ser vazio!");
			}
	        
	        return pagamentoRepository.listarPorAluno(cpfAluno);
	 }
	 
	 public List<Pagamento> listarPagamentoPendentes(){
	     
	        
	        return pagamentoRepository.listarTodos().stream().filter(p -> !p.getPago()).toList();
	    }
	 
	 public List<Pagamento> listarPagamentoVencidos(){
	    
	        
	        return pagamentoRepository.listarTodos().stream().filter(p -> !p.getPago()&& p.getDataVencimento().isBefore(LocalDate.now())).toList();
	    }
	 
	 public double calcularTotalRecebidoNoMes(YearMonth mes, Usuario solicitante) { //YearMonth recebe AAAA, MM
		 
		 if(!(solicitante instanceof Administrador)) {
			 throw new SecurityException("Acesso negado");
		 }
		 if (mes == null) {
			    throw new IllegalArgumentException("Mês não pode ser nulo!");
			}
		 
		 
		 LocalDate inicio = mes.atDay(1);
		 LocalDate fim = mes.atEndOfMonth();
		 
		 return pagamentoRepository.listarTodos().stream().filter(p-> p.getPago())
				 .filter(p-> !p.getDataPagamento().isBefore(inicio)).
				 filter(p-> !p.getDataPagamento().isAfter(fim)).mapToDouble(p-> p.getValorPago()).sum();
	}

	//-------------------BUSCAR-----------------------
	 
	 public Pagamento buscarPorId(int idPagamento) {
		
		 Pagamento pagamento = pagamentoRepository.buscarPorId(idPagamento).orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado"));
		 
	
		 return pagamento;
		 
	 }
	 
	//--------------------ATUALIZAR---------------------
	
	public void atualizarDataDePagamento(int idPagamento, LocalDate data) {
		
		    
		    Pagamento pagamento = pagamentoRepository.buscarPorId(idPagamento)
		        .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado!"));
		    
		    pagamento.setDataPagamento(data);
		    pagamentoRepository.atualizar(pagamento);
		
		
	}
	
	
	public void marcarComoPago(int idPagamento) {
		
		
		Pagamento pagamento = pagamentoRepository.buscarPorId(idPagamento).orElseThrow(() -> new IllegalArgumentException("Pagamento com ID não encontrado!"));

	    if (pagamento.getPago()) {
	        throw new IllegalStateException("O pagamento já está marcado como pago!");
	    }
	    
	    

	    
	    pagamento.setPago(true);
	    pagamento.setDataPagamento(LocalDate.now());
	    pagamentoRepository.atualizar(pagamento);
	    
	}
		
	
	
	//--------------------REMOVER---------------------
	
	public boolean removerPagamento(int idPagamento) {
	    
	    return pagamentoRepository.remover(idPagamento);
	}
	
	
	
	
}
