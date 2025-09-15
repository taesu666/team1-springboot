package lx.edu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import lx.edu.springboot.vo.LoginVO;

@Controller
public class HomeController {

    @RequestMapping("/home.do")
    public String goToHome(HttpSession session, Model model) {
    	 String userNickName = (String) session.getAttribute("userNickName");
         model.addAttribute("userNickName", userNickName);
        return "home";  // home.html 뷰 반환
    }

    @GetMapping("/register.do")
    public String goToRegister(Model model) {
        model.addAttribute("vo", new LoginVO());  // 회원가입 폼에 빈 VO 제공
        return "register";  // register.html 뷰 반환
    }

    @RequestMapping("/fate.do")
    public String goToFate() {
        return "fate_input_form";  // 사주 입력 폼 뷰
    }

    @RequestMapping("/couple.do")
    public String goToCouple() {
        return "couple_input";  // 궁합 입력 폼 뷰
    }

}
