package br.com.lais.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.lais.model.AnimalModel;
import br.com.lais.view.Tela;

public class JogoController {
	private final Tela tela = new Tela();
	private final String[] opcao = { "SIM!!!", "Não :(" };
	private final String[] tituloTipoAnimal = { "Animais Aquáticos", "Animais Terrestres" };
	private final String[] primeiroAnimal = { "Cachorro", "Peixinho" };
	private final AnimalModel animalModel = new AnimalModel();
	private final String[] tipoAnimal = { "Aquático", "Terrestre" };
	private List<String> listAnimaisTerrestres = new ArrayList<>();
	private List<String> listAnimaisAquaticos = new ArrayList<>();
	private int tipoAnimalEscolhido;

	public void jogar() {
		iniciarJogo();
	}

	private void iniciarJogo() {
		tela.mensagem("Pense em um animal");
		tipoAnimalEscolhido = tela.opcaoEscolhida(tipoAnimal, "O animal que você pensou é:", "Animais");
		adivinharAnimal(verificarTipoAnimal(tipoAnimalEscolhido));
	}

	private void adivinharAnimal(List<String> animais) {
		for (String animal : animais) {
			final String descricao = "O animal que você pensou é um " + animal + "?";
			int resultadoOpcaoEscolhida = tipoAnimalEscolhido != 0
					? tela.opcaoEscolhida(opcao, descricao, tituloTipoAnimal[1])
					: tela.opcaoEscolhida(opcao, descricao, tituloTipoAnimal[0]);
			if (resultadoOpcaoEscolhida == 0) {
				tela.mensagem("Ebaaaaa!!! Eu acerteeeei! :D");
				jogarNovamente();
				return;
			}
		}
		animalModel.adicionarAnimal(tela.inputTexto("Qual animal você pensou?"), animais);
		iniciarJogo();
	}

	private void jogarNovamente() {
		if (tela.opcaoEscolhida(opcao, "Quer jogar novamente?", "Reiniciar Jogo") == 0) {
			iniciarJogo();
			return;
		}
		tela.mensagem("Tchau, até a entrevista! <3");
	}

	public List<String> verificarTipoAnimal(int tipoAnimalEscolhido) {
		return tipoAnimalEscolhido != 0 ? validarTipoAnimalEscolhido(primeiroAnimal[0], listAnimaisTerrestres)
				: validarTipoAnimalEscolhido(primeiroAnimal[1], listAnimaisAquaticos);

	}

	private List<String> validarTipoAnimalEscolhido(String animal, List<String> listAnimal) {
		if (listAnimal.size() == 0) {
			animalModel.adicionarAnimal(animal, listAnimal);
		}
		return listAnimal;
	}

}
