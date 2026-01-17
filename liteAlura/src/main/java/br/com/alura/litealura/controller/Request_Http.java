package br.com.alura.litealura.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Request_Http {
	private String url;
	private String response;

	public Request_Http() {
	}

	public String getUrl() {
		return url;
	}

	public String getResponse() {
		return response;
	}

	public String CreateURL(String nameAutor) {
		String nameValid = nameAutor.replace(" ", "%20");
		String createUrl = "https://gutendex.com/books/?search=" + nameValid;
		return this.url = createUrl;
	}

	public void resquestHttpSearch(String url) {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.build();

			HttpResponse<String> response = client
					.send(request, BodyHandlers.ofString());
			this.response = response.body();

		} catch (MalformedURLException | InterruptedException e) {
			System.out.println("Argumento invalido, nessesario URL valida");

		} catch (IOException e) {
			e.getMessage();
		}
	}
}
