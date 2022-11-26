package programmers.lv0.day24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AConvertToB {

    public static void main(String[] args) {
        System.out.println(solution("allpe", "apple"));
    }

    public static int solution(String before, String after) {
        String[] splitBefore = before.split("");
        Map<String, Integer> beforeMap = new HashMap<>();
        for (String s : splitBefore) {
            if (beforeMap.containsKey(s)) {
                beforeMap.put(s, beforeMap.get(s) + 1);
                continue;
            }

            beforeMap.put(s, 1);
        }

        String[] splitAfter = after.split("");
        Map<String, Integer> afterMap = new HashMap<>();
        for (String s : splitAfter) {
            if (afterMap.containsKey(s)) {
                afterMap.put(s, afterMap.get(s) + 1);
                continue;
            }

            afterMap.put(s, 1);
        }

        for (int i = 0; i < before.length(); i++) {
            if (beforeMap.get(splitBefore[i]) != afterMap.get(splitBefore[i])) {
                return 0;
            }
        }

        return 1;
    }

    public int solution2(String before, String after) {
        char[] a = before.toCharArray();
        char[] b = after.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        return new String(a).equals(new String(b)) ? 1 :0;
    }
}