package br.com.restaurante.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Ingrediente", catalog = "dbrestaurante", uniqueConstraints = {
		@UniqueConstraint(columnNames = "codIngrediente") })
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codIngrediente", unique = true, nullable = false)
	private int codIngrediente;
	private String nome;
	
	private int codPrato;
	
	private float peso;
	
	private double preco;
	
	private LocalDate dtValidade;
	
	private float quantidade;
	
	private String tipo;
	
}
