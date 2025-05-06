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
	
	public static List<Tutor>getTutoresCadastrados(){
		return usuarioservice.listarTutores(null);
	}

	private static AuthService authservice = new AuthService(new UsuarioRepository());
	private static UsuarioService usuarioservice = new UsuarioService(new UsuarioRepository()); 
	
	//METODOS CHAMAM O SERVICE
	public static void cadastroTutoresController(Aluno aluno) {
	//cadastroAluno
		usuarioservice.cadastroAluno(aluno.getNome(),aluno.getEmail(),aluno.getSenha(),aluno.getCpf(),aluno.getDataDeNascimento(),aluno.getAltura(),aluno.getPeso(),aluno.getNivel(),aluno.getMetas(),aluno.getMetaPersonalizada(),aluno.getPlano(), aluno.getGenero(),aluno.getImc());
	
}
	public static Tutor loginTutorController(String email,String senha) {
		
		//verificar
		return (Tutor) authservice.login(email, senha);
	}
	
	public static void listaralunoController(Aluno aluno) {
	//listarAlunos
	//usuarioservice.listarAlunos(aluno.getNome(),aluno.getEmail(),aluno.getSenha(),aluno.getCpf(),aluno.getDataDeNascimento(),aluno.getAltura(),aluno.getPeso(),aluno.getNivel(),aluno.getMetas(),aluno.getMetaPersonalizada(),aluno.getPlano());
	}

	public static void atualizaralunoController(Aluno aluno) {
	//atualizarDados
	//atualizarStatusOnline
	//atualizarPlanoAluno
		
	}
	public static void buscaralunoController(Aluno aluno) {
	//buscarPorCpf
    //buscarPorNome
	//buscarPorEmail
	}
	
	public static void removeralunoController(Aluno aluno) {
	//removerUsuario;
	}
	
	 public static boolean verificarAlunoExistente(Tutor tutor) {
	
	  return usuarioservice.buscarPorCpf(tutor.getCpf(), tutor) != null || 
			  usuarioservice.buscarPorEmail(tutor.getEmail())!= null;
	    }
	
	
	
	
	
	
	
	
	
	
	
	/*
	//Metodos staticos que são compartilhados por todas as instancias da classe

    // Lista de alunos
    private static List<Aluno> alunos = new ArrayList<>();

    // Método para obter a lista de alunos
    public static List<Aluno> getAlunos() {
        return alunos;
    }

    // Método para adicionar um aluno à lista
    public static void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    // Método para verificar se um aluno com o mesmo e-mail já existe
    public static boolean verificarAlunoExistente(String email) {
        for (Aluno aluno : alunos) {
            if (aluno.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }*/
    
    /*
     * METODOS
     * 
     * VERIFICAR SE O ALUNO ESTÁ NA ACADEMIA E CONTAR PRESENÇA
     * FAZER UMA MEDIA DESSA PRESENÇA
     * 
     * 
     * */
    

}
