package programmers.lv1;

public class CoupleNumbers {

    public static void main(String[] args) {
        solution("5525", "1255");
    }

    public static String solution(String X, String Y) {
        int[] xArray = new int[10];
        int[] yArray = new int[10];

        for (String x : X.split("")) {
            ++xArray[Integer.parseInt(x)];
        }

        for (String y : Y.split("")) {
            ++yArray[Integer.parseInt(y)];
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 9; i >= 0; --i) {
            while (xArray[i] > 0 && yArray[i] > 0) {
                answer.append(i);
                --xArray[i];
                --yArray[i];
            }
        }

        if (answer.length() == 0) {
            return "-1";
        }

        int index = 0;

        for (int i = 0; i < answer.length(); ++i) {
            if (answer.charAt(i) != '0') {
                break;
            }

            ++index;
        }

        if (index == answer.length()) {
            return "0";
        }

        return answer.substring(0);
    }
}
