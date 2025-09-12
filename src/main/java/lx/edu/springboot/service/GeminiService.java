package lx.edu.springboot.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lx.edu.springboot.client.GoogleAiClient;

@Service
public class GeminiService {
    @Autowired
    private GoogleAiClient googleAiClient;

    public String generate(String prompt) {
        return googleAiClient.getGeminiContent(prompt);
    }
}
