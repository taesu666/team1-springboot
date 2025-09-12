package lx.edu.springboot.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lx.edu.springboot.vo.CoupleInputVO;


@Repository

public class CoupleInputDAO {
	

	@Autowired
	SqlSession session;
	
	public int insertCoupleInput(CoupleInputVO civ) {
		return session.insert("insertCoupleInputDB", civ); 
	}

}
