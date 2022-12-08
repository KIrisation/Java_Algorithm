package programmers.lv1;

/**
 * 소수 만들기
 * 문제 설명
 * 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때,
 * nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
 * nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
 *
 * 입출력 예
 * nums	result
 * [1,2,3,4]	1
 * [1,2,7,6,4]	4
 *
 * 입출력 예 설명
 * 입출력 예 #1
 * [1,2,4]를 이용해서 7을 만들 수 있습니다.
 *
 * 입출력 예 #2
 * [1,2,4]를 이용해서 7을 만들 수 있습니다.
 * [1,4,6]을 이용해서 11을 만들 수 있습니다.
 * [2,4,7]을 이용해서 13을 만들 수 있습니다.
 * [4,6,7]을 이용해서 17을 만들 수 있습니다.
 *
 * 생각 해야 할 점.
 * 1. 3개의 수를 더했을 때 소수가 되는 경우를 확인 해야한다.
 *  - 3개의 수를 구한다.
 *  - 3개의 수를 더한다.
 *  - 더한 값이 소수인지 확인한다.
 *  - 더한 값이 소수라면 카운팅한다.
 *  - 더한 값이 소수가 아니라면 카운팅하지 않는다.
 *  - 3개의 수는 중복되는 숫자가 없다.(Set 의 사용이 필요 없다.)
 * 2. nums 배열에는 총 50개의 숫자가 들어올 수 있다.
 */
public class MakePrimeNumber {

    public static void main(String[] args) {

    }

    public static int solution(int[] nums) {
        int answer = 0;

        for (int firstNumber = 0; firstNumber < nums.length - 2; firstNumber++) {
            for (int secondNumber = firstNumber + 1; secondNumber < nums.length - 1; secondNumber++) {
                for (int thirdNumber = secondNumber + 1; thirdNumber < nums.length; thirdNumber++) {
                    if (isPrime(nums[firstNumber], nums[secondNumber], nums[thirdNumber])) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    private static boolean isPrime(int firstNumber, int secondNumber, int thirdNumber) {
        int sum = firstNumber + secondNumber + thirdNumber;

        for(int i = 2; i * i <= sum; i++) {
            if(sum % i == 0) {
                return false;
            }
        }

        return true;
    }
}
