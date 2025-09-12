package lx.edu.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import lx.edu.springboot.dao.FateDAO;
import lx.edu.springboot.service.FateService;
import lx.edu.springboot.service.GeminiService;
import lx.edu.springboot.vo.FateInputVO;
import lx.edu.springboot.vo.FateResultVO;

@Controller
public class FateController {

	@Autowired
	FateDAO dao;
	
	@Autowired
	private GeminiService geminiService;
	
	@Autowired
	private FateService fateService;
	
	@RequestMapping("/fate_input_form.do")
	public String fateInputForm() {
		return "fate_input_form";
	}
	
    @RequestMapping("/insert_fate_input.do")
    public String insertInput(FateInputVO inputVO, HttpServletRequest req) throws Exception {
        System.out.println(inputVO);
        dao.insertInputFate(inputVO);

        FateResultVO resultVO = fateService.fateGenerate(inputVO);      
        req.setAttribute("resultVO", resultVO);

        return "forward:/insert_fate_result.do"; 
    }


    @RequestMapping("/insert_fate_result.do")
    public String insertResult(FateResultVO resultVO, HttpServletRequest req) throws Exception {
        dao.insertResultFate(resultVO);
        req.setAttribute("id", resultVO.getResultFateId());
        return "fate_result_form";
    }
    
	
	@RequestMapping("/fate_result_form.do")
	public String fateResultForm(Integer id, HttpServletRequest req) throws Exception {
		id = 1;
		FateResultVO resultVO = dao.selectResultFate(id);
		req.setAttribute("resultVO", resultVO);
		req.setAttribute("detail", resultVO.getLove());
		return "fate_result_form";
	}
	
	@RequestMapping("/fate_detail.do")
	public String fateDetail(@RequestParam("fateOption") String type, HttpServletRequest req) {
	    FateResultVO result = dao.selectResultFate(1);
	    
	    String detail = "";
	    switch (type) {
	        case "love":
	            detail = result.getLove();
	            break;
	        case "health":
	            detail = result.getHealth();
	            break;
	        case "money":
	            detail = result.getMoney();
	            break;
	        case "job":
	            detail = result.getJob();
	            break;
	    }
	    
	    // detail 저장
	    req.setAttribute("resultVO", result);
	    req.setAttribute("detail", detail);
	    
	    // redirect 말고 forward
	    return "fate_result_form"; 
	}

	
	@RequestMapping("/gemini.do")
	public String home() {
		return "gemini";
	}
	
}
