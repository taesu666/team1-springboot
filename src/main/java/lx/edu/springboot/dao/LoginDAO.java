package lx.edu.springboot.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import lx.edu.springboot.vo.LoginVO;

@Repository
public class LoginDAO {

    @Autowired
    private SqlSession session;

    public int insertLoginDB(LoginVO vo) {
        return session.insert("mapper-login.insertLoginDB", vo);
    }

    public int updateLoginDB(LoginVO vo) {
        return session.update("mapper-login.updateLoginDB", vo);
    }

    public LoginVO selectUserById(String userId) {
        return session.selectOne("mapper-login.selectUserById", userId);
    }
}
