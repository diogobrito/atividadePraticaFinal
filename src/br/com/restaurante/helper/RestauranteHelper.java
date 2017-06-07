package br.com.restaurante.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.restaurante.entity.Fornecedor;
import br.com.restaurante.entity.Ingrediente;
import br.com.restaurante.entity.Prato;


public class RestauranteHelper {
	private EntityManager em;

	public RestauranteHelper(EntityManager em){
		this.em = em;
	}

	public void salvarFornecedores(Fornecedor fornecedores) throws Exception { 
		try {
			em.getTransaction().begin(); 
			em.persist(fornecedores); 
			em.getTransaction().commit();
		} 
		catch (Exception e) {
			throw e;
		} finally { 
			em.close();
		} 
	}

	public List<Fornecedor> listarFornecedores(){
		TypedQuery<Fornecedor> tQuery = em.createQuery("select f from Fornecedor f", Fornecedor.class); 
		return tQuery.getResultList();
	}
	
	public void salvarPratos(Prato pratos) throws Exception { 
		try {
			em.getTransaction().begin(); 
			em.persist(pratos); 
			em.getTransaction().commit();
		} 
		catch (Exception e) {
			throw e;
		} finally { 
			em.close();
		} 
	}

	public List<Prato> listarPratos(){

		TypedQuery<Prato> tQuery = em.createQuery("select f from Prato f", Prato.class); 
		return tQuery.getResultList();
	}

	
	public void salvarIngredientes(Ingrediente ingredientes) throws Exception { 
		try {
			em.getTransaction().begin(); 
			em.persist(ingredientes); 
			em.getTransaction().commit();
		} 
		catch (Exception e) {
			throw e;
		} finally { 
			em.close();
		} 
	}

	public List<Ingrediente> listarIngrediente(){

		TypedQuery<Ingrediente> tQuery = em.createQuery("select f from Ingrediente f", Ingrediente.class); 
		return tQuery.getResultList();
	}

	
	

	

}
