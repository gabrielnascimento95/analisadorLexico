package analisadorLexico;

import java.util.ArrayList;
import java.util.List;

public class Reconhecedor {

	public Reconhecedor() {
		// TODO Auto-generated constructor stub
	}

	public static void reconheceLinguagem(String chave, Automato automato) {

		Estado inicial = automato.getInicial();
		List<Transicao> possiveisTransicoes = new ArrayList<>();
		int flag = 0;

		for (int i = 0; i < chave.length(); i++) {
			flag = 0;
			char c = chave.charAt(i);

			for (int j = 0; j < automato.getTransicoes().size(); j++) {

				if (automato.getTransicoes().get(j).getSimbolo() == c
						|| automato.getTransicoes().get(j).getSimbolo() == '*') {
					possiveisTransicoes.add(automato.getTransicoes().get(j));
				}
			}

			for (Transicao transicao : possiveisTransicoes) {

				if (transicao.getOrigem() == automato.getAtual()) {

					automato.setAtual(transicao.getDestino());
					flag = 1;
				}

			}
		}

		if (flag == 0) {
			System.out.println("Não Reconhece: " + chave);

		}

		else {
			System.out.println("Reconhece: " + chave);
		}
		automato.setAtual(automato.getInicial());

	}
}
