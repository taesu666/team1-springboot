
// 첫 생성
// 로그인, 회원가입 추가

package lx.edu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import lx.edu.springboot.dao.LoginDAO;
import lx.edu.springboot.vo.LoginVO;


@Controller
public class LoginController {
	
	@Autowired
	LoginDAO dao;
	
	@RequestMapping("/insertLogin.do")
	public String insertLoginDB(LoginVO vo) throws Exception { //Spring에서는 이렇게 사용 가능!
		System.out.println(vo);
		dao.insertLoginDB(vo);
		return "login";
	}
	
	@RequestMapping("/updateLogin.do")
	public String updateLoginDB(LoginVO vo) throws Exception {
		dao.updateLoginDB(vo);
		return "redirect:/login";
	}
	
	@RequestMapping("/home") 
	public String goToHome() {
		return "home";
	}

	@RequestMapping("/doLogin") 
	public String doLogin() {
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
