package services;

import model.*;
import repository.UsuarioRepository;


public class AuthService {
	private final UsuarioRepository usuarioRepository;
	private UsuarioService usuarioService;
	
	//modifiquei
	
	public AuthService(UsuarioRepository usuarioRepository,UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
		this.usuarioRepository = usuarioRepository;
	}
	
	
	public Usuario login(String email, String senha) {
		Usuario usuario = usuarioRepository.buscarPorEmail(email);
		
		if(usuario == null || !usuario.getSenha().equals(senha)) {
			throw new IllegalArgumentException("Email ou senha incorretos!");
		}
		
		if(!usuario.getOnline()) {
			usuario.setOnline(true);			
		}
		
		//System.out.println("logado com sucesso");
		return usuario;
		
	}
	
	public void logout(Usuario usuario) {
		if(usuario != null) {
			usuario.setOnline(false);
		}
		
	}

	
}
