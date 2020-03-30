package br.com.lais;

import br.com.lais.controller.JogoController;

public class Application {

	private JogoController jogoController = new JogoController();

	private void inicio() {
		jogoController.jogar();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application application = new Application();
		application.inicio();

	}

}
