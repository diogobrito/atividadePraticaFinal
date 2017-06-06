package br.com.restaurante.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.restaurante.entity.Fornecedor;


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

	

}
