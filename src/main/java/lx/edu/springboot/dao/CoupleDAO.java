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

	SqlSession session;



	

	public int insertCoupleInput(CoupleInputVO civ) {
		return session.insert("insertCoupleInputDB", civ);
	}

	public int insertCoupleResult(CoupleResultVO crv) {
		return session.insert("insertCoupleResultDB", crv);
	}



	public List<CoupleResultVO> getCoupleList() {
		return session.selectList("getCoupleList");
	}


	public CoupleResultVO selectResultCouple(int inputId){
		return session.selectOne("selectResultCouple", inputId);
	}

	public int deleteCouple(int resultCoupleId) {
		return session.delete("deleteCouple", resultCoupleId);
	}




}
