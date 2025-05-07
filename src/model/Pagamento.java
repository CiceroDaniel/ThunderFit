package model;

import java.time.LocalDate;

public class Pagamento {
	
	//------------------------ATRIBUTOS-----------------
	
	private int id;
	private Aluno aluno;
	private double valorPago;
	private LocalDate dataPagamento;
	private LocalDate dataVencimento;
	private boolean pago;
	
	public Pagamento(Aluno aluno,double valorPago,LocalDate datapagamento, boolean pago) {
		this.setAluno(aluno);
		this.setValorPago(valorPago);
		this.setDataPagamento(datapagamento);
		this.pago=pago;
	}
	
	
	//-------------------METODOS-------------------------
	
	private LocalDate calcularDataVencimento() {
		
		return switch (aluno.getPlano()) {
		case planoMensal -> dataPagamento.plusMonths(1);
		case planoTrimestral -> dataPagamento.plusMonths(3);
		case planoAnual -> dataPagamento.plusYears(1);
		default -> throw new IllegalArgumentException("Plano invalido!");
		};
	}
	
	public LocalDate calcularProximoVencimento() {
	    return switch (aluno.getPlano()) {
	        case planoMensal -> LocalDate.now().plusMonths(1);
	        case planoTrimestral -> LocalDate.now().plusMonths(3);
	        case planoAnual -> LocalDate.now().plusYears(1);
	        default -> throw new IllegalArgumentException("Plano invalido!");
	    };
	}
	
	public boolean estaVencido() {
        return !pago && LocalDate.now().isAfter(dataVencimento);
    }
	
	@Override
	public String toString() {
		return "Pagamento em " + dataPagamento + "-Valor: "+getValorDoPlano()+ "-Valor Pago: "+getValorPago()+ "- Situação: " + (pago ? "Pago" : "Inadimplente");
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
	public void setDataPagamento(LocalDate dataPagamento) {
		if(dataPagamento==null) throw new IllegalArgumentException("Data de pagamento invalida!"); 
		this.dataPagamento=dataPagamento;
	    this.dataVencimento = calcularDataVencimento();
	    if(dataVencimento.isBefore(dataPagamento)) { 
	        throw new IllegalStateException("Data de vencimento deve ser apos a data de pagamento!");
	    }
	}
	
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	
	public boolean getPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago= pago;
	}
	
	public double getValorDoPlano() {
		return aluno.getPlano().getValor();
	}


	public double getValorPago() {
		return valorPago;
	}


	public void setValorPago(double valorPago) {
		if(valorPago <= 0) {
			throw new IllegalArgumentException("Valor invalido!");
		}
		this.valorPago = valorPago;
		}
	


}
