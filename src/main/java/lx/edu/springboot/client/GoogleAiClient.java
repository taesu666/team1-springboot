package lx.edu.springboot.client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

@Component
public class GoogleAiClient {
    @Value("${gemini.api.key}")
    private String apiKey;

    private final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=%s";

    public String getGeminiContent(String prompt) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(API_URL, apiKey);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject part = new JSONObject();
        part.put("text", prompt);

        JSONArray parts = new JSONArray();
        parts.put(part);

        JSONObject content = new JSONObject();
        content.put("parts", parts);

        JSONArray contentsArray = new JSONArray();
        contentsArray.put(content);

        JSONObject body = new JSONObject();
        body.put("contents", contentsArray);

        HttpEntity<String> entity = new HttpEntity<>(body.toString(), headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        JSONObject result = new JSONObject(response.getBody());
        JSONArray candidates = result.getJSONArray("candidates");
        JSONObject contentObj = candidates.getJSONObject(0).getJSONObject("content");
        JSONArray contentParts = contentObj.getJSONArray("parts");
        return contentParts.getJSONObject(0).getString("text");
    }
    
    public String getCoupleAnalysis(String prompt) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(API_URL, apiKey);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject part = new JSONObject();
        part.put("text", prompt);

        JSONArray parts = new JSONArray();
        parts.put(part);

        JSONObject content = new JSONObject();
        content.put("parts", parts);

        JSONArray contentsArray = new JSONArray();
        contentsArray.put(content);

        JSONObject body = new JSONObject();
        body.put("contents", contentsArray);

        HttpEntity<String> entity = new HttpEntity<>(body.toString(), headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        JSONObject result = new JSONObject(response.getBody());
        JSONArray candidates = result.getJSONArray("candidates");
        JSONObject contentObj = candidates.getJSONObject(0).getJSONObject("content");
        JSONArray contentParts = contentObj.getJSONArray("parts");
        return contentParts.getJSONObject(0).getString("text");
    }
}
