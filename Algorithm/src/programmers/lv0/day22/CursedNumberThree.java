package programmers.lv0.day22;

public class CursedNumberThree {

    public static void main(String[] args) {
        System.out.println(solution(1000));
    }

    public static int solution(int n) {
        int[] arr3 = new int[n + 1];
        // 3의 배수X 3이 들어가도 안돼
        for (int i = 1; i <= n; i++) {
            int candidateNum = arr3[i - 1] + 1;

            while (true) {
                if (candidateNum % 3 == 0 || checkThreeNum(candidateNum)) {
                    ++candidateNum;
                    continue;
                }

                arr3[i] = candidateNum;
                break;
            }
        }

        return arr3[n];
    }

    private static boolean checkThreeNum(int candidateNum) {
        while (candidateNum != 0) {
            if (candidateNum % 10 == 3) {
                return true;
            }
            candidateNum /= 10;
        }
        return false;
    }
}
