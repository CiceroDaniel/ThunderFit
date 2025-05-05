package model;

import java.time.LocalDate;

public class Pagamento {
	
	//------------------------ATRIBUTOS-----------------
	
	private int id;
	private Aluno aluno;
	private LocalDate dataPagamento;
	private boolean pago;
	
	public Pagamento(Aluno aluno,LocalDate datapagamento, boolean pago) {
		this.setAluno(aluno);
		this.dataPagamento=datapagamento;
		this.pago=pago;
	}
	
	//----------------------GETTERS AND SETTERS--------------
	
	 public void setId(int id) {
		 this.id = id;
		 }
	 public int getId() { 
	    return id;
	   	}
	
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		if(aluno == null) {
		throw new IllegalArgumentException("Aluno não pode ser nulo!");
		}
		this.aluno = aluno;
	}
	
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}
	
	public boolean getPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago= pago;
	}
	
	public double getValor() {
		return aluno.getPlano().getValor();
	}
	//-----------------------------------------------
	
	   @Override
	    public String toString() {
	        return "Pagamento em " + dataPagamento + "-Valor: "+getValor()+ "- Situação: " + (pago ? "Pago" : "Inadimplente");
	    }


}
