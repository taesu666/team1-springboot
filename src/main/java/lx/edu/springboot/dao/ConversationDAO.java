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

<<<<<<< HEAD
	public int insertConversation(ConversationVO ab) throws Exception {
		return session.insert("insertConversation", ab);
	}
	

	public List<ConversationVO> getDBList(int targetId, int type) throws Exception {
		return session.selectList("getDBList");
	}


	public List<ConversationVO> getConversationList(int targetId) {
		return session.selectList("getConversationList", targetId);
=======
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
>>>>>>> eunho
	}



}