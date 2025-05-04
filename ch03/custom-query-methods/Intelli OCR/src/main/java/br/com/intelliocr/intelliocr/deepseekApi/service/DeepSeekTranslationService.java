package br.com.intelliocr.intelliocr.deepseekApi.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class DeepSeekTranslationService {

    private static final String API_URL = "https://api.deepseek.com/v1/chat/completions";
    private static final String API_KEY = "";

    public String traduzirTexto(String texto) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(API_KEY);

        String prompt = "Traduza o seguinte texto para o português brasileiro (pt-br), mantendo o sentido técnico e tornando a tradução o mais natural possível. Responda apenas com o texto traduzido, sem explicações, observações, formate o texto para que ele tenha apenas a primeira letra maiúscula no início da frase e em nomes próprios:\n\n" + texto;


        Map<String, Object> requestBody = Map.of(
                "model", "deepseek-chat",
                "messages", new Object[]{
                        Map.of("role", "user", "content", prompt)
                }
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(API_URL, request, Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            Map<String, Object> responseBody = response.getBody();
            if (responseBody != null && responseBody.containsKey("choices")) {
                Map firstChoice = ((java.util.List<Map>) responseBody.get("choices")).get(0);
                Map message = (Map) firstChoice.get("message");
                return (String) message.get("content");
            }
        }

        return "Erro na tradução.";
    }
}
