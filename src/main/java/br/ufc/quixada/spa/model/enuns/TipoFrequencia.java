package br.ufc.quixada.spa.model.enuns;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

public enum TipoFrequencia {
	RECORDATORIO("Recordatório"),
	PLANOALIMENTAR("Plano Alimentar");
	
	@OneToOne(mappedBy = "consultaNutricional", cascade = {CascadeType.ALL})
	private String tipofrequencia;
		
	private TipoFrequencia(String tipo){
		this.tipofrequencia = tipo;
	}

	public String getTipo() {
		return tipofrequencia;
	}
}
