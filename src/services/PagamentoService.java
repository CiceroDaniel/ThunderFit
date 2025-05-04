package services;

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
	
	
}
