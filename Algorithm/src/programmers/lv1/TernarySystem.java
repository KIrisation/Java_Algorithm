package programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 3진법 뒤집기 문제 설명 자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
 * <p>
 * 제한사항 n은 1 이상 100,000,000 이하인 자연수입니다. 입출력 예 n	result 45	7 125	229 입출력 예 설명 입출력 예 #1
 * <p>
 * 답을 도출하는 과정은 다음과 같습니다. n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현 45	1200	0021
 */
public class TernarySystem {

    public static void main(String[] args) {
        System.out.println(solution(125));
    }
    public static int solution(int n) {
        String nToTernary = Integer.toString(n, 3);
        List<Character> reverseTernary = new ArrayList<>();

        for (int i = 0; i < nToTernary.length(); i++) {
            reverseTernary.add(nToTernary.charAt(i));
        }

        Collections.reverse(reverseTernary);
        String result = "";
        for (Character character : reverseTernary) {
            result += character;
        }

        return Integer.parseInt(result, 3);
    }
}
