package br.com.alura.litealura.model;

import br.com.alura.litealura.dto.BookData;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String language;
	private Integer numberDownload;

	@ManyToOne
	private Author author;

	public Book() {
	}

	public Book(BookData data, Author author) {
		this.title = data.titleBook();
		this.author = author;
		this.language = data.language().get(0);
		this.numberDownload = data.numberDownload();
	}

	@Override
	public String toString() {
		return "\n" + "Title -> " + getTitle() + "\n" +
				"Author -> " + getAuthor().getName() + "\n" +
				"Languages -> " + getLanguage() + "\n" +
				"Downloads -> " + getNumberDownload() + "\n";
	}

	public String getTitle() {
		return title;
	}

	public Author getAuthor() {
		return author;
	}

	public Integer getNumberDownload() {
		return numberDownload;
	}

	public String getLanguage() {
		return language;
	}
}
