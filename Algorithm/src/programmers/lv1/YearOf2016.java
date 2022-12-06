package programmers.lv1;

/**
 * 2016년 문제 설명 2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
 * 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT
 * <p>
 * 입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.
 * <p>
 * 제한 조건 2016년은 윤년입니다. 2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다) 입출력 예 a	b	result 5	24	"TUE"
 * <p>
 * 생각해야 할 점.
 * 1. 순회 방법을 모색한다.
 */
public class YearOf2016 {
    private static final String[] DAY_WEEK = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    private static final int[] DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }

    // 1차 풀이
    // 고려하지 못한 점
    // 2중 for 문이 필요없는 상황이였음. 그리고 dayWeekPointer 변수는 필요 없었음.
    // 완전 탐색 방법을 통해 해결하려고 했으나 이는 시간 복잡도만 증가시키는 좋지 않은 풀이였음.
    public static String solution(int a, int b) {
        String answer = "";
        int dayWeekPointer = 5;

        for (int month = 1; month <= a; month++) {
            for (int day = 1; day <= DAYS[month - 1]; day++) {
                if (dayWeekPointer > 6) {
                    dayWeekPointer = 0;
                }

                if (month == a && day == b) {
                    answer = DAY_WEEK[dayWeekPointer];
                }

                dayWeekPointer++;
            }
        }

        return answer;
    }

    // 2차 풀이
    // 위의 2중 for문을 제거하고 변수를 줄였음.
    public static String solution2(int a, int b) {
        int totalDate = 0;
        for (int i = 0; i < a - 1; i++) {
            totalDate += DAYS[i];
        }

        totalDate += b - 1;

        return DAY_WEEK[totalDate % 7];
    }
}
