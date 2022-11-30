package programmers.lv1;

public class HashadNumber {

    public static void main(String[] args) {

    }

    public boolean solution(int x) {
        String s = String.valueOf(x);
        String[] split = s.split("");
        int xSum = 0;
        for (String s1 : split) {
            xSum += Integer.parseInt(s1);
        }

        if (x % xSum == 0) {
            return true;
        }

        return false;
    }

}
