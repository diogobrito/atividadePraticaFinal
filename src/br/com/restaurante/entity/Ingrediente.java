package br.com.restaurante.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Ingrediente", catalog = "dbrestaurante", uniqueConstraints = {
		@UniqueConstraint(columnNames = "codIngrediente") })
public class Ingrediente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codIngrediente", unique = true, nullable = false)
	private int codIngrediente;

	@Column(name = "nome", unique = true, nullable = true)
	private String nome;

	@Column(name = "peso", unique = true, nullable = true)
	private float peso;

	@Column(name = "preco", unique = true, nullable = true)
	private double preco;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codPrato")
	private Prato prato;


	public int getCodIngrediente() {
		return codIngrediente;
	}


	public void setCodIngrediente(int codIngrediente) {
		this.codIngrediente = codIngrediente;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public float getPeso() {
		return peso;
	}


	public void setPeso(float peso) {
		this.peso = peso;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public Prato getPrato() {
		return prato;
	}


	public void setPrato(Prato prato) {
		this.prato = prato;
	}

	
}
