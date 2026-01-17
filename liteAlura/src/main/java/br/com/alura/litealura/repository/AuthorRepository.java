package br.com.alura.litealura.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.litealura.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	Optional<Author> findByNameContainingIgnoreCase(String name);

	boolean existsByNameIgnoreCase(String name);

	List<Author> findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(Integer birthYear, Integer deathYear);

}
