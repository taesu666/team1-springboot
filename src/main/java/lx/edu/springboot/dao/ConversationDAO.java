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

	public int insertDB(ConversationVO ab) throws Exception {
		return session.insert("insertDB", ab);
	}
	
	public List<ConversationVO> getDBList() throws Exception {
		return session.selectList("getDBList");
	}

	public ConversationVO selectFateDBlist(int resultfateId) {
		return session.selectOne("selectFateDBlist", resultfateId);
	}



}
