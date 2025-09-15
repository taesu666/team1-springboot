// 보물찾기

package lx.edu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import lx.edu.springboot.dao.LoginDAO;
import lx.edu.springboot.vo.LoginVO;


@Controller
public class LoginController {
	
	@Autowired
	LoginDAO dao;
	
	@PostMapping("/insertLogin.do")
	public String insertLoginDB(LoginVO vo) throws Exception { 
		System.out.println(vo);
		dao.insertLoginDB(vo);
		return "redirect:/login";
	}
	
	@RequestMapping("/updateLogin.do")
	public String updateLoginDB(LoginVO vo) throws Exception {
		dao.updateLoginDB(vo);
		return "redirect:/login";
	}

	@PostMapping("/doLogin") 
	public String doLogin(@RequestParam String userId, @RequestParam String userPassword, HttpSession session,	Model model) {
		boolean success = dao.doLogin(userId, userPassword);
		if (success) {
			session.setAttribute("userId", userId);
			return "redirect:/home";
		} else {
			model.addAttribute("errorMsg", "로그인에 실패했습니다. 아이디와 비밀번호를 확인하세요.");
        	return "login";
		}
	}
}
