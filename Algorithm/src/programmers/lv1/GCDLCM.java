package programmers.lv1;

public class GCDLCM {

    public static void main(String[] args) {

    }

    public static int[] solution(int n, int m) {
        int[] answer =  new int[2];
        int gcd = getGCD(n, m);
        answer[0] = gcd;
        answer[1] = (n * m) / gcd;
        return answer;
    }

    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }

        return getGCD(num2, num1%num2);
    }
}
