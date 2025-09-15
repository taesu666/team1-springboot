package lx.edu.springboot.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lx.edu.springboot.vo.ConversationVO;

@Component
public class ConversationDAO2 {

	@Autowired
	SqlSession session;

	public int insertConversation(ConversationVO vo) throws Exception {
		return session.insert("insertConversation", vo);
	}
	

	public List<ConversationVO> getConversationList(int targetId, int type) {
	    ConversationVO param = new ConversationVO();
	    param.setTargetId(targetId);
	    param.setType(type);
	    return session.selectList("getConversationList", param);
	}

	/*
	 * public static List<ConversationVO> getCommentsByFateId(int inputId) { return
	 * session.selectList("getCommentsByFateId", inputId);
	 * 
	 * }
	 */


}