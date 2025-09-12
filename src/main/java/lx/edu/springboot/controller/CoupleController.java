package lx.edu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model; 
import lx.edu.springboot.dao.CoupleInputDAO;
import lx.edu.springboot.dao.CoupleResultDAO;
import lx.edu.springboot.service.CoupleService;
import lx.edu.springboot.vo.CoupleInputVO;
import lx.edu.springboot.vo.CoupleResultVO;
@Controller
public class CoupleController {
    @Autowired CoupleService coupleService;
    
    @Autowired
    CoupleResultDAO crd;
    @Autowired
    CoupleInputDAO cid;
    
    @GetMapping("/coupleinput")
    public String showInput() { 
    	return "couple_input"; 
    	}

    @PostMapping("/coupleInputInsert")
    public String inputInsert(CoupleInputVO civ, Model model) {
        // 1. 입력값 DB 저장
        cid.insertCoupleInput(civ);

        
        // 2. Gemini API로 궁합 분석
        CoupleResultVO result = coupleService.analyzeCouple(
            civ.getUserName(), civ.getUserBirth(), civ.getUserGender(), civ.getUserTime(),
            civ.getPartnerName(), civ.getPartnerBirth(), civ.getPartnerGender(), civ.getPartnerTime()
        );

        // 3. 결과 화면에 전달
        model.addAttribute("result", result);

        // 4. 결과도 DB에 저장 (서비스에서 이미 수행중)
        // coupleResultDAO.insertCoupleResult(result); // 이미 service에서 처리

        return "couple_result";
    }

}

