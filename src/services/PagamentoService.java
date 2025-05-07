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
	
	public Pagamento registrarPagamento(Aluno aluno,double valorPago, LocalDate dataPagamento, Usuario solicitante) {
		if(!(solicitante instanceof Administrador)) {
			throw new SecurityException("Acesso não autorizado!");
		}
		if (dataPagamento.isAfter(LocalDate.now())) {
	        throw new IllegalArgumentException("Data de pagamento não pode ser do futuro!");
	    }
		
		Pagamento novoPagamento = new Pagamento(aluno,valorPago ,dataPagamento,true);
		pagamentoRepository.cadastro(novoPagamento);
		return novoPagamento;
		
	}
	
	//--------------------LISTAR---------------------
	
	 public List<Pagamento> listarPagamentosPorAluno(String cpfAluno, Usuario solicitante) {
			Objects.requireNonNull(solicitante);
			if (cpfAluno == null || cpfAluno.isBlank()) {
			    throw new IllegalArgumentException("CPF não pode ser vazio!");
			}
	        if (!(solicitante instanceof Administrador) && !(solicitante.getCpf().equals(cpfAluno))) {
	            throw new SecurityException("Acesso não autorizado!");
	        }
	        
	        return pagamentoRepository.listarPorAluno(cpfAluno);
	 }
	 
	 public List<Pagamento> listarPagamentoPendentes(Usuario solicitante){
	        if (!solicitante.temAcessoAdmin()) {
	            throw new SecurityException("Apenas administradores podem ver pagamentos pendentes!");
	        }
	        
	        return pagamentoRepository.listarTodos().stream().filter(p -> !p.getPago()).toList();
	    }
	 
	 public List<Pagamento> listarPagamentoVencidos(Usuario solicitante){
	        if (!solicitante.temAcessoAdmin()) {
	            throw new SecurityException("Apenas administradores podem ver pagamentos pendentes!");
	        }
	        
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

	 
	//--------------------ATUALIZAR---------------------
	
	public void atualizarDataDePagamento(int idPagamento, LocalDate data, Usuario solicitante) {
		 if (!(solicitante instanceof Administrador)) {
		        throw new SecurityException("Apenas administradores podem alterar datas!");
		    }
		    
		    Pagamento pagamento = pagamentoRepository.buscarPorId(idPagamento)
		        .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado!"));
		    
		    pagamento.setDataPagamento(data);
		    pagamentoRepository.atualizar(pagamento);
		
		
	}
	
	
	public void marcarComoPago(int idPagamento, Usuario solicitante) {
		if(!(solicitante instanceof Administrador)) {
			throw new SecurityException("Acesso não autorizado!");
		}
		
		Pagamento pagamento = pagamentoRepository.buscarPorId(idPagamento).orElseThrow(() -> new IllegalArgumentException("Pagamento com ID não encontrado!"));

	    if (pagamento.getPago()) {
	        throw new IllegalStateException("O pagamento já está marcado como pago!");
	    }
	    
	    

	    
	    pagamento.setPago(true);
	    pagamento.setDataPagamento(LocalDate.now());
	    pagamentoRepository.atualizar(pagamento);
	    
	}
		
	
	
	//--------------------REMOVER---------------------
	
	public boolean removerPagamento(int idPagamento, Usuario solicitante) {
	    if (!(solicitante instanceof Administrador)) {
	        throw new SecurityException("Apenas administradores podem remover pagamentos!");
	    }
	    return pagamentoRepository.remover(idPagamento);
	}
	
	
	//-----------------------------------------------
	
	
}
