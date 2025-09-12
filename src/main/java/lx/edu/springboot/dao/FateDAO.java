package lx.edu.springboot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lx.edu.springboot.vo.FateInputVO;
import lx.edu.springboot.vo.FateResultVO;

@Repository
public class FateDAO {
	
	@Autowired
	SqlSession session;
		
	public int insertInputFate(FateInputVO input_fate){
		return session.insert("insertInputFate", input_fate);
	}
	
	public int insertResultFate(FateResultVO result_fate){
		return session.insert("insertResultFate", result_fate);
	}

	public FateResultVO selectResultFate(int inputId){
		return session.selectOne("selectResultFate", inputId);
	}

	
}
