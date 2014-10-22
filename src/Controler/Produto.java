package Controler;
public class Produto {

	private String nome;
	private double preco;
	private String unidade;
	private int quantidade;

	Produto(String nome, double preco, String unidade, int quantidade) {
		setNome(nome);
		setPreco(preco);
		setUnidade(unidade);
		setQuantidade(quantidade);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
