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

    // 로그인 폼 보여주기
    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("vo", new LoginVO());
        return "login";
    }

    // 로그인 처리
    @PostMapping("/doLogin")
    public String doLogin(@RequestParam String userId,
                          @RequestParam String userPassword,
                          HttpSession session,
                          Model model) {
        LoginVO loginUser = dao.selectUserById(userId);
        if (loginUser != null && userPassword.equals(loginUser.getUserPassword())) {
            session.setAttribute("userNickName",  loginUser.getUserNickName());
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
    @PostMapping("/updateLogin.do")
    public String updateLoginDB(LoginVO vo) throws Exception {
        dao.updateLoginDB(vo);
        return "redirect:/login";
    }
}
