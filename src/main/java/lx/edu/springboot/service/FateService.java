package lx.edu.springboot.service;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lx.edu.springboot.client.GoogleAiClient;
import lx.edu.springboot.dao.FateDAO;
import lx.edu.springboot.vo.FateInputVO;
import lx.edu.springboot.vo.FateResultVO;

@Service
public class FateService {
	
    @Autowired
    GoogleAiClient googleAiClient;
	
	@Autowired
	FateDAO fateResultDAO;
	
    public FateResultVO fateGenerate(FateInputVO inputVO) {
    	String prompt = String.format(
                "사용자 이름: %s, 생년월일: %s, 시간: %s, 성별: %s를 기반으로 오행 몇개인지랑, 총운, 건강운, 직업운, 연애운, 재물운 사주를 분석해줘."
                		+ "꼭 순수 JSON만 반환하고, "
                        + "필수 키: 목_개수, 화_개수, 토_개수, 금_개수, 수_개수, 총운, 건강운, 직업운, 연애운, 재물운.",
                inputVO.getUserName(),
                inputVO.getUserBirth(),
                inputVO.getUserTime(),
                inputVO.getUserGender()
        );

        
        String aiResultRaw = googleAiClient.getCoupleAnalysis(prompt);

     // 코드블록 제거
        String aiResult = aiResultRaw.replaceAll("```json", "")
                                   .replaceAll("```", "")
                                   .trim();

        System.out.println("Cleaned AI Response: " + aiResult);

        if (aiResult == null || !aiResult.trim().startsWith("{")) {
            throw new RuntimeException("Invalid JSON response from AI client: " + aiResultRaw);
        }

        JSONObject json = new JSONObject(aiResult);

        String coupleKey = json.keySet().iterator().next();
        Object val = json.get(coupleKey);

        JSONObject obj;

        if (val instanceof JSONObject) {
            obj = (JSONObject) val;
        } else {
            // 최상위 키 값이 JSONObject가 아닐 경우 (예: 문자열 등), JSON 객체로 간주
            obj = json;
        }
        
        FateResultVO fateResult = new FateResultVO();
        fateResult.setUserName(inputVO.getUserName());

     // JSONObject에서 값 추출 시도,
        // 해당 키의 값이 JSONObject가 아니라 문자열인 경우도 optString으로 받음
        int tree = obj.optInt("목_개수", 0);
        int fire = obj.optInt("화_개수", 0);
        int soil = obj.optInt("토_개수", 0);
        int steel = obj.optInt("금_개수", 0);
        int water = obj.optInt("수_개수", 0);
        String total = obj.optString("총운", "정보 없음");
        String health = obj.optString("건강운", "정보 없음");
        String job = obj.optString("직업운", "정보 없음");
        String love = obj.optString("연애운", "정보 없음");
        String money = obj.optString("재물운", "정보 없음");

        fateResult.setTree(tree);
        fateResult.setFire(fire);
        fateResult.setSoil(soil);
        fateResult.setSteel(steel);
        fateResult.setWater(water);
        fateResult.setTotal(total);
        fateResult.setHealth(health);
        fateResult.setJob(job);
        fateResult.setLove(love);
        fateResult.setMoney(money);

        fateResultDAO.insertResultFate(fateResult);

        return fateResult;
    }
}
