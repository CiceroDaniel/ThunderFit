package controller;
import model.Aluno;
import model.Tutor;
import model.Usuario;
import repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import services.*;

//METODOS PRINCIPAIS DO ALUNO

public class Tutorcontroller {
	
	private final AuthService authservice;
	private final UsuarioService usuarioservice;
	
	public Tutorcontroller(AuthService authservice,UsuarioService usuarioservice) {
		this.authservice=authservice;
		this.usuarioservice=usuarioservice;
	}
	public Tutor loginTutorController(String email,String senha) {
		
	Usuario usuario = authservice.login(email, senha);
		
	if(usuario instanceof Tutor) {
		return (Tutor) usuario;
	}else {
		throw new IllegalArgumentException("O usuario não é um tutor");
	}
	
	}

}