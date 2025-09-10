package lx.edu.springboot.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lx.edu.springboot.vo.AddrBookVO;

@SpringBootTest
public class AddrBookDAOTestcase {

	@Autowired
	AddrBookDAO dao;
		
	@Test
	public void testGetDBList() {
		List<AddrBookVO> list = dao.getDBList();
		assertEquals(list.size()>0, true);
	}
	
}
