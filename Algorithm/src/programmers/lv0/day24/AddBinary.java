package programmers.lv0.day24;

public class AddBinary {

    public static void main(String[] args) {
        System.out.println(solution("10", "11"));
    }

    public static String solution(String bin1, String bin2) {
        int str1 = Integer.parseInt(bin1, 2);
        int str2 = Integer.parseInt(bin2, 2);
        int str3 = str1 + str2;

        return Integer.toBinaryString(str3);
    }
}
