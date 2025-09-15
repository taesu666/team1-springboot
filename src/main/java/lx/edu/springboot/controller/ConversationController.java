package lx.edu.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lx.edu.springboot.dao.ConversationDAO;
import lx.edu.springboot.vo.ConversationVO;

@Controller
public class ConversationController {
	
	@Autowired
	ConversationDAO dao;


	@GetMapping("/conversation_select")
	public String form2() {
		return "conversation_select";
	}
	
//	@RequestMapping("/insert.do")
//	public String insert(ConversationVO vo) throws Exception {
//		System.out.println(vo);
//		dao.insertDB(vo);
//		return "redirect:addrbook_list.do";
//	}

	@RequestMapping("/addrbook_form.do")
	public String form() {
		return "addrbook_form"; // jsp file name
	}

    // 개별 사주 결과 상세 페이지
	/*
	 * @GetMapping("/conversation_result_fate.do") public String
	 * resultFate(@RequestParam("resultfateId") int resultfateId, Model model) {
	 * ConversationVO vo = dao.selectFateDBlist(resultfateId);
	 * model.addAttribute("result", vo); return "conversation_result_fate"; }
	 */


}
