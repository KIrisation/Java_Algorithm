package programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class KnightWeapons {

    public static void main(String[] args) {
        solution(10, 3, 2);
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;
        List<Integer> weapons = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            int sqrt = (int) Math.sqrt(i);

            for (int j = 1; j <= sqrt; j++) {
                if (i % j == 0) {
                    weapons.add(j);

                    if (i / j != j) {
                        weapons.add(i / j);
                    }
                }
            }

            if (weapons.size() > limit) {
                answer += power;
                continue;
            }

            answer += weapons.size();
        }

        return answer;
    }
}
