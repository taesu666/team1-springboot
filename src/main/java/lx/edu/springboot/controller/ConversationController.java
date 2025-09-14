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

	@GetMapping("/conversation_select.do")
	public String form2() {
		return "conversation_select";
	}
	


	// 사주 목록
	@RequestMapping("/conversation_list_fate.do")
	public String list(HttpServletRequest req) throws Exception {
	    List<ConversationVO> list = dao.getConversationList(1);
	    req.setAttribute("data", list);
	    return "conversation_list_fate";  // 뷰 파일 이름 (addrbook_list.jsp 또는 .html)
	}
	
	// 궁합 목록
	@RequestMapping("/conversation_list_couple.do")
	public String list2(HttpServletRequest req) throws Exception {
	    List<ConversationVO> list = dao.getConversationList(1);
	    req.setAttribute("data", list);
	    return "conversation_list_couple";  // 뷰 파일 이름 (addrbook_list.jsp 또는 .html)
	}
	
  /*  // 사주 리스트 페이지
    @GetMapping("/conversation_list_fate.do")
    public String listFate(HttpServletRequest req) throws Exception {
        List<ConversationVO> list = dao.getDBList();
        req.setAttribute("data", list);
        return "conversation_list_fate";
    }
    
    // 개별 사주 결과 상세 페이지
    @GetMapping("/conversation_result_fate.do")
    public String resultFate(@RequestParam("resultfateId") int resultfateId, Model model) {
        ConversationVO vo = dao.selectFateDBlist(resultfateId);
        model.addAttribute("result", vo);
        return "conversation_result_fate";
    }*/

}
