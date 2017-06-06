package br.com.restaurante.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Fornecedor", catalog = "dbrestaurante", uniqueConstraints = {
		@UniqueConstraint(columnNames = "codFornecedor") })
public class Fornecedor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codFornecedor", unique = true, nullable = false)
	private int codFornecedor;

	@Column(name = "nome", unique = true, nullable = false)
	private String nome;

	@Column(name = "porte", unique = true, nullable = false)
	private String porte;

	@Column(name = "CNPJ", unique = true, nullable = false)
	private int CNPJ;

	@Column(name = "flAtivo", unique = true, nullable = false)
	private boolean flAtivo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codIngrediente")
	private Ingrediente ingrediente;

	public int getCodFornecedor() {
		return codFornecedor;
	}

	public void setCodFornecedor(int codFornecedor) {
		this.codFornecedor = codFornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public int getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(int cNPJ) {
		CNPJ = cNPJ;
	}

	public boolean isFlAtivo() {
		return flAtivo;
	}

	public void setFlAtivo(boolean flAtivo) {
		this.flAtivo = flAtivo;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

}
