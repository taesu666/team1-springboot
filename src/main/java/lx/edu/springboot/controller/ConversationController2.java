package lx.edu.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lx.edu.springboot.dao.CoupleDAO;
import lx.edu.springboot.dao.FateDAO;
import lx.edu.springboot.service.ConversationService;
import lx.edu.springboot.vo.ConversationVO;
import lx.edu.springboot.vo.CoupleResultVO;
import lx.edu.springboot.vo.FateResultVO;

@Controller
public class ConversationController2 {

    @Autowired
    private ConversationService conversationService;

    @Autowired
    private FateDAO fateDao; // DAO 주입 
    @Autowired
    private CoupleDAO coupleDao;
    @GetMapping("/conversation_result_fate.do")
    public String resultFate(@RequestParam(value="resultfateId", required=false, defaultValue="0") int resultfateId,
                             @RequestParam(value="targetId", required=false, defaultValue="0") int targetId,
                             @RequestParam(value="type", required=false, defaultValue="0") int type,
                             Model model) {
        // 1. 사주 상세 데이터 조회 (resultfateId 사용)
        FateResultVO detail = fateDao.selectResultFate(resultfateId);
        model.addAttribute("resultVO", detail);

        // 2. 댓글 리스트 조회 (targetId, type 사용)
        List<ConversationVO> list = conversationService.getConversationList(targetId, type);
        model.addAttribute("result", list);

        model.addAttribute("targetId", targetId);
        model.addAttribute("type", type);

        // 상세 및 댓글 뷰 페이지 이름 반환
        return "conversation_result_fate"; 
    }
    
    @GetMapping("/conversation_result_couple.do")
    public String coupleResultDetail(@RequestParam(value="resultCoupleId", required=false, defaultValue="0") int resultcoupleId,
                                     @RequestParam(value="targetId", required=false, defaultValue="0") int targetId,
                                     @RequestParam(value="type", required=false, defaultValue="0") int type,
                                     Model model) {
        // 1. 궁합 상세 데이터 조회 (resultcoupleId 사용)
        CoupleResultVO detail = coupleDao.selectResultCouple(resultcoupleId);
        
        if(detail == null) {
            detail = new CoupleResultVO(); // 기본값 객체 생성 또는 예외처리
        }
        model.addAttribute("coupleResultVO", detail);

        // 2. 댓글 리스트 조회 (targetId, type 사용)
        List<ConversationVO> list = conversationService.getConversationList(targetId, type);
        model.addAttribute("result", list);

        model.addAttribute("targetId", targetId);
        model.addAttribute("type", type);

        // 상세 및 댓글 뷰 페이지 이름 반환
        return "conversation_result_couple"; // Thymeleaf 템플릿 이름
    }

    // 댓글 등록
    @PostMapping("/insert_conversation.do")
    public String insertConversation(@RequestParam(value="targetId", required=false, defaultValue="0") int targetId,
                                     @RequestParam(value="type", required=false, defaultValue="0") int type, ConversationVO vo) throws Exception {
        vo.setTargetId(targetId);
        vo.setType(type);
        conversationService.insertConversation(vo);

        return "redirect:/conversation_result_fate.do?targetId=" + targetId + "&type=" + type;
    }
}