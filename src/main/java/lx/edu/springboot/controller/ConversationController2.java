package lx.edu.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lx.edu.springboot.dao.FateDAO;
import lx.edu.springboot.service.ConversationService;
import lx.edu.springboot.vo.ConversationVO;
import lx.edu.springboot.vo.FateResultVO;

@Controller
public class ConversationController2 {

    @Autowired
    private ConversationService conversationService;

    @Autowired
    private FateDAO fateDao; // DAO 주입 

    @GetMapping("/conversation_result_fate.do")
    public String resultFate(@RequestParam(value="resultfateId", required=false, defaultValue="0") int resultfateId, Model model) {
        // 1. 사주 상세 데이터 조회 (resultfateId 사용)
        FateResultVO detail = fateDao.selectResultFate(resultfateId);
        model.addAttribute("resultVO", detail);

        // 2. 댓글 리스트 조회 (targetId, type 사용)
        List<ConversationVO> list = conversationService.getConversationListByFateId(resultfateId);
        model.addAttribute("result", list);

        // 상세 및 댓글 뷰 페이지 이름 반환
        return "conversation_result_fate"; 
    }
    // 댓글 등록
    @PostMapping("/insert_fate_conversation.do")
    public String insertFateConversation(@RequestParam(value="targetId", required=false, defaultValue="0") int targetId, ConversationVO vo) throws Exception {
        vo.setTargetId(targetId);
        conversationService.insertFateConversation(vo);

        return "redirect:/conversation_result_fate.do?resultfateId=" + targetId;
    }
}