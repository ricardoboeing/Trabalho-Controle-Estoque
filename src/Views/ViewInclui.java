package Views;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.ImageIcon;

import Controler.Gerenciador;
import Controler.Produto;

public class ViewInclui extends JFrame {
	private JTextField textNome;
	private JTextField textPreco;
	private JTextField textUnidade;
	private JTextField textQuantidade;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Gerenciador gerenciador = new Gerenciador();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewInclui frame = new ViewInclui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewInclui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNesistemaDeControle = new JLabel("Sistema de Controle de Estoque Boeing");
		lblNesistemaDeControle.setBounds(26, 13, 399, 22);
		lblNesistemaDeControle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNesistemaDeControle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNesistemaDeControle.setForeground(Color.BLACK);
		lblNesistemaDeControle.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(lblNesistemaDeControle);
		
		JButton btnNewButton = new JButton("Inclui");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((textNome.getText().trim().equals("")) 
					|| (textPreco.getText().trim().equals("")) 
					|| (textUnidade.getText().trim().equals(""))
					|| (textQuantidade.getText().trim().equals(""))  
				){
					JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
				}else{
					gerenciador.cadastraProduto(textNome.getText(), Double.parseDouble(textPreco.getText()), textUnidade.getText(), Integer.parseInt(textQuantidade.getText()));
					JOptionPane.showMessageDialog(null, "Produto Cadastrado");
				}
			}
		});
		btnNewButton.setBounds(12, 47, 90, 25);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButton.setPreferredSize(new Dimension(100, 25));
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(348, 235, 77, 25);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewInclui.this.dispose();
				ViewCadastro frame = new ViewCadastro();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnVoltar);
		
		JButton btnConsulta = new JButton("");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = textNome.getText();
				Produto produtoConsulta = gerenciador.consultaProduto(nome);
				if(produtoConsulta != null){
					textPreco.setText(String.valueOf(produtoConsulta.getPreco()));
					textUnidade.setText(produtoConsulta.getUnidade());
					textQuantidade.setText(String.valueOf(produtoConsulta.getQuantidade()));
				}else{
					JOptionPane.showMessageDialog(null, "Produto não encontrado");
				}
				
			}
		});
		btnConsulta.setIcon(new ImageIcon("/home/ricardo/Área de Trabalho/Eclipse Arquivos/Programação II/Trabalho Controle de Estoque/Imagens/icone_lupa.jpeg"));
		btnConsulta.setBounds(253, 106, 24, 24);
		contentPane.add(btnConsulta);
		
		JButton btnLimpa = new JButton("Limpa");
		btnLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome.setText(null);
				textPreco.setText(null);
				textUnidade.setText(null);
				textQuantidade.setText(null);
			}
		});
		btnLimpa.setBounds(12, 235, 117, 25);
		contentPane.add(btnLimpa);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(26, 106, 70, 15);
		contentPane.add(lblNome);
		
		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setBounds(26, 133, 70, 15);
		contentPane.add(lblPreco);
		
		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setBounds(26, 160, 70, 15);
		contentPane.add(lblUnidade);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(26, 187, 83, 15);
		contentPane.add(lblQuantidade);
		
		textNome = new JTextField();
		textNome.setBounds(127, 106, 114, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textPreco = new JTextField();
		textPreco.setBounds(127, 135, 114, 19);
		contentPane.add(textPreco);
		textPreco.setColumns(10);
		
		textUnidade = new JTextField();
		textUnidade.setBounds(127, 160, 114, 19);
		contentPane.add(textUnidade);
		textUnidade.setColumns(10);
		
		textQuantidade = new JTextField();
		textQuantidade.setBounds(127, 187, 114, 19);
		contentPane.add(textQuantidade);
		textQuantidade.setColumns(10);
		

		
	}
}
