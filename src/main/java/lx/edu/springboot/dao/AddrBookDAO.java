package lx.edu.springboot.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lx.edu.springboot.vo.AddrBookVO;

@Repository
public class AddrBookDAO {
	
	@Autowired
	SqlSession session;
		
	public int insertDB(AddrBookVO ab){
		return session.insert("insertDB", ab); //mapper xml의 bean id
	}

	public List<AddrBookVO> getDBList(){
		return session.selectList("getDBList");
	}

	public AddrBookVO getDB(int abId){
		AddrBookVO vo = session.selectOne("getDB", abId);
		return vo;
	}
	
	public int updateDB(AddrBookVO ab){
		return session.update("updateDB", ab);
	}
	
	public int deleteDB(int abId) {
		return session.delete("deleteDB", abId);
	}
	
//	private Connection getConnection(){
//		return dataSource.getConnection();
//	}
	
}
