package model;

import java.time.YearMonth;
import java.util.List;

public class RelatorioPresenca extends Relatorio {

	private List<Aluno> alunos;
	
	
	public RelatorioPresenca(YearMonth periodo, List<Aluno> alunos) {
		super(periodo);
		this.alunos=List.copyOf(alunos); //imutavel
	}

	@Override
	public String getTitulo() {
		return String.format("Relatorio de Frequência - %02d/%d", 
                getPeriodo().getMonthValue(), 
                getPeriodo().getYear());
	}

	
	public List<Aluno> getAlunos() {
        return alunos;
    }

}
