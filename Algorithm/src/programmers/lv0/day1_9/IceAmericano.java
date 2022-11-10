package programmers.lv0.day1_9;

import java.util.HashMap;
import java.util.Map;

/**
 * 머쓱이는 추운 날에도 아이스 아메리카노만 마십니다.
 * 아이스 아메리카노는 한잔에 5,500원입니다. 머쓱이가 가지고 있는 돈 money가 매개변수로 주어질 때, 머쓱이가 최대로 마실 수 있는 아메리카노의 잔 수와
 * 남는 돈을 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
 */
public class IceAmericano {

    public static final int ICE_AMERICANO = 5_500;

    public static void main(String[] args) {
        solution(5500);
    }

    private static int[] solution(int price) {
        int[] answer = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        int americanoCnt = price / ICE_AMERICANO;
        int changeMoney = price % ICE_AMERICANO;

        if (americanoCnt == 0) {
            map.put(0, price);
        } else {
            map.put(americanoCnt, changeMoney);
        }

        map.forEach((key, value) -> {
            answer[0] = key;
            answer[1] = value;
        });

        return answer;
    }

}
