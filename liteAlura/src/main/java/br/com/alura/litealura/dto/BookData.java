package br.com.alura.litealura.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
		@JsonAlias("title") String titleBook,
		@JsonAlias("authors") List<AuthorData> author,
		@JsonAlias("languages") List<String> language,
		@JsonAlias("download_count") Integer numberDownload) {

	@Override
	public final String toString() {
		String nameAuthor = author.stream()
				.map(AuthorData::nameAuthor).collect(Collectors.joining(","));

		return "\nTitulo -> " + titleBook + "\n" +
				"Autor -> " + nameAuthor + "\n" +
				"Idiomas -> " + language + "\n" +
				"Quantidade de downloads - > " + numberDownload + "\n";

	}

}
