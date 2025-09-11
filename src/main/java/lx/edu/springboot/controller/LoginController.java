
// 첫 생성

package lx.edu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		return "redirect:/home.do";
	}

	
	@RequestMapping("/updateLogin.do")
	public String updateLoginDB(LoginVO vo) throws Exception {
		dao.updateLoginDB(vo);
		return "redirect:/home.do";
	}
	
	@RequestMapping("/home") 
		public  String goToHome() {
			return "home";
		}

	

}
