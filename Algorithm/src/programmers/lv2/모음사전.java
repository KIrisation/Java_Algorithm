package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class 모음사전 {
    static Map<String, Integer> dic = new HashMap<>();
    static int num = 1;
    public int solution(String word) {
        String[] alphabets = {"A", "E", "I", "O", "U"};
        StringBuilder s = new StringBuilder();
        dfs(alphabets, s);

        return dic.get(word);
    }

    public void dfs(String[] alphabets, StringBuilder s) {
        if (s.length() > 5) {
            return;
        }

        for (int i = 0; i < alphabets.length; i++) {
            s.append(alphabets[i]);// 문자 추가
            dic.put(s.toString(), num);
            dfs(alphabets, s);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
