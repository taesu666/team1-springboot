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

	public int insertConversation(ConversationVO ab) throws Exception {
		return session.insert("insertConversation", ab);
	}
	

	public List<ConversationVO> getConversationList(int targetId) {
		return session.selectList("getConversationList", targetId);
	}



}
