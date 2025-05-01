package controller;


import model.Aluno;
import model.Tutor;
import java.util.ArrayList;
import java.util.List;

public class Instrutorcontroller {
	
	  private static List<Aluno> alunos = new ArrayList<>();
	
	//Metodos staticos que são compartilhados por todas as instancias da classe

    // Lista de alunos
    private static List<Tutor> tutores = new ArrayList<>(3);

    // Método para obter a lista de alunos
    public static List<Tutor> getTutores() {
        return tutores;
    }

    // Método para adicionar um aluno à lista
    public static void adicionarTutor(Tutor tutor) {
        tutores.add(tutor);
    }

    // Método para verificar se um aluno com o mesmo e-mail já existe
    public static boolean verificarTutorExistente(String email) {
        for (Tutor tutor : tutores) {
            if (tutor.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    
    /*
    public void Pesquisaraluno(Aluno aluno) {
    	
    }
    
    public void Removeraluno(Aluno aluno) {
    	alunos.remove(aluno);
    }*/
    
    /*
     * 
     * VERIFIQUE SE FICA MELHOR USAR ESSES METODOS AQUI NO CONTROLLER
     * JÁ QUE O ALUNO N PODE SE EXCLUIR
     * 
     * 
     * 
     * 
     * */
    

}
