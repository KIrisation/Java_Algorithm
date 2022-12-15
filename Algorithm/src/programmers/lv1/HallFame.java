package programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class HallFame {

    public static int[] solution(int k, int[] score) {
        int[] result = new int[score.length];
        List<Integer> fame = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            if (i < k - 1) {
                fame.add(score[i]);
                fame.sort(Collections.reverseOrder());
                result[i] = fame.get(fame.size() - 1);

            } else if (i >= k - 1) {
                fame.add(score[i]);
                fame.sort(Collections.reverseOrder());
                result[i] = fame.get(k - 1);
            }
        }

        return result;
    }

    public static int[] solution2(int k, int[] score) {
        int[] answer = new int[score.length];

        Queue<Integer> fame = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {

            fame.add(score[i]);

            if (fame.size() > k) {
                fame.poll();
            }

            answer[i] = fame.peek();
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(3, new int[]{10, 100, 20, 150, 1, 100, 200});
    }
}
