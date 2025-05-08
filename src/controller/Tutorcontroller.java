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
	

	private  AuthService authservice = new AuthService(new UsuarioRepository());
	private  UsuarioService usuarioservice = new UsuarioService(new UsuarioRepository()); 
	
	public List<Tutor>getTutoresCadastrados(){
		return usuarioservice.listarTutores(null);
	}
	//METODOS CHAMAM O SERVICE
	public void cadastroTutoresController(Tutor tutor) {
	//cadastroAluno
    usuarioservice.cadastroTutor(tutor.getNome(),tutor.getEmail(),tutor.getSenha(),tutor.getCpf(), null, 0);
	
}
	public Tutor loginTutorController(String email,String senha) {
		
		//verificar
		return (Tutor) authservice.login(email, senha);
	}
	
	
		
		 public boolean verificarAlunoExistente(Aluno aluno) {
		
		  return usuarioservice.buscarPorCpf(aluno.getCpf(), aluno) != null || 
				  usuarioservice.buscarPorEmail(aluno.getEmail(), aluno)!= null;
		    }
		 
		 //ESSE METODO É CHAMADO PELO TUTOR NA TABELA
		 //APÓS SELECIONAR O ALUNO ELE APLICA O PAGAMENTO CHAMANDO ESSE METODO
		 public boolean confirmarAlunoPagament(Aluno aluno) {
			 return true;
		 }
}
