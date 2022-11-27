package programmers.lv0.day25;

/**
 * 문자열 밀기
 * <p>
 * 문제 설명 문자열 "hello"에서 각 문자를 오른쪽으로 한 칸씩 밀고 마지막 문자는 맨 앞으로 이동시키면 "ohell"이 됩니다. 이것을 문자열을 민다고 정의한다면 문자열 A와 B가 매개변수로 주어질 때,
 * A를 밀어서 B가 될 수 있다면 몇 번 밀어야 하는지 횟수를 return하고 밀어서 B가 될 수 없으면 -1을 return 하도록 solution 함수를 완성해보세요.
 * <p>
 * 제한사항 0 < A의 길이 = B의 길이 < 100 A, B는 알파벳 소문자로 이루어져 있습니다.
 * <p>
 * 입출력 예 A	B	result "hello"	"ohell"	1 "apple"	"elppa"	-1
 */
//0 -> 1 o
//1 -> 2 h
//2 -> 3 e
//3 -> 4 l
//4 -> 0 l
public class PushString {

    public static void main(String[] args) {
        System.out.println(solution("hello", "ohell"));
    }

    public static int solution(String A, String B) {
        String[] splitA = A.split("");
        String result = "";
        int cnt = -1;
        do {
            if (cnt == A.length()) {
                break;
            }

            if (!result.equals(B)) {
                cnt++;
            } else if (result.equals(B)) {
                return cnt;
            }

            result = push(A);
        } while (true);

        return cnt;
    }

    private static String push(String a) {
        String result = String.valueOf(a.charAt(a.length() -1));
        for (int i = 0; i < a.length() - 1; i++) {
            result += a.charAt(i);
        }
        return result;
    }
}
