package controller;
import model.Aluno;
import model.Usuario;
import repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import services.*;

//METODOS PRINCIPAIS DO ALUNO

public class Alunocontroller {
	
	public static List<Aluno>getAlunosCadastrados(){
		return usuarioservice.listarAlunos(null);
	}

	private static AuthService authservice = new AuthService(new UsuarioRepository());
	private static UsuarioService usuarioservice = new UsuarioService(new UsuarioRepository()); 
	
	//METODOS CHAMAM O SERVICE
	public static void cadastroalunoController(Aluno aluno) {

	usuarioservice.cadastroAluno(aluno.getNome(),aluno.getEmail(),aluno.getSenha(),aluno.getCpf(),aluno.getDataDeNascimento(),aluno.getAltura(),aluno.getPeso(),aluno.getNivel(),aluno.getMetas(),aluno.getMetaPersonalizada(),aluno.getPlano(), aluno.getGenero(),aluno.getImc());
	
}
	public static Aluno loginAlunoController(String email,String senha) {
		
	return (Aluno) authservice.login(email, senha);
	
	}
	
	public static List<Aluno> listaralunoController(Aluno aluno) {
		
	List<Aluno> todosAluno = usuarioservice.listarAlunos(aluno);
	return todosAluno;
	
	
	}

	public static void atualizaralunoController(Aluno aluno) {
	//atualizarDados
	//atualizarStatusOnline
	//atualizarPlanoAluno
		
	}
	
	//RETORNA LIST DE ALUNOS
	//RECEBE PARAMETROS NOME,EMAIL,SENHA
	public static List<Aluno> buscaralunoController(String nome,String email,String cpf) {
	
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
	
	 public static boolean verificarAlunoExistente(Aluno aluno) {
	
	  return usuarioservice.buscarPorCpf(aluno.getCpf(), aluno) != null || 
			  usuarioservice.buscarPorEmail(aluno.getEmail(), aluno)!= null;
	    }
	 
	 //ESSE METODO É CHAMADO PELO TUTOR NA TABELA
	 //APÓS SELECIONAR O ALUNO ELE APLICA O PAGAMENTO CHAMANDO ESSE METODO
	 public static boolean confirmarAlunoPagament(Aluno aluno) {
		 return true;
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
