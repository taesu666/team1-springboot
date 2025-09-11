package lx.edu.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lx.edu.springboot.dao.FateDAO;
import lx.edu.springboot.vo.FateInputVO;

@Controller
public class FateController {

	@Autowired
	FateDAO dao;
	
	@RequestMapping("/fate_input_form.do")
	public String fateInputForm() {
		return "fate_input_form";
	}
	
	@RequestMapping("/insert_fate_input.do")
	public String insert(FateInputVO vo) throws Exception {
		System.out.println(vo);
		dao.insertInputFate(vo);
		//여기서 insertResultFate()까지 실행
		return "insert_result_form";
	}
	
	@RequestMapping("/fate_result_form.do")
	public String fateResultForm() {
		return "fate_result_form";
	}

	
}
