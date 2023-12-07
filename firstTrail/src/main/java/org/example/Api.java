package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Api {
    ObjectMapper objectMapper = new ObjectMapper();

    public String getTranslationByWord(String word, String target) {
        try {
            HttpRequest request = createRequest("").method("POST", HttpRequest.BodyPublishers.ofString("source=fr&target=" + target +"&q=" + word)).build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return parseBodyToList(response.body(), "translations", "translatedText").getFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public List<String> getLanguages() {
        try {
            HttpRequest request = createRequest("languages").method("GET", HttpRequest.BodyPublishers.noBody()).build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return parseBodyToList(response.body(), "languages", "language");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    private HttpRequest.Builder createRequest(String uri) {
        return HttpRequest.newBuilder().uri(URI.create("https://google-translate1.p.rapidapi.com/language/translate/v2/" + uri)).header("content-type", "application/x-www-form-urlencoded").header("Accept-Encoding", "application/gzip").header("X-RapidAPI-Key", "48c64b0754msh2a3b6de6550e4a3p16a12bjsn3a51f630d98c").header("X-RapidAPI-Host", "google-translate1.p.rapidapi.com");
    }

    private List<String> parseBodyToList(String body, String... node) {
        List<String> languageList = new ArrayList<>();
        try {
            JsonNode languagesNode = objectMapper.readTree(body).path("data").path(node[0]);
            languagesNode.forEach(languageNode -> languageList.add(languageNode.path(node[1]).asText()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return languageList;
    }
}
