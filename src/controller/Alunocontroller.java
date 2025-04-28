package controller;

import model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class Alunocontroller {
	
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
    }
    

}
