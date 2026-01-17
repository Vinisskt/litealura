package br.com.alura.litealura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.alura.litealura.controller.Request_Http;
import br.com.alura.litealura.dto.BookData;
import br.com.alura.litealura.dto.ResultData;

public class ConversionJson {

	private String response;

	public ConversionJson() {
	}

	public String getResponse() {
		return response;
	}

	public String requestHttpBook(String input) {
		Request_Http request_Http = new Request_Http();
		String url = request_Http.CreateURL(input);
		request_Http.resquestHttpSearch(url);
		return this.response = request_Http.getResponse();
	}

	public BookData conversionJson() throws JsonProcessingException {
		String json = getResponse();
		final var objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ResultData resultData = objectMapper.readValue(json, ResultData.class);

		return resultData.books().isEmpty() ? null : resultData.books().get(0);

	}
}
