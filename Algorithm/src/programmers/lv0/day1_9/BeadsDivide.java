package programmers.lv0.day1_9;

public class BeadsDivide {

    public static void main(String[] args) {
        String s = Integer.toBinaryString(0x123);
        System.out.println(s);
    }

    //5 3
    public int solution(int balls, int share) {
        int answer = 0;

        long motherNum = 1;
        for (int i = balls; i >= balls - share ; ++i) {
            motherNum *= i;
        }

        long sonNum = 1;
        for (int i = 1; i <= balls - share; ++i) {
            sonNum *= i;
        }

        for (long i = 1; i<= share; ++i) {
            sonNum *= i;
        }

        long result = motherNum / sonNum;

        answer = Long.valueOf(result).intValue();

        return answer;
    }
}
