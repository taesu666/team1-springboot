package lx.edu.springboot.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lx.edu.springboot.vo.CoupleInputVO;
import lx.edu.springboot.vo.CoupleResultVO;


@Repository

public class CoupleDAO {
	

	@Autowired
	SqlSession session;
	
	public int insertCoupleInput(CoupleInputVO civ) {
		return session.insert("insertCoupleInputDB", civ); 
	}

	
	public int insertCoupleResult(CoupleResultVO crv) {
		return session.insert("insertCoupleResultDB", crv); 
	}

}
