package services;

import java.time.LocalDate;
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
		
		Pagamento novoPagamento = new Pagamento(aluno, dataPagamento,true);
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
		 
	    
	
	//--------------------ATUALIZAR---------------------
	
	
	
	
	public void marcarComoPago(int idPagamento, Usuario solicitante) {
		if(!(solicitante instanceof Administrador)) {
			throw new SecurityException("Acesso não autorizado!");
		}
		
		Optional<Pagamento> pagamentoOpt = pagamentoRepository.buscarPorId(idPagamento);
		if(pagamentoOpt.isEmpty()) {
			throw new IllegalArgumentException("Pagamento não encontrado!");
		}
		
		Pagamento pagamento = pagamentoOpt.get();
		pagamento.setPago(true);
		pagamentoRepository.atualizar(pagamento);
		
	}
	
	
	//--------------------REMOVER---------------------
	
	
	//-----------------------------------------------
	
	
}
