package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class 기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> daysQueue = new LinkedList<>();

        // 각 작업이 완료되는 데 필요한 일수 계산
        for (int i = 0; i < progresses.length; i++) {
            int remainingWork = 100 - progresses[i];
            int daysRequired = (int) Math.ceil((double) remainingWork / speeds[i]);
            daysQueue.offer(daysRequired);
        }

        List<Integer> releaseCounts = new ArrayList<>();

        while (!daysQueue.isEmpty()) {
            int currentDay = daysQueue.poll();
            int count = 1;

            // 현재 작업이 완료될 때까지 기다려야 하는 작업들 확인
            while (!daysQueue.isEmpty() && daysQueue.peek() <= currentDay) {
                count++;
                daysQueue.poll();
            }

            releaseCounts.add(count);
        }

        // 결과를 배열로 변환하여 반환
        int[] answer = new int[releaseCounts.size()];
        for (int i = 0; i < releaseCounts.size(); i++) {
            answer[i] = releaseCounts.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        기능개발 solution = new 기능개발();
        solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
    }
}