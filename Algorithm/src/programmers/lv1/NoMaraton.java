package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

class NoMaraton {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participants = new HashMap<>();

        for (String value : participant) {
            participants.compute(value, (k, v) -> (v == null) ? 1 : ++v);
        }

        for (String s : completion) {
            participants.put(s, participants.get(s) - 1);
        }

        return participants.keySet()
                           .stream()
                           .filter(i -> participants.get(i) > 0)
                           .findFirst()
                           .orElse(null);
    }
}
