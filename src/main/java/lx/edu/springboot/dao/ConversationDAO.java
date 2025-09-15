package lx.edu.springboot.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lx.edu.springboot.vo.ConversationVO;

@Component
public class ConversationDAO {

	@Autowired
	SqlSession session;

	public int insertFateConversation(ConversationVO vo) throws Exception {
		return session.insert("insertFateConversation", vo);
	}
	

	public List<ConversationVO> getConversationListByFateId(int resultfateId) {
	    return session.selectList("getConversationListByFateId", resultfateId);
	}


	public List<ConversationVO> getConversationListByCoupleId(int resultcoupleId) {
		return session.selectList("getConversationListByCoupleId", resultcoupleId);
	}


	public int insertCoupleConversation(ConversationVO vo) throws Exception {
		return session.insert("insertCoupleConversation", vo);
	}



}
