package model;

import java.time.LocalDateTime;
import java.time.YearMonth;


public abstract class Relatorio {
	private YearMonth periodo;
	private LocalDateTime dataGeracao;
	
	public Relatorio (YearMonth periodo) {
	this.periodo = periodo;
	this.dataGeracao=LocalDateTime.now();
	}
	
	
	public YearMonth getPeriodo() {
        return periodo;
    }

    public LocalDateTime getDataGeracao() {
        return dataGeracao;
    }

    public abstract String getTitulo();
	
}
