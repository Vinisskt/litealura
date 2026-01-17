package br.com.alura.litealura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;

public record ResultData(@JsonAlias("results") List<BookData> books) {

}
