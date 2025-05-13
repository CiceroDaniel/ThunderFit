package model;

import java.time.LocalDate;

public class RegistroPeso {
    private LocalDate data;
    private double peso;

    public RegistroPeso(LocalDate data, double peso) {
        this.data = data;
        this.peso = peso;
    }

    // ----------GETTERS AND SETTERS-----------
    public LocalDate getData(){ 
    	return data;
    	}
    
    public double getPeso(){ 
    	return peso;
    	}
}