// 보물찾기
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

	public LoginVO selectUserById(String userId) {
		return session.selectOne("selectUserById", userId);
    }

	public boolean doLogin(String userId, String userPassword) {
		LoginVO user = selectUserById(userId);
		if (user != null && user.getUserPassword().equals(userPassword)) {
			return true;
		}
		return false;
	}
}
