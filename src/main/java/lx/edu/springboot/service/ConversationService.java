package lx.edu.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lx.edu.springboot.dao.ConversationDAO2;
import lx.edu.springboot.vo.ConversationVO;

@Service
public class ConversationService {

    @Autowired
    private ConversationDAO2 dao;

    // 댓글 목록 조회
    public List<ConversationVO> getConversationList(int targetId, int type) {
        return dao.getConversationList(targetId, type);
    }

    // 댓글 등록
    public void insertConversation(ConversationVO vo) throws Exception {
        dao.insertConversation(vo);
    }
}