package programmers.lv0.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 옹알이 (1)
 *
 * 문제 설명
 * 머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다.
 * 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음을 최대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다.
 * 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 1 ≤ babbling의 길이 ≤ 100
 * 1 ≤ babbling[i]의 길이 ≤ 15
 * babbling의 원소에서 "aya", "ye", "woo", "ma"는 각각 최대 한 번씩만 등장합니다.
 * 문자열은 알파벳 소문자로만 이루어져 있습니다.
 *
 * 입출력 예
 * babbling	result
 * ["aya", "yee", "u", "maa", "wyeoo"]	1
 * ["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]	3
 */
public class Babbling {
    public static String[] AVAILABLE_DICTION = {"aya", "ye", "woo", "ma"};
    public static List<String> ALL_DICTION = new ArrayList<>();

    public static void main(String[] args) {
        solution(null);
    }

    public static int solution(String[] babbling) {
        int answer = 0;

        boolean[] check = new boolean[4];

        Arrays.fill(check, false);

        makeAllDiction(check, "");

        for (String diction : babbling) {
            if (ALL_DICTION.contains(diction)) {
                ++answer;
            }
        }

        return answer;
    }

    private static void makeAllDiction(boolean[] check, String str) {
        if (!str.equals("")) {
            ALL_DICTION.add(str);
        }

        for (int i = 0; i < AVAILABLE_DICTION.length; ++i) {
            if (!check[i]) {
                check[i] = true;
                makeAllDiction(check, str + AVAILABLE_DICTION[i]);
                check[i] = false;
            }
        }
    }

    public int solution2(String[] babbling) {
        int answer = 0;


        for (String diction : babbling) {
            for (String avaDiction : AVAILABLE_DICTION) {
                diction = diction.replace(avaDiction, "*");
            }


            if (diction.replace("*", "").equals("")) {
                ++answer;
            }
        }

        return answer;
    }
}


