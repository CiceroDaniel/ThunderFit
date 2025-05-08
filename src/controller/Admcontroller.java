package controller;
import model.Aluno;
import model.Tutor;
import model.Usuario;
import repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import services.*;

//METODOS PRINCIPAIS DO ALUNO

public class Admcontroller {
	
	private final AuthService authservice;
	private final UsuarioService usuarioservice;
	
	public Admcontroller(AuthService authservice,UsuarioService usuarioservice) {
		this.authservice=authservice;
		this.usuarioservice=usuarioservice;
	}
	public List<Aluno>getAlunosCadastrados(){
		return usuarioservice.listarAlunos(null);
	}
	
	public List<Tutor>getTutoresCadastrados(){
		return usuarioservice.listarTutores(null);
	}
	
	
	//--------------------------ALUNOS---------------------------------------------
	
	   public List<Aluno> listaralunoController(Aluno aluno) {
	 	
		List<Aluno> todosAluno = usuarioservice.listarAlunos(aluno);
		return todosAluno;
		
		
		}
	  //METODOS CHAMAM O SERVICE
	  public void cadastroAlunoController(Aluno aluno) {
	
	  usuarioservice.cadastroAluno(aluno.getNome(),aluno.getEmail(),aluno.getSenha(),aluno.getCpf(),aluno.getDataDeNascimento(),aluno.getAltura(),aluno.getPeso(),aluno.getNivel(),aluno.getMetas(),aluno.getMetaPersonalizada(),aluno.getPlano(), aluno.getGenero());
	
	
       }

		public void atualizaralunoController(Aluno aluno) {
			//atualizarDados
			//atualizarStatusOnline
			//atualizarPlanoAluno
				
		}
			
			//RETORNA LIST DE ALUNOS
			//RECEBE PARAMETROS NOME,EMAIL,SENHA
			public List<Aluno> buscaralunoController(String nome,String email,String cpf) {
			
		    //CHAMA TODOS OS ALUNOS CADASTRADOS NO SISTEMA
			List<Aluno> todosAlunos = usuarioservice.listarAlunos(null);
			
			//CRIEI UMA LISTA FAZIA CHAMADA RESULTADO,AI AQUI DA PRA VERIFICAR OS ALUNOS
			//E VER SE OS PARAMETROS CONDIZEM COM OS DOS CAMPOS DE TEXTO
			List<Aluno> resultado = new ArrayList<>();
			
			//VERIFICA TODOS OS ALUNOS DA LISTA
			for(Aluno a: todosAlunos) {
				
				boolean igual = true;
				
				
			   if(!nome.isEmpty() && !a.getNome().contains(nome)) {
		       igual = false;
			   }
			   if(!email.isEmpty() && !a.getEmail().contains(email)) {
			   igual = false;
			   }
			   if(!cpf.isEmpty() && !a.getCpf().contains(cpf)) {
			   igual = false;
			   }
			   if(igual) {
				   resultado.add(a);
			   }
			}
			return resultado;
				
			}
			
//------------------------------TUTORES------------------------------------------------
			
	public void Cadastrotutor(Tutor tutor) {
		
		usuarioservice.cadastroTutor(tutor.getNome(),tutor.getEmail(),tutor.getSenha(),tutor.getCpf(), null, 0);
		
	}
	
	
	public List<Tutor> ListarTutores(Tutor tutor) {
		
		List<Tutor> todosTutores = usuarioservice.listarTutores(tutor);
		return todosTutores;
		
	}
	
	
//----------------------------------------------------------------------------------------
}