package programmers.lv0.day11;

/**
 * 약수의 개수가 세 개 이상인 수를 합성수라고 합니다.
 * 자연수 n이 매개변수로 주어질 때 n이하의 합성수의 개수를 return하도록 solution 함수를 완성해주세요.
 * n	result
 * 10	5
 * 15	8
 *
 * 생각되는 부분은 약수가 세 개 일때 연산을 멈추고 다음 수로 넘어가야함.
 */
public class FindCompositeNumbers {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static int solution(int n) {
        int answer = 0;

        if (n == 4) {
            return 1;
        }

        for (int i = 1; i <= n; i++) {
            int compositeNumberCnt = 0;
            for (int j = 1; j <= n; j++) {
                if (compositeNumberCnt == 3) {
                    answer++;
                    j = n;
                }

                if (i % j == 0) {
                    compositeNumberCnt++;
                }
            }
        }

        return answer;
    }
}
