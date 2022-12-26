package programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Camouflage {

    public static void main(String[] args) {
        solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban",
                "headgear"}});
    }

    public static int solution(String[][] clothes) {
        int sizeValue = 1;
        Map<String, List<String>> map = new HashMap<>();

        for (String[] clothe : clothes) {
            if (!map.containsKey(clothe[1])) {
                map.put(clothe[1], new ArrayList<>(List.of(clothe[0])));
            } else {
                List<String> findToMap = map.get(clothe[1]);
                findToMap.add(clothe[0]);
                map.put(clothe[1], findToMap);
            }
        }

        for (List<String> value : map.values()) {
            sizeValue *= (value.size() + 1); // + 1 을 한 이유? 안 입는 경우를 추가 한 것이다.
        }

        return sizeValue - 1; // - 1 을 한 이유? 단 하나의 종류도 입지 않았을 경우를 제외한다.
    }

    public static int solution2(String[][] clothes) {
        int sizeValue = 1;
        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            map.compute(clothe[1], (k,v) -> v == null ? 1 : ++v);
        }

        for (Integer value : map.values()) {
            sizeValue *= (value + 1); // + 1 을 한 이유? 안 입는 경우를 추가 한 것이다.
        }

        return sizeValue - 1; // - 1 을 한 이유? 단 하나의 종류도 입지 않았을 경우를 제외한다.
    }
}
