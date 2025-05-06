package model;
import javax.swing.table.AbstractTableModel;

public class Modelotabela extends AbstractTableModel{

	private static final String[] colunas = {
			
		"NOME", "EMAIL", "SENHA", "CPF", "PLANO", "VALOR"
			
	};
	
	@Override
	public int getRowCount() {
		
		return alunos.size();
		
		return 0;
	}

	@Override
	public int getColumnCount() {
	
		colunas.lenght;
		
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Aluno aluno = aluno.get(rowIndex);
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
	    return null;
	    }
	   
		return null;
	}

}
