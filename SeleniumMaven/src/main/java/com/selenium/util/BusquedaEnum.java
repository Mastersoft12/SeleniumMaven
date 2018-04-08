package com.selenium.util;

public enum BusquedaEnum {
	
	NAME("NAME"),
	XPAHT("XPAHT"),
	ID("ID"),
	CLASS("CLASS");
	
	private String valor;	
	

	private BusquedaEnum(String valor) {
		this.valor = valor;
	}


	public String getValor() {
		return valor;
	}

	
	

}
