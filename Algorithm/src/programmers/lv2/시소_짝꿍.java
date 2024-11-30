package programmers.lv2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 시소_짝꿍 {

    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<BigDecimal, Integer> map = new HashMap<>();

        for (int weight : weights) {
            BigDecimal caseA = BigDecimal.valueOf(weight * 1.0);
            BigDecimal caseB = BigDecimal.valueOf((weight * 2.0) / 3.0);
            BigDecimal caseC = BigDecimal.valueOf((weight * 1.0) / 2.0);
            BigDecimal caseD = BigDecimal.valueOf((weight * 3.0) / 4.0);

            if (map.containsKey(caseA)) {
                answer += map.get(caseA);
            }

            if (map.containsKey(caseB)) {
                answer += map.get(caseB);
            }

            if (map.containsKey(caseC)) {
                answer += map.get(caseC);
            }

            if (map.containsKey(caseD)) {
                answer += map.get(caseD);
            }

            map.put(BigDecimal.valueOf((weight * 1.0)), map.getOrDefault(BigDecimal.valueOf(weight * 1.0) , 0));
        }

        return answer;
    }
}
