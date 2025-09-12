package lx.edu.springboot.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lx.edu.springboot.vo.CoupleResultVO;

@Repository

public class CoupleResultDAO {
	
	@Autowired
	SqlSession session;
	
	public int insertCoupleResult(CoupleResultVO crv) {
		return session.insert("insertCoupleResultDB", crv); 
	}

}
