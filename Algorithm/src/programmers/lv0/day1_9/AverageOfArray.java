package programmers.lv0.day1_9;

/**
 * 정수 배열 numbers 가 매개변수로 주어집니다.
 * numbers 의 원소의 평균값을 return 하도록 solution 함수를 완성해주세요.
 */

public class AverageOfArray {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        double solution = solution(numbers);
        System.out.println(3.0/2.0);
    }
    public static double solution(int[] numbers) {
        double answer = 0;
        for (int number : numbers) {
            answer += number;
        }
        return answer / numbers.length;
    }
}
