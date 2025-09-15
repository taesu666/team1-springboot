package lx.edu.springboot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lx.edu.springboot.vo.CoupleInputVO;
import lx.edu.springboot.vo.CoupleResultVO;
import lx.edu.springboot.vo.FateResultVO;

@Repository

public class CoupleDAO {

	@Autowired
<<<<<<< HEAD
	SqlSession session;

=======
	SqlSession session; 
	
>>>>>>> byeongiu
	public int insertCoupleInput(CoupleInputVO civ) {
		return session.insert("insertCoupleInputDB", civ);
	}

	public int insertCoupleResult(CoupleResultVO crv) {
		return session.insert("insertCoupleResultDB", crv);
	}


	public List<CoupleResultVO> getCoupleList() {
		return session.selectList("getCoupleList");
	}
	

	public List<CoupleResultVO> getCoupleList() {
		return session.selectList("getCoupleList");
	}

}
