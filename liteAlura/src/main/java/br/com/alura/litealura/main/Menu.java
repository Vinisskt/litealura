package br.com.alura.litealura.main;

import java.util.Scanner;

public class Menu {
	private String menu;

	public Menu() {
		this.menu = menu();
	}

	public String getMenu() {
		return menu;
	}

	public String menu() {
		String menu = String.format("""

					  digite o numero para acessar as opçoes do menu

					#########################################################
					##     ##                                              ##
					##  1  ##       buscar livros pelo titulo              ##
					##  2  ##       listar livros registrados              ##
					##  3  ##       listar autores registrados             ##
					##  4  ##  listar autores vivos em um determinado ano  ##
					##  5  ##   listar livros em um determinado idioma     ##
					##  6  ##                 sair                         ##
					##     ##                                              ##
					#########################################################
				\n""");

		return menu;
	}

	public String menuLanguages() {
		String menu = String.format("""

					digite a sigla do idioma para acessar a opçoes do menu

					##########################################################
					##      ##                                              ##
					##  En  ##            livros em Ingles                  ##
					##  Pt  ##           livros em Portugues                ##
					##     	##                                              ##
					##########################################################
				\n""");

		return menu;
	}

	public boolean validateInput(char input, Scanner scanner) {
		if (input == '0' || input == '7' || input == '8' || input == '9') {
			System.out.println("\nValor invalido, tente novamente com numeros entre 1 a 6\n");
			return false;
		}

		boolean isDigit = Character.isDigit(input);
		if (isDigit == false) {
			System.out.println("\nValor invalido, tente novamente com numeros entre 1 a 6\n");
			return false;
		}
		return true;
	}
}
