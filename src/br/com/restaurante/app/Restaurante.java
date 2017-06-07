package br.com.restaurante.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.restaurante.entity.Fornecedor;
import br.com.restaurante.entity.Ingrediente;
import br.com.restaurante.entity.Prato;
import br.com.restaurante.helper.RestauranteHelper;

public class Restaurante {

	public static void main(String[] args) {

		int cadastro = JOptionPane.showConfirmDialog(null,
				"Bem vindo ao nosso Restaurante! Deseja cadastrar seus dados?", "Restaurante", 0);

		if (cadastro == 0) {

			cadastrarPrato();
			cadastrarFonecedor();
			cadastrarIngrediente();
			listarIngredientes();
			listarPratos();
			listarFonecedores();

		} else {
			JOptionPane.showMessageDialog(null, "Obrigado!");
		}
	}

	public static void cadastrarPrato() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Restaurante");     
		EntityManager em = emf.createEntityManager();                                         
		RestauranteHelper helper = new RestauranteHelper(em);                                 
		Prato prato = new Prato();
		prato.setNome(JOptionPane.showInputDialog("Nome do prato: "));
		prato.setChefe(JOptionPane.showInputDialog("Nome do chefe: "));
		prato.setCategoria(JOptionPane.showInputDialog("Categoria: "));
		prato.setValor(Float.parseFloat(JOptionPane.showInputDialog("Preço: ")));

		try {
			helper.salvarPratos(prato);
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void cadastrarFonecedor() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Restaurante");     
		EntityManager em = emf.createEntityManager();                                         
		RestauranteHelper helper = new RestauranteHelper(em);         
		Fornecedor forn = new Fornecedor();
		forn.setNome(JOptionPane.showInputDialog("Nome do fornecedor: "));
		forn.setCNPJ(new Long(JOptionPane.showInputDialog("CNPJ: ")));
		forn.setPorte(JOptionPane.showInputDialog("Porte: "));

		try {
			helper.salvarFornecedores(forn);
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void cadastrarIngrediente() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Restaurante");     
		EntityManager em = emf.createEntityManager();                                         
		RestauranteHelper helper = new RestauranteHelper(em); 
		
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setNome(JOptionPane.showInputDialog("Nome: "));
		ingrediente.setPeso(new Float(JOptionPane.showInputDialog("Peso: ")));
		ingrediente.setPreco(new Double(JOptionPane.showInputDialog("Preço: ")));

		try {
			helper.salvarIngredientes(ingrediente);
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void listarIngredientes() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Restaurante");     
		EntityManager em = emf.createEntityManager();                                         
		RestauranteHelper helper = new RestauranteHelper(em); 
		List<Ingrediente> ingredientes = helper.listarIngrediente();
		for (Ingrediente ingrediente : ingredientes) {
			System.out.println(ingrediente.getNome() + ": " + ingrediente.getPeso() + ": " + ingrediente.getPreco());
		}
		em.close();
	}

	public static void listarPratos() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Restaurante");     
		EntityManager em = emf.createEntityManager();                                         
		RestauranteHelper helper = new RestauranteHelper(em); 
		List<Prato> pratos = helper.listarPratos();
		for (Prato prato : pratos) {
			System.out.println(
					prato.getNome() + ": " + prato.getChefe() + ": " + prato.getCategoria() + ": " + prato.getValor());
		}
		em.close();
	}

	public static void listarFonecedores() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Restaurante");     
		EntityManager em = emf.createEntityManager();                                         
		RestauranteHelper helper = new RestauranteHelper(em); 
		List<Fornecedor> fornecedores = helper.listarFornecedores();
		for (Fornecedor fornecedore : fornecedores) {
			System.out.println(fornecedore.getCNPJ() + ": " + fornecedore.getNome() + ": " + fornecedore.getPorte());
		}
		em.close();
	}

}