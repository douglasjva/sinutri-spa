package br.ufc.quixada.spa.model.enuns;

public enum SistemaUrinario {
		
	RUN("RUN"),
	RUA("RUA");

	private String tipo;
		
	private SistemaUrinario(String tipo){
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
}
