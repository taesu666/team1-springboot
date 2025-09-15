package lx.edu.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import lx.edu.springboot.dao.CoupleDAO;
import lx.edu.springboot.dao.PartnerDAO;
import lx.edu.springboot.service.CoupleService;
import lx.edu.springboot.vo.CoupleInputVO;
import lx.edu.springboot.vo.CoupleResultVO;

import lx.edu.springboot.vo.FateResultVO;

import lx.edu.springboot.vo.PartnerVO;


@Controller
public class CoupleController {
	@Autowired
	CoupleService coupleService;

	@Autowired
	CoupleDAO cdao;
	
	@Autowired
	PartnerDAO pdao;
	


	@GetMapping("/coupleinput")
	public String showInput(Model model) {
		// DAO 직접 호출해서 partner 리스트 가져오기
		List<PartnerVO> partners = pdao.getAllPartners();

		// 모델에 partner 리스트 담기
		model.addAttribute("partners", partners);

		return "couple_input"; // 뷰 이름

	}

	@PostMapping("/coupleInputInsert")
	public String inputInsert(CoupleInputVO civ, Model model) {
		// 1. 입력값 DB 저장
		cdao.insertCoupleInput(civ);

		// 2. Gemini API로 궁합 분석
		CoupleResultVO result = coupleService.analyzeCouple(civ.getUserName(), civ.getUserBirth(), civ.getUserGender(),
				civ.getUserTime(), civ.getPartnerName(), civ.getPartnerBirth(), civ.getPartnerGender(),
				civ.getPartnerTime());

		// 3. 결과 화면에 전달
		model.addAttribute("result", result);

		// 4. 결과도 DB에 저장 (서비스에서 이미 수행중)
		// coupleResultDAO.insertCoupleResult(result); // 이미 service에서 처리

		return "couple_result";
	}


	// 사주 목록
	@RequestMapping("/list_couple.do")
	public String list(HttpServletRequest req) throws Exception {
	    List<CoupleResultVO> list = cdao.getCoupleList();
	    req.setAttribute("result", list);
	    return "list_couple";  
	}
    	    

    	
   
    


	@RequestMapping("/conversation_list_couple.do")
	public String list2(HttpServletRequest req) throws Exception {
	    List<CoupleResultVO> list = cdao.getCoupleList();
	    req.setAttribute("result", list);
	    return "/conversation_list_couple";  
	}
    	    


}

