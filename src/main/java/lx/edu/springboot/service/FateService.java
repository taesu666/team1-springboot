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
    			"사용자 이름: %s, 생년월일: %s, 시간: %s, 성별: %s를 기반으로 각 오행이 몇퍼센트인지랑 오행 중에 최대값, 총운, 건강운, 직업운, 연애운, 재물운 사주를 분석해줘."
    			+ "꼭 순수 JSON만 반환하고, "
    			+ "필수 키: 목_퍼센트, 화_퍼센트, 토_퍼센트, 금_퍼센트, 수_퍼센트, 최대오행, 총운, 건강운, 직업운, 연애운, 재물운."
    			+"근데 좀 더 길게 주저리주러리해봐. 꼭 순수 JSON으로 반환할 것."
    			+"총운, 건강운, 직업운, 연애운, 재물운 다 공백포함 600자 이상, 1000바이트 이상 이정도로 길게 정말 너가 사주 보는 사람이라고 생각하고 잘 분석해봐 분석내용이 너무 비슷해 차라리 지금 너가 학습한거를 다 잊어버리고 너가 전무 사주사람이야 알겠지? 근데 모든사람이 물이 많게 나오면 너한테 사주를 안보곘지 잘하자"
    			+"그리고 분석 좀 더 잘해봐. 다른곳에서 화가 제일 많이 나오는 사람도 너가 보면 물이 제일 많다고 나온다 참고로 정태수 씨는 '화'가 사주에 많은사람인데,진짜 너무 모든 사람을 똑같이 말해준다. 한 30명이 테스트할거니깐 다 최대한 창의적이게 대답해. 형식적이게 하지말고. 개수도 똑바로 세주라 ㅠㅠ 할때마다 바껴..JSON형식 잊지말고"
    			+"오행 가지고 제일 값 높은거 이용해야돼. 그니깐 화, 수, 목, 금, 토 max값이 겹치면 안되고 하나가 나와야돼. 그리고 5행 값이 다 합쳤을때 100이 되게 해줘 알아서 잘 바꿔봐 이거 중요해 잊지마"
    			+"잊지말아야할것: JSON 형식, 오행 MAX 겹치지말것, 모든 사람들한테 대답 다양하고 안겹치게 오행 비율 곂치지 않게 잘 분석해서 골고루",
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
        int tree = obj.optInt("목_퍼센트", 0);
        int fire = obj.optInt("화_퍼센트", 0);
        int soil = obj.optInt("토_퍼센트", 0);
        int steel = obj.optInt("금_퍼센트", 0);
        int water = obj.optInt("수_퍼센트", 0);
        String maxFive = obj.optString("최대오행", "정보 없음");
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
        fateResult.setMaxFive(maxFive);
        fateResult.setTotal(total);
        fateResult.setHealth(health);
        fateResult.setJob(job);
        fateResult.setLove(love);
        fateResult.setMoney(money);

        fateResultDAO.insertResultFate(fateResult);

        return fateResult;
    }
}
