package services;

import model.Catraca;
import model.Pagamento;
import repository.PagamentoRepository;

import java.util.List;

import model.Aluno;

public class CatracaService{
	private final Catraca catraca;
	private final PagamentoRepository pagamentoRepository;
	private final PresencaService presencaService;
	
	public CatracaService(Catraca catraca, PagamentoRepository pagamentoRepository, PresencaService presencaService){
		this.catraca=catraca;
		this.pagamentoRepository= pagamentoRepository;
		this.presencaService=presencaService;
	}
	
	public boolean liberarAcesso(Aluno aluno) {
		if(aluno == null) return false;
		List<Pagamento> pagamentosDoAluno = pagamentoRepository.listarPorAluno(aluno.getCpf());
		
		if(pagamentosDoAluno.isEmpty())	return false;
		
		Pagamento ultimoPagamento = pagamentosDoAluno.stream()										//compara um par de datas para 
				.max((p1,p2)-> p1.getDataPagamento().compareTo(p2.getDataPagamento())).orElse(null);//saber qual é a mais atual
																		//e atual da antiga dupla se compara com outra ate haver apenas uma
		if(ultimoPagamento == null || ultimoPagamento.estaVencido()) return false;
		
		
	  catraca.liberar(aluno);
	  return true;
		
	}
	
	public boolean registrarPassagem(Aluno aluno) {
		if(!liberarAcesso(aluno)){
			return false;
		}
		presencaService.registrarPresenca(aluno);
		catraca.bloquear();
		return true;
		
	}
	
}