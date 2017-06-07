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
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Restaurante");
	static EntityManager em = emf.createEntityManager();
	static RestauranteHelper helper = new RestauranteHelper(em);

	public static void main(String[] args) {

		int cadastro = JOptionPane.showConfirmDialog(null,
				"Bem vindo ao nosso Restaurante! Deseja cadastrar seus dados?", "Restaurante", 0);

		if (cadastro == 0) {

			cadastrarPrato();
			cadastrarFonecedor();

		} else {
			JOptionPane.showMessageDialog(null, "Obrigado!");
		}
	}

	public static void cadastrarPrato() {
		Prato prato = new Prato();
		prato.setNome(JOptionPane.showInputDialog("Nome do prato: "));
		prato.setChefe(JOptionPane.showInputDialog("Nome do chefe: "));
		prato.setCategoria(JOptionPane.showInputDialog("Categoria: "));
		prato.setValor(Float.parseFloat(JOptionPane.showInputDialog("Preço: ")));

		try {
			helper.salvarPratos(prato);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void cadastrarFonecedor() {
		Fornecedor forn = new Fornecedor();
		forn.setNome(JOptionPane.showInputDialog("Nome do fornecedor: "));
		forn.setCNPJ(new Long(JOptionPane.showInputDialog("CNPJ: ")));
		forn.setPorte(JOptionPane.showInputDialog("Porte: "));


		try {
			helper.salvarFornecedores(forn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void cadastrarIngrediente() {
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setNome(JOptionPane.showInputDialog("Nome: "));
		ingrediente.setPeso(new Float(JOptionPane.showInputDialog("Peso: ")));
		ingrediente.setPreco(new Double(JOptionPane.showInputDialog("Preço: ")));

		try {
			helper.salvarIngredientes(ingrediente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void listarIngredientes() {
		List<Ingrediente> ingredientes = helper.listarIngrediente();
		for (Ingrediente ingrediente : ingredientes) {
			System.out.println(ingrediente.getNome() + ": " + ingrediente.getPeso()+": " + ingrediente.getPreco());
		}
	}

	public static void listarPratos() {
		List<Prato> pratos = helper.listarPratos();
		for (Prato prato : pratos) {
			System.out.println(prato.getNome() + ": " + prato.getChefe() + ": " +prato.getCategoria() + ": " +prato.getValor());
		}
	}

	public static void listarFonecedores() {
		List<Fornecedor> fornecedores = helper.listarFornecedores();
		for (Fornecedor fornecedore : fornecedores) {
			System.out.println(fornecedore.getCNPJ() + ": " + fornecedore.getNome()+": " + fornecedore.getPorte());
		}
	}

}