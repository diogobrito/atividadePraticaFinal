package br.com.restaurante.helper;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.com.restaurante.entity.Fornecedor;

public class RestauranteHelperTest {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Restaurante");
	EntityManager em = emf.createEntityManager();
	RestauranteHelper helper = new RestauranteHelper(em);

	@Test
	public void testSalvarFornecedores() {
		Fornecedor forn = new Fornecedor();
		forn.setCNPJ(12345678910111l);
		forn.setCodFornecedor(123);
	}

	@Test
	public void testListarFornecedores() {
		fail("Not yet implemented");
	}

	@Test
	public void testSalvarPratos() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarPratos() {
		fail("Not yet implemented");
	}

	@Test
	public void testSalvarIngredientes() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarIngrediente() {
		fail("Not yet implemented");
	}

}
