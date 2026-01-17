package br.com.alura.litealura.main;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.alura.litealura.dto.AuthorData;
import br.com.alura.litealura.dto.BookData;
import br.com.alura.litealura.model.Author;
import br.com.alura.litealura.model.Book;
import br.com.alura.litealura.repository.AuthorRepository;
import br.com.alura.litealura.repository.BookRepository;
import br.com.alura.litealura.service.ConversionJson;

public class Main {

	private BookRepository bookRepository;
	private AuthorRepository authorRepository;

	public Main(BookRepository bookRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	public AuthorRepository getAuthorRepository() {
		return authorRepository;
	}

	public BookRepository getBookRepository() {
		return bookRepository;
	}

	public void mainLiteAlura() {
		Scanner scanner = new Scanner(System.in);
		Menu menu = new Menu();
		ConversionJson conversionJson = new ConversionJson();

		while (true) {
			System.out.println(menu.getMenu());

			System.out.println("\nEscolha qual Opçao Deseja acessar");
			char input = scanner.next().charAt(0);
			scanner.nextLine();

			if (menu.validateInput(input, scanner) == false) {
				continue;
			}

			if (input == '6') {
				scanner.close();
				System.out.println("\nprograma finalizado\n");
				break;
			}

			switch (input) {
				case '1':
					try {
						System.out.println("Digite o nome do titulo");
						String nameBook = scanner.nextLine();
						conversionJson.requestHttpBook(nameBook);
						BookData data = conversionJson.conversionJson();

						if (data == null) {
							System.out.println(
									"Esse Livro nao esta disponivel para a consulta");
						}

						if (data != null) {
							System.out.println(data);
							Author author = new Author(data.author().get(0));
							String nameAuthor = data.author().stream()
									.map(AuthorData::nameAuthor)
									.collect(Collectors.joining());
							if (!authorRepository
									.existsByNameIgnoreCase(nameAuthor.trim())) {
								authorRepository.save(author);
							}

							Book book = new Book(data, author);
							if (bookRepository.existsByTitle(book.getTitle())) {
								System.out.println("esse livro ja foi cadastrado");
								continue;
							}
							bookRepository.save(book);
							System.out.println("Salvo com sucesso");
						}

					} catch (JsonProcessingException e) {
						System.out.println("erro ao processar o json");
						break;
					}
					break;
				case '2':
					System.out.println(bookRepository.findAll());
					break;
				case '3':
					System.out.println(authorRepository.findAll());
					break;
				case '4':
					System.out.println("Insira o ano que seja pesquisar");
					try {
						Integer authorLiving = scanner.nextInt();
						scanner.nextLine();
						System.out.println(authorRepository
								.findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(
										authorLiving, authorLiving));

					} catch (InputMismatchException e) {
						scanner.nextLine();
						System.out.println("Insira apenas numeros");
						break;
					}
					break;
				case '5':
					System.out.println(menu.menuLanguages());
					String language = scanner.nextLine();
					if (language.equalsIgnoreCase("pt") || language.equalsIgnoreCase("en")) {
						System.out.println(bookRepository
								.findByLanguageContainingIgnoreCase(language));
					} else {
						System.out.println("O idioma nao esta disponivel para consulta");
					}
					break;
				default:
					break;
			}
		}

	}

}
