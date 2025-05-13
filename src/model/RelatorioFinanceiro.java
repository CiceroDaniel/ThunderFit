package model;

import java.time.YearMonth;

public class RelatorioFinanceiro {
	//-----------------ATRIBUTOS----------------
    private YearMonth mesReferencia;
    private double receitaTotal;  // SERA A SOMA DOS PAGAMENTOS
    private double despesasTotal; // DEPESAS = SALARIOS DOS TUTORES
    private double lucro;         // RECEITA - DESPESAS

    // -----------------CONSTRUTOR---------------------
    
    public RelatorioFinanceiro(YearMonth mesReferencia, double receitaTotal, double despesasTotal, double lucro) {
        this.mesReferencia = mesReferencia;
        this.receitaTotal = receitaTotal;
        this.despesasTotal = despesasTotal;
        this.lucro = lucro;
    }

    //---------------METODOS-------------------
    
    @Override
    public String toString() {
    	return String.format(
    			"Relatório Financeiro (%s):\nReceita: R$%.2f\nDespesas (Salários): R$%.2f\nLucro: R$%.2f",
    			mesReferencia, receitaTotal, despesasTotal, lucro);
    }
    
    //-------------------GETTERS AND SETTERS-----------------
    
    public YearMonth getMesReferencia() {
        return mesReferencia;
    }

    public double getReceitaTotal() {
        return receitaTotal;
    }

    public double getDespesasTotal() {
        return despesasTotal;
    }

    public double getLucro() {
        return lucro;
    }

}