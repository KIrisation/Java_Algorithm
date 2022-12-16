package programmers.lv1.kakao;

import java.util.HashMap;
import java.util.Map;

/**
 * 매우 동의나 매우 비동의 선택지를 선택하면 3점을 얻습니다. 동의나 비동의 선택지를 선택하면 2점을 얻습니다. 약간 동의나 약간 비동의 선택지를 선택하면 1점을 얻습니다. 모르겠음 선택지를 선택하면 점수를 얻지
 * 않습니다.
 * <p>
 * 하나의 지표에서 각 성격 유형 점수가 같으면, 두 성격 유형 중 사전 순으로 빠른 성격 유형을 검사자의 성격 유형이라고 판단합니다.
 * <p>
 * survey[i]의 첫 번째 캐릭터는 i+1번 질문의 비동의 관련 선택지를 선택하면 받는 성격 유형을 의미합니다. survey[i]의 두 번째 캐릭터는 i+1번 질문의 동의 관련 선택지를 선택하면 받는 성격
 * 유형을 의미합니다.
 * <p>
 * choices의 길이 = survey의 길이
 * <p>
 * choices[i]는 검사자가 선택한 i+1번째 질문의 선택지를 의미합니다. 1 ≤ choices의 원소 ≤ 7
 * <p>
 * 입출력 예 survey	choices	result ["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA" ["TR", "RT", "TR"]	[7, 1,
 * 3]	"RCJA"
 */
public class CheckPersonalityType {

    public static void main(String[] args) {
    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> types = new HashMap<>();

        // 타입 1
        types.put('R', 0);
        types.put('T', 0);

        // 타입 2
        types.put('C', 0);
        types.put('F', 0);

        // 타입 3
        types.put('J', 0);
        types.put('M', 0);

        // 타입 4
        types.put('A', 0);
        types.put('N', 0);

        int prevIdx = 0;
        int nextIdx = 1;

        for (int i = 0; i < survey.length; i++) {
            if (choices[i] < 4) {
                int score = choices[i];
                types.compute(survey[i].charAt(prevIdx), (k, v) -> v == 0 ? Math.abs(score - 4) : v + Math.abs(score - 4));
            }

            if (choices[i] > 4) {
                int score = choices[i];
                types.compute(survey[i].charAt(nextIdx), (k, v) -> v == 0 ? score - 4 : v + (score - 4));
            }
        }

        if (types.get('R') >= types.get('T')) {
            answer += 'R';
        } else {
            answer += 'T';
        }

        if (types.get('C') >= types.get('F')) {
            answer += 'C';
        } else {
            answer += 'F';
        }

        if (types.get('J') >= types.get('M')) {
            answer += 'J';
        } else {
            answer += 'M';
        }

        if (types.get('A') >= types.get('N')) {
            answer += 'A';
        } else {
            answer += 'N';
        }

        return answer;
    }
}
