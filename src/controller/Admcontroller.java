package controller;
import model.Administrador;
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
	
	public Admcontroller(AuthService authservice, UsuarioService usuarioservice) {
		this.authservice=authservice;
		this.usuarioservice=usuarioservice;
	}
	
	//-----------------------------ADM-----------------------------------------
	
	  public void cadastroAdmController(Administrador adm) {
			
		 usuarioservice.cadastroAdministrador(adm.getNome(),adm.getEmail(),adm.getSenha(),adm.getCpf(),adm.getDataDeNascimento());
	  }
	
	//--------------------------ALUNOS---------------------------------------------
	
	   public List<Aluno> listaralunoController(Aluno filtro) {
	 	
		return usuarioservice.listarAlunos(filtro);
		
		
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
			/*
			public List<Aluno>filtrarAlunos(String nome,String email,String cpf){
				List<Aluno>alunosFiltrados = new ArrayList<>();
				if(Aluno aluno : listaralunoController(null)) {
					if(aluno.getNome().contains(nome) && aluno.getEmail().contains(email)&& aluno.getCpf().contains(cpf)) {
					alunosFiltrados.add(aluno);	
					}
				}
				return alunosFiltrados;
			}
			
			public void excluirAluno(Aluno aluno) {
				usuarioservice.excluirAluno(aluno);
			}*/
			
//------------------------------TUTORES------------------------------------------------
			
	public void Cadastrotutor(Tutor tutor) {
		
		usuarioservice.cadastroTutor(tutor.getNome(),tutor.getEmail(),tutor.getSenha(),tutor.getCpf(),tutor.getDataDeNascimento(),tutor.getSalario());
		
	}
	
	
	public List<Tutor> ListarTutores(Tutor filtro) {
		
		return usuarioservice.listarTutores(filtro);
		
	}

	
	
//----------------------------------------------------------------------------------------
	
	
	public Administrador loginAdmController(String email, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

}

