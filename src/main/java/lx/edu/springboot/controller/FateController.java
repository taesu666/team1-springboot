package lx.edu.springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import lx.edu.springboot.dao.FateDAO;
import lx.edu.springboot.service.FateService;
import lx.edu.springboot.service.GeminiService;
import lx.edu.springboot.vo.FateInputVO;
import lx.edu.springboot.vo.FateResultVO;

@Controller
public class FateController {

    private final LoginController loginController;

	@Autowired
	FateDAO dao;
	
	@Autowired
	private GeminiService geminiService;
	
	@Autowired
	private FateService fateService;

    FateController(LoginController loginController) {
        this.loginController = loginController;
    }
	
	@RequestMapping("/fate_input_form.do")
	public String fateInputForm() {
		return "fate_input_form";
	}
	
    @RequestMapping("/insert_fate_input.do")
    public String insertInput(FateInputVO inputVO, Model model, HttpServletRequest req) throws Exception {
        System.out.println(inputVO);
        dao.insertInputFate(inputVO);

        FateResultVO resultVO = fateService.fateGenerate(inputVO);      
        model.addAttribute("resultVO", resultVO);
        
        req.getSession().setAttribute("maxFive", resultVO.getMaxFive());
        req.getSession().setAttribute("userName", resultVO.getUserName());

 		req.setAttribute("detail", resultVO.getLove());
		return "fate_result_form";
	}

    
	// 사주 목록
	@RequestMapping("/list_fate.do")
	public String list(HttpServletRequest req) throws Exception {
	    List<FateResultVO> list = dao.getFateList();
    req.setAttribute("result", list);
	    return "list_fate";  
	}


	// 사주 목록
	@RequestMapping("/conversation_list_fate.do")
	public String list2(HttpServletRequest req) throws Exception {
	    List<FateResultVO> list = dao.getFateList();
    req.setAttribute("result", list);
	    return "/conversation_list_fate";  
	}

	
	@GetMapping("/select.do")
	public String form() {
	    return "select";
	}

	

	
}
