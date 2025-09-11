// 첫 생성
package lx.edu.springboot.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lx.edu.springboot.vo.LoginVO;

@Repository
public class LoginDAO {

	@Autowired
	SqlSession session;
	
	public int insertLoginDB(LoginVO vo) {
		return session.insert("insertLoginDB", vo);
	}
	
	public int updateLoginDB(LoginVO vo) {
		return session.update("updateLoginDB", vo);
	}
}
