package br.com.gerenciador.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Company {
	private Long id;
	private String name;
	private String dataOpen;
//	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDataOpen() {
		return dataOpen;
	}

	public void setDataOpen(String dataOpen) {
		this.dataOpen = dataOpen;
	}
}
