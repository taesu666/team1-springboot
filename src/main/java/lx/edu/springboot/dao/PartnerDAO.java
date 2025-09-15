package lx.edu.springboot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lx.edu.springboot.vo.CoupleInputVO;
import lx.edu.springboot.vo.CoupleResultVO;
import lx.edu.springboot.vo.PartnerVO;

@Repository
public class PartnerDAO {

    @Autowired
    private SqlSession sqlSession;
    
	public List<PartnerVO> getAllPartners() {
		   return sqlSession.selectList("selectAllPartners");
	}

}
