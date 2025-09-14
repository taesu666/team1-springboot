package lx.edu.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lx.edu.springboot.service.ConversationService;
import lx.edu.springboot.vo.ConversationVO;

@Controller
public class ConversationController2 {

    @Autowired
    private ConversationService conversationService;


    @GetMapping("/conversation_result_fate.do")
    public String resultFate(@RequestParam(value="targetId", required=false, defaultValue="0") int targetId,
                             @RequestParam(value="type", required=false, defaultValue="0") int type, Model model) {
        List<ConversationVO> list = conversationService.getConversationList(targetId, type);
        model.addAttribute("result", list);
        model.addAttribute("targetId", targetId);
        model.addAttribute("type", type);
        return "conversation_result_fate"; 
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