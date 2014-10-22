package Controler;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Gerenciador {

	ArrayList<Produto> listaProduto = new ArrayList<Produto>();

	public void cadastraProduto(String nome, double preco, String unidade,
			int quantidade) {
		Produto novoPro = new Produto(nome, preco, unidade, quantidade);
		listaProduto.add(novoPro);

	}

	public void alteraProduto(String nome, double preco, String unidade,
			int quantidade) {
		for (Produto Produto : listaProduto) {
			if (nome.equalsIgnoreCase(Produto.getNome())) {
				Produto.setPreco(preco);
				Produto.setUnidade(unidade);
				Produto.setQuantidade(quantidade);
			}
		}
	}

	public Produto consultaProduto(String nome) {
		try {
			for (Produto Produto : listaProduto) {
				if (nome.equalsIgnoreCase(Produto.getNome())) {
					return Produto;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}

	public void excluiProduto(String nome) {
		for (Produto Produto : listaProduto) {
			if (nome.equalsIgnoreCase(Produto.getNome())) {
				listaProduto.remove(Produto);
			} else {
				JOptionPane.showMessageDialog(null, "Produto não encontrado");
			}
		}
	}

	public void entradaEstoque() {

	}

	public void saidaEstoque() {

	}

	public void alteraPreco() {

	}

	public void alteraPrecoTodos() {

	}

}
