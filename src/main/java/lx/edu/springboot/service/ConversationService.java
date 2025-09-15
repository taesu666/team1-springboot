package lx.edu.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lx.edu.springboot.dao.ConversationDAO;
import lx.edu.springboot.vo.ConversationVO;

@Service
public class ConversationService {

    @Autowired
    private ConversationDAO dao;

    // 댓글 목록 조회
    public List<ConversationVO> getConversationListByFateId(int resultfateId) {
        return dao.getConversationListByFateId(resultfateId);
    }

    // 댓글 등록
    public void insertFateConversation(ConversationVO vo) throws Exception {
        dao.insertFateConversation(vo);
    }

	public List<ConversationVO> getConversationListByCoupleId(int resultcoupleId) {
		return dao.getConversationListByCoupleId(resultcoupleId);
	}

	public void insertCoupleConversation(ConversationVO vo) throws Exception {
		dao.insertCoupleConversation(vo);
	}
}
