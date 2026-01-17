package br.com.alura.litealura.model;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.litealura.dto.AuthorData;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String name;

	private Integer birthYear;
	private Integer deathYear;

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Book> books;

	public Author() {
	}

	public Author(AuthorData data) {
		this.name = data.nameAuthor();
		this.birthYear = data.birthYear();
		this.deathYear = data.deathYear();
	}

	@Override
	public String toString() {

		String nameBooks = getBooks().stream()
				.map(Book::getTitle).collect(Collectors.joining(","));

		return "\n" + "Author -> " + getName() + "\n" +
				"Birth year -> " + getBirthYear() + "\n" +
				"Death year -> " + getDeathYear() + "\n" +
				"Books -> " + nameBooks + "\n";

	}

	public String getName() {
		return name;
	}

	public Integer getBirthYear() {
		return birthYear;
	}

	public Integer getDeathYear() {
		return deathYear;
	}

	public List<Book> getBooks() {
		return books;
	}
}
