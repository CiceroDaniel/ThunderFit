package services;

import model.*;
import repository.UsuarioRepository;


public class AuthService {
	private final UsuarioRepository usuarioRepository;
	private Usuario usuarioLogado;
	
	public AuthService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository=usuarioRepository;
	}
	
	
	public Usuario login(String email, String senha) {
		Usuario usuario = usuarioRepository.buscarPorEmail(email);
		
		if(usuario == null || !usuario.getSenha().equals(senha)) {
			throw new IllegalArgumentException("Email ou senha incorretos!");
		}
		
		if(!usuario.getOnline()) {
			usuario.setOnline(true);			
		}
		
		this.usuarioLogado = usuario;
		System.out.println("logado com sucesso");
		return usuario;
		
	}
	
	public void logout() {
		if(usuarioLogado != null) {
			usuarioLogado.setOnline(false);
			usuarioLogado = null;
		}
		
	}
	
	public boolean getUsuarioLogado(){
		return usuarioLogado != null;
	}
	
}
