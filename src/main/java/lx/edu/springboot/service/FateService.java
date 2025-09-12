package lx.edu.springboot.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lx.edu.springboot.client.GoogleAiClient;
import lx.edu.springboot.vo.FateInputVO;
import lx.edu.springboot.vo.FateResultVO;

@Service
public class FateService {
	
	@Autowired
	private GeminiService geminiService;
	
    public FateResultVO fateGenerate(FateInputVO inputVO) {
    	String prompt = String.format(
                "사용자 이름: %s, 생년월일: %s, 시간: %s, 성별: %s를 기반으로 오행 몇개인지랑, 총운, 건강운, 직업운, 연애운, 재물운 사주를 분석해줘.",
                inputVO.getUserName(),
                inputVO.getUserBirth(),
                inputVO.getUserTime(),
                inputVO.getUserGender()
        );

        
        String aiResult = geminiService.generate(prompt);

        FateResultVO resultVO = new FateResultVO();
        resultVO.setUserName(inputVO.getUserName());
        resultVO.setTotal(aiResult);
        
        return resultVO;
    }
}
