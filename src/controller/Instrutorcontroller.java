package controller;


import model.Tutor;
import java.util.ArrayList;
import java.util.List;

public class Instrutorcontroller {
	
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
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * */
    

}
