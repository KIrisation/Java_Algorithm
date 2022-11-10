package programmers.lv0.day1_9;

public class EvenOddNumberCnt {
    public int[] solution(int[] num_list) {
        int evenCnt = 0; // 짝수
        int oddNumberCnt = 0; // 홀수

        for (int value : num_list) {
            if (value % 2 == 0) {
                evenCnt++;
            } else {
                oddNumberCnt++;
            }
        }
        int[] answer = {evenCnt, oddNumberCnt};
        return answer;
    }

}
