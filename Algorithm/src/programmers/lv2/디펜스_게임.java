package programmers.lv2;

import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/142085
 */
public class 디펜스_게임 {

    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });

        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pq.offer(enemy[i]);

            if (n < 0) {
                if(k != 0 && !pq.isEmpty()) {
                    --k;
                    n += pq.poll();
                } else {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }
}
