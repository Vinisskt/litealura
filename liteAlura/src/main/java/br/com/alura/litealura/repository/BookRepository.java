package br.com.alura.litealura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.litealura.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByLanguageContainingIgnoreCase(String language);

	boolean existsByTitle(String title);

}
