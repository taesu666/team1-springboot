package lx.edu.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lx.edu.springboot.dao.FateDAO;
import lx.edu.springboot.service.GeminiService;
import lx.edu.springboot.vo.FateInputVO;
import lx.edu.springboot.vo.FateResultVO;

@Controller
public class FateController {

	@Autowired
	FateDAO dao;
	
	@Autowired
	private GeminiService geminiService;
	
	@RequestMapping("/fate_input_form.do")
	public String fateInputForm() {
		return "fate_input_form";
	}
	
    @RequestMapping("/insert_fate_input.do")
    public String insertInput(FateInputVO inputVO, HttpServletRequest req) throws Exception {
        System.out.println(inputVO);
        dao.insertInputFate(inputVO);

        String prompt = String.format(
                "사용자 이름: %s, 생년월일: %s, 시간: %s, 성별: %s를 기반으로 오행 몇개인지랑, 총운, 건강운, 직업운, 연애운, 재물운 사주를 분석해줘.",
                inputVO.getUserName(),
                inputVO.getUserBirth(),
                inputVO.getUserTime(),
                inputVO.getUserGender()
        );

        // Google AI 호출
        String aiResult = geminiService.generate(prompt);

        FateResultVO resultVO = new FateResultVO();
        resultVO.setUserName(inputVO.getUserName());
        resultVO.setTotal(aiResult);

        // 오행, 연애운.. 이런거 각각 어떻게 담을지 고민고민중
        // 아직 테스트 안해봄
        
        // 모델에 담아서 insert_fate_result.do로 넘김
        req.setAttribute("resultVO", resultVO);

        return "forward:/insert_fate_result.do"; 
    }


    @RequestMapping("/insert_fate_result.do")
    public String insertResult(FateResultVO resultVO) throws Exception {
        dao.insertResultFate(resultVO);
        return "fate_result_form";
    }
    
	
	@RequestMapping("/fate_result_form.do")
	public String fateResultForm() {
		return "fate_result_form";
	}
	
	@RequestMapping("/gemini.do")
	public String home() {
		return "gemini";
	}
	
}
