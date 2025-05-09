package controller;
import model.Aluno;
import model.Usuario;
import repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import services.*;

//METODOS PRINCIPAIS DO ALUNO

public class Alunocontroller {
	
	private final AuthService authservice;
	private final UsuarioService usuarioservice;
	
	public Alunocontroller(AuthService authservice,UsuarioService usuarioservice) {
		this.authservice=authservice;
		this.usuarioservice=usuarioservice;
	}
	public Aluno loginAlunoController(String email,String senha) {
		
	return (Aluno) authservice.login(email, senha);
	
	}

}