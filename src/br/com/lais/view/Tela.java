package br.com.lais.view;

import javax.swing.JOptionPane;

public class Tela {
	public void mensagem(String titulo) {
		JOptionPane.showMessageDialog(null, titulo);
	}
	
	public String inputTexto(String titulo) {
		return JOptionPane.showInputDialog(titulo);
	}
	
	public int opcaoEscolhida(String[] opcao, String descricao, String titulo) {
		return JOptionPane.showOptionDialog(null, descricao, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, null);
	}
}
