package lx.edu.springboot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lx.edu.springboot.vo.TravelVO;

@Repository
public class TravelDAO {

	@Autowired
	SqlSession session;
	/*
	public String getMaxFiveByResultFateId(int resultFateId) throws Exception {
		return session.selectOne("getMaxFiveByResultFateId", resultFateId);
	}
	*/

	public List<TravelVO> getRecommendedByMaxFive(String maxFive) throws Exception {
		return session.selectList("getRecommendedByMaxFive", maxFive);
	}
	
	public String getBadByMaxFive(String maxFive) throws Exception {
		return session.selectOne("getBadByMaxFive", maxFive); 
	}
	
	public List<TravelVO> getAvoidByBad(String bad) throws Exception {
		return session.selectList("getAvoidByBad", bad);
	}
	
	public TravelVO selectTravelDB(int travelId) throws Exception {
		return session.selectOne("selectTravelDB", travelId);
	}
	
}
