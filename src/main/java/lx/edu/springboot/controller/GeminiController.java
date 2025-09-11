package lx.edu.springboot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lx.edu.springboot.service.GeminiService;

@Controller
public class GeminiController {

    @Autowired
    private GeminiService geminiService;

    @GetMapping("/gemini")
    public String gemini(@RequestParam(defaultValue = "오늘 날씨 알려줘") String prompt, Model model) {
        String result = geminiService.generate(prompt);
        model.addAttribute("result", result);
        model.addAttribute("prompt", prompt);
        return "gemini";
    }
}
