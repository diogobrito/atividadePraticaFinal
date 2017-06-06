package br.com.restaurante.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PRATO", catalog = "dbrestaurante", uniqueConstraints = {
		@UniqueConstraint(columnNames = "codPrato") })
public class Prato implements Serializable {

	private static final long serialVersionUID = 978887095374937064L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codPrato", unique = true, nullable = false)
	private int codPrato;
	
	@Column(name = "nome", unique = false, nullable = false, length = 100)
	private String nome;
	
	@Column(name = "valor", unique = false, nullable = false, length = 10)
	private double valor;
	
	@Column(name = "categoria", unique = false, nullable = false, length = 100)
	private String categoria;
	
	@Column(name = "chefe", unique = false, nullable = false, length = 100)
	private String chefe;

	
	
	public int getCodPrato() {
		return codPrato;
	}

	public void setCodPrato(int codPrato) {
		this.codPrato = codPrato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getChefe() {
		return chefe;
	}

	public void setChefe(String chefe) {
		this.chefe = chefe;
	}
	
}
