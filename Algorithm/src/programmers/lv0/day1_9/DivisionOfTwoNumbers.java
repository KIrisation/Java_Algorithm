package programmers.lv0.day1_9;

/**
 * 정수 num1과 num2가 매개변수로 주어질 때,
 * num1을 num2로 나눈 값에 1,000을 곱한 후
 * 정수 부분을 return 하도록 soltuion 함수를 완성해주세요.
 */
public class DivisionOfTwoNumbers {
    public static void main(String[] args) {
        System.out.println(solution(3, 2));
        System.out.println(solution(7, 3));
        System.out.println(solution(1, 16));
    }

    private static int solution(int num1, int num2) {
        StringBuilder builder = new StringBuilder();
        String divisionOfTwoNumbersToString = String.valueOf((double) num1 / num2);

        if (divisionOfTwoNumbersToString.length() < 5) {
            for (int i = 0; i < divisionOfTwoNumbersToString.length(); i++) {
                builder.append(divisionOfTwoNumbersToString.charAt(i));
            }
        } else {
            for (int i = 0; i < 5; i++) {
                builder.append(divisionOfTwoNumbersToString.charAt(i));
            }
        }
        double doubleValue = Double.parseDouble(String.valueOf(builder)) * 1000;
        return (int) doubleValue;
    }
}
