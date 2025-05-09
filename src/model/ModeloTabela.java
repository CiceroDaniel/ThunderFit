package model;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import controller.Alunocontroller;

public class ModeloTabela extends AbstractTableModel{

	private static final String[] colunas = {
			
		"NOME", "EMAIL", "SENHA", "CPF", "PLANO", "VALOR"
			
	};
	
    private List<Aluno>alunos;//LISTA DE ALUNOS QUESERÃO EXIBIDOS
	
    //CONSTRUTOR QUE RECEBE A LISTA DE ALUNOS
    public ModeloTabela(List<Aluno>alunos) {
    	this.alunos=alunos;
    }
	
	@Override
	public int getRowCount() {
		
		return alunos.size();
	}

	@Override
	public int getColumnCount() {
	
		return colunas.length;
	
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Aluno aluno = alunos.get(rowIndex);
		if(columnIndex == 0){
		return aluno.getNome();
	    }else 
	    if(columnIndex == 1){
		return aluno.getEmail();
	    }else 
	    if(columnIndex == 2){
		return aluno.getSenha();
	    }else 
	    if(columnIndex == 3){
		return aluno.getCpf();
	    }else 
	    if(columnIndex == 4){
		return aluno.getPlano();
	    }else 
	    if(columnIndex == 5){
		return aluno.getPlano().getValor();
	    }else {
	    if(columnIndex == 5){
	    return aluno.getPlano().getValor();
	    }else {
	    return null;
	    }
	    }
	   
	}
	
	@Override 
	public String getColumnName(int column) {
		return colunas[column];
	}
	
	public Aluno getAlunotAt(int linha) {
		return alunos.get(linha);
	}

}
