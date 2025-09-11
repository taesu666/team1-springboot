package lx.edu.springboot.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lx.edu.springboot.vo.InputFateVO;
import lx.edu.springboot.vo.ResultFateVO;

@Repository
public class FateDAO {
	
	@Autowired
	SqlSession session;
		
	public int insertInputFate(InputFateVO input_fate){
		return session.insert("insertInputFate", input_fate);
	}
	
	public int insertResultFate(InputFateVO result_fate){
		return session.insert("insertResultFate", result_fate);
	}

	public ResultFateVO selectResultFate(int inputId){
		return session.selectOne("selectResultFate", inputId);
	}

	public String selectEachResultFate(String fate_name){
		return session.selectOne("selectEachResultFate", fate_name);
	}

	
}
