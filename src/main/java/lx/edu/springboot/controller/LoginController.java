package lx.edu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import lx.edu.springboot.dao.LoginDAO;
import lx.edu.springboot.vo.LoginVO;

@Controller
public class LoginController {

	@Autowired
	private LoginDAO dao;
	
	@GetMapping("/login")
	public String loginPage(Model model, HttpSession session) {
	    // 세션에 로그인 정보가 이미 있는 경우
	    if (session.getAttribute("userNickName") != null) {
	        model.addAttribute("alreadyLoggedIn", true);
	        return "home"; 
	    }

	    if (!model.containsAttribute("vo")) {
	        model.addAttribute("vo", new LoginVO());  // 빈 VO 객체 기본값 세팅
	    }
	    return "login";
	}
	
	  @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();  // 세션 전체 무효화 (로그인 정보 모두 삭제)
	        return "redirect:home"; // 로그아웃 후 로그인 페이지로 이동
	    }

	// 로그인 처리
	@PostMapping("/doLogin")
	public String doLogin(@RequestParam String userId, @RequestParam String userPassword, HttpSession session,
			Model model) {
		LoginVO loginUser = dao.selectUserById(userId);
		if (loginUser != null && userPassword.equals(loginUser.getUserPassword())) {
	        session.setAttribute("userId", loginUser.getUserId());      // <-- 여기 userId 저장
			session.setAttribute("userNickName", loginUser.getUserNickName());
			return "redirect:/home";
		} else {
			model.addAttribute("errorMsg", "로그인에 실패했습니다. 아이디와 비밀번호를 확인하세요.");
			model.addAttribute("vo", new LoginVO()); // 반드시 vo 객체도 넣기
			return "login";
		}
	}

	// 회원가입 처리 - 예시
	@PostMapping("/insertLogin.do")
	public String insertLoginDB(LoginVO vo) throws Exception {
		dao.insertLoginDB(vo);
		return "redirect:/login";
	}

	// 회원정보 수정 처리 - 예시
	@GetMapping("/updateLogin")
	 public String showUpdateForm(HttpSession session, Model model) {
        String userId = (String) session.getAttribute("userId");
        
        LoginVO loginUser = dao.selectUserById(userId);
        model.addAttribute("loginUser", loginUser);
        return "update_login";
    }
}
