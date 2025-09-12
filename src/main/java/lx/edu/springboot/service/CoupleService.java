package lx.edu.springboot.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lx.edu.springboot.client.GoogleAiClient;
import lx.edu.springboot.dao.CoupleDAO;

import lx.edu.springboot.vo.CoupleResultVO;

@Service
public class CoupleService {
    @Autowired
    GoogleAiClient googleAiClient;

    @Autowired
    CoupleDAO coupleDAO;

    public CoupleResultVO analyzeCouple(String userName, String userBirth, String userGender, String userTime,
                                        String partnerName, String partnerBirth, String partnerGender, String partnerTime) {
        String prompt = String.format("%s,%s, %s, 태어난시간 %s 출생과 %s,%s, %s, 태어난시간 %s 출생의 두사람을 생년월일과 이름 기준 궁합풀이 해줘. "
                + "꼭 순수 JSON만 반환하고, "
                + "필수 키: 종합_궁합_점수, 종합_궁합_총평, 연애운, 동업운."
                + "연애운과 동업운 값은 '점수'를 빼고, 텍스트 설명만 JSON에 포함시켜."
                +"\"정태수_김준하_궁합\": {\r\n"
                + "    \"종합_궁합_점수\": 75,\r\n"
                + "    \"종합_궁합_총평\": \"두 분은 비교적 좋은 조화를 이루는 관계입니다. 서로의 장점을 이해하고 단점을 보완하며 발전적인 관계를 만들어갈 수 있습니다. 다만, 서로의 개성을 존중하고 소통하는 노력이 필요합니다.\",\r\n"
                + "    \"연애운\": {\r\n"
                + "      \"설명\": \"서로에게 호감을 느끼기 쉬운 매력적인 조합입니다. 처음에는 강렬하게 끌리지만, 시간이 지날수록 서로의 차이점을 발견하고 갈등이 발생할 수 있습니다. 서로의 다름을 인정하고 맞춰나가는 노력이 필요하며, 솔직하고 진솔한 대화를 통해 오해를 풀어나가는 것이 중요합니다. 서로를 이해하고 배려하는 마음을 잃지 않는다면, 행복한 연애를 이어갈 수 있을 것입니다.\"\r\n"
                + "    },\r\n"
                + "    \"동업운\": {\r\n"
                + "      \"설명\": \"서로의 강점을 활용하여 시너지 효과를 낼 수 있는 좋은 조합입니다. 정태수님은 추진력과 리더십이 뛰어나고, 김준하님은 꼼꼼하고 분석적인 능력이 뛰어납니다. 서로의 역할을 분담하고 협력한다면 성공적인 결과를 얻을 수 있을 것입니다. 다만, 의사결정 과정에서 의견 충돌이 발생할 수 있으므로, 서로의 의견을 존중하고 합리적인 결정을 내리는 것이 중요합니다.\"\r\n"
                + "    }\r\n"
                + "  } 이렇게 주지말고"
                + "  \"이름1\": \"이정민\",\r\n"
                + "  \"생년월일1\": \"2025-09-11\",\r\n"
                + "  \"성별1\": \"남자\",\r\n"
                + "  \"태어난시간1\": \"축시\",\r\n"
                + "  \"이름2\": \"박지겸\",\r\n"
                + "  \"생년월일2\": \"2025-09-18\",\r\n"
                + "  \"성별2\": \"여자\",\r\n"
                + "  \"태어난시간2\": \"출생시\",\r\n"
                + "  \"종합_궁합_점수\": 78,\r\n"
                + "  \"종합_궁합_총평\": \"두 분은 서로를 이해하고 배려하는 마음이 깊어 안정적인 관계를 유지할 수 있습니다. 서로의 부족한 부분을 채워주며 함께 성장해 나갈 수 있는 좋은 궁합입니다. 다만, 때로는 의견 충돌이 발생할 수 있으니, 서로의 의견을 존중하고 대화를 통해 해결하는 것이 중요합니다.\",\r\n"
                + "  \"연애운\": \"서로에게 편안함과 안정감을 주는 관계입니다. 서로를 아끼고 사랑하는 마음이 깊어 오랫동안 행복한 연애를 이어갈 수 있습니다. 서로의 감정을 솔직하게 표현하고, 작은 일에도 감사하는 마음을 가지면 더욱 좋은 관계를 유지할 수 있습니다.\",\r\n"
                + "  \"동업운\": \"서로의 강점을 살려 시너지 효과를 낼 수 있는 좋은 동업 관계입니다. 이정민님은 리더십과 추진력이 뛰어나고, 박지겸님은 꼼꼼하고 세심한 성격을 가지고 있어 서로 보완적인 역할을 할 수 있습니다. 서로의 의견을 존중하고 협력하면 성공적인 사업 파트너가 될 수 있습니다.\"\r\n"
                + "} 무조건 이렇게 줘 무조건",
                userName, userBirth, userGender, userTime, partnerName,
                partnerBirth, partnerGender, partnerTime);

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

        CoupleResultVO coupleResult = new CoupleResultVO();
        coupleResult.setUserName(userName);
        coupleResult.setPartnerName(partnerName);

        // JSONObject에서 값 추출 시도,
        // 해당 키의 값이 JSONObject가 아니라 문자열인 경우도 optString으로 받음
        int score = obj.optInt("종합_궁합_점수", 0);
        String total = obj.optString("종합_궁합_총평", "정보 없음");
        String love = obj.optString("연애운", "정보 없음");
        String partner = obj.optString("동업운", "정보 없음");

        coupleResult.setScore(score);
        coupleResult.setTotal(total);
        coupleResult.setLove(love);
        coupleResult.setPartner(partner);

        coupleDAO.insertCoupleResult(coupleResult);

        return coupleResult;
    }
}
