package programmers.lv0.day1_9;

/**
 * 첫 번째 분수의 분자와 분모를 뜻하는 denum1, num1,
 * 두 번째 분수의 분자와 분모를 뜻하는 denum2, num2가 매개변수로 주어집니다.
 * 두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을
 * return 하도록 solution 함수를 완성해보세요.
 */
public class AdditionOfFractions {
    public static void main(String[] args) {
        solution(1, 2, 3 , 4);

    }

    public static int[] solution(int denum1, int num1, int denum2, int num2) {
        int[] answer = {(denum1 * num2) + (denum2 * num1) ,num1 * num2};

        int i = 2; // 1 로 나눈 값은 필요없다. 2 부터 시작한다.

        while (num1 * num2 >= i) {
            if (answer[0] % i == 0 && answer[1] % i == 0) {
                answer[0] = answer[0] / i;
                answer[1] = answer[1] / i;
                continue;
            }
            i++;
        }

        return answer;
    }
}
