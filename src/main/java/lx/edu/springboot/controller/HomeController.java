//보물찾기

package lx.edu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lx.edu.springboot.vo.LoginVO;


@Controller
public class HomeController {
	
	@RequestMapping("/home") 
	public String goToHome() {
		return "home";
	}

	@GetMapping("/login")
	public String goToLogin(Model model) {
		model.addAttribute("vo", new LoginVO()); // 빈 vo 객체 전달
		return "login";
	}

	@GetMapping("/register")
	public String goToRegister(Model model) {
		model.addAttribute("vo", new LoginVO());
		return "register";
	}
		
	@RequestMapping("/fate") 
	public String goToFate() {
		return "fate_input_form";
	}	

	@RequestMapping("/couple") 
	public String goToCouple() {
		return "couple_input";
	}

	@RequestMapping("/result") 
	public String goToResult() {
		return "conversation_select";
	}

	

}
