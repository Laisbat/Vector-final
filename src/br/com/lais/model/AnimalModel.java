package br.com.lais.model;

import java.util.List;

public class AnimalModel {

	public List<String> adicionarAnimal(String animal, List<String> listAnimais) {
		listAnimais.add(animal);
		return listAnimais;
	}
}
